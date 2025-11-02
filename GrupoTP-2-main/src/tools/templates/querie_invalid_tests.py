from hypothesis.strategies import composite, sampled_from, integers
from generators.time_generator import gerar_datas_invalidas

# Define aqui cada query que queremos testar com datas inválidas.
# (Nome da classe Java, nome do método em QueriesManager, parâmetros fixos antes de data1,data2)
QUERIES = [
    ("HowManyAltimetryDone",      "executeQueryHowManyAltimetryDone",      ['new UserManager()', '"user@example.com"']),
    ("HowManyKMsDone",            "executeQueryHowManyKMsDone",            ['new UserManager()', '"user@example.com"']),
    ("WhoBurnsMoreCalories",      "executeQuerywhoBurnsMoreCalories",      ['new UserManager()']),
    ("WhoDidTheMostActivities",   "executeQueryWhoDidTheMostActivities",    ['new UserManager()']),
]

def gerar_metodo_query_invalida_datas(i, query_info, q):
    class_name, method_name, fixed_args = query_info
    erro  = q["erro"]
    data1 = q["data1"]
    data2 = q["data2"]
    args = ",\n                ".join(fixed_args + [data1, data2])

    return f"""
    @Test
    public void test{class_name}_InvalidDates_{i}_{erro}() {{
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {{
            qm.{method_name}(
                {args}
            );
        }});
    }}
    """.strip()

def gerar_classe_queries_data_invalidas():
    metodos = []
    for i in range(10):
        q = gerar_datas_invalidas().example()
        for query_info in QUERIES:
            metodos.append(gerar_metodo_query_invalida_datas(i, query_info, q))

    corpo = "\n\n".join(metodos)
    codigo = f"""
package test_Hypothesis;

import MakeItFit.queries.QueriesManager;
import MakeItFit.users.UserManager;
import MakeItFit.trainingPlan.TrainingPlanManager;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueriesInvalidDateGeneratedTest {{

{corpo}

}}
""".strip()

    # Escreve o ficheiro Java de uma só vez
    with open("../../test/java/test_Hypothesis/QueriesInvalidDateGeneratedTest.java", "w", encoding="utf-8") as f:
        f.write(codigo)
    print("✅ Ficheiro Java 'QueriesInvalidDateGeneratedTest.java' criado com sucesso!")



gerar_classe_queries_data_invalidas()