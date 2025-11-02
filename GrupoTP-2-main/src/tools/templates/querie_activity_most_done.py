

def determinar_tipo_atividade_estilo_java(atv):
    t = atv["tipo"]
    if t == "Trail":
        return "DistanceWithAltimetry"
    elif t == "Running":
        return "Distance"
    elif t == "WeightSquat":
        return "RepetitionsWithWeights"
    elif t == "PushUp":
        return "Repetitions"
    return None


def gerar_teste_most_done_activity(data):

    counts = {
        "DistanceWithAltimetry": 0,
        "Distance": 0,
        "RepetitionsWithWeights": 0,
        "Repetitions": 0
    }

    for atv in data["activities"]:
        tipo = determinar_tipo_atividade_estilo_java(atv)
        if tipo:
            counts[tipo] += 1

    # Mesma lógica que o método Java usa: encontrar o índice do máximo e devolver o nome correspondente
    ordem_java = ["DistanceWithAltimetry", "Distance", "RepetitionsWithWeights", "Repetitions"]
    valores = [counts[t] for t in ordem_java]
    max_index = valores.index(max(valores))
    tipo_mais_frequente = ordem_java[max_index]

    return f'''
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        String resultMoreDone = qm.executeQueryMostDoneActivity(um);
        assertEquals("{tipo_mais_frequente}", resultMoreDone);
    '''

