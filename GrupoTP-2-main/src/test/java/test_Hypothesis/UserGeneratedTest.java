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

public class UserGeneratedTest {


    @Test
    public void testUser_0() {
        // Construtor principal
        Amateur u0 = new Amateur("AA", 10, Gender.Male, 30.0f, 120, 40, 0, "Rua A", "900000000", "AA8b23a4@aaa.com");
        assertNotNull(u0);

        // Getters
        assertEquals("AA", u0.getName());
        assertEquals(10, u0.getAge());
        assertEquals(Gender.Male, u0.getGender());
        assertEquals(30.0f, u0.getWeight(), 0.01);
        assertEquals(120, u0.getHeight());
        assertEquals(0, u0.getLevel());
        assertEquals("900000000", u0.getPhone());
        assertEquals("AA8b23a4@aaa.com", u0.getEmail());
        
        //EmailValidator
        assertTrue(EmailValidator.isValidEmail("AA8b23a4@aaa.com"));


        // Setters
        u0.setName("NovoNome");
        u0.setAge(42);
        u0.setGender(Gender.Male);
        u0.setWeight(77.7f);
        u0.setHeight(180);
        u0.setBpm(90);
        u0.setLevel(7);
        u0.setAddress("Rua Teste");
        u0.setPhone("911111111");
        u0.setEmail("teste@email.com");
        u0.setIndex(9.9f);

        assertEquals("NovoNome", u0.getName());
        assertEquals(42, u0.getAge());
        assertEquals(Gender.Male, u0.getGender());
        assertEquals(77.7f, u0.getWeight(), 0.01);
        assertEquals(180, u0.getHeight());
        assertEquals(90, u0.getBpm());
        assertEquals(7, u0.getLevel());
        assertEquals("Rua Teste", u0.getAddress());
        assertEquals("911111111", u0.getPhone());
        assertEquals("teste@email.com", u0.getEmail());
        assertEquals(9.9f, u0.getIndex(), 0.01);

        // equals & toString
        assertNotNull(u0.toString());
        assertNotEquals(u0, new Object());

        // Construtor cópia
        User copia = new Amateur(u0);
        assertEquals(u0.getName(), copia.getName());

        // compareTo
        User cp = new Amateur(u0);
        assertEquals(u0.getName(), cp.getName());
        assertEquals(u0, cp); // já tinham os mesmos valores


        // Alterar idade mantendo o mesmo nome
        User outro = new Amateur("NovoNome", 99, Gender.Male, 77.7f, 180, 90, 7, "Rua Teste", "911111111", "teste@email.com");
        assertTrue(u0.compareTo(outro) < 0); // idade 42 < 99

        // Testar métodos com atividades
        Trail act0 = new Trail(UUID.fromString("59c5f75f-94dc-461a-9826-a83b47a21096"), MakeItFitDate.of(2004, 10, 26), 45, "wtoO", "True", 50.0, 0.0, 0.0, 6);
        u0.addActivity(act0);
        u0.addActivities(List.of(act0));
        int caloriasAntes = act0.getCaloricWaste();
        u0.updateActivities();
        int caloriasDepois = act0.getCaloricWaste();
        assertTrue(caloriasDepois >= caloriasAntes);

        u0.removeActivity(act0.getCode());
        assertNotNull(u0.getListActivities());
        assertNotNull(copia.getListActivities());
        
        
        // clone
        Amateur clone = (Amateur) u0.clone();
        assertEquals(u0.getName(), clone.getName());
        assertEquals(u0.getAge(), clone.getAge());
        assertEquals(u0.getGender(), clone.getGender());
    
    }

