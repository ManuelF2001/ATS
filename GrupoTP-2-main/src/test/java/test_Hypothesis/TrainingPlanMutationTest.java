package test_Hypothesis;

import MakeItFit.activities.Activity;
import MakeItFit.activities.implementation.PushUp;
import MakeItFit.utils.MakeItFitDate;
import MakeItFit.trainingPlan.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TrainingPlanMutationTest {

    @Test
    void testUpdateActivitiesCallsUpdateActivityAndConditional() {
        UUID userCode = UUID.randomUUID();
        MakeItFitDate startDate = MakeItFitDate.of(2024, 4, 4);
        TrainingPlan tp = new TrainingPlan(userCode, startDate);

        // Activity with realizationDate before currentDate
        Activity act = new PushUp(userCode, MakeItFitDate.of(2024, 4, 1), 10, "Push", "PushUp", 10, 2);
        tp.addActivity(1, act);

        // Activity with realizationDate after currentDate
        Activity act2 = new PushUp(userCode, MakeItFitDate.of(2024, 4, 10), 10, "Push", "PushUp", 10, 2);
        tp.addActivity(1, act2);

        // currentDate is after act, before act2
        tp.updateActivities(MakeItFitDate.of(2024, 4, 5), 2.0f);

        // act should have updated caloricWaste, act2 should not
        int caloricWasteAfter = act.getCaloricWaste();
        assertTrue(caloricWasteAfter > 0, "Activity before currentDate should be updated");
        assertEquals(0, act2.getCaloricWaste(), "Activity after currentDate should not be updated");
    }

    @Test
    void testExtractActivitiesConditionalAndReturn() {
        UUID userCode = UUID.randomUUID();
        MakeItFitDate startDate = MakeItFitDate.of(2024, 4, 4);
        TrainingPlan tp = new TrainingPlan(userCode, startDate);

        Activity act = new PushUp(userCode, MakeItFitDate.of(2024, 4, 1), 10, "Push", "PushUp", 10, 2);
        tp.addActivity(1, act);

        // currentDate is after activity date, should return a list with a clone
        List<Activity> result = tp.extractActivities(MakeItFitDate.of(2024, 4, 5));
        assertEquals(1, result.size());
        assertNotSame(act, result.get(0));
        assertEquals(act, result.get(0));

        // currentDate is before activity date, should return empty list
        List<Activity> result2 = tp.extractActivities(MakeItFitDate.of(2024, 4, 1));
        assertTrue(result2.isEmpty());
    }

    @Test
    void testToStringNotEmpty() {
        TrainingPlan tp = new TrainingPlan(UUID.randomUUID(), MakeItFitDate.of(2024, 4, 4));
        assertFalse(tp.toString().isEmpty());
        assertTrue(tp.toString().toLowerCase().contains("training"));
    }

    @Test
    void testEqualsAllBranches() {
        UUID userCode = UUID.randomUUID();
        MakeItFitDate startDate = MakeItFitDate.of(2024, 4, 4);
        TrainingPlan tp1 = new TrainingPlan(userCode, startDate);
        TrainingPlan tp2 = new TrainingPlan(userCode, startDate);

        // Reflexive
        assertTrue(tp1.equals(tp1));
        // Null
        assertFalse(tp1.equals(null));
        // Different class
        assertFalse(tp1.equals("not a plan"));
        // Different userCode
        TrainingPlan tp3 = new TrainingPlan(UUID.randomUUID(), startDate);
        assertFalse(tp1.equals(tp3));
        // Different startDate
        TrainingPlan tp4 = new TrainingPlan(userCode, MakeItFitDate.of(2023, 1, 1));
        assertFalse(tp1.equals(tp4));
        // Different activities
        TrainingPlan tp5 = new TrainingPlan(userCode, startDate);
        Activity act = new PushUp(userCode, MakeItFitDate.of(2024, 4, 1), 10, "Push", "PushUp", 10, 2);
        tp5.addActivity(1, act);
        assertFalse(tp1.equals(tp5));
        // True
        assertTrue(tp1.equals(tp2));
    }

    @Test
    void testCompareToBranchesAndMutants() {
        UUID userCode = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 4, 4);
        TrainingPlan tp1 = new TrainingPlan(userCode, date);
        TrainingPlan tp2 = new TrainingPlan(userCode, date);

        // Same date, same activities
        assertEquals(0, tp1.compareTo(tp2));

        // Same date, different activities
        Activity act = new PushUp(userCode, MakeItFitDate.of(2024, 4, 1), 10, "Push", "PushUp", 10, 2);
        tp2.addActivity(1, act);
        assertTrue(tp1.compareTo(tp2) < 0);
        assertTrue(tp2.compareTo(tp1) > 0);

        // Different date
        TrainingPlan tp3 = new TrainingPlan(userCode, MakeItFitDate.of(2023, 1, 1));
        assertTrue(tp1.compareTo(tp3) > 0 || tp1.compareTo(tp3) < 0);
    }
}