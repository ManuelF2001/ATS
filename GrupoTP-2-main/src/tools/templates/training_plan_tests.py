from generators.training_plan import gerar_training_plan
from pathlib import Path
from generators.activities import gerar_atividade

from generators.users import gerar_user
import warnings
from hypothesis.errors import NonInteractiveExampleWarning
warnings.filterwarnings("ignore", category=NonInteractiveExampleWarning)



def gerar_metodo_training_plan(i, tp):
    obj = f"tp{i}"
    add_atividades = []
    codes = []

    for j, (reps, atividade) in enumerate(tp["atividades"]):
        tipo = atividade["tipo"]
        nome_var = f"a{i}_{j}"
        user_code_at_java = f'UUID.fromString("{atividade["user_code"]}")'
        user_code_java = f'UUID.fromString("{tp["user_code"]}")'

        comum = f'{tipo} {nome_var} = new {tipo}({user_code_at_java}, {atividade["realization_date"]}, {atividade["expected_duration"]}, "{atividade["designation"]}", "{atividade["name"]}"'

        if tipo == "Running":
            construtor = f"{comum}, {atividade['distance']}, {atividade['speed']});"
        elif tipo == "PushUp":
            construtor = f"{comum}, {atividade['repetitions']}, {atividade['series']});"
        elif tipo == "Trail":
            construtor = f"{comum}, {atividade['distance']}, {atividade['elevation_gain']}, {atividade['elevation_loss']}, {atividade['trail_type']});"
        elif tipo == "WeightSquat":
            construtor = f"{comum}, {atividade['repetitions']}, {atividade['series']}, {atividade['weight']});"

        add = f"""
        {construtor}
        {obj}.addActivity({reps}, {nome_var});
        UUID code{j} = {nome_var}.getCode();
        """
        codes.append(f"code{j}")
        add_atividades.append(add)

    update_remove_extract = f"""
        // Update activities with index 1.5
        {obj}.updateActivities({tp['start_date']}, 1.5f);

        // Remove first activity
        {obj}.removeActivity({codes[0]});

        // Extract past activities
        var extracted = {obj}.extractActivities({tp['start_date']});
        assertNotNull(extracted);
        """

    return f"""
    @Test
    public void testTrainingPlan_{i}() {{
        TrainingPlan {obj} = new TrainingPlan({user_code_java}, {tp['start_date']});
        assertNotNull({obj});
        assertEquals({tp['start_date']}, {obj}.getStartDate());
{chr(10).join(add_atividades)}
        assertFalse({obj}.getActivities().isEmpty());
{update_remove_extract}
        assertNotNull({obj}.toString());
        
        assertEquals({tp['start_date']}, {obj}.getStartDate());

        MakeItFitDate novaData = MakeItFitDate.of(2025, 1, 1);
        {obj}.setStartDate(novaData);
        assertEquals(novaData, {obj}.getStartDate());

        var clone = {obj}.clone();
        assertEquals({obj}, clone);
        assertDoesNotThrow(() -> {obj}.compareTo(clone));
    }}
    """.strip()

def gerar_classe_training_plan():
    Path("../../test/java/test_Hypothesis").mkdir(parents=True, exist_ok=True)
    metodos = []

    # Gera users
    users = [gerar_user().example() for _ in range(2)]

    # Gera atividades por user

    activities = []
    activities_per_user = {u["code"]: [] for u in users}
    for user in users:
        user_activities = [gerar_atividade(users).example() for _ in range(5)]
        activities += user_activities
        activities_per_user[user["code"]] = user_activities

    # Gera planos com essas atividades
    for i in range(10):
        tp = gerar_training_plan(users, activities_per_user).example()
        metodo = gerar_metodo_training_plan(i, tp)
        metodos.append(metodo)

    codigo = f"""
package test_Hypothesis;

import MakeItFit.trainingPlan.TrainingPlan;
import MakeItFit.activities.implementation.*;
import MakeItFit.utils.MakeItFitDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainingPlanGeneratedTest {{

{chr(10).join(metodos)}

}}
""".strip()

    Path("../../test/java/test_Hypothesis/TrainingPlanGeneratedTest.java").write_text(codigo, encoding="utf-8")
    print("\u2705 Ficheiro Java 'TrainingPlanGeneratedTest.java' criado com sucesso!")

# Executar
gerar_classe_training_plan()


