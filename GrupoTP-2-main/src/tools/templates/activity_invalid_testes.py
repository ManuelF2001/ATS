from generators.activities import gerar_atividade_invalida
from generators.users import gerar_user
from pathlib import Path
import warnings
from hypothesis.errors import NonInteractiveExampleWarning

warnings.filterwarnings("ignore", category=NonInteractiveExampleWarning)


def gerar_metodo_atividade_invalida(i, atividade):
    tipo = atividade["tipo"]
    user_code = f'UUID.fromString("{atividade["user_code"]}")'
    data = atividade["realization_date"]
    duracao = atividade["expected_duration"]
    designacao = atividade["designation"]
    nome = atividade["name"]

    base_args = f"{user_code}, {data}, {duracao}, \"{designacao}\", \"{nome}\""

    if tipo == "Running":
        return f"""
    @Test
    public void testInvalidRunning_{i}() {{
        assertThrows(IllegalArgumentException.class, () -> {{
            new Running({base_args}, {atividade["distance"]}, {atividade["speed"]});
        }});
    }}"""

    elif tipo == "PushUp":
        return f"""
    @Test
    public void testInvalidPushUp_{i}() {{
        assertThrows(IllegalArgumentException.class, () -> {{
            new PushUp({base_args}, {atividade["repetitions"]}, {atividade["series"]});
        }});
    }}"""

    elif tipo == "Trail":
        return f"""
    @Test
    public void testInvalidTrail_{i}() {{
        assertThrows(IllegalArgumentException.class, () -> {{
            new Trail({base_args}, {atividade["distance"]}, {atividade["elevation_gain"]}, {atividade["elevation_loss"]}, {atividade["trail_type"]});
        }});
    }}"""

    elif tipo == "WeightSquat":
        return f"""
    @Test
    public void testInvalidWeightSquat_{i}() {{
        assertThrows(IllegalArgumentException.class, () -> {{
            new WeightSquat({base_args}, {atividade["repetitions"]}, {atividade["series"]}, {atividade["weight"]});
        }});
    }}"""

    return "// Tipo desconhecido"


def gerar_classe_activity_invalida():
    Path("../../test/java/test_Hypothesis").mkdir(parents=True, exist_ok=True)
    metodos = []

    user = gerar_user().example()

    for i in range(10):
        atv = gerar_atividade_invalida([user]).example()
        metodo = gerar_metodo_atividade_invalida(i, atv)
        metodos.append(metodo)

    codigo = f"""
package test_Hypothesis;

import MakeItFit.activities.implementation.*;
import MakeItFit.utils.MakeItFitDate;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ActivityInvalidGeneratedTest {{

{chr(10).join(metodos)}

}}""".strip()

    Path("../../test/java/test_Hypothesis/ActivityInvalidGeneratedTest.java").write_text(codigo, encoding="utf-8")
    print("✅ Ficheiro Java 'ActivityInvalidGeneratedTest.java' criado com sucesso!")


# Executar
gerar_classe_activity_invalida()