    @Test
    public void testUser_1() {
        // Construtor principal
        Professional u1 = new Professional("OVgQ", 53, Gender.Male, 150.0f, 216, 180, 1, "Rua DTD", "966560038", "OVgQ59573f@drz.com", 12);
        assertNotNull(u1);

        // Getters
        assertEquals("OVgQ", u1.getName());
        assertEquals(53, u1.getAge());
        assertEquals(Gender.Male, u1.getGender());
        assertEquals(150.0f, u1.getWeight(), 0.01);
        assertEquals(216, u1.getHeight());
        assertEquals(1, u1.getLevel());
        assertEquals("966560038", u1.getPhone());
        assertEquals("OVgQ59573f@drz.com", u1.getEmail());
        
        //EmailValidator
        assertTrue(EmailValidator.isValidEmail("OVgQ59573f@drz.com"));


        // Setters
        u1.setName("NovoNome");
        u1.setAge(42);
        u1.setGender(Gender.Male);
        u1.setWeight(77.7f);
        u1.setHeight(180);
        u1.setBpm(90);
        u1.setLevel(7);
        u1.setAddress("Rua Teste");
        u1.setPhone("911111111");
        u1.setEmail("teste@email.com");
        u1.setIndex(9.9f);

        assertEquals("NovoNome", u1.getName());
        assertEquals(42, u1.getAge());
        assertEquals(Gender.Male, u1.getGender());
        assertEquals(77.7f, u1.getWeight(), 0.01);
        assertEquals(180, u1.getHeight());
        assertEquals(90, u1.getBpm());
        assertEquals(7, u1.getLevel());
        assertEquals("Rua Teste", u1.getAddress());
        assertEquals("911111111", u1.getPhone());
        assertEquals("teste@email.com", u1.getEmail());
        assertEquals(9.9f, u1.getIndex(), 0.01);

        // equals & toString
        assertNotNull(u1.toString());
        assertNotEquals(u1, new Object());

        // Construtor cópia
        User copia = new Professional(u1);
        assertEquals(u1.getName(), copia.getName());

        // compareTo
        User cp = new Professional(u1);
        assertEquals(u1.getName(), cp.getName());
        assertEquals(u1, cp); // já tinham os mesmos valores


        // Alterar idade mantendo o mesmo nome
        User outro = new Professional("NovoNome", 99, Gender.Male, 77.7f, 180, 90, 7, "Rua Teste", "911111111", "teste@email.com", 12);
        assertTrue(u1.compareTo(outro) < 0); // idade 42 < 99

        // Testar métodos com atividades
        Trail act1 = new Trail(UUID.fromString("c484aada-9136-410e-9ca5-fb365a5fcd23"), MakeItFitDate.of(2010, 4, 7), 29, "YfREeaDtCM", "gonqmKCmQh", 1.5, 202.8, 1.0, 8);
        u1.addActivity(act1);
        u1.addActivities(List.of(act1));
        int caloriasAntes = act1.getCaloricWaste();
        u1.updateActivities();
        int caloriasDepois = act1.getCaloricWaste();
        assertTrue(caloriasDepois >= caloriasAntes);

        u1.removeActivity(act1.getCode());
        assertNotNull(u1.getListActivities());
        assertNotNull(copia.getListActivities());
        
        
        // clone
        Professional clone = (Professional) u1.clone();
        assertEquals(u1.getName(), clone.getName());
        assertEquals(u1.getAge(), clone.getAge());
        assertEquals(u1.getGender(), clone.getGender());
    
        assertEquals(u1.getFrequency(), clone.getFrequency());
        assertEquals(u1.getSpecialization(), clone.getSpecialization());
        
        // Métodos específicos de Professional
        assertEquals(12, u1.getFrequency());
        u1.setFrequency(5);
        assertEquals(5, u1.getFrequency());

        assertEquals("No specialization", u1.getSpecialization()); // valor inicial
        u1.setSpecialization("Trail");
        assertEquals("Trail", u1.getSpecialization());

        // updateSpecialization
        u1.addActivity(act1);
        u1.updateSpecialization();
        assertEquals("Trail", u1.getSpecialization());

        
        
    }

