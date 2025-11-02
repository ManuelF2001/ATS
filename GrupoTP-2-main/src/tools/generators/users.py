from hypothesis.strategies import composite, integers, floats, text, sampled_from, just
import string
from uuid import uuid4

from hypothesis.strategies import one_of


@composite
def gerar_tipo(draw):
    return draw(sampled_from(["Amateur", "Occasional", "Professional"]))

@composite
def gerar_nome(draw):
    return draw(text(alphabet=string.ascii_letters, min_size=2, max_size=12))

@composite
def gerar_idade(draw):
    return draw(integers(min_value=10, max_value=100))

@composite
def gerar_genero(draw):
    return draw(sampled_from(["Male", "Female", "Other"]))

@composite
def gerar_peso(draw):
    return round(draw(floats(min_value=30.0, max_value=150.0)), 2)

@composite
def gerar_altura(draw):
    return draw(integers(min_value=120, max_value=220))

@composite
def gerar_bpm(draw):
    return draw(integers(min_value=40, max_value=180))

@composite
def gerar_nivel(draw):
    return draw(integers(min_value=0, max_value=10))

@composite
def gerar_morada(draw):
    return "Rua " + draw(text(alphabet=string.ascii_uppercase, min_size=1, max_size=3))

@composite
def gerar_telemovel(draw):
    return "9" + ''.join(draw(sampled_from(string.digits)) for _ in range(8))

@composite
def gerar_email(draw, nome=None):
    nome = nome or draw(text(alphabet=string.ascii_lowercase, min_size=3, max_size=8))
    sufixo = str(uuid4()).replace("-", "")[:6]  # 6 caracteres únicos
    dominio = draw(text(alphabet=string.ascii_lowercase, min_size=3, max_size=6))
    tld = draw(sampled_from(["com", "pt", "org", "net"]))
    return f"{nome}{sufixo}@{dominio}.{tld}"



@composite
def gerar_frequencia(draw):
    return draw(integers(min_value=1, max_value=15))

def calculate_index(weight, height, bpm):
    return (weight / ((height / 100) * (height / 100))) + (bpm / 40)


@composite
def gerar_user(draw):
    raw_uuid = str(uuid4())
    code = raw_uuid  # usado internamente no Python
    code_java = f'UUID.fromString("{raw_uuid}")'  # usado ao gerar Java
    #code= draw(uuid_strategy())
    tipo = draw(gerar_tipo())
    nome = draw(gerar_nome())
    idade = draw(gerar_idade())
    genero = draw(gerar_genero())
    peso = draw(gerar_peso())
    altura = draw(gerar_altura())
    bpm = draw(gerar_bpm())
    nivel = draw(gerar_nivel())
    morada = draw(gerar_morada())
    telefone = draw(gerar_telemovel())
    email = draw(gerar_email(nome))
    freq = draw(gerar_frequencia()) if tipo != "Amateur" else 0
    index = calculate_index(peso, altura, bpm)


    return {
        "code": code,
        "code_java": code_java,
        "tipo": tipo,
        "nome": nome,
        "idade": idade,
        "genero": genero,
        "peso": peso,
        "altura": altura,
        "bpm": bpm,
        "nivel": nivel,
        "morada": morada,
        "telemovel": telefone,
        "email": email,
        "frequencia": freq,
        "index": index
    }


from hypothesis import assume, reject


@composite
def gerar_user_invalido(draw):
    user = draw(gerar_user())
    erro_tipo = draw(sampled_from(["valores", "nulls"]))  # novo: dois tipos de erro

    if erro_tipo == "valores":
        campo = draw(sampled_from(["idade", "peso", "altura", "bpm", "frequencia"]))

        if campo == "idade":
            user["idade"] = draw(integers(min_value=-5, max_value=0))
        elif campo == "peso":
            user["peso"] = round(draw(floats(min_value=-5.0, max_value=0)), 2)
        elif campo == "altura":
            user["altura"] = 0
        elif campo == "bpm":
            user["bpm"] = draw(integers(min_value=-5, max_value=0))
        elif campo == "frequencia":
            if user["tipo"] == "Amateur":
                reject()  # ignorar, vai gerar outro
            user["frequencia"] = draw(integers(min_value=-5, max_value=-1))

        altura_segura = user["altura"] if user["altura"] > 0 else 1
        user["index"] = calculate_index(user["peso"], altura_segura, user["bpm"])

        assume(
            user["idade"] <= 0 or
            user["peso"] <= 0 or
            user["altura"] <= 0 or
            user["bpm"] <= 0 or
            (user["tipo"] != "Amateur" and user["frequencia"] < 0)
        )

    else:  # erro_tipo == "nulls"
        campo_null = draw(sampled_from(["nome", "morada", "telemovel", "email"]))
        user[campo_null] = None

    return user

