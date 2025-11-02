from hypothesis.strategies import composite, integers,  sampled_from

@composite
def gerar_data_temporaria(draw):
    ano = draw(integers(min_value=2000, max_value=2025))
    mes = draw(integers(min_value=1, max_value=12))
    dia = draw(integers(min_value=1, max_value=28))  # Evita datas inválidas
    return (ano, mes, dia)




@composite
def gerar_datas_invalidas(draw):
    erro = draw(sampled_from([
        "data1_null",
        "data2_null",
        "data2_antes_ou_igual"
    ]))

    if erro == "data1_null":
        data1 = "null"
        data2 = "MakeItFitDate.of(2024, 5, 10)"
    elif erro == "data2_null":
        data1 = "MakeItFitDate.of(2024, 5, 10)"
        data2 = "null"
    else:  # "data2_antes_ou_igual"
        y = draw(integers(min_value=2020, max_value=2024))
        m = draw(integers(min_value=1, max_value=12))
        d = draw(integers(min_value=1, max_value=28))
        data1 = f"MakeItFitDate.of({y}, {m}, {d})"
        y2 = draw(integers(min_value=2015, max_value=2020))
        m2 = draw(integers(min_value=1, max_value=12))
        d2 = draw(integers(min_value=1, max_value=28))
        data2 = f"MakeItFitDate.of({y2}, {m2}, {d2})"

    return {
        "erro": erro,
        "data1": data1,
        "data2": data2
    }