    @Test
    public void testUser_2() {
        // Construtor principal
        Professional u2 = new Professional("ASpJ", 100, Gender.Other, 88.25f, 183, 164, 7, "Rua XRV", "951329499", "ASpJ39596c@jhwq.net", 8);
        assertNotNull(u2);

        // Getters
        assertEquals("ASpJ", u2.getName());
        assertEquals(100, u2.getAge());
        assertEquals(Gender.Other, u2.getGender());
        assertEquals(88.25f, u2.getWeight(), 0.01);
        assertEquals(183, u2.getHeight());
        assertEquals(7, u2.getLevel());
        assertEquals("951329499", u2.getPhone());
        assertEquals("ASpJ39596c@jhwq.net", u2.getEmail());
        
        //EmailValidator
        assertTrue(EmailValidator.isValidEmail("ASpJ39596c@jhwq.net"));


        // Setters
        u2.setName("NovoNome");
        u2.setAge(42);
        u2.setGender(Gender.Male);
        u2.setWeight(77.7f);
        u2.setHeight(180);
        u2.setBpm(90);
        u2.setLevel(7);
        u2.setAddress("Rua Teste");
        u2.setPhone("911111111");
        u2.setEmail("teste@email.com");
        u2.setIndex(9.9f);

        assertEquals("NovoNome", u2.getName());
        assertEquals(42, u2.getAge());
        assertEquals(Gender.Male, u2.getGender());
        assertEquals(77.7f, u2.getWeight(), 0.01);
        assertEquals(180, u2.getHeight());
        assertEquals(90, u2.getBpm());
        assertEquals(7, u2.getLevel());
        assertEquals("Rua Teste", u2.getAddress());
        assertEquals("911111111", u2.getPhone());
        assertEquals("teste@email.com", u2.getEmail());
        assertEquals(9.9f, u2.getIndex(), 0.01);

        // equals & toString
        assertNotNull(u2.toString());
        assertNotEquals(u2, new Object());

        // Construtor cópia
        User copia = new Professional(u2);
        assertEquals(u2.getName(), copia.getName());

        // compareTo
        User cp = new Professional(u2);
        assertEquals(u2.getName(), cp.getName());
        assertEquals(u2, cp); // já tinham os mesmos valores


        // Alterar idade mantendo o mesmo nome
        User outro = new Professional("NovoNome", 99, Gender.Male, 77.7f, 180, 90, 7, "Rua Teste", "911111111", "teste@email.com", 8);
        assertTrue(u2.compareTo(outro) < 0); // idade 42 < 99

        // Testar métodos com atividades
        WeightSquat act2 = new WeightSquat(UUID.fromString("8c8ce936-03fb-4001-b22b-f66849c5f1d1"), MakeItFitDate.of(2020, 9, 19), 180, "pLzttgylkB", "gnhoTOqV", 46, 4, 100.0);
        u2.addActivity(act2);
        u2.addActivities(List.of(act2));
        int caloriasAntes = act2.getCaloricWaste();
        u2.updateActivities();
        int caloriasDepois = act2.getCaloricWaste();
        assertTrue(caloriasDepois >= caloriasAntes);

        u2.removeActivity(act2.getCode());
        assertNotNull(u2.getListActivities());
        assertNotNull(copia.getListActivities());
        
        
        // clone
        Professional clone = (Professional) u2.clone();
        assertEquals(u2.getName(), clone.getName());
        assertEquals(u2.getAge(), clone.getAge());
        assertEquals(u2.getGender(), clone.getGender());
    
        assertEquals(u2.getFrequency(), clone.getFrequency());
        assertEquals(u2.getSpecialization(), clone.getSpecialization());
        
        // Métodos específicos de Professional
        assertEquals(8, u2.getFrequency());
        u2.setFrequency(5);
        assertEquals(5, u2.getFrequency());

        assertEquals("No specialization", u2.getSpecialization()); // valor inicial
        u2.setSpecialization("WeightSquat");
        assertEquals("WeightSquat", u2.getSpecialization());

        // updateSpecialization
        u2.addActivity(act2);
        u2.updateSpecialization();
        assertEquals("WeightSquat", u2.getSpecialization());

        
        
    }

