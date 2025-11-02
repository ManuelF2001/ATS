from generators.activities import gerar_atividade
from pathlib import Path

import warnings
from hypothesis.errors import NonInteractiveExampleWarning
warnings.filterwarnings("ignore", category=NonInteractiveExampleWarning)

from generators.users import gerar_user


# ----------------------------
# Gerador de método de teste
# ----------------------------

def gerar_metodo_teste(i, atv):
    tipo = atv["tipo"]
    obj = f"a{i}"
    user_code_java = f'UUID.fromString("{atv["user_code"]}")'
    comum = f'{tipo} {obj} = new {tipo}({user_code_java}, {atv["realization_date"]}, {atv["expected_duration"]}, "{atv["designation"]}", "{atv["name"]}"'

    if tipo == "Running":
        construtor = f"{comum}, {atv['distance']}, {atv['speed']});"
        extra_getset = f"""
        assertEquals({atv['distance']}, {obj}.getDistance(), 0.01);
        assertEquals({atv['speed']}, {obj}.getSpeed(), 0.01);
        {obj}.setDistance(12.34);
        {obj}.setSpeed(8.88);
        assertEquals(12.34, {obj}.getDistance(), 0.01);
        assertEquals(8.88, {obj}.getSpeed(), 0.01);
        """
    elif tipo == "PushUp":
        construtor = f"{comum}, {atv['repetitions']}, {atv['series']});"
        extra_getset = f"""
        assertEquals({atv['repetitions']}, {obj}.getRepetitions());
        assertEquals({atv['series']}, {obj}.getSeries());
        {obj}.setRepetitions(15);
        {obj}.setSeries(3);
        assertEquals(15, {obj}.getRepetitions());
        assertEquals(3, {obj}.getSeries());
        """
    elif tipo == "Trail":
        construtor = f"{comum}, {atv['distance']}, {atv['elevation_gain']}, {atv['elevation_loss']}, {atv['trail_type']});"
        # Corrige valor esperado para setTrailType
        valor_gerado = atv["trail_type"]
        if valor_gerado < 0:
            esperado = 0
        elif valor_gerado > 2:
            esperado = 2
        else:
            esperado = valor_gerado
        extra_getset = f"""
        assertEquals({atv['distance']}, {obj}.getDistance(), 0.01);
        assertEquals({atv['elevation_gain']}, {obj}.getElevationGain(), 0.01);
        assertEquals({atv['elevation_loss']}, {obj}.getElevationLoss(), 0.01);

        // O construtor não aplica validação ao trailType
        assertEquals({valor_gerado}, {obj}.getTrailType());
        
        // setTrailType com valor gerado ({valor_gerado})
        {obj}.setTrailType({valor_gerado});
        assertEquals({esperado}, {obj}.getTrailType());

        {obj}.setElevationGain(100.1);
        {obj}.setElevationLoss(50.1);
        assertEquals(100.1, {obj}.getElevationGain(), 0.01);
        assertEquals(50.1, {obj}.getElevationLoss(), 0.01);
        """
    elif tipo == "WeightSquat":
        construtor = f"{comum}, {atv['repetitions']}, {atv['series']}, {atv['weight']});"
        extra_getset = f"""
        assertEquals({atv['repetitions']}, {obj}.getRepetitions());
        assertEquals({atv['series']}, {obj}.getSeries());
        assertEquals({atv['weight']}, {obj}.getWeight(), 0.01);
        {obj}.setWeight(44.4);
        assertEquals(44.4, {obj}.getWeight(), 0.01);
        """

    return f"""
    @Test
    public void test_{tipo}_{i}() {{
        {construtor}
        assertNotNull({obj});
        assertEquals("{atv["designation"]}", {obj}.getDesignation());
        assertEquals("{atv["name"]}", {obj}.getName());
        assertEquals({atv["expected_duration"]}, {obj}.getExpectedDuration());
        {extra_getset}
        {obj}.setDuration(60);
        {obj}.setCaloricWaste(300);
        {obj}.setExpectedDuration(123);
        {obj}.setDesignation("Nova Designação");

        assertEquals(123, {obj}.getExpectedDuration());
        assertEquals("Nova Designação", {obj}.getDesignation());
        assertEquals(60, {obj}.getDuration());
        assertEquals(300, {obj}.getCaloricWaste());

        var clone = {obj}.clone();
        assertEquals({obj}, clone);
        assertNotNull({obj}.toString());
        assertDoesNotThrow(() -> {obj}.compareTo(clone));
    }}
    """.strip()

# ----------------------------
# Gerador do ficheiro Java
# ----------------------------

def gerar_classe_java_activity():
    metodos = []
    # Gera um user só uma vez para todas as atividades
    user = gerar_user().example()
    for i in range(10):
        # Passa o user para o gerador de atividades
        atv = gerar_atividade([user]).example()
        metodo = gerar_metodo_teste(i, atv)
        metodos.append(metodo)

    codigo = f"""
package test_Hypothesis;

import MakeItFit.activities.implementation.*;
import MakeItFit.utils.MakeItFitDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ActivityGeneratedTest {{

{chr(10).join(metodos)}

}}
""".strip()

    Path("../../test/java/test_Hypothesis/ActivityGeneratedTest.java").write_text(codigo, encoding="utf-8")
    print("✅ Ficheiro Java 'ActivityGeneratedTest.java' criado com sucesso!")

# Executar
gerar_classe_java_activity()