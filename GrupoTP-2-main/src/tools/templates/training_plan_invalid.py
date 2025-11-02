from generators.training_plan import gerar_plano_invalido
from pathlib import Path
import warnings
from hypothesis.errors import NonInteractiveExampleWarning

warnings.filterwarnings("ignore", category=NonInteractiveExampleWarning)


def gerar_metodo_plano_invalido(i, plano):
    erro = plano["erro"]

    # 1. Erros ao criar plano
    if erro in ["userCode_null", "startDate_null"]:
        user = "null" if plano["user_code"] is None else f'UUID.fromString("{plano["user_code"]}")'
        data = plano["start_date"]
        return f"""
    @Test
    public void testPlanoInvalido_{i}_{erro}() {{
        assertThrows(IllegalArgumentException.class, () -> {{
            new TrainingPlanManager().createTrainingPlan({user}, {data});
        }});
    }}""".strip()

    # 2. Erros na construção por objetivos
    elif erro in [
        "maxActivitiesPerDay_alto",
        "maxDifferentActivities_negativo",
        "weeklyRecurrence_alto",
        "minimumCaloricWaste_negativo"
    ]:
        args = plano["construct"]
        return f"""
    @Test
    public void testPlanoInvalido_{i}_{erro}() {{
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {{
            tpm.constructTrainingPlanByObjectives(
                tp,
                {args["index"]}f,
                {str(args["hard"]).lower()},
                {args["maxPerDay"]},
                {args["maxDiff"]},
                {args["recurrence"]},
                {args["minCalories"]}
            );
        }});
    }}""".strip()

    # 3. Erros ao adicionar atividade com iteração inválida
    elif erro == "repetitions_zero_ou_negativo":
        repetitions = plano["add"]["repetitions"]
        return f"""
    @Test
    public void testPlanoInvalido_{i}_{erro}() {{
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {{
            tpm.addActivity(tp.getCode(), {repetitions}, atividade);
        }});
    }}""".strip()

    else:
        raise ValueError(f"Erro inválido ou não tratado: {erro}")



def gerar_classe_treinoplanos_invalidos():
    Path("../../test/java/test_Hypothesis").mkdir(parents=True, exist_ok=True)
    metodos = []

    for i in range(100):
        plano = gerar_plano_invalido().example()
        metodo = gerar_metodo_plano_invalido(i, plano)
        metodos.append(metodo)

    codigo = f"""
package test_Hypothesis;

import MakeItFit.activities.implementation.PushUp;
import MakeItFit.trainingPlan.*;
import MakeItFit.exceptions.*;
import MakeItFit.utils.MakeItFitDate;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainingPlanInvalidGeneratedTest {{

{chr(10).join(metodos)}

}}""".strip()

    Path("../../test/java/test_Hypothesis/TrainingPlanInvalidGeneratedTest.java").write_text(codigo, encoding="utf-8")
    print("✅ Ficheiro Java 'TrainingPlanInvalidGeneratedTest.java' criado com sucesso!")


# Executar
gerar_classe_treinoplanos_invalidos()