    @Test
    public void testUser_3() {
        // Construtor principal
        Occasional u3 = new Occasional("AxnvJkylSWPp", 24, Gender.Male, 96.46f, 187, 47, 2, "Rua Y", "967010890", "AxnvJkylSWPp39c6b3@xdnaoz.pt", 7);
        assertNotNull(u3);

        // Getters
        assertEquals("AxnvJkylSWPp", u3.getName());
        assertEquals(24, u3.getAge());
        assertEquals(Gender.Male, u3.getGender());
        assertEquals(96.46f, u3.getWeight(), 0.01);
        assertEquals(187, u3.getHeight());
        assertEquals(2, u3.getLevel());
        assertEquals("967010890", u3.getPhone());
        assertEquals("AxnvJkylSWPp39c6b3@xdnaoz.pt", u3.getEmail());
        
        //EmailValidator
        assertTrue(EmailValidator.isValidEmail("AxnvJkylSWPp39c6b3@xdnaoz.pt"));


        // Setters
        u3.setName("NovoNome");
        u3.setAge(42);
        u3.setGender(Gender.Male);
        u3.setWeight(77.7f);
        u3.setHeight(180);
        u3.setBpm(90);
        u3.setLevel(7);
        u3.setAddress("Rua Teste");
        u3.setPhone("911111111");
        u3.setEmail("teste@email.com");
        u3.setIndex(9.9f);

        assertEquals("NovoNome", u3.getName());
        assertEquals(42, u3.getAge());
        assertEquals(Gender.Male, u3.getGender());
        assertEquals(77.7f, u3.getWeight(), 0.01);
        assertEquals(180, u3.getHeight());
        assertEquals(90, u3.getBpm());
        assertEquals(7, u3.getLevel());
        assertEquals("Rua Teste", u3.getAddress());
        assertEquals("911111111", u3.getPhone());
        assertEquals("teste@email.com", u3.getEmail());
        assertEquals(9.9f, u3.getIndex(), 0.01);

        // equals & toString
        assertNotNull(u3.toString());
        assertNotEquals(u3, new Object());

        // Construtor cópia
        User copia = new Occasional(u3);
        assertEquals(u3.getName(), copia.getName());

        // compareTo
        User cp = new Occasional(u3);
        assertEquals(u3.getName(), cp.getName());
        assertEquals(u3, cp); // já tinham os mesmos valores


        // Alterar idade mantendo o mesmo nome
        User outro = new Occasional("NovoNome", 99, Gender.Male, 77.7f, 180, 90, 7, "Rua Teste", "911111111", "teste@email.com", 7);
        assertTrue(u3.compareTo(outro) < 0); // idade 42 < 99

        // Testar métodos com atividades
        Running act3 = new Running(UUID.fromString("729ba2f4-4e35-4187-8abe-614674a50401"), MakeItFitDate.of(2009, 5, 27), 73, "CtXYIDkYhz", "eyz", 1.1, 1.9);
        u3.addActivity(act3);
        u3.addActivities(List.of(act3));
        int caloriasAntes = act3.getCaloricWaste();
        u3.updateActivities();
        int caloriasDepois = act3.getCaloricWaste();
        assertTrue(caloriasDepois >= caloriasAntes);

        u3.removeActivity(act3.getCode());
        assertNotNull(u3.getListActivities());
        assertNotNull(copia.getListActivities());
        
        
        // clone
        Occasional clone = (Occasional) u3.clone();
        assertEquals(u3.getName(), clone.getName());
        assertEquals(u3.getAge(), clone.getAge());
        assertEquals(u3.getGender(), clone.getGender());
    
    }

    @Test
    public void testUser_4() {
        // Construtor principal
        Occasional u4 = new Occasional("wmD", 21, Gender.Female, 150.0f, 198, 149, 6, "Rua I", "923539267", "wmDd65071@xpcn.com", 2);
        assertNotNull(u4);

        // Getters
        assertEquals("wmD", u4.getName());
        assertEquals(21, u4.getAge());
        assertEquals(Gender.Female, u4.getGender());
        assertEquals(150.0f, u4.getWeight(), 0.01);
        assertEquals(198, u4.getHeight());
        assertEquals(6, u4.getLevel());
        assertEquals("923539267", u4.getPhone());
        assertEquals("wmDd65071@xpcn.com", u4.getEmail());
        
        //EmailValidator
        assertTrue(EmailValidator.isValidEmail("wmDd65071@xpcn.com"));


        // Setters
        u4.setName("NovoNome");
        u4.setAge(42);
        u4.setGender(Gender.Male);
        u4.setWeight(77.7f);
        u4.setHeight(180);
        u4.setBpm(90);
        u4.setLevel(7);
        u4.setAddress("Rua Teste");
        u4.setPhone("911111111");
        u4.setEmail("teste@email.com");
        u4.setIndex(9.9f);

        assertEquals("NovoNome", u4.getName());
        assertEquals(42, u4.getAge());
        assertEquals(Gender.Male, u4.getGender());
        assertEquals(77.7f, u4.getWeight(), 0.01);
        assertEquals(180, u4.getHeight());
        assertEquals(90, u4.getBpm());
        assertEquals(7, u4.getLevel());
        assertEquals("Rua Teste", u4.getAddress());
        assertEquals("911111111", u4.getPhone());
        assertEquals("teste@email.com", u4.getEmail());
        assertEquals(9.9f, u4.getIndex(), 0.01);

        // equals & toString
        assertNotNull(u4.toString());
        assertNotEquals(u4, new Object());

        // Construtor cópia
        User copia = new Occasional(u4);
        assertEquals(u4.getName(), copia.getName());

        // compareTo
        User cp = new Occasional(u4);
        assertEquals(u4.getName(), cp.getName());
        assertEquals(u4, cp); // já tinham os mesmos valores


        // Alterar idade mantendo o mesmo nome
        User outro = new Occasional("NovoNome", 99, Gender.Male, 77.7f, 180, 90, 7, "Rua Teste", "911111111", "teste@email.com", 2);
        assertTrue(u4.compareTo(outro) < 0); // idade 42 < 99

        // Testar métodos com atividades
        WeightSquat act4 = new WeightSquat(UUID.fromString("eb7da961-435c-4c26-a2a9-2715146370c6"), MakeItFitDate.of(2018, 8, 15), 105, "xUVJ", "hnCzJD", 33, 2, 1.1);
        u4.addActivity(act4);
        u4.addActivities(List.of(act4));
        int caloriasAntes = act4.getCaloricWaste();
        u4.updateActivities();
        int caloriasDepois = act4.getCaloricWaste();
        assertTrue(caloriasDepois >= caloriasAntes);

        u4.removeActivity(act4.getCode());
        assertNotNull(u4.getListActivities());
        assertNotNull(copia.getListActivities());
        
        
        // clone
        Occasional clone = (Occasional) u4.clone();
        assertEquals(u4.getName(), clone.getName());
        assertEquals(u4.getAge(), clone.getAge());
        assertEquals(u4.getGender(), clone.getGender());
    
    }

