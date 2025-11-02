from pathlib import Path
from generators.time_generator import gerar_data_temporaria
from datetime import date, timedelta


def gerar_metodo_teste(i, ano, mes, dia):
    data = date(ano, mes, dia)
    nova_data = data + timedelta(days=5)
    java_data = f"MakeItFitDate.of({ano}, {mes}, {dia})"
    java_nova_data = f"MakeItFitDate.of({nova_data.year}, {nova_data.month}, {nova_data.day})"

    return f"""
    @Test
    public void testTimeManager_{i}() {{
        MakeItFitDate data = {java_data};
        TimeManager tm = new TimeManager(data);
        assertEquals(data, tm.getCurrentDate());

        MakeItFitDate nova = tm.advanceTime(5);
        assertEquals({java_nova_data}, nova);

        assertThrows(IllegalArgumentException.class, () -> tm.advanceTime(-1));
    }}
    """.strip()


def gerar_metodo_teste_date_util(i, ano, mes, dia):
    data_str = f"{dia:02d}/{mes:02d}/{ano}"
    nova_data = date(ano, mes, dia) + timedelta(days=10)
    nova_obj_java = f"MakeItFitDate.of({nova_data.year}, {nova_data.month}, {nova_data.day})"

    return f"""
    @Test
    public void testMakeItFitDate_{i}() {{
        // fromString e toString
        MakeItFitDate data = MakeItFitDate.fromString("{data_str}");
        assertEquals("{data_str}", data.toString());

        // clone
        MakeItFitDate copia = data.clone();
        assertEquals(data.toString(), copia.toString());

        // distance
        MakeItFitDate nova = {nova_obj_java};
        int distancia = data.distance(nova);
        assertEquals(10, distancia);

        // comparações
        assertTrue(data.isBeforeOrSame(nova));
        assertTrue(nova.isAfterOrSame(data));
        assertFalse(data.isAfterOrSame(nova));
    }}
    """.strip()



def gerar_classe_java_time():

    metodos = []
    for i in range(10):
        ano, mes, dia = gerar_data_temporaria().example()
        metodo_time = gerar_metodo_teste(i, ano, mes, dia)
        metodo_date = gerar_metodo_teste_date_util(i, ano, mes, dia)
        metodos.append(metodo_time)
        metodos.append(metodo_date)


    codigo = f"""
package test_Hypothesis;

import MakeItFit.time.TimeManager;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimeManagerGeneratedTest {{

{chr(10).join(metodos)}

}}
""".strip()

    Path("../../test/java/test_Hypothesis/TimeManagerGeneratedTest.java").write_text(codigo, encoding="utf-8")
    print("✅ Ficheiro Java 'TimeManagerGeneratedTest.java' criado com sucesso!")

# Executar
gerar_classe_java_time()
