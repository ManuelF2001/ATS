from generators.users import gerar_email, gerar_user
from uuid import uuid4
from pathlib import Path

def gerar_teste_email_codigo_nao_existe(i):
    fake_email = gerar_email().example()
    fake_code = str(uuid4())

    return f"""
    @Test
    public void testEmailOuCodigoInexistente_{i}() {{
        UserManager um = new UserManager();

        assertFalse(um.existsUserWithEmail("{fake_email}"));

        assertThrows(EntityDoesNotExistException.class, () -> {{
            um.getUserByEmail("{fake_email}");
        }});

        assertThrows(EntityDoesNotExistException.class, () -> {{
            um.removeUserByEmail("{fake_email}");
        }});

        UUID codigo = UUID.fromString("{fake_code}");
        assertThrows(EntityDoesNotExistException.class, () -> {{
            um.getUserByCode(codigo);
        }});

        assertThrows(EntityDoesNotExistException.class, () -> {{
            um.removeUserByCode(codigo);
        }});
    }}
    """.strip()


def gerar_teste_email_codigo_duplicado(i):
    user = gerar_user().example()

    genero_java = f'Gender.{user["genero"].capitalize()}'
    code_java = f'UUID.fromString("{user["code"]}")'
    email = user["email"]
    tipo = user["tipo"]
    nome1 = f"userA{i}"
    nome2 = f"userB{i}"

    args = f'"{user["nome"]}", {user["idade"]}, {genero_java}, {user["peso"]}f, {user["altura"]}, {user["bpm"]}, {user["nivel"]}, "{user["morada"]}", "{user["telemovel"]}", "{email}", {user["frequencia"]}, "{tipo}"'

    return f"""
    @Test
    public void testDuplicados_{i}() {{
        UserManager um = new UserManager();

        // Criar dois utilizadores válidos
        User {nome1} = um.createUser({args});
        {nome1}.setCode({code_java});
        um.insertUser({nome1});

        User {nome2} = um.createUser({args});
        {nome2}.setCode({code_java}); // mesmo código

        // Tentar inserir com o mesmo email deve falhar
        assertThrows(ExistingEntityConflictException.class, () -> {{
            um.insertUser({nome2});
        }});
    }}
    """.strip()


def gerar_classe_user_manager_missing_entries():
    Path("../../test/java/test_Hypothesis").mkdir(parents=True, exist_ok=True)
    metodos = []

    # Emails e códigos que não existem
    for i in range(10):
        metodos.append(gerar_teste_email_codigo_nao_existe(i))

    # Tentativas de duplicação (email e código)
    for i in range(10):
        metodos.append(gerar_teste_email_codigo_duplicado(i))

    codigo = f"""
package test_Hypothesis;

import MakeItFit.users.*;
import MakeItFit.users.types.*;
import MakeItFit.exceptions.*;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerMissingEntriesTest {{

{chr(10).join(metodos)}

}}""".strip()

    Path("../../test/java/test_Hypothesis/UserManagerMissingEntriesTest.java").write_text(codigo, encoding="utf-8")
    print("✅ Ficheiro Java 'UserManagerMissingEntriesTest.java' criado com sucesso!")


# Executar
gerar_classe_user_manager_missing_entries()