    @Test
    public void testUser_5() {
        // Construtor principal
        Occasional u5 = new Occasional("AA", 10, Gender.Male, 30.0f, 120, 40, 0, "Rua A", "900000000", "AA946312@aaa.com", 1);
        assertNotNull(u5);

        // Getters
        assertEquals("AA", u5.getName());
        assertEquals(10, u5.getAge());
        assertEquals(Gender.Male, u5.getGender());
        assertEquals(30.0f, u5.getWeight(), 0.01);
        assertEquals(120, u5.getHeight());
        assertEquals(0, u5.getLevel());
        assertEquals("900000000", u5.getPhone());
        assertEquals("AA946312@aaa.com", u5.getEmail());
        
        //EmailValidator
        assertTrue(EmailValidator.isValidEmail("AA946312@aaa.com"));


        // Setters
        u5.setName("NovoNome");
        u5.setAge(42);
        u5.setGender(Gender.Male);
        u5.setWeight(77.7f);
        u5.setHeight(180);
        u5.setBpm(90);
        u5.setLevel(7);
        u5.setAddress("Rua Teste");
        u5.setPhone("911111111");
        u5.setEmail("teste@email.com");
        u5.setIndex(9.9f);

        assertEquals("NovoNome", u5.getName());
        assertEquals(42, u5.getAge());
        assertEquals(Gender.Male, u5.getGender());
        assertEquals(77.7f, u5.getWeight(), 0.01);
        assertEquals(180, u5.getHeight());
        assertEquals(90, u5.getBpm());
        assertEquals(7, u5.getLevel());
        assertEquals("Rua Teste", u5.getAddress());
        assertEquals("911111111", u5.getPhone());
        assertEquals("teste@email.com", u5.getEmail());
        assertEquals(9.9f, u5.getIndex(), 0.01);

        // equals & toString
        assertNotNull(u5.toString());
        assertNotEquals(u5, new Object());

        // Construtor cópia
        User copia = new Occasional(u5);
        assertEquals(u5.getName(), copia.getName());

        // compareTo
        User cp = new Occasional(u5);
        assertEquals(u5.getName(), cp.getName());
        assertEquals(u5, cp); // já tinham os mesmos valores


        // Alterar idade mantendo o mesmo nome
        User outro = new Occasional("NovoNome", 99, Gender.Male, 77.7f, 180, 90, 7, "Rua Teste", "911111111", "teste@email.com", 1);
        assertTrue(u5.compareTo(outro) < 0); // idade 42 < 99

        // Testar métodos com atividades
        WeightSquat act5 = new WeightSquat(UUID.fromString("e590e274-75c2-4be9-a3b4-2016c41a6f93"), MakeItFitDate.of(2000, 8, 23), 51, "MIAA", "gTk", 21, 1, 1.0);
        u5.addActivity(act5);
        u5.addActivities(List.of(act5));
        int caloriasAntes = act5.getCaloricWaste();
        u5.updateActivities();
        int caloriasDepois = act5.getCaloricWaste();
        assertTrue(caloriasDepois >= caloriasAntes);

        u5.removeActivity(act5.getCode());
        assertNotNull(u5.getListActivities());
        assertNotNull(copia.getListActivities());
        
        
        // clone
        Occasional clone = (Occasional) u5.clone();
        assertEquals(u5.getName(), clone.getName());
        assertEquals(u5.getAge(), clone.getAge());
        assertEquals(u5.getGender(), clone.getGender());
    
    }

