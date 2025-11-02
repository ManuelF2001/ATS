package test_Hypothesis;

import MakeItFit.activities.implementation.PushUp;
import MakeItFit.trainingPlan.*;
import MakeItFit.exceptions.*;
import MakeItFit.utils.MakeItFitDate;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainingPlanInvalidGeneratedTest {

@Test
    public void testPlanoInvalido_0_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2000, 1, 1));
        });
    }
@Test
    public void testPlanoInvalido_1_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2000, 1, 1));
        });
    }
@Test
    public void testPlanoInvalido_2_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                -3,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_3_minimumCaloricWaste_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                3,
                -427
            );
        });
    }
@Test
    public void testPlanoInvalido_4_maxDifferentActivities_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                -6,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_5_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2016, 2, 24));
        });
    }
@Test
    public void testPlanoInvalido_6_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2000, 1, 1));
        });
    }
@Test
    public void testPlanoInvalido_7_startDate_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(UUID.fromString("59baa621-7a88-479e-a56e-7242aeddb9da"), null);
        });
    }
@Test
    public void testPlanoInvalido_8_minimumCaloricWaste_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                3,
                -348
            );
        });
    }
@Test
    public void testPlanoInvalido_9_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2000, 1, 1));
        });
    }
@Test
    public void testPlanoInvalido_10_minimumCaloricWaste_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                3,
                -45
            );
        });
    }
@Test
    public void testPlanoInvalido_11_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -6, atividade);
        });
    }
@Test
    public void testPlanoInvalido_12_maxDifferentActivities_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                -7,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_13_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2000, 1, 1));
        });
    }
@Test
    public void testPlanoInvalido_14_startDate_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(UUID.fromString("224da6fb-a70e-4c05-a920-9218bc797bae"), null);
        });
    }
@Test
    public void testPlanoInvalido_15_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2000, 1, 1));
        });
    }
@Test
    public void testPlanoInvalido_16_startDate_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(UUID.fromString("2283d999-ac3c-4749-84c8-86b69a41ac72"), null);
        });
    }
@Test
    public void testPlanoInvalido_17_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                83,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_18_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                20,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_19_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                83,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_20_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2013, 7, 9));
        });
    }
@Test
    public void testPlanoInvalido_21_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -9, atividade);
        });
    }
@Test
    public void testPlanoInvalido_22_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                -10,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_23_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2000, 1, 1));
        });
    }
@Test
    public void testPlanoInvalido_24_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                15,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_25_startDate_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(UUID.fromString("d6f3e6f9-e3d0-422f-a69e-c9e3a10ac65f"), null);
        });
    }
@Test
    public void testPlanoInvalido_26_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                -1,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_27_weeklyRecurrence_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                -10,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_28_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), 0, atividade);
        });
    }
@Test
    public void testPlanoInvalido_29_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2000, 1, 1));
        });
    }
@Test
    public void testPlanoInvalido_30_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                -1,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_31_startDate_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(UUID.fromString("7946401d-40e0-4446-8aec-20283b46f14f"), null);
        });
    }
@Test
    public void testPlanoInvalido_32_maxDifferentActivities_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                -1,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_33_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2000, 1, 1));
        });
    }
@Test
    public void testPlanoInvalido_34_minimumCaloricWaste_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                3,
                -376
            );
        });
    }
@Test
    public void testPlanoInvalido_35_weeklyRecurrence_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                -8,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_36_startDate_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(UUID.fromString("91bc9c20-2c9d-4f0e-9e75-a897aedb18a2"), null);
        });
    }
@Test
    public void testPlanoInvalido_37_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                90,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_38_startDate_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(UUID.fromString("6d9a2970-bb4a-4c8d-ad53-575b17a6c295"), null);
        });
    }
@Test
    public void testPlanoInvalido_39_minimumCaloricWaste_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                3,
                -34
            );
        });
    }
@Test
    public void testPlanoInvalido_40_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -4, atividade);
        });
    }
@Test
    public void testPlanoInvalido_41_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                15,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_42_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2003, 10, 25));
        });
    }
@Test
    public void testPlanoInvalido_43_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -9, atividade);
        });
    }
@Test
    public void testPlanoInvalido_44_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                -4,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_45_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                -9,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_46_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                -1,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_47_minimumCaloricWaste_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                3,
                -292
            );
        });
    }
@Test
    public void testPlanoInvalido_48_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2000, 1, 1));
        });
    }
@Test
    public void testPlanoInvalido_49_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -5, atividade);
        });
    }
@Test
    public void testPlanoInvalido_50_weeklyRecurrence_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                -6,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_51_maxDifferentActivities_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                -8,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_52_startDate_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(UUID.fromString("5999fe7a-144d-4525-81cb-60755c0ffe87"), null);
        });
    }
@Test
    public void testPlanoInvalido_53_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                -7,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_54_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -8, atividade);
        });
    }
@Test
    public void testPlanoInvalido_55_maxDifferentActivities_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                -4,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_56_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -4, atividade);
        });
    }
@Test
    public void testPlanoInvalido_57_minimumCaloricWaste_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                3,
                -1
            );
        });
    }
@Test
    public void testPlanoInvalido_58_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2000, 1, 1));
        });
    }
@Test
    public void testPlanoInvalido_59_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -7, atividade);
        });
    }
@Test
    public void testPlanoInvalido_60_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -5, atividade);
        });
    }
@Test
    public void testPlanoInvalido_61_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -5, atividade);
        });
    }
@Test
    public void testPlanoInvalido_62_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                53,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_63_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -5, atividade);
        });
    }
@Test
    public void testPlanoInvalido_64_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                92,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_65_weeklyRecurrence_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                21,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_66_weeklyRecurrence_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                -10,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_67_weeklyRecurrence_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                -9,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_68_maxDifferentActivities_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                -6,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_69_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                94,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_70_weeklyRecurrence_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                -1,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_71_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -5, atividade);
        });
    }
@Test
    public void testPlanoInvalido_72_weeklyRecurrence_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                18,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_73_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                -4,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_74_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -9, atividade);
        });
    }
@Test
    public void testPlanoInvalido_75_maxDifferentActivities_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                -1,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_76_weeklyRecurrence_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                -5,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_77_startDate_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(UUID.fromString("c4ea2a79-2cfa-4b3a-9c38-7540acfad718"), null);
        });
    }
@Test
    public void testPlanoInvalido_78_minimumCaloricWaste_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                3,
                -447
            );
        });
    }
@Test
    public void testPlanoInvalido_79_maxActivitiesPerDay_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                -1,
                2,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_80_weeklyRecurrence_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                -6,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_81_maxDifferentActivities_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                -5,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_82_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -6, atividade);
        });
    }
@Test
    public void testPlanoInvalido_83_maxDifferentActivities_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                -6,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_84_weeklyRecurrence_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                -1,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_85_weeklyRecurrence_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                28,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_86_maxDifferentActivities_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                -3,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_87_weeklyRecurrence_alto() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                -8,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_88_maxDifferentActivities_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                -5,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_89_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2006, 2, 10));
        });
    }
@Test
    public void testPlanoInvalido_90_maxDifferentActivities_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                -1,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_91_minimumCaloricWaste_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                2,
                3,
                -418
            );
        });
    }
@Test
    public void testPlanoInvalido_92_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2016, 10, 1));
        });
    }
@Test
    public void testPlanoInvalido_93_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2000, 1, 1));
        });
    }
@Test
    public void testPlanoInvalido_94_startDate_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(UUID.fromString("204644a6-fbc6-4199-b64c-2d4a5f160643"), null);
        });
    }
@Test
    public void testPlanoInvalido_95_maxDifferentActivities_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                -5,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_96_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -3, atividade);
        });
    }
@Test
    public void testPlanoInvalido_97_maxDifferentActivities_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = tpm.createTrainingPlan(user, date);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.constructTrainingPlanByObjectives(
                tp,
                1.0f,
                true,
                2,
                -5,
                3,
                100
            );
        });
    }
@Test
    public void testPlanoInvalido_98_userCode_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrainingPlanManager().createTrainingPlan(null, MakeItFitDate.of(2013, 4, 19));
        });
    }
@Test
    public void testPlanoInvalido_99_repetitions_zero_ou_negativo() {
        TrainingPlanManager tpm = new TrainingPlanManager();
        UUID user = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 14);
        TrainingPlan tp = new TrainingPlan(user, date);
        tpm.insertTrainingPlan(tp);

        PushUp atividade = new PushUp(user, date, 20, "Push", "Push", 10, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            tpm.addActivity(tp.getCode(), -8, atividade);
        });
    }

}