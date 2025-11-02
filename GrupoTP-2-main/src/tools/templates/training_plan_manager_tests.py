from generators.activities import gerar_atividade
from generators.training_plan import gerar_training_plan, gerar_training_plan_com_objetivo
from pathlib import Path

from generators.users import gerar_user
import warnings
from hypothesis.errors import NonInteractiveExampleWarning
warnings.filterwarnings("ignore", category=NonInteractiveExampleWarning)



def gerar_metodo_training_plan_manager(i, data, data_obj, users):
    obj = f"tpm{i}"
    plan = f"tp{i}"

    repetitions, a = data["atividades"][0]
    tipo = a["tipo"]
    nome_var = f"act{i}"
    user_index = next(u["index"] for u in users if u["code"] == data["user_code"])

    user_code_at_java = f'UUID.fromString("{a["user_code"]}")'
    plan_user_code_java = f'UUID.fromString("{data["user_code"]}")'
    base = f'{tipo} {nome_var} = new {tipo}({user_code_at_java}, {a["realization_date"]}, {a["expected_duration"]}, "{a["designation"]}", "{a["name"]}"'

    if tipo == "Running":
        construtor = f"{base}, {a['distance']}, {a['speed']});"
    elif tipo == "PushUp":
        construtor = f"{base}, {a['repetitions']}, {a['series']});"
    elif tipo == "Trail":
        construtor = f"{base}, {a['distance']}, {a['elevation_gain']}, {a['elevation_loss']}, {a['trail_type']});"
    elif tipo == "WeightSquat":
        construtor = f"{base}, {a['repetitions']}, {a['series']}, {a['weight']});"

    return f"""
    @Test
    @Timeout(30)
    public void testTrainingPlanManager_{i}() {{
        TrainingPlanManager {obj} = new TrainingPlanManager();
        TrainingPlan {plan} = {obj}.createTrainingPlan({plan_user_code_java}, {data['start_date']});
        UUID code = {plan}.getCode();
        assertNotNull({plan});

        {obj}.insertTrainingPlan({plan});
        assertEquals({plan}, {obj}.getTrainingPlan(code));

        // Teste de remoção
        {obj}.removeTrainingPlan(code);
        assertThrows(IllegalArgumentException.class, () -> {obj}.getTrainingPlan(code));

        // Reinserção e continuação de testes
        {obj}.insertTrainingPlan({plan});

        {construtor}
        {obj}.addActivity(code, {repetitions}, {nome_var});
        {obj}.removeActivity(code, {nome_var}.getCode());

        {obj}.updateTrainingPlan({plan});
        List<TrainingPlan> userPlans = {obj}.getTrainingPlansFromUser({plan_user_code_java});
        assertFalse(userPlans.isEmpty());

        {obj}.updateActivities({data['start_date']}, {user_index}f);

        List<Activity> extracted = {obj}.extractActivities({data['start_date']}, {plan_user_code_java});
        assertNotNull(extracted);

        TrainingPlan objetivo = {obj}.constructTrainingPlanByObjectives(
            {plan}, {data_obj['index']}f, {str(data_obj['hard_activities']).lower()},
            {data_obj['max_per_day']}, {data_obj['max_diff']}, {data_obj['weekly']}, {data_obj['min_caloric']}
        );
        assertNotNull(objetivo);

        // Calorias
        int caloriasTotais = objetivo.getActivities().stream()
            .mapToInt(tuple -> tuple.getItem2().caloricWaste({user_index}f))
            .sum();
        assertTrue(caloriasTotais >= {data_obj['min_caloric']});

        // Tipos únicos de atividade
        Set<String> tipos = new HashSet<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {{
            tipos.add(t.getItem2().getClass().getSimpleName());
        }}
        assertTrue(tipos.size() <= {data_obj['max_diff']});

        // Atividades por dia
        Map<MakeItFitDate, Integer> atividadesPorDia = new HashMap<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {{
            MakeItFitDate data = t.getItem2().getRealizationDate();
            atividadesPorDia.put(data, atividadesPorDia.getOrDefault(data, 0) + 1);
        }}
        for (int count : atividadesPorDia.values()) {{
            assertTrue(count <= {data_obj['max_per_day']});
        }}

        // Se hard_activities for false, garantir que não existem atividades difíceis
        if (!{str(data_obj['hard_activities']).lower()}) {{
            for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {{
                assertFalse(t.getItem2() instanceof HardInterface);
            }}
        }}
    }}
    """.strip()


def gerar_classe_tpm():
    Path("../../test/java/test_Hypothesis").mkdir(parents=True, exist_ok=True)
    metodos = []
    # Gera alguns utilizadores de teste
    users = [gerar_user().example() for _ in range(2)]
    activities = []
    activities_per_user = {u["code"]: [] for u in users}
    for user in users:
        user_activities = [gerar_atividade(users).example() for _ in range(5)]
        activities += user_activities
        activities_per_user[user["code"]] = user_activities
    for i in range(10):
        data = gerar_training_plan(users,activities_per_user).example()
        data_obj = gerar_training_plan_com_objetivo(users).example()
        metodo = gerar_metodo_training_plan_manager(i, data, data_obj, users)
        metodos.append(metodo)

    codigo = f"""
package test_Hypothesis;
import MakeItFit.utils.MyTuple;
import MakeItFit.activities.HardInterface;
import MakeItFit.trainingPlan.*;
import MakeItFit.activities.Activity;
import MakeItFit.activities.implementation.*;
import MakeItFit.utils.MakeItFitDate;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Timeout;

public class TrainingPlanManagerGeneratedTest {{

{chr(10).join(metodos)}

}}
""".strip()

    Path("../../test/java/test_Hypothesis/TrainingPlanManagerGeneratedTest.java").write_text(codigo, encoding="utf-8")
    print("\u2705 Ficheiro Java 'TrainingPlanManagerGeneratedTest.java' criado com sucesso!")

# Executar
gerar_classe_tpm()
