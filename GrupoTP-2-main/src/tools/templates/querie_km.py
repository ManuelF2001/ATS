from generators.queries_manager import in_interval

def calcular_kms_user(data, email, d1=None, d2=None):
    kms = 0.0
    users_by_code = {u["code"]: u for u in data["users"]}
    for a in data["activities"]:
        if a["tipo"] not in ("Running", "Trail"):
            continue
        user = users_by_code[a["user_code"]]
        if user["email"] != email:
            continue
        if d1 is not None and d2 is not None:
            if not in_interval(a, d1, d2):
                continue
        kms += a["distance"]
    return kms / 1000




def gerar_teste_kms_done(data, email, d1, d2):
    # Calcula o esperado sem datas
    expected_kms = calcular_kms_user(data, email)
    # Calcula o esperado com datas
    expected_kms_with_dates = calcular_kms_user(data, email, d1, d2)
    return f"""

        double expectedKMs = {expected_kms};
        double resultKMs = qm.executeQueryHowManyKMsDone(um, "{email}");
        assertEquals(expectedKMs, resultKMs, 0.001);

        double expectedKMsWithDates = {expected_kms_with_dates};
        double resultKMsWithDates = qm.executeQueryHowManyKMsDone(um, "{email}", data1, data2);
        assertEquals(expectedKMsWithDates, resultKMsWithDates, 0.001);
    """



