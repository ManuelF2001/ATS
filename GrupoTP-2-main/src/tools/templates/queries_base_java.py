
def gerar_users_java(data):
    users_java = ""
    user_refs = []
    user_code_to_var = {}

    for idx, u in enumerate(data["users"]):
        tipo = u["tipo"]
        genero_java = f'Gender.{u["genero"][0].upper() + u["genero"][1:].lower()}'
        varname = f"user{idx}"
        user_refs.append(varname)
        user_code_to_var[u["code"]] = varname

        if tipo == "Amateur":
            users_java += f"""
            User {varname} = new {tipo}("{u["nome"]}", {u["idade"]}, {genero_java}, {u["peso"]}f, {u["altura"]}, {u["bpm"]},
                                       {u["nivel"]}, "{u["morada"]}", "{u["telemovel"]}", "{u["email"]}");
            {varname}.setCode({u["code_java"]});
            um.insertUser({varname});
            """
        else:
            users_java += f"""
            User {varname} = new {tipo}("{u["nome"]}", {u["idade"]}, {genero_java}, {u["peso"]}f, {u["altura"]}, {u["bpm"]},
                                       {u["nivel"]}, "{u["morada"]}", "{u["telemovel"]}", "{u["email"]}", {u["frequencia"]});
            {varname}.setCode({u["code_java"]});
            um.insertUser({varname});
            """
    return users_java, user_refs, user_code_to_var





def mapear_atividades_por_user_code(data):
    atividades_user = {u["code"]: [] for u in data["users"]}
    for en, a in enumerate(data["activities"]):
        nome_var = f'act_{en}'
        atividades_user[a["user_code"]].append({
            "atividade_id": a["atividade_id"],
            "nome_var": nome_var
        })
    return atividades_user


def gerar_planos_com_atividades_java(data, user_code_to_var, atividades_user):
    planos_java = ""
    for idx, p in enumerate(data["plans"]):
        tp_var = f"tp_{idx}"
        user_var = user_code_to_var[p["user_code"]]
        planos_java += f"""
            TrainingPlan {tp_var} = new TrainingPlan({user_var}.getCode(), {p["start_date"]});
            tpm.insertTrainingPlan({tp_var});
        """
        for reps, atividade in p["atividades"]:
            user_acts = atividades_user[p["user_code"]]
            nome_var = next(x["nome_var"] for x in user_acts if x["atividade_id"] == atividade["atividade_id"])
            planos_java += f"""
                {tp_var}.addActivity({reps}, {nome_var});
            """
    return planos_java











def gerar_atividades_java(data, user_code_to_var):
    atividades_java = ""
    for en, a in enumerate(data["activities"]):
        tipo = a["tipo"]
        nome_var = f'act_{en}'
        user_var = user_code_to_var[a["user_code"]]
        base = f'{tipo} {nome_var} = new {tipo}({user_var}.getCode(), {a["realization_date"]}, {a["expected_duration"]}, "{a["designation"]}", "{a["name"]}"'
        if tipo == "Running":
            construtor = f"{base}, {a['distance']}, {a['speed']});"
        elif tipo == "PushUp":
            construtor = f"{base}, {a['repetitions']}, {a['series']});"
        elif tipo == "Trail":
            construtor = f"{base}, {a['distance']}, {a['elevation_gain']}, {a['elevation_loss']}, {a['trail_type']});"
        elif tipo == "WeightSquat":
            construtor = f"{base}, {a['repetitions']}, {a['series']}, {a['weight']});"
        atividades_java += f"""
            {construtor}
            {user_var}.addActivity({nome_var});
        """
    return atividades_java



def gerar_asserts_basicos(email):
    return f"""
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "{email}"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "{email}", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "{email}"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "{email}", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryMostDemandingTrainingPlan(tpm, um));
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um, data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um, data1, data2));
    """


