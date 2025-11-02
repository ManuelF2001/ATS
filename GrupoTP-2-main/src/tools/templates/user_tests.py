from generators.users import gerar_user
from generators.activities import gerar_atividade
from pathlib import Path

import warnings
from hypothesis.errors import NonInteractiveExampleWarning
warnings.filterwarnings("ignore", category=NonInteractiveExampleWarning)


def gerar_metodo_teste(i, user):
    tipo = user["tipo"]
    genero_java = f'Gender.{user["genero"][0].upper() + user["genero"][1:].lower()}'
    classe = tipo
    nome_obj = f"u{i}"

    if tipo == "Amateur":
        construtor = f'{classe} {nome_obj} = new {classe}("{user["nome"]}", {user["idade"]}, {genero_java}, {user["peso"]}f, {user["altura"]}, {user["bpm"]}, {user["nivel"]}, "{user["morada"]}", "{user["telemovel"]}", "{user["email"]}");'
    else:
        construtor = f'{classe} {nome_obj} = new {classe}("{user["nome"]}", {user["idade"]}, {genero_java}, {user["peso"]}f, {user["altura"]}, {user["bpm"]}, {user["nivel"]}, "{user["morada"]}", "{user["telemovel"]}", "{user["email"]}", {user["frequencia"]});'

    atividade = gerar_atividade([user]).example()
    tipo_atividade = atividade["tipo"]
    nome_atividade = f"act{i}"
    user_code_java = f'UUID.fromString("{atividade["user_code"]}")'
    base_atividade = f'{tipo_atividade} {nome_atividade} = new {tipo_atividade}({user_code_java}, {atividade["realization_date"]}, {atividade["expected_duration"]}, "{atividade["designation"]}", "{atividade["name"]}"'

    if tipo_atividade == "Running":
        construtor_atividade = f"{base_atividade}, {atividade['distance']}, {atividade['speed']});"
    elif tipo_atividade == "PushUp":
        construtor_atividade = f"{base_atividade}, {atividade['repetitions']}, {atividade['series']});"
    elif tipo_atividade == "Trail":
        construtor_atividade = f"{base_atividade}, {atividade['distance']}, {atividade['elevation_gain']}, {atividade['elevation_loss']}, {atividade['trail_type']});"
    elif tipo_atividade == "WeightSquat":
        construtor_atividade = f"{base_atividade}, {atividade['repetitions']}, {atividade['series']}, {atividade['weight']});"

    linha_outro = f'User outro = new {classe}("NovoNome", 99, Gender.Male, 77.7f, 180, 90, 7, "Rua Teste", "911111111", "teste@email.com"'
    if tipo != "Amateur":
        linha_outro += f", {user['frequencia']}"
    linha_outro += ");"

    metodo_base = f"""
    @Test
    public void testUser_{i}() {{
        // Construtor principal
        {construtor}
        assertNotNull({nome_obj});

        // Getters
        assertEquals("{user["nome"]}", {nome_obj}.getName());
        assertEquals({user["idade"]}, {nome_obj}.getAge());
        assertEquals({genero_java}, {nome_obj}.getGender());
        assertEquals({user["peso"]}f, {nome_obj}.getWeight(), 0.01);
        assertEquals({user["altura"]}, {nome_obj}.getHeight());
        assertEquals({user["nivel"]}, {nome_obj}.getLevel());
        assertEquals("{user["telemovel"]}", {nome_obj}.getPhone());
        assertEquals("{user["email"]}", {nome_obj}.getEmail());
        
        //EmailValidator
        assertTrue(EmailValidator.isValidEmail("{user["email"]}"));


        // Setters
        {nome_obj}.setName("NovoNome");
        {nome_obj}.setAge(42);
        {nome_obj}.setGender(Gender.Male);
        {nome_obj}.setWeight(77.7f);
        {nome_obj}.setHeight(180);
        {nome_obj}.setBpm(90);
        {nome_obj}.setLevel(7);
        {nome_obj}.setAddress("Rua Teste");
        {nome_obj}.setPhone("911111111");
        {nome_obj}.setEmail("teste@email.com");
        {nome_obj}.setIndex(9.9f);

        assertEquals("NovoNome", {nome_obj}.getName());
        assertEquals(42, {nome_obj}.getAge());
        assertEquals(Gender.Male, {nome_obj}.getGender());
        assertEquals(77.7f, {nome_obj}.getWeight(), 0.01);
        assertEquals(180, {nome_obj}.getHeight());
        assertEquals(90, {nome_obj}.getBpm());
        assertEquals(7, {nome_obj}.getLevel());
        assertEquals("Rua Teste", {nome_obj}.getAddress());
        assertEquals("911111111", {nome_obj}.getPhone());
        assertEquals("teste@email.com", {nome_obj}.getEmail());
        assertEquals(9.9f, {nome_obj}.getIndex(), 0.01);

        // equals & toString
        assertNotNull({nome_obj}.toString());
        assertNotEquals({nome_obj}, new Object());

        // Construtor cópia
        User copia = new {classe}({nome_obj});
        assertEquals({nome_obj}.getName(), copia.getName());

        // compareTo
        User cp = new {classe}({nome_obj});
        assertEquals({nome_obj}.getName(), cp.getName());
        assertEquals({nome_obj}, cp); // já tinham os mesmos valores


        // Alterar idade mantendo o mesmo nome
        {linha_outro}
        assertTrue({nome_obj}.compareTo(outro) < 0); // idade 42 < 99

        // Testar métodos com atividades
        {construtor_atividade}
        {nome_obj}.addActivity({nome_atividade});
        {nome_obj}.addActivities(List.of({nome_atividade}));
        int caloriasAntes = {nome_atividade}.getCaloricWaste();
        {nome_obj}.updateActivities();
        int caloriasDepois = {nome_atividade}.getCaloricWaste();
        assertTrue(caloriasDepois >= caloriasAntes);

        {nome_obj}.removeActivity({nome_atividade}.getCode());
        assertNotNull({nome_obj}.getListActivities());
        assertNotNull(copia.getListActivities());
        
        
        // clone
        {classe} clone = ({classe}) {nome_obj}.clone();
        assertEquals({nome_obj}.getName(), clone.getName());
        assertEquals({nome_obj}.getAge(), clone.getAge());
        assertEquals({nome_obj}.getGender(), clone.getGender());
    """

    if tipo == "Professional":
        bloco_professional = f"""
        assertEquals({nome_obj}.getFrequency(), clone.getFrequency());
        assertEquals({nome_obj}.getSpecialization(), clone.getSpecialization());
        
        // Métodos específicos de Professional
        assertEquals({user["frequencia"]}, {nome_obj}.getFrequency());
        {nome_obj}.setFrequency(5);
        assertEquals(5, {nome_obj}.getFrequency());

        assertEquals("No specialization", {nome_obj}.getSpecialization()); // valor inicial
        {nome_obj}.setSpecialization("{tipo_atividade}");
        assertEquals("{tipo_atividade}", {nome_obj}.getSpecialization());

        // updateSpecialization
        {nome_obj}.addActivity({nome_atividade});
        {nome_obj}.updateSpecialization();
        assertEquals("{tipo_atividade}", {nome_obj}.getSpecialization());

        
        """
        return metodo_base + bloco_professional + "\n    }"
    else:
        return metodo_base + "\n    }"



# Junta tudo num ficheiro .java
def gerar_classe_java():
    metodos = []
    for i in range(10):  # Podes ajustar o número de utilizadores/testes
        user = gerar_user().example()
        metodo = gerar_metodo_teste(i, user)
        metodos.append(metodo)

    codigo = f"""
package test_Hypothesis;

import MakeItFit.users.*;
import MakeItFit.users.types.*;
import MakeItFit.users.Gender;
import MakeItFit.activities.*;
import MakeItFit.activities.implementation.*;
import MakeItFit.utils.*;


import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserGeneratedTest {{

{chr(10).join(metodos)}

}}
""".strip()

    Path("../../test/java/test_Hypothesis/UserGeneratedTest.java").write_text(codigo, encoding="utf-8")
    print("✅ Ficheiro Java 'UserGeneratedTest.java' criado com sucesso!")

# Executar
gerar_classe_java()