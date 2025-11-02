"""
 Gerador Hypothesis para criar um cenário de teste completo para queries estatísticas do sistema.

 O cenário inclui:
     - Utilizadores (cada um com identificador único)
     - Atividades associadas a utilizadores
     - Planos de treino compostos apenas por atividades do próprio utilizador
     - Duas datas de referência para queries (intervalo temporal)

 O gerador assegura que:
     - Todas as atividades têm um utilizador válido associado (via user_code)
     - Todos os planos de treino apenas incluem atividades do próprio utilizador
     - Não existem planos "órfãos" (sem atividades)
     - É sempre gerado pelo menos um plano e uma atividade (garantia de utilidade do teste)
"""

from datetime import date, timedelta
from hypothesis.strategies import composite, lists
from generators.users import gerar_user
from generators.activities import gerar_atividade
from generators.training_plan import gerar_training_plan
from generators.time_generator import gerar_data_temporaria


@composite
def gerar_queries_data(draw):
    # 1. Gerar utilizadores
    users = draw(lists(gerar_user(), min_size=2, max_size=3))

    # 2. Gerar atividades associadas a users
    activities = draw(lists(gerar_atividade(users), min_size=5, max_size=10))

    # 3. Mapear atividades por utilizador usando user_code
    activities_per_user = {u["code"]: [] for u in users}
    for atividade in activities:
        activities_per_user[atividade["user_code"]].append(atividade)

    # 4. Gerar planos de treino
    plans = []
    for user in users:
        user_acts = activities_per_user[user["code"]]
        if not user_acts:
            continue
        plan = draw(gerar_training_plan([user], {user["code"]: user_acts}))
        plans.append(plan)

    # 5. Garante que há pelo menos 1 plano e 1 atividade
    if not (plans and activities):
        raise Exception("Não foi possível gerar planos e atividades válidos.")

    # 6. Datas para queries
    ano1, mes1, dia1 = draw(gerar_data_temporaria())
    ano2, mes2, dia2 = draw(gerar_data_temporaria())

    d1 = date(ano1, mes1, dia1)
    d2 = date(ano2, mes2, dia2)

    d1, d2 = sorted([d1, d2])  # garante ordem cronológica
    if d1 == d2: d2 = d1 + timedelta(days=1)

    data1 = f"MakeItFitDate.of({d1.year}, {d1.month}, {d1.day})"
    data2 = f"MakeItFitDate.of({d2.year}, {d2.month}, {d2.day})"


    return {
            "users": users,
            "activities": activities,
            "plans": plans,
            "data1": data1,
            "data2": data2
        }


def in_interval(atividade, data1, data2):
    try:
        parts = atividade["realization_date"].replace("MakeItFitDate.of(", "").replace(")", "").split(",")
        atividade_data = date(int(parts[0]), int(parts[1]), int(parts[2]))
        return data1 < atividade_data < data2
    except:
        return False


def parse_date(str_date):
    y, m, d = str_date.replace("MakeItFitDate.of(", "").replace(")", "").split(", ")
    return date(int(y), int(m), int(d))