    @Test
    public void testUser_6() {
        // Construtor principal
        Occasional u6 = new Occasional("AA", 10, Gender.Male, 30.0f, 120, 40, 0, "Rua A", "900000000", "AAd9b9ee@aaa.com", 1);
        assertNotNull(u6);

        // Getters
        assertEquals("AA", u6.getName());
        assertEquals(10, u6.getAge());
        assertEquals(Gender.Male, u6.getGender());
        assertEquals(30.0f, u6.getWeight(), 0.01);
        assertEquals(120, u6.getHeight());
        assertEquals(0, u6.getLevel());
        assertEquals("900000000", u6.getPhone());
        assertEquals("AAd9b9ee@aaa.com", u6.getEmail());
        
        //EmailValidator
        assertTrue(EmailValidator.isValidEmail("AAd9b9ee@aaa.com"));


        // Setters
        u6.setName("NovoNome");
        u6.setAge(42);
        u6.setGender(Gender.Male);
        u6.setWeight(77.7f);
        u6.setHeight(180);
        u6.setBpm(90);
        u6.setLevel(7);
        u6.setAddress("Rua Teste");
        u6.setPhone("911111111");
        u6.setEmail("teste@email.com");
        u6.setIndex(9.9f);

        assertEquals("NovoNome", u6.getName());
        assertEquals(42, u6.getAge());
        assertEquals(Gender.Male, u6.getGender());
        assertEquals(77.7f, u6.getWeight(), 0.01);
        assertEquals(180, u6.getHeight());
        assertEquals(90, u6.getBpm());
        assertEquals(7, u6.getLevel());
        assertEquals("Rua Teste", u6.getAddress());
        assertEquals("911111111", u6.getPhone());
        assertEquals("teste@email.com", u6.getEmail());
        assertEquals(9.9f, u6.getIndex(), 0.01);

        // equals & toString
        assertNotNull(u6.toString());
        assertNotEquals(u6, new Object());

        // Construtor cópia
        User copia = new Occasional(u6);
        assertEquals(u6.getName(), copia.getName());

        // compareTo
        User cp = new Occasional(u6);
        assertEquals(u6.getName(), cp.getName());
        assertEquals(u6, cp); // já tinham os mesmos valores


        // Alterar idade mantendo o mesmo nome
        User outro = new Occasional("NovoNome", 99, Gender.Male, 77.7f, 180, 90, 7, "Rua Teste", "911111111", "teste@email.com", 1);
        assertTrue(u6.compareTo(outro) < 0); // idade 42 < 99

        // Testar métodos com atividades
        Running act6 = new Running(UUID.fromString("dc0f4159-0f81-4159-9067-6e5576444e50"), MakeItFitDate.of(2025, 11, 14), 51, "miT", "pJqUVmst", 0.5, 1.0);
        u6.addActivity(act6);
        u6.addActivities(List.of(act6));
        int caloriasAntes = act6.getCaloricWaste();
        u6.updateActivities();
        int caloriasDepois = act6.getCaloricWaste();
        assertTrue(caloriasDepois >= caloriasAntes);

        u6.removeActivity(act6.getCode());
        assertNotNull(u6.getListActivities());
        assertNotNull(copia.getListActivities());
        
        
        // clone
        Occasional clone = (Occasional) u6.clone();
        assertEquals(u6.getName(), clone.getName());
        assertEquals(u6.getAge(), clone.getAge());
        assertEquals(u6.getGender(), clone.getGender());
    
    }

    @Test
    public void testUser_7() {
        // Construtor principal
        Amateur u7 = new Amateur("cPrt", 75, Gender.Male, 30.0f, 204, 107, 5, "Rua R", "960199512", "cPrtd33c52@tlgugf.net");
        assertNotNull(u7);

        // Getters
        assertEquals("cPrt", u7.getName());
        assertEquals(75, u7.getAge());
        assertEquals(Gender.Male, u7.getGender());
        assertEquals(30.0f, u7.getWeight(), 0.01);
        assertEquals(204, u7.getHeight());
        assertEquals(5, u7.getLevel());
        assertEquals("960199512", u7.getPhone());
        assertEquals("cPrtd33c52@tlgugf.net", u7.getEmail());
        
        //EmailValidator
        assertTrue(EmailValidator.isValidEmail("cPrtd33c52@tlgugf.net"));


        // Setters
        u7.setName("NovoNome");
        u7.setAge(42);
        u7.setGender(Gender.Male);
        u7.setWeight(77.7f);
        u7.setHeight(180);
        u7.setBpm(90);
        u7.setLevel(7);
        u7.setAddress("Rua Teste");
        u7.setPhone("911111111");
        u7.setEmail("teste@email.com");
        u7.setIndex(9.9f);

        assertEquals("NovoNome", u7.getName());
        assertEquals(42, u7.getAge());
        assertEquals(Gender.Male, u7.getGender());
        assertEquals(77.7f, u7.getWeight(), 0.01);
        assertEquals(180, u7.getHeight());
        assertEquals(90, u7.getBpm());
        assertEquals(7, u7.getLevel());
        assertEquals("Rua Teste", u7.getAddress());
        assertEquals("911111111", u7.getPhone());
        assertEquals("teste@email.com", u7.getEmail());
        assertEquals(9.9f, u7.getIndex(), 0.01);

        // equals & toString
        assertNotNull(u7.toString());
        assertNotEquals(u7, new Object());

        // Construtor cópia
        User copia = new Amateur(u7);
        assertEquals(u7.getName(), copia.getName());

        // compareTo
        User cp = new Amateur(u7);
        assertEquals(u7.getName(), cp.getName());
        assertEquals(u7, cp); // já tinham os mesmos valores


        // Alterar idade mantendo o mesmo nome
        User outro = new Amateur("NovoNome", 99, Gender.Male, 77.7f, 180, 90, 7, "Rua Teste", "911111111", "teste@email.com");
        assertTrue(u7.compareTo(outro) < 0); // idade 42 < 99

        // Testar métodos com atividades
        WeightSquat act7 = new WeightSquat(UUID.fromString("b67f31da-609f-4219-8766-8eccbeb70de6"), MakeItFitDate.of(2014, 10, 10), 82, "IJfgHpCgW", "ZVG", 25, 2, 99.0);
        u7.addActivity(act7);
        u7.addActivities(List.of(act7));
        int caloriasAntes = act7.getCaloricWaste();
        u7.updateActivities();
        int caloriasDepois = act7.getCaloricWaste();
        assertTrue(caloriasDepois >= caloriasAntes);

        u7.removeActivity(act7.getCode());
        assertNotNull(u7.getListActivities());
        assertNotNull(copia.getListActivities());
        
        
        // clone
        Amateur clone = (Amateur) u7.clone();
        assertEquals(u7.getName(), clone.getName());
        assertEquals(u7.getAge(), clone.getAge());
        assertEquals(u7.getGender(), clone.getGender());
    
    }

    @Test
    public void testUser_8() {
        // Construtor principal
        Amateur u8 = new Amateur("bimmE", 27, Gender.Other, 141.14f, 186, 81, 5, "Rua BNG", "969482784", "bimmEddd2bd@mwddup.com");
        assertNotNull(u8);

        // Getters
        assertEquals("bimmE", u8.getName());
        assertEquals(27, u8.getAge());
        assertEquals(Gender.Other, u8.getGender());
        assertEquals(141.14f, u8.getWeight(), 0.01);
        assertEquals(186, u8.getHeight());
        assertEquals(5, u8.getLevel());
        assertEquals("969482784", u8.getPhone());
        assertEquals("bimmEddd2bd@mwddup.com", u8.getEmail());
        
        //EmailValidator
        assertTrue(EmailValidator.isValidEmail("bimmEddd2bd@mwddup.com"));


        // Setters
        u8.setName("NovoNome");
        u8.setAge(42);
        u8.setGender(Gender.Male);
        u8.setWeight(77.7f);
        u8.setHeight(180);
        u8.setBpm(90);
        u8.setLevel(7);
        u8.setAddress("Rua Teste");
        u8.setPhone("911111111");
        u8.setEmail("teste@email.com");
        u8.setIndex(9.9f);

        assertEquals("NovoNome", u8.getName());
        assertEquals(42, u8.getAge());
        assertEquals(Gender.Male, u8.getGender());
        assertEquals(77.7f, u8.getWeight(), 0.01);
        assertEquals(180, u8.getHeight());
        assertEquals(90, u8.getBpm());
        assertEquals(7, u8.getLevel());
        assertEquals("Rua Teste", u8.getAddress());
        assertEquals("911111111", u8.getPhone());
        assertEquals("teste@email.com", u8.getEmail());
        assertEquals(9.9f, u8.getIndex(), 0.01);

        // equals & toString
        assertNotNull(u8.toString());
        assertNotEquals(u8, new Object());

        // Construtor cópia
        User copia = new Amateur(u8);
        assertEquals(u8.getName(), copia.getName());

        // compareTo
        User cp = new Amateur(u8);
        assertEquals(u8.getName(), cp.getName());
        assertEquals(u8, cp); // já tinham os mesmos valores


        // Alterar idade mantendo o mesmo nome
        User outro = new Amateur("NovoNome", 99, Gender.Male, 77.7f, 180, 90, 7, "Rua Teste", "911111111", "teste@email.com");
        assertTrue(u8.compareTo(outro) < 0); // idade 42 < 99

        // Testar métodos com atividades
        WeightSquat act8 = new WeightSquat(UUID.fromString("12b18f7b-e22d-4be0-8b67-c5564431b51e"), MakeItFitDate.of(2017, 4, 28), 27, "tMQAJChim", "kkL", 48, 3, 17.49);
        u8.addActivity(act8);
        u8.addActivities(List.of(act8));
        int caloriasAntes = act8.getCaloricWaste();
        u8.updateActivities();
        int caloriasDepois = act8.getCaloricWaste();
        assertTrue(caloriasDepois >= caloriasAntes);

        u8.removeActivity(act8.getCode());
        assertNotNull(u8.getListActivities());
        assertNotNull(copia.getListActivities());
        
        
        // clone
        Amateur clone = (Amateur) u8.clone();
        assertEquals(u8.getName(), clone.getName());
        assertEquals(u8.getAge(), clone.getAge());
        assertEquals(u8.getGender(), clone.getGender());
    
    }

