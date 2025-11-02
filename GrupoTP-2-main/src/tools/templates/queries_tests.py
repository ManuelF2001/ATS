from generators.queries_manager import gerar_queries_data, parse_date
from pathlib import Path

from templates.querie_activity_most_done import gerar_teste_most_done_activity
from templates.querie_altimetry import gerar_teste_altimetry
from templates.querie_demanding_plan import gerar_teste_most_demanding_training_plan
from templates.querie_km import gerar_teste_kms_done
from templates.querie_who_more_active import gerar_teste_most_activities
from templates.queries_base_java import (gerar_users_java, gerar_atividades_java, gerar_planos_com_atividades_java,
                                        gerar_asserts_basicos, mapear_atividades_por_user_code)
from templates.queries_more_calories import gerar_teste_burns_more


def gerar_metodo_queries_manager(i, data):
    d1 = parse_date(data["data1"])
    d2 = parse_date(data["data2"])
    email = data['users'][0]['email']  # usa o primeiro user para os testes


    users_java, user_refs, user_code_to_var = gerar_users_java(data)
    atividades_java = gerar_atividades_java(data, user_code_to_var)
    atividades_user = mapear_atividades_por_user_code(data)
    planos_java = gerar_planos_com_atividades_java(data, user_code_to_var, atividades_user)

    altimetria = gerar_teste_altimetry(data, user_refs, email, d1, d2)
    kms_done = gerar_teste_kms_done(data, email, d1, d2)
    demanding = gerar_teste_most_demanding_training_plan(data)
    most_done = gerar_teste_most_done_activity(data)
    queimou_cal = gerar_teste_burns_more(data, user_refs, d1, d2)
    most_activity = gerar_teste_most_activities(data, user_refs, d1, d2)
    asserts_outros = gerar_asserts_basicos(email)

    return f"""
    @Test
    public void testQueriesManager_{i}() {{
        UserManager um = new UserManager();
        TrainingPlanManager tpm = new TrainingPlanManager();
        QueriesManager qm = new QueriesManager(um, tpm);

        MakeItFitDate data1 = {data["data1"]};
        MakeItFitDate data2 = {data["data2"]};

        // Criar utilizadores
        {users_java}

        // Criar atividades
        {atividades_java}

        // Inserir planos
        {planos_java}

        // Queries:
        {altimetria} // nao testavam se estava dentro das datas e altimetria sem datas tinha sinal trocado
        {kms_done}
        {demanding}
        {most_done} // as repeticoes e repeticoes com peso estavam trocadas no java
        {queimou_cal}
        {most_activity}
        {asserts_outros}
    }}
    """.strip()


def gerar_classe_qm():
    Path("../../test/java/test_Hypothesis").mkdir(parents=True, exist_ok=True)
    metodos = []
    for i in range(10):
        data = gerar_queries_data().example()
        metodo = gerar_metodo_queries_manager(i, data)
        metodos.append(metodo)

    codigo = f"""
package test_Hypothesis;

import MakeItFit.queries.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.UUID;
import MakeItFit.users.types.*;
import MakeItFit.users.UserManager;
import MakeItFit.activities.Activity;
import MakeItFit.users.*;
import MakeItFit.activities.implementation.*;
import MakeItFit.trainingPlan.*;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueriesManagerGeneratedTest {{

{chr(10).join(metodos)}

}}
""".strip()

    Path("../../test/java/test_Hypothesis/QueriesManagerGeneratedTest.java").write_text(codigo, encoding="utf-8")
    print("✅ Ficheiro Java 'QueriesManagerGeneratedTest.java' criado com sucesso!")



gerar_classe_qm()

