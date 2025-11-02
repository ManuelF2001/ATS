
from generators.users import gerar_user
from uuid import uuid4
from hypothesis.strategies import composite, lists, integers, sampled_from, floats, booleans
from generators.activities import gerar_atividade
from random import choice
from generators.time_generator import gerar_data_temporaria

@composite
def gerar_training_plan(draw, users, activities_per_user):
    # Escolhe UM user para o plano
    user = draw(sampled_from(users))
    user_acts = activities_per_user[user["code"]]
    ano, mes, dia = draw(gerar_data_temporaria())
    start_date = f"MakeItFitDate.of({ano}, {mes}, {dia})"

    # Seleciona aleatoriamente atividades dessa lista para o plano
    n_acts = draw(integers(min_value=1, max_value=min(5, len(user_acts))))
    atividades_escolhidas = draw(lists(sampled_from(user_acts), min_size=n_acts, max_size=n_acts,  unique_by=lambda a: a["atividade_id"]))

    atividades = []
    for atividade in atividades_escolhidas:
        reps = draw(integers(min_value=1, max_value=10))
        atividades.append((reps, atividade))

    return {
        "plan_id": str(uuid4()),
        "user_code": user["code"],
        "start_date": start_date,
        "atividades": atividades
    }


@composite
def gerar_training_plan_com_objetivo(draw, users):
    user = draw(sampled_from(users))
    ano, mes, dia = draw(gerar_data_temporaria())
    start_date = f"MakeItFitDate.of({ano}, {mes}, {dia})"
    atividade = draw(gerar_atividade(users))
    repetitions = draw(integers(min_value=1, max_value=5))
    return {
        "user_code": user["code"],
        "start_date": start_date,
        "atividade": atividade,
        "repetitions": repetitions,
        "index": round(draw(floats(min_value=0.5, max_value=2.5)), 2),
        "hard_activities": draw(booleans()),
        "max_per_day": draw(integers(min_value=1, max_value=3)),
        "max_diff": draw(integers(min_value=1, max_value=4)),
        "weekly": draw(integers(min_value=1, max_value=7)),
        "min_caloric": draw(integers(min_value=50, max_value=1000))
    }




from hypothesis.strategies import composite, sampled_from, integers
from generators.users import gerar_user
from generators.activities import gerar_atividade
from generators.time_generator import gerar_data_temporaria
from uuid import uuid4
from random import choice

@composite
def gerar_plano_invalido(draw):
    erro_tipo = draw(sampled_from([
        "userCode_null",
        "startDate_null",
        "maxActivitiesPerDay_alto",
        "maxDifferentActivities_negativo",
        "weeklyRecurrence_alto",
        "minimumCaloricWaste_negativo",
        "repetitions_zero_ou_negativo"
    ]))

    user = draw(gerar_user())
    user_code = None if erro_tipo == "userCode_null" else user["code"]

    if erro_tipo == "startDate_null":
        start_date = "null"
    else:
        ano, mes, dia = draw(gerar_data_temporaria())
        start_date = f"MakeItFitDate.of({ano}, {mes}, {dia})"

    plano = {
        "user_code": user_code,
        "start_date": start_date,
        "erro": erro_tipo,
    }

    # Erros da construção por objetivos
    if erro_tipo in [
        "maxActivitiesPerDay_alto",
        "maxDifferentActivities_negativo",
        "weeklyRecurrence_alto",
        "minimumCaloricWaste_negativo"
    ]:
        plano["construct"] = {
            "index": 1.0,
            "hard": True,
            "maxPerDay": 2,
            "maxDiff": 2,
            "recurrence": 3,
            "minCalories": 100
        }

        if erro_tipo == "maxActivitiesPerDay_alto":
            plano["construct"]["maxPerDay"] = draw(
                draw(sampled_from([
                    integers(min_value=-10, max_value=-1),
                    integers(min_value=4, max_value=100)
                ]))
            )
        elif erro_tipo == "maxDifferentActivities_negativo":
            plano["construct"]["maxDiff"] = draw(integers(min_value=-10, max_value=-1))
        elif erro_tipo == "weeklyRecurrence_alto":
            plano["construct"]["recurrence"] = draw(
                draw(sampled_from([
                    integers(min_value=-10, max_value=-1),
                    integers(min_value=8, max_value=30)
                ]))
            )
        elif erro_tipo == "minimumCaloricWaste_negativo":
            plano["construct"]["minCalories"] = draw(integers(min_value=-500, max_value=-1))

    # Erros ao adicionar atividade ao plano
    elif erro_tipo in ["repetitions_zero_ou_negativo"]:
        repetitions = draw(integers(min_value=-10, max_value=0)) if erro_tipo == "repetitions_zero_ou_negativo" else draw(integers(min_value=1, max_value=5))

        plano["add"] = {
            "repetitions": repetitions
        }

    return plano
