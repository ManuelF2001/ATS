from generators.queries_manager import in_interval

from generators.queries_manager import in_interval

def gerar_teste_altimetry(data, user_refs, email, d1, d2):
    altimetria_com_datas = 0
    altimetria_sem_datas = 0

    user_code = next(u["code"] for u in data["users"] if u["email"] == email)

    for a in data["activities"]:
        if a["tipo"] != "Trail":
            continue
        if a["user_code"] != user_code:
            continue  # só consideramos atividades deste user

        gain = a["elevation_gain"]
        loss = a["elevation_loss"]

        if in_interval(a, d1, d2):
            altimetria_com_datas += gain + loss
        altimetria_sem_datas += gain + loss

    return f"""

        double expectedAltimetry = {altimetria_sem_datas};
        double resultAltimetry = qm.executeQueryHowManyAltimetryDone(um, "{email}");
        assertEquals(expectedAltimetry, resultAltimetry, 0.001);

        double expectedAltimetryWithDates = {altimetria_com_datas};
        double resultAltimetryWithDates = qm.executeQueryHowManyAltimetryDone(um, "{email}", data1, data2);
        assertEquals(expectedAltimetryWithDates, resultAltimetryWithDates, 0.001);
    """
