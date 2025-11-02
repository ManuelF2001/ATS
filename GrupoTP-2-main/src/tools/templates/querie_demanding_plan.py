"""
from templates.queries_more_calories import caloric_waste

def calcular_most_demanding_training_plan(data):
    planos = data['plans']
    users = data['users']

    plano_calorias = []

    for plano in planos:
        user_code = plano['user_code']
        user = next(u for u in users if u['code'] == user_code)
        index = user['index']
        plan_id = plano['plan_id']

        total_calorias = 0
        print(f"\\nPlano {plan_id} (email={user['email']}):")
        for reps, atividade in plano['atividades']:
            calorias = caloric_waste(atividade, index)
            print(f"  → {reps}x atividade {atividade['atividade_id']} → {calorias} calorias (index={index})")
            total_calorias += reps * calorias

        print(f"  Total: {total_calorias} calorias")
        plano_calorias.append((user['email'], total_calorias))

    email_mais_exigente, _ = max(plano_calorias, key=lambda x: x[1])
    print(f"\\nPlano mais exigente pertence a: {email_mais_exigente}")
    return f'"{email_mais_exigente}"'


def gerar_teste_most_demanding_training_plan(data):
    plano = calcular_most_demanding_training_plan(data)
    return f\"\"\"
        TrainingPlan resultDemanding = qm.executeQueryMostDemandingTrainingPlan(tpm, um);
        if (resultDemanding != null) {{
            assertEquals({plano}, um.getUserByCode(resultDemanding.getUserCode()).getEmail());
        }}
    \"\"\"
"""


from templates.queries_more_calories import caloric_waste

def calcular_most_demanding_training_plan(data):
    planos = data['plans']
    users = data['users']

    plano_calorias = []

    for plano in planos:
        user_code = plano['user_code']
        user = next(u for u in users if u['code'] == user_code)
        index = user['index']
        total_calorias = 0
        for reps, atividade in plano['atividades']:
            calorias = caloric_waste(atividade, index)
            total_calorias += reps * calorias

        plano_calorias.append((plano, total_calorias))

    plano_mais_exigente, _ = max(plano_calorias, key=lambda x: x[1])
    return plano_mais_exigente


def gerar_teste_most_demanding_training_plan(data):
    plano = calcular_most_demanding_training_plan(data)
    user_code_java = f'UUID.fromString("{plano["user_code"]}")'

    return f"""
        TrainingPlan resultDemanding = qm.executeQueryMostDemandingTrainingPlan(tpm, um);
        if (resultDemanding != null) {{
            assertEquals({user_code_java}, resultDemanding.getUserCode());
        }}
    """
