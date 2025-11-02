from generators.users import gerar_user
from generators.activities import gerar_atividades_lista
from pathlib import Path
import warnings
from hypothesis.errors import NonInteractiveExampleWarning
from hypothesis import settings

warnings.filterwarnings("ignore", category=NonInteractiveExampleWarning)


def gerar_construtor_atividade(nome_atividade, atividade):
    tipo = atividade["tipo"]
    user_code_java = f'UUID.fromString("{atividade["user_code"]}")'
    base = f'{tipo} {nome_atividade} = new {tipo}({user_code_java}, {atividade["realization_date"]}, {atividade["expected_duration"]}, "{atividade["designation"]}", "{atividade["name"]}"'

    if tipo == "Running":
        return f"{base}, {atividade['distance']}, {atividade['speed']});"
    elif tipo == "PushUp":
        return f"{base}, {atividade['repetitions']}, {atividade['series']});"
    elif tipo == "Trail":
        return f"{base}, {atividade['distance']}, {atividade['elevation_gain']}, {atividade['elevation_loss']}, {atividade['trail_type']});"
    elif tipo == "WeightSquat":
        return f"{base}, {atividade['repetitions']}, {atividade['series']}, {atividade['weight']});"
    return "// Tipo de atividade não suportado."


def gerar_metodo_user_manager(i, u):
    genero_java = f'Gender.{u["genero"][0].upper() + u["genero"][1:].lower()}'
    tipo = u["tipo"]
    nome = f"u{i}"
    copia = f"{nome}Copia"
    frequencia = u.get("frequencia", 0)
    atividades = gerar_atividades_lista([u]).example()

    construtores = []
    nomes_atividades = []

    for j, atividade in enumerate(atividades):
        nome_atividade = f"act{i}_{j}"
        nomes_atividades.append(nome_atividade)
        linha = gerar_construtor_atividade(nome_atividade, atividade)
        construtores.append(linha)

    atividades_code = ", ".join(nomes_atividades)
    atividades_java = '\n        '.join(construtores)

    atividades_teste = f"""
        {atividades_java}
        for (Activity act : List.of({atividades_code})) {{
            um.addActivityToUser("{u['email'].lower()}", act);
        }}
        assertEquals({len(nomes_atividades)}, um.getUserByEmail("{u['email'].lower()}").getListActivities().size());

        um.removeActivityFromUser("{u['email'].lower()}", {nomes_atividades[0]}.getCode());
        assertEquals({len(nomes_atividades) - 1}, um.getUserByEmail("{u['email'].lower()}").getListActivities().size());
    """.strip()
    atividades_teste += f"""

        // === Testar getActivitiesFromUser ===
        List<Activity> atividades = um.getActivitiesFromUser("{u['email'].lower()}");
        assertEquals({len(nomes_atividades) - 1}, atividades.size());

        // === Testar addActivitiesToUser ===
        um.addActivitiesToUser({nome}.getCode(), List.of({atividades_code}));
        assertEquals({(len(nomes_atividades) - 1) + len(nomes_atividades)}, um.getUserByEmail("{u['email'].lower()}").getListActivities().size());
    """


    return f"""
    @Test
    public void testUserManager_{i}() {{
        UserManager um = new UserManager();

        User {nome} = um.createUser(
            "{u['nome']}", {u['idade']}, {genero_java}, {u['peso']}f, {u['altura']},
            {u['bpm']}, {u['nivel']}, "{u['morada']}", "{u['telemovel']}",
            "{u['email']}", {frequencia}, "{tipo}"
        );
        {nome}.setCode({u["code_java"]});
        assertNotNull({nome});

        User {copia} = um.createUser(
            "{u['nome']}", {u['idade']}, {genero_java}, {u['peso']}f, {u['altura']},
            {u['bpm']}, {u['nivel']}, "{u['morada']}", "{u['telemovel']}",
            "{u['email']}", {frequencia}, "{tipo}"
        );
        {copia}.setCode({u["code_java"]});

        um.insertUser({nome});
        assertTrue(um.existsUserWithEmail("{u['email']}"));

        User porEmail = um.getUserByEmail("{u['email']}");
        assertEquals("{u['nome']}", porEmail.getName());

        um.updateUser({nome});
        assertFalse(um.getAllUsers().isEmpty());

        User porCodigo = um.getUserByCode({nome}.getCode());
        assertEquals({nome}.getEmail(), porCodigo.getEmail());

        // === Testar atividades ===
        {atividades_teste}
        
        

        assertDoesNotThrow(() -> um.updateSystem());

        // === Remoções ===
        um.removeUserByCode({nome}.getCode());
        assertFalse(um.existsUserWithEmail({nome}.getEmail()));

        um.insertUser({copia});
        um.removeUserByEmail("{u['email']}");
        assertFalse(um.existsUserWithEmail("{u['email']}"));
    }}
    """.strip()



def gerar_classe_user_manager():
    settings.register_profile("fast", max_examples=1)
    settings.load_profile("fast")

    metodos = []
    for i in range(10):
        user = gerar_user().example()
        metodo = gerar_metodo_user_manager(i, user)
        metodos.append(metodo)

    codigo = f"""
package test_Hypothesis;

import MakeItFit.users.*;
import MakeItFit.users.types.*;
import MakeItFit.users.UserManager;
import MakeItFit.activities.*;
import MakeItFit.activities.implementation.*;
import MakeItFit.utils.MakeItFitDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerGeneratedTest {{

{chr(10).join(metodos)}

}}
""".strip()

    Path("../../test/java/test_Hypothesis/UserManagerGeneratedTest.java").write_text(codigo, encoding="utf-8")
    print("✅ Ficheiro Java 'UserManagerGeneratedTest.java' criado com sucesso!")


# Executar
gerar_classe_user_manager()

