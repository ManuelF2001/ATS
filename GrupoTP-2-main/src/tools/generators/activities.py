
from hypothesis.strategies import composite, floats, integers, text, sampled_from
from generators.time_generator import gerar_data_temporaria
from uuid import uuid4
import string


@composite
def gerar_base_comum(draw, users):
    user = draw(sampled_from(users))
    ano, mes, dia = draw(gerar_data_temporaria())
    realization_date = f"MakeItFitDate.of({ano}, {mes}, {dia})"
    return {
        "atividade_id": str(uuid4()),
        "user_code": user["code"],
        "realization_date": realization_date,
        "expected_duration": draw(integers(min_value=10, max_value=180)),
        "designation": draw(text(string.ascii_letters, min_size=3, max_size=10)),
        "name": draw(text(string.ascii_letters, min_size=3, max_size=10))
    }


@composite
def gerar_running(draw, users):
    base = draw(gerar_base_comum(users))
    distance = round(draw(floats(min_value=0.5, max_value=50.0)), 2)
    speed = round(draw(floats(min_value=1.0, max_value=20.0)), 2)
    return {
        "tipo": "Running",
        **base,
        "distance": distance,
        "speed": speed
    }


@composite
def gerar_pushup(draw, users):
    base = draw(gerar_base_comum(users))
    repetitions = draw(integers(min_value=1, max_value=50))
    series = draw(integers(min_value=1, max_value=10))
    return {
        "tipo": "PushUp",
        **base,
        "repetitions": repetitions,
        "series": series
    }


@composite
def gerar_trail(draw, users):
    base = draw(gerar_base_comum(users))
    distance = round(draw(floats(min_value=0.5, max_value=50.0)), 2)
    elevation_gain = round(draw(floats(min_value=0.0, max_value=1500.0)), 2)
    elevation_loss = round(draw(floats(min_value=0.0, max_value=1500.0)), 2)
    trail_type = draw(integers(min_value=-10, max_value=10))
    return {
        "tipo": "Trail",
        **base,
        "distance": distance,
        "elevation_gain": elevation_gain,
        "elevation_loss": elevation_loss,
        "trail_type": trail_type
    }


@composite
def gerar_weightsquat(draw, users):
    base = draw(gerar_base_comum(users))
    repetitions = draw(integers(min_value=1, max_value=50))
    series = draw(integers(min_value=1, max_value=10))
    weight = round(draw(floats(min_value=1.0, max_value=100.0)), 2)
    return {
        "tipo": "WeightSquat",
        **base,
        "repetitions": repetitions,
        "series": series,
        "weight": weight
    }


@composite
def gerar_atividade(draw, users):
    tipo = draw(sampled_from(["Running", "PushUp", "Trail", "WeightSquat"]))
    if tipo == "Running":
        return draw(gerar_running(users))
    elif tipo == "PushUp":
        return draw(gerar_pushup(users))
    elif tipo == "Trail":
        return draw(gerar_trail(users))
    elif tipo == "WeightSquat":
        return draw(gerar_weightsquat(users))


@composite
def gerar_atividades_lista(draw, users):
    atividades = []

    tipos = [gerar_running, gerar_pushup, gerar_trail, gerar_weightsquat]

    for _ in range(draw(integers(min_value=2, max_value=5))):
        tipo = draw(sampled_from(tipos))
        atividade = draw(tipo(users))
        atividades.append(atividade)

    return atividades



@composite
def gerar_atividade_invalida(draw, users):
    tipo = draw(sampled_from(["Running", "PushUp", "Trail", "WeightSquat"]))
    base = draw(gerar_base_comum(users))

    # Decide: erro comum OU erro específico
    erro_tipo = draw(sampled_from(["comum", "especifico"]))

    if erro_tipo == "comum":
        campo = draw(sampled_from(["expected_duration", "realization_date"]))
        if campo == "expected_duration":
            base["expected_duration"] = draw(integers(min_value=-100, max_value=0))
        elif campo == "realization_date":
            base["realization_date"] = "null"

        # Preencher o resto com valores válidos
        if tipo == "Running":
            return {
                "tipo": "Running",
                **base,
                "distance": round(draw(floats(min_value=0.5, max_value=50.0)), 2),
                "speed": round(draw(floats(min_value=1.0, max_value=20.0)), 2)
            }

        elif tipo == "PushUp":
            return {
                "tipo": "PushUp",
                **base,
                "repetitions": draw(integers(min_value=1, max_value=50)),
                "series": draw(integers(min_value=1, max_value=10))
            }

        elif tipo == "Trail":
            return {
                "tipo": "Trail",
                **base,
                "distance": round(draw(floats(min_value=0.5, max_value=50.0)), 2),
                "elevation_gain": round(draw(floats(min_value=0.0, max_value=1500.0)), 2),
                "elevation_loss": round(draw(floats(min_value=0.0, max_value=1500.0)), 2),
                "trail_type": draw(integers(min_value=0, max_value=2))
            }

        elif tipo == "WeightSquat":
            return {
                "tipo": "WeightSquat",
                **base,
                "repetitions": draw(integers(min_value=1, max_value=50)),
                "series": draw(integers(min_value=1, max_value=10)),
                "weight": round(draw(floats(min_value=1.0, max_value=100.0)), 2)
            }

    else:  # erro específico da modalidade
        if tipo == "Running":
            campo = draw(sampled_from(["distance", "speed"]))
            distance = draw(floats(min_value=-100.0, max_value=0.0)) if campo == "distance" else round(draw(floats(min_value=0.5, max_value=50.0)), 2)
            speed = draw(floats(min_value=-20.0, max_value=0.0)) if campo == "speed" else round(draw(floats(min_value=1.0, max_value=20.0)), 2)
            return {
                "tipo": "Running",
                **base,
                "distance": round(distance, 2),
                "speed": round(speed, 2)
            }

        elif tipo == "PushUp":
            campo = draw(sampled_from(["repetitions", "series"]))
            repetitions = draw(integers(min_value=-10, max_value=0)) if campo == "repetitions" else draw(integers(min_value=1, max_value=50))
            series = draw(integers(min_value=-10, max_value=0)) if campo == "series" else draw(integers(min_value=1, max_value=10))
            return {
                "tipo": "PushUp",
                **base,
                "repetitions": repetitions,
                "series": series
            }

        elif tipo == "Trail":
            campo = draw(sampled_from(["distance", "elevation_gain", "elevation_loss"]))
            distance = draw(floats(min_value=-100.0, max_value=0.0)) if campo == "distance" else draw(floats(min_value=0.5, max_value=50.0))
            elevation_gain = draw(floats(min_value=-200.0, max_value=-1.0)) if campo == "elevation_gain" else draw(floats(min_value=0.0, max_value=1500.0))
            elevation_loss = draw(floats(min_value=-200.0, max_value=-1.0)) if campo == "elevation_loss" else draw(floats(min_value=0.0, max_value=1500.0))
            return {
                "tipo": "Trail",
                **base,
                "distance": round(distance, 2),
                "elevation_gain": round(elevation_gain, 2),
                "elevation_loss": round(elevation_loss, 2),
                "trail_type": draw(integers(min_value=0, max_value=2))
            }

        elif tipo == "WeightSquat":
            campo = draw(sampled_from(["repetitions", "series", "weight"]))
            repetitions = draw(integers(min_value=-10, max_value=0)) if campo == "repetitions" else draw(integers(min_value=1, max_value=50))
            series = draw(integers(min_value=-10, max_value=0)) if campo == "series" else draw(integers(min_value=1, max_value=10))
            weight = draw(floats(min_value=-100.0, max_value=0.0)) if campo == "weight" else draw(floats(min_value=1.0, max_value=100.0))
            return {
                "tipo": "WeightSquat",
                **base,
                "repetitions": repetitions,
                "series": series,
                "weight": round(weight, 2)
            }

