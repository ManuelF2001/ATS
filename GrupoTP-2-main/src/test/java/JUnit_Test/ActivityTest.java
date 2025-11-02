package JUnit_Test;

import MakeItFit.activities.Activity;

import MakeItFit. utils. MakeItFitDate;

import MakeItFit.activities.implementation.PushUp;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

public class ActivityTest {

    @Test
    void testConstructorAndGetters() {
        UUID userCode = UUID.randomUUID();
        MakeItFitDate date = new MakeItFitDate();
        Activity activity = new PushUp(userCode, date, 30, "Workout", "Morning Pushups", 10, 3);

        assertEquals(userCode, activity.getUserCode());
        assertEquals(date, activity.getRealizationDate());
        assertEquals(30, activity.getExpectedDuration());
        assertEquals("Workout", activity.getDesignation());
        assertEquals("Morning Pushups", activity.getName());
    }

    @Test
    void testSetters() {
        Activity activity = new PushUp();
        activity.setExpectedDuration(45);
        activity.setDesignation("New Designation");
        activity.setDuration(40);
        activity.setCaloricWaste(200);

        assertEquals(45, activity.getExpectedDuration());
        assertEquals("New Designation", activity.getDesignation());
        assertEquals(40, activity.getDuration());
        assertEquals(200, activity.getCaloricWaste());
    }

    @Test
    void testEquality() {
        UUID userCode = UUID.randomUUID();
        MakeItFitDate date = new MakeItFitDate();
        Activity a1 = new PushUp(userCode, date, 30, "Workout", "Pushups", 10, 3);
        Activity a2 = new PushUp(userCode, date, 30, "Workout", "Pushups", 10, 3);

        assertTrue(a1.equals(a2));
        a2.setExpectedDuration(40);
        assertFalse(a1.equals(a2));
    }

    @Test
    void testComparison() {
       MakeItFitDate date1 = MakeItFitDate.fromString("01/01/2023");
        MakeItFitDate date2 = MakeItFitDate.fromString("02/01/2023");

        Activity a1 = new PushUp(UUID.randomUUID(), date1, 30, "A", "A", 10, 3);
        Activity a2 = new PushUp(UUID.randomUUID(), date2, 30, "B", "B", 10, 3);
        Activity a3 = new PushUp(UUID.randomUUID(), date1, 20, "C", "C", 10, 3);

        assertTrue(a1.compareTo(a2) < 0);
        assertTrue(a1.compareTo(a3) > 0);
    }
    @Test
    void testToString() {
        UUID userCode = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.fromString("01/01/2023");
        Activity activity = new PushUp(userCode, date, 30, "Workout", "Morning Pushups", 10, 3);

        String expected = "Activity: Morning Pushups, Code: " + activity.getCode() + ", Designation: Workout, Expected Duration: 30 minutes, Realization Date: 01/01/2023, Caloric Waste: 0 calories, Repetitions: 10, Series: 3, ";
        assertEquals(expected, activity.toString());
    }
    @Test
    void testUpdateActivity() {
        Activity activity = new PushUp(UUID.randomUUID(), new MakeItFitDate(), 30, "Workout", "Pushups", 10, 3);
        activity.updateActivity(1.5f);

        assertTrue(activity.getCaloricWaste() > 0); // Verifica se o desperdício calórico foi calculado.
    }
    @Test
    void testClone() {
        UUID userCode = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.fromString("01/01/2023");
        Activity original = new PushUp(userCode, date, 30, "Workout", "Pushups", 10, 3);
        Activity clone = original.clone();

        assertEquals(original.getUserCode(), clone.getUserCode());
        assertEquals(original.getRealizationDate(), clone.getRealizationDate());
        assertEquals(original.getExpectedDuration(), clone.getExpectedDuration());
        assertEquals(original.getDesignation(), clone.getDesignation());
        assertEquals(original.getName(), clone.getName());
        assertEquals(original.getDuration(), clone.getDuration());
        assertEquals(original.getCaloricWaste(), clone.getCaloricWaste());
        assertNotSame(original, clone); // Verifica se são objetos diferentes.
    }
    @Test
    void testInvalidExpectedDuration() {
        Activity activity = new PushUp();
        activity.setExpectedDuration(-10); // Invalid negative duration
        assertEquals(-10, activity.getExpectedDuration());
    }

    @Test
    void testEmptyDesignation() {
        Activity activity = new PushUp();
        activity.setDesignation("");
        assertEquals("", activity.getDesignation());
    }

    @Test
    void testBoundaryDuration() {
        Activity activity = new PushUp();
        activity.setDuration(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, activity.getDuration());
        activity.setDuration(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, activity.getDuration());
    }

    @Test
    void testBoundaryCaloricWaste() {
        Activity activity = new PushUp();
        activity.setCaloricWaste(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, activity.getCaloricWaste());
        activity.setCaloricWaste(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, activity.getCaloricWaste());
    }


    @Test
    void testUpdateActivityWithZeroIndex() {
        Activity activity = new PushUp(UUID.randomUUID(), new MakeItFitDate(), 30, "Workout", "Pushups", 10, 3);
        activity.updateActivity(0.0f);
        assertEquals(0, activity.getCaloricWaste());
    }

    @Test
    void testUpdateActivityWithNegativeIndex() {
        Activity activity = new PushUp(UUID.randomUUID(), new MakeItFitDate(), 30, "Workout", "Pushups", 10, 3);
        activity.updateActivity(-1.0f);
        assertTrue(activity.getCaloricWaste() < 0); // Negative caloric waste
    }

    @Test
    void testCloneWithModifiedOriginal() {
        UUID userCode = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.fromString("01/01/2023");
        Activity original = new PushUp(userCode, date, 30, "Workout", "Pushups", 10, 3);
        Activity clone = original.clone();

        original.setExpectedDuration(40);
        original.setDesignation("Modified Designation");

        assertNotEquals(original.getExpectedDuration(), clone.getExpectedDuration());
        assertNotEquals(original.getDesignation(), clone.getDesignation());
    }
/* 
    @Test
    void testEqualityWithDifferentUserCode() {
        UUID userCode1 = UUID.randomUUID();
        UUID userCode2 = UUID.randomUUID();
        MakeItFitDate date = new MakeItFitDate();
        Activity a1 = new PushUp(userCode1, date, 30, "Workout", "Pushups", 10, 3);
        Activity a2 = new PushUp(userCode2, date, 30, "Workout", "Pushups", 10, 3);

        assertFalse(a1.equals(a2));
    }*/
    @Test
    void testComparisonWithSameDateDifferentDuration() {
        MakeItFitDate date = MakeItFitDate.fromString("01/01/2023");
        Activity a1 = new PushUp(UUID.randomUUID(), date, 30, "A", "A", 10, 3);
        Activity a2 = new PushUp(UUID.randomUUID(), date, 20, "B", "B", 10, 3);

        assertTrue(a1.compareTo(a2) > 0);
    }

}