package test_Hypothesis;
import MakeItFit.utils.MyTuple;
import MakeItFit.activities.HardInterface;
import MakeItFit.trainingPlan.*;
import MakeItFit.activities.Activity;
import MakeItFit.activities.implementation.*;
import MakeItFit.utils.MakeItFitDate;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Timeout;

public class TrainingPlanManagerGeneratedTest {

@Test
    @Timeout(30)
    public void testTrainingPlanManager_0() {
        TrainingPlanManager tpm0 = new TrainingPlanManager();
        TrainingPlan tp0 = tpm0.createTrainingPlan(UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"), MakeItFitDate.of(2008, 6, 1));
        UUID code = tp0.getCode();
        assertNotNull(tp0);

        tpm0.insertTrainingPlan(tp0);
        assertEquals(tp0, tpm0.getTrainingPlan(code));

        // Teste de remoção
        tpm0.removeTrainingPlan(code);
        assertThrows(IllegalArgumentException.class, () -> tpm0.getTrainingPlan(code));

        // Reinserção e continuação de testes
        tpm0.insertTrainingPlan(tp0);

        WeightSquat act0 = new WeightSquat(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"), MakeItFitDate.of(2018, 2, 3), 121, "TKWbciddaq", "INF", 2, 2, 1.0);
        tpm0.addActivity(code, 5, act0);
        tpm0.removeActivity(code, act0.getCode());

        tpm0.updateTrainingPlan(tp0);
        List<TrainingPlan> userPlans = tpm0.getTrainingPlansFromUser(UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"));
        assertFalse(userPlans.isEmpty());

        tpm0.updateActivities(MakeItFitDate.of(2008, 6, 1), 55.37170852083031f);

        List<Activity> extracted = tpm0.extractActivities(MakeItFitDate.of(2008, 6, 1), UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"));
        assertNotNull(extracted);

        TrainingPlan objetivo = tpm0.constructTrainingPlanByObjectives(
            tp0, 0.5f, false,
            1, 3, 6, 121
        );
        assertNotNull(objetivo);

        // Calorias
        int caloriasTotais = objetivo.getActivities().stream()
            .mapToInt(tuple -> tuple.getItem2().caloricWaste(55.37170852083031f))
            .sum();
        assertTrue(caloriasTotais >= 121);

        // Tipos únicos de atividade
        Set<String> tipos = new HashSet<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            tipos.add(t.getItem2().getClass().getSimpleName());
        }
        assertTrue(tipos.size() <= 3);

        // Atividades por dia
        Map<MakeItFitDate, Integer> atividadesPorDia = new HashMap<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            MakeItFitDate data = t.getItem2().getRealizationDate();
            atividadesPorDia.put(data, atividadesPorDia.getOrDefault(data, 0) + 1);
        }
        for (int count : atividadesPorDia.values()) {
            assertTrue(count <= 1);
        }

        // Se hard_activities for false, garantir que não existem atividades difíceis
        if (!false) {
            for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
                assertFalse(t.getItem2() instanceof HardInterface);
            }
        }
    }
@Test
    @Timeout(30)
    public void testTrainingPlanManager_1() {
        TrainingPlanManager tpm1 = new TrainingPlanManager();
        TrainingPlan tp1 = tpm1.createTrainingPlan(UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"), MakeItFitDate.of(2021, 10, 12));
        UUID code = tp1.getCode();
        assertNotNull(tp1);

        tpm1.insertTrainingPlan(tp1);
        assertEquals(tp1, tpm1.getTrainingPlan(code));

        // Teste de remoção
        tpm1.removeTrainingPlan(code);
        assertThrows(IllegalArgumentException.class, () -> tpm1.getTrainingPlan(code));

        // Reinserção e continuação de testes
        tpm1.insertTrainingPlan(tp1);

        PushUp act1 = new PushUp(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"), MakeItFitDate.of(2009, 8, 22), 96, "Infinity", "SSRUMGYwci", 15, 1);
        tpm1.addActivity(code, 6, act1);
        tpm1.removeActivity(code, act1.getCode());

        tpm1.updateTrainingPlan(tp1);
        List<TrainingPlan> userPlans = tpm1.getTrainingPlansFromUser(UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"));
        assertFalse(userPlans.isEmpty());

        tpm1.updateActivities(MakeItFitDate.of(2021, 10, 12), 55.37170852083031f);

        List<Activity> extracted = tpm1.extractActivities(MakeItFitDate.of(2021, 10, 12), UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"));
        assertNotNull(extracted);

        TrainingPlan objetivo = tpm1.constructTrainingPlanByObjectives(
            tp1, 0.5f, false,
            3, 1, 6, 906
        );
        assertNotNull(objetivo);

        // Calorias
        int caloriasTotais = objetivo.getActivities().stream()
            .mapToInt(tuple -> tuple.getItem2().caloricWaste(55.37170852083031f))
            .sum();
        assertTrue(caloriasTotais >= 906);

        // Tipos únicos de atividade
        Set<String> tipos = new HashSet<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            tipos.add(t.getItem2().getClass().getSimpleName());
        }
        assertTrue(tipos.size() <= 1);

        // Atividades por dia
        Map<MakeItFitDate, Integer> atividadesPorDia = new HashMap<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            MakeItFitDate data = t.getItem2().getRealizationDate();
            atividadesPorDia.put(data, atividadesPorDia.getOrDefault(data, 0) + 1);
        }
        for (int count : atividadesPorDia.values()) {
            assertTrue(count <= 3);
        }

        // Se hard_activities for false, garantir que não existem atividades difíceis
        if (!false) {
            for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
                assertFalse(t.getItem2() instanceof HardInterface);
            }
        }
    }
@Test
    @Timeout(30)
    public void testTrainingPlanManager_2() {
        TrainingPlanManager tpm2 = new TrainingPlanManager();
        TrainingPlan tp2 = tpm2.createTrainingPlan(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"), MakeItFitDate.of(2000, 7, 18));
        UUID code = tp2.getCode();
        assertNotNull(tp2);

        tpm2.insertTrainingPlan(tp2);
        assertEquals(tp2, tpm2.getTrainingPlan(code));

        // Teste de remoção
        tpm2.removeTrainingPlan(code);
        assertThrows(IllegalArgumentException.class, () -> tpm2.getTrainingPlan(code));

        // Reinserção e continuação de testes
        tpm2.insertTrainingPlan(tp2);

        WeightSquat act2 = new WeightSquat(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"), MakeItFitDate.of(2010, 9, 21), 37, "PSa", "jcAciIZBM", 50, 4, 2.0);
        tpm2.addActivity(code, 1, act2);
        tpm2.removeActivity(code, act2.getCode());

        tpm2.updateTrainingPlan(tp2);
        List<TrainingPlan> userPlans = tpm2.getTrainingPlansFromUser(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"));
        assertFalse(userPlans.isEmpty());

        tpm2.updateActivities(MakeItFitDate.of(2000, 7, 18), 12.637470620554929f);

        List<Activity> extracted = tpm2.extractActivities(MakeItFitDate.of(2000, 7, 18), UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"));
        assertNotNull(extracted);

        TrainingPlan objetivo = tpm2.constructTrainingPlanByObjectives(
            tp2, 2.16f, false,
            1, 1, 4, 487
        );
        assertNotNull(objetivo);

        // Calorias
        int caloriasTotais = objetivo.getActivities().stream()
            .mapToInt(tuple -> tuple.getItem2().caloricWaste(12.637470620554929f))
            .sum();
        assertTrue(caloriasTotais >= 487);

        // Tipos únicos de atividade
        Set<String> tipos = new HashSet<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            tipos.add(t.getItem2().getClass().getSimpleName());
        }
        assertTrue(tipos.size() <= 1);

        // Atividades por dia
        Map<MakeItFitDate, Integer> atividadesPorDia = new HashMap<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            MakeItFitDate data = t.getItem2().getRealizationDate();
            atividadesPorDia.put(data, atividadesPorDia.getOrDefault(data, 0) + 1);
        }
        for (int count : atividadesPorDia.values()) {
            assertTrue(count <= 1);
        }

        // Se hard_activities for false, garantir que não existem atividades difíceis
        if (!false) {
            for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
                assertFalse(t.getItem2() instanceof HardInterface);
            }
        }
    }
@Test
    @Timeout(30)
    public void testTrainingPlanManager_3() {
        TrainingPlanManager tpm3 = new TrainingPlanManager();
        TrainingPlan tp3 = tpm3.createTrainingPlan(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"), MakeItFitDate.of(2000, 1, 1));
        UUID code = tp3.getCode();
        assertNotNull(tp3);

        tpm3.insertTrainingPlan(tp3);
        assertEquals(tp3, tpm3.getTrainingPlan(code));

        // Teste de remoção
        tpm3.removeTrainingPlan(code);
        assertThrows(IllegalArgumentException.class, () -> tpm3.getTrainingPlan(code));

        // Reinserção e continuação de testes
        tpm3.insertTrainingPlan(tp3);

        Running act3 = new Running(UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"), MakeItFitDate.of(2023, 10, 20), 101, "xoSSUwmJMM", "WDs", 1.0, 1.9);
        tpm3.addActivity(code, 1, act3);
        tpm3.removeActivity(code, act3.getCode());

        tpm3.updateTrainingPlan(tp3);
        List<TrainingPlan> userPlans = tpm3.getTrainingPlansFromUser(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"));
        assertFalse(userPlans.isEmpty());

        tpm3.updateActivities(MakeItFitDate.of(2000, 1, 1), 12.637470620554929f);

        List<Activity> extracted = tpm3.extractActivities(MakeItFitDate.of(2000, 1, 1), UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"));
        assertNotNull(extracted);

        TrainingPlan objetivo = tpm3.constructTrainingPlanByObjectives(
            tp3, 2.5f, false,
            1, 2, 6, 635
        );
        assertNotNull(objetivo);

        // Calorias
        int caloriasTotais = objetivo.getActivities().stream()
            .mapToInt(tuple -> tuple.getItem2().caloricWaste(12.637470620554929f))
            .sum();
        assertTrue(caloriasTotais >= 635);

        // Tipos únicos de atividade
        Set<String> tipos = new HashSet<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            tipos.add(t.getItem2().getClass().getSimpleName());
        }
        assertTrue(tipos.size() <= 2);

        // Atividades por dia
        Map<MakeItFitDate, Integer> atividadesPorDia = new HashMap<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            MakeItFitDate data = t.getItem2().getRealizationDate();
            atividadesPorDia.put(data, atividadesPorDia.getOrDefault(data, 0) + 1);
        }
        for (int count : atividadesPorDia.values()) {
            assertTrue(count <= 1);
        }

        // Se hard_activities for false, garantir que não existem atividades difíceis
        if (!false) {
            for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
                assertFalse(t.getItem2() instanceof HardInterface);
            }
        }
    }
@Test
    @Timeout(30)
    public void testTrainingPlanManager_4() {
        TrainingPlanManager tpm4 = new TrainingPlanManager();
        TrainingPlan tp4 = tpm4.createTrainingPlan(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"), MakeItFitDate.of(2009, 4, 22));
        UUID code = tp4.getCode();
        assertNotNull(tp4);

        tpm4.insertTrainingPlan(tp4);
        assertEquals(tp4, tpm4.getTrainingPlan(code));

        // Teste de remoção
        tpm4.removeTrainingPlan(code);
        assertThrows(IllegalArgumentException.class, () -> tpm4.getTrainingPlan(code));

        // Reinserção e continuação de testes
        tpm4.insertTrainingPlan(tp4);

        Running act4 = new Running(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"), MakeItFitDate.of(2020, 10, 1), 106, "grTfhAnWJR", "cPYU", 0.5, 1.1);
        tpm4.addActivity(code, 2, act4);
        tpm4.removeActivity(code, act4.getCode());

        tpm4.updateTrainingPlan(tp4);
        List<TrainingPlan> userPlans = tpm4.getTrainingPlansFromUser(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"));
        assertFalse(userPlans.isEmpty());

        tpm4.updateActivities(MakeItFitDate.of(2009, 4, 22), 12.637470620554929f);

        List<Activity> extracted = tpm4.extractActivities(MakeItFitDate.of(2009, 4, 22), UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"));
        assertNotNull(extracted);

        TrainingPlan objetivo = tpm4.constructTrainingPlanByObjectives(
            tp4, 1.5f, true,
            2, 3, 4, 487
        );
        assertNotNull(objetivo);

        // Calorias
        int caloriasTotais = objetivo.getActivities().stream()
            .mapToInt(tuple -> tuple.getItem2().caloricWaste(12.637470620554929f))
            .sum();
        assertTrue(caloriasTotais >= 487);

        // Tipos únicos de atividade
        Set<String> tipos = new HashSet<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            tipos.add(t.getItem2().getClass().getSimpleName());
        }
        assertTrue(tipos.size() <= 3);

        // Atividades por dia
        Map<MakeItFitDate, Integer> atividadesPorDia = new HashMap<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            MakeItFitDate data = t.getItem2().getRealizationDate();
            atividadesPorDia.put(data, atividadesPorDia.getOrDefault(data, 0) + 1);
        }
        for (int count : atividadesPorDia.values()) {
            assertTrue(count <= 2);
        }

        // Se hard_activities for false, garantir que não existem atividades difíceis
        if (!true) {
            for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
                assertFalse(t.getItem2() instanceof HardInterface);
            }
        }
    }
@Test
    @Timeout(30)
    public void testTrainingPlanManager_5() {
        TrainingPlanManager tpm5 = new TrainingPlanManager();
        TrainingPlan tp5 = tpm5.createTrainingPlan(UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"), MakeItFitDate.of(2014, 1, 23));
        UUID code = tp5.getCode();
        assertNotNull(tp5);

        tpm5.insertTrainingPlan(tp5);
        assertEquals(tp5, tpm5.getTrainingPlan(code));

        // Teste de remoção
        tpm5.removeTrainingPlan(code);
        assertThrows(IllegalArgumentException.class, () -> tpm5.getTrainingPlan(code));

        // Reinserção e continuação de testes
        tpm5.insertTrainingPlan(tp5);

        PushUp act5 = new PushUp(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"), MakeItFitDate.of(2009, 8, 22), 96, "Infinity", "SSRUMGYwci", 15, 1);
        tpm5.addActivity(code, 1, act5);
        tpm5.removeActivity(code, act5.getCode());

        tpm5.updateTrainingPlan(tp5);
        List<TrainingPlan> userPlans = tpm5.getTrainingPlansFromUser(UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"));
        assertFalse(userPlans.isEmpty());

        tpm5.updateActivities(MakeItFitDate.of(2014, 1, 23), 55.37170852083031f);

        List<Activity> extracted = tpm5.extractActivities(MakeItFitDate.of(2014, 1, 23), UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"));
        assertNotNull(extracted);

        TrainingPlan objetivo = tpm5.constructTrainingPlanByObjectives(
            tp5, 0.5f, false,
            1, 1, 1, 50
        );
        assertNotNull(objetivo);

        // Calorias
        int caloriasTotais = objetivo.getActivities().stream()
            .mapToInt(tuple -> tuple.getItem2().caloricWaste(55.37170852083031f))
            .sum();
        assertTrue(caloriasTotais >= 50);

        // Tipos únicos de atividade
        Set<String> tipos = new HashSet<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            tipos.add(t.getItem2().getClass().getSimpleName());
        }
        assertTrue(tipos.size() <= 1);

        // Atividades por dia
        Map<MakeItFitDate, Integer> atividadesPorDia = new HashMap<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            MakeItFitDate data = t.getItem2().getRealizationDate();
            atividadesPorDia.put(data, atividadesPorDia.getOrDefault(data, 0) + 1);
        }
        for (int count : atividadesPorDia.values()) {
            assertTrue(count <= 1);
        }

        // Se hard_activities for false, garantir que não existem atividades difíceis
        if (!false) {
            for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
                assertFalse(t.getItem2() instanceof HardInterface);
            }
        }
    }
@Test
    @Timeout(30)
    public void testTrainingPlanManager_6() {
        TrainingPlanManager tpm6 = new TrainingPlanManager();
        TrainingPlan tp6 = tpm6.createTrainingPlan(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"), MakeItFitDate.of(2005, 6, 16));
        UUID code = tp6.getCode();
        assertNotNull(tp6);

        tpm6.insertTrainingPlan(tp6);
        assertEquals(tp6, tpm6.getTrainingPlan(code));

        // Teste de remoção
        tpm6.removeTrainingPlan(code);
        assertThrows(IllegalArgumentException.class, () -> tpm6.getTrainingPlan(code));

        // Reinserção e continuação de testes
        tpm6.insertTrainingPlan(tp6);

        Running act6 = new Running(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"), MakeItFitDate.of(2010, 12, 4), 43, "nFBI", "CrXEULdc", 1.9, 1.9);
        tpm6.addActivity(code, 1, act6);
        tpm6.removeActivity(code, act6.getCode());

        tpm6.updateTrainingPlan(tp6);
        List<TrainingPlan> userPlans = tpm6.getTrainingPlansFromUser(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"));
        assertFalse(userPlans.isEmpty());

        tpm6.updateActivities(MakeItFitDate.of(2005, 6, 16), 12.637470620554929f);

        List<Activity> extracted = tpm6.extractActivities(MakeItFitDate.of(2005, 6, 16), UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"));
        assertNotNull(extracted);

        TrainingPlan objetivo = tpm6.constructTrainingPlanByObjectives(
            tp6, 0.5f, false,
            1, 1, 1, 50
        );
        assertNotNull(objetivo);

        // Calorias
        int caloriasTotais = objetivo.getActivities().stream()
            .mapToInt(tuple -> tuple.getItem2().caloricWaste(12.637470620554929f))
            .sum();
        assertTrue(caloriasTotais >= 50);

        // Tipos únicos de atividade
        Set<String> tipos = new HashSet<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            tipos.add(t.getItem2().getClass().getSimpleName());
        }
        assertTrue(tipos.size() <= 1);

        // Atividades por dia
        Map<MakeItFitDate, Integer> atividadesPorDia = new HashMap<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            MakeItFitDate data = t.getItem2().getRealizationDate();
            atividadesPorDia.put(data, atividadesPorDia.getOrDefault(data, 0) + 1);
        }
        for (int count : atividadesPorDia.values()) {
            assertTrue(count <= 1);
        }

        // Se hard_activities for false, garantir que não existem atividades difíceis
        if (!false) {
            for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
                assertFalse(t.getItem2() instanceof HardInterface);
            }
        }
    }
@Test
    @Timeout(30)
    public void testTrainingPlanManager_7() {
        TrainingPlanManager tpm7 = new TrainingPlanManager();
        TrainingPlan tp7 = tpm7.createTrainingPlan(UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"), MakeItFitDate.of(2000, 1, 1));
        UUID code = tp7.getCode();
        assertNotNull(tp7);

        tpm7.insertTrainingPlan(tp7);
        assertEquals(tp7, tpm7.getTrainingPlan(code));

        // Teste de remoção
        tpm7.removeTrainingPlan(code);
        assertThrows(IllegalArgumentException.class, () -> tpm7.getTrainingPlan(code));

        // Reinserção e continuação de testes
        tpm7.insertTrainingPlan(tp7);

        PushUp act7 = new PushUp(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"), MakeItFitDate.of(2009, 8, 22), 96, "Infinity", "SSRUMGYwci", 15, 1);
        tpm7.addActivity(code, 1, act7);
        tpm7.removeActivity(code, act7.getCode());

        tpm7.updateTrainingPlan(tp7);
        List<TrainingPlan> userPlans = tpm7.getTrainingPlansFromUser(UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"));
        assertFalse(userPlans.isEmpty());

        tpm7.updateActivities(MakeItFitDate.of(2000, 1, 1), 55.37170852083031f);

        List<Activity> extracted = tpm7.extractActivities(MakeItFitDate.of(2000, 1, 1), UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"));
        assertNotNull(extracted);

        TrainingPlan objetivo = tpm7.constructTrainingPlanByObjectives(
            tp7, 1.7f, false,
            3, 2, 6, 177
        );
        assertNotNull(objetivo);

        // Calorias
        int caloriasTotais = objetivo.getActivities().stream()
            .mapToInt(tuple -> tuple.getItem2().caloricWaste(55.37170852083031f))
            .sum();
        assertTrue(caloriasTotais >= 177);

        // Tipos únicos de atividade
        Set<String> tipos = new HashSet<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            tipos.add(t.getItem2().getClass().getSimpleName());
        }
        assertTrue(tipos.size() <= 2);

        // Atividades por dia
        Map<MakeItFitDate, Integer> atividadesPorDia = new HashMap<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            MakeItFitDate data = t.getItem2().getRealizationDate();
            atividadesPorDia.put(data, atividadesPorDia.getOrDefault(data, 0) + 1);
        }
        for (int count : atividadesPorDia.values()) {
            assertTrue(count <= 3);
        }

        // Se hard_activities for false, garantir que não existem atividades difíceis
        if (!false) {
            for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
                assertFalse(t.getItem2() instanceof HardInterface);
            }
        }
    }
@Test
    @Timeout(30)
    public void testTrainingPlanManager_8() {
        TrainingPlanManager tpm8 = new TrainingPlanManager();
        TrainingPlan tp8 = tpm8.createTrainingPlan(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"), MakeItFitDate.of(2000, 1, 1));
        UUID code = tp8.getCode();
        assertNotNull(tp8);

        tpm8.insertTrainingPlan(tp8);
        assertEquals(tp8, tpm8.getTrainingPlan(code));

        // Teste de remoção
        tpm8.removeTrainingPlan(code);
        assertThrows(IllegalArgumentException.class, () -> tpm8.getTrainingPlan(code));

        // Reinserção e continuação de testes
        tpm8.insertTrainingPlan(tp8);

        Running act8 = new Running(UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"), MakeItFitDate.of(2023, 10, 20), 101, "xoSSUwmJMM", "WDs", 1.0, 1.9);
        tpm8.addActivity(code, 1, act8);
        tpm8.removeActivity(code, act8.getCode());

        tpm8.updateTrainingPlan(tp8);
        List<TrainingPlan> userPlans = tpm8.getTrainingPlansFromUser(UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"));
        assertFalse(userPlans.isEmpty());

        tpm8.updateActivities(MakeItFitDate.of(2000, 1, 1), 12.637470620554929f);

        List<Activity> extracted = tpm8.extractActivities(MakeItFitDate.of(2000, 1, 1), UUID.fromString("b4367b9f-47aa-4afa-9937-bd6c16f4c335"));
        assertNotNull(extracted);

        TrainingPlan objetivo = tpm8.constructTrainingPlanByObjectives(
            tp8, 0.5f, false,
            1, 1, 1, 50
        );
        assertNotNull(objetivo);

        // Calorias
        int caloriasTotais = objetivo.getActivities().stream()
            .mapToInt(tuple -> tuple.getItem2().caloricWaste(12.637470620554929f))
            .sum();
        assertTrue(caloriasTotais >= 50);

        // Tipos únicos de atividade
        Set<String> tipos = new HashSet<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            tipos.add(t.getItem2().getClass().getSimpleName());
        }
        assertTrue(tipos.size() <= 1);

        // Atividades por dia
        Map<MakeItFitDate, Integer> atividadesPorDia = new HashMap<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            MakeItFitDate data = t.getItem2().getRealizationDate();
            atividadesPorDia.put(data, atividadesPorDia.getOrDefault(data, 0) + 1);
        }
        for (int count : atividadesPorDia.values()) {
            assertTrue(count <= 1);
        }

        // Se hard_activities for false, garantir que não existem atividades difíceis
        if (!false) {
            for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
                assertFalse(t.getItem2() instanceof HardInterface);
            }
        }
    }
@Test
    @Timeout(30)
    public void testTrainingPlanManager_9() {
        TrainingPlanManager tpm9 = new TrainingPlanManager();
        TrainingPlan tp9 = tpm9.createTrainingPlan(UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"), MakeItFitDate.of(2019, 6, 28));
        UUID code = tp9.getCode();
        assertNotNull(tp9);

        tpm9.insertTrainingPlan(tp9);
        assertEquals(tp9, tpm9.getTrainingPlan(code));

        // Teste de remoção
        tpm9.removeTrainingPlan(code);
        assertThrows(IllegalArgumentException.class, () -> tpm9.getTrainingPlan(code));

        // Reinserção e continuação de testes
        tpm9.insertTrainingPlan(tp9);

        Trail act9 = new Trail(UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"), MakeItFitDate.of(2013, 3, 27), 50, "jVySJbjHVS", "xrVhV", 28.58, 1499.0, 1500.0, -8);
        tpm9.addActivity(code, 4, act9);
        tpm9.removeActivity(code, act9.getCode());

        tpm9.updateTrainingPlan(tp9);
        List<TrainingPlan> userPlans = tpm9.getTrainingPlansFromUser(UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"));
        assertFalse(userPlans.isEmpty());

        tpm9.updateActivities(MakeItFitDate.of(2019, 6, 28), 55.37170852083031f);

        List<Activity> extracted = tpm9.extractActivities(MakeItFitDate.of(2019, 6, 28), UUID.fromString("4d857de7-bd8a-41cf-a463-41b57763fe5c"));
        assertNotNull(extracted);

        TrainingPlan objetivo = tpm9.constructTrainingPlanByObjectives(
            tp9, 0.5f, false,
            1, 1, 1, 50
        );
        assertNotNull(objetivo);

        // Calorias
        int caloriasTotais = objetivo.getActivities().stream()
            .mapToInt(tuple -> tuple.getItem2().caloricWaste(55.37170852083031f))
            .sum();
        assertTrue(caloriasTotais >= 50);

        // Tipos únicos de atividade
        Set<String> tipos = new HashSet<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            tipos.add(t.getItem2().getClass().getSimpleName());
        }
        assertTrue(tipos.size() <= 1);

        // Atividades por dia
        Map<MakeItFitDate, Integer> atividadesPorDia = new HashMap<>();
        for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
            MakeItFitDate data = t.getItem2().getRealizationDate();
            atividadesPorDia.put(data, atividadesPorDia.getOrDefault(data, 0) + 1);
        }
        for (int count : atividadesPorDia.values()) {
            assertTrue(count <= 1);
        }

        // Se hard_activities for false, garantir que não existem atividades difíceis
        if (!false) {
            for (MyTuple<Integer, Activity> t : objetivo.getActivities()) {
                assertFalse(t.getItem2() instanceof HardInterface);
            }
        }
    }

}