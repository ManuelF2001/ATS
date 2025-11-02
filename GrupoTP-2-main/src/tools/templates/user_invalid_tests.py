from generators.users import gerar_user_invalido
from pathlib import Path
import warnings
from hypothesis.errors import NonInteractiveExampleWarning

warnings.filterwarnings("ignore", category=NonInteractiveExampleWarning)


def gerar_metodo_user_manager_invalido(i, user):
    tipo = user["tipo"]
    genero_java = f'Gender.{user["genero"].capitalize()}'
    nome_java = f"user{i}"
    nome_java = "null" if user["nome"] is None else f'"{user["nome"]}"'
    morada_java = "null" if user["morada"] is None else f'"{user["morada"]}"'
    telemovel_java = "null" if user["telemovel"] is None else f'"{user["telemovel"]}"'
    email_java = "null" if user["email"] is None else f'"{user["email"]}"'

    args_base = f'{nome_java}, {user["idade"]}, {genero_java}, {user["peso"]}f, {user["altura"]}, {user["bpm"]}, {user["nivel"]}, {morada_java}, {telemovel_java}, {email_java}, {user["frequencia"]}, "{tipo}"'


    # Descrição automática do erro
    erros = []
    if user["idade"] <= 0: erros.append("idade <= 0")
    if user["peso"] <= 0: erros.append("peso <= 0")
    if user["altura"] <= 0: erros.append("altura <= 0")
    if user["bpm"] <= 0: erros.append("bpm <= 0")
    if user["frequencia"] < 0 and tipo != "Amateur": erros.append("frequência < 0")

    return f"""
    @Test
    public void testCreateUserInvalido_{i}() {{
        UserManager um = new UserManager();
        // Espera-se erro com: {", ".join(erros)}
        assertThrows(IllegalArgumentException.class, () -> {{
            um.createUser({args_base});
        }});
    }}
    """.strip()


def gerar_classe_user_manager_invalid():
    Path("../../test/java/test_Hypothesis").mkdir(parents=True, exist_ok=True)
    metodos = []

    for i in range(10):  # Podes ajustar para gerar mais testes
        user = gerar_user_invalido().example()
        metodo = gerar_metodo_user_manager_invalido(i, user)
        metodos.append(metodo)

    codigo = f"""
package test_Hypothesis;

import MakeItFit.users.*;
import MakeItFit.users.types.*;
import MakeItFit.exceptions.*;
import MakeItFit.users.Gender;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerInvalidGeneratedTest {{

{chr(10).join(metodos)}

}}""".strip()

    Path("../../test/java/test_Hypothesis/UserManagerInvalidGeneratedTest.java").write_text(codigo, encoding="utf-8")
    print("✅ Ficheiro Java 'UserManagerInvalidGeneratedTest.java' criado com sucesso!")

# Executar
gerar_classe_user_manager_invalid()