    @Test
    public void testUser_9() {
        // Construtor principal
        Amateur u9 = new Amateur("kqhonZwQsPqH", 97, Gender.Female, 106.93f, 142, 114, 7, "Rua RXY", "997649067", "kqhonZwQsPqH1f2419@ftsk.org");
        assertNotNull(u9);

        // Getters
        assertEquals("kqhonZwQsPqH", u9.getName());
        assertEquals(97, u9.getAge());
        assertEquals(Gender.Female, u9.getGender());
        assertEquals(106.93f, u9.getWeight(), 0.01);
        assertEquals(142, u9.getHeight());
        assertEquals(7, u9.getLevel());
        assertEquals("997649067", u9.getPhone());
        assertEquals("kqhonZwQsPqH1f2419@ftsk.org", u9.getEmail());
        
        //EmailValidator
        assertTrue(EmailValidator.isValidEmail("kqhonZwQsPqH1f2419@ftsk.org"));


        // Setters
        u9.setName("NovoNome");
        u9.setAge(42);
        u9.setGender(Gender.Male);
        u9.setWeight(77.7f);
        u9.setHeight(180);
        u9.setBpm(90);
        u9.setLevel(7);
        u9.setAddress("Rua Teste");
        u9.setPhone("911111111");
        u9.setEmail("teste@email.com");
        u9.setIndex(9.9f);

        assertEquals("NovoNome", u9.getName());
        assertEquals(42, u9.getAge());
        assertEquals(Gender.Male, u9.getGender());
        assertEquals(77.7f, u9.getWeight(), 0.01);
        assertEquals(180, u9.getHeight());
        assertEquals(90, u9.getBpm());
        assertEquals(7, u9.getLevel());
        assertEquals("Rua Teste", u9.getAddress());
        assertEquals("911111111", u9.getPhone());
        assertEquals("teste@email.com", u9.getEmail());
        assertEquals(9.9f, u9.getIndex(), 0.01);

        // equals & toString
        assertNotNull(u9.toString());
        assertNotEquals(u9, new Object());

        // Construtor cópia
        User copia = new Amateur(u9);
        assertEquals(u9.getName(), copia.getName());

        // compareTo
        User cp = new Amateur(u9);
        assertEquals(u9.getName(), cp.getName());
        assertEquals(u9, cp); // já tinham os mesmos valores


        // Alterar idade mantendo o mesmo nome
        User outro = new Amateur("NovoNome", 99, Gender.Male, 77.7f, 180, 90, 7, "Rua Teste", "911111111", "teste@email.com");
        assertTrue(u9.compareTo(outro) < 0); // idade 42 < 99

        // Testar métodos com atividades
        Trail act9 = new Trail(UUID.fromString("9827372c-a634-4c00-875c-57189bf570ba"), MakeItFitDate.of(2005, 8, 1), 146, "GOCDLDGZe", "NGzWxQGLfI", 50.0, 0.0, 0.0, 7);
        u9.addActivity(act9);
        u9.addActivities(List.of(act9));
        int caloriasAntes = act9.getCaloricWaste();
        u9.updateActivities();
        int caloriasDepois = act9.getCaloricWaste();
        assertTrue(caloriasDepois >= caloriasAntes);

        u9.removeActivity(act9.getCode());
        assertNotNull(u9.getListActivities());
        assertNotNull(copia.getListActivities());
        
        
        // clone
        Amateur clone = (Amateur) u9.clone();
        assertEquals(u9.getName(), clone.getName());
        assertEquals(u9.getAge(), clone.getAge());
        assertEquals(u9.getGender(), clone.getGender());
    
    }

}