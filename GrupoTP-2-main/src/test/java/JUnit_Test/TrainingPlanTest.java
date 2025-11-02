package JUnit_Test;

import MakeItFit.activities.Activity;
import MakeItFit.activities.implementation.PushUp;
import MakeItFit.trainingPlan.TrainingPlan;
import MakeItFit.utils.MakeItFitDate;
import MakeItFit.utils.MyTuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TrainingPlanTest {
    private TrainingPlan trainingPlan;
    private UUID userCode;
    private MakeItFitDate startDate;
    private Activity activity;

    @BeforeEach
    void setUp() {
        userCode = UUID.randomUUID();
        startDate = MakeItFitDate.fromString("01/01/2023");
        trainingPlan = new TrainingPlan(userCode, startDate);
        activity = new PushUp(userCode, startDate, 30, "PushUp", "PushUp", 10, 3);
    }

    @Test
    void testAddActivity() {
        trainingPlan.addActivity(3, activity);
        List<MyTuple<Integer, Activity>> activities = trainingPlan.getActivities();
        assertEquals(1, activities.size());
        assertEquals(3, activities.get(0).getItem1());
        assertEquals(activity, activities.get(0).getItem2());
    }

    @Test
    void testAddActivityWithInvalidRepetitions() {
        assertThrows(IllegalArgumentException.class, () -> trainingPlan.addActivity(0, activity));
    }

    @Test
    void testRemoveActivity() {
        trainingPlan.addActivity(3, activity);
        trainingPlan.removeActivity(activity.getCode());
        assertTrue(trainingPlan.getActivities().isEmpty());
    }

    @Test
    void testUpdateActivities() {
        trainingPlan.addActivity(3, activity);
        MakeItFitDate currentDate = startDate.plusDays(1);
        trainingPlan.updateActivities(currentDate, 1.5f);
        assertTrue(activity.getCaloricWaste() > 0);
    }
    @Test
    void testCloneTrainingPlan() {
        trainingPlan.addActivity(3, activity);
        TrainingPlan clonedPlan = trainingPlan.clone();
        assertEquals(trainingPlan, clonedPlan);
        assertNotSame(trainingPlan, clonedPlan);
        assertEquals(trainingPlan.getActivities(), clonedPlan.getActivities());
        assertSame(trainingPlan.getActivities(), clonedPlan.getActivities());
    }
    @Test
    void testEqualsTrainingPlan() {
        TrainingPlan anotherPlan = new TrainingPlan(userCode, startDate);
        assertTrue(trainingPlan.equals(anotherPlan));

        anotherPlan.addActivity(3, activity);
        assertFalse(trainingPlan.equals(anotherPlan));

        TrainingPlan differentPlan = new TrainingPlan(UUID.randomUUID(), startDate);
        assertFalse(trainingPlan.equals(differentPlan));
    }
    @Test
    void testCompareToTrainingPlan() {
        TrainingPlan laterPlan = new TrainingPlan(userCode, startDate.plusDays(1));
        assertTrue(trainingPlan.compareTo(laterPlan) < 0);

        TrainingPlan sameDatePlan = new TrainingPlan(userCode, startDate);
        assertEquals(0, trainingPlan.compareTo(sameDatePlan));
    }
    @Test
    void testRemoveNonExistentActivity() {
        UUID randomCode = UUID.randomUUID();
        trainingPlan.addActivity(3, activity);
        trainingPlan.removeActivity(randomCode);
        assertEquals(1, trainingPlan.getActivities().size());
    }
    @Test
    void testUpdateActivitiesWithNoActivities() {
        MakeItFitDate currentDate = startDate.plusDays(1);
        trainingPlan.updateActivities(currentDate, 1.5f);
        assertTrue(trainingPlan.getActivities().isEmpty());
    }
    @Test
    void testExtractActivitiesWithNoMatchingDate() {
        trainingPlan.addActivity(3, activity);
        MakeItFitDate futureDate = startDate.plusDays(10);
        List<Activity> extractedActivities = trainingPlan.extractActivities(futureDate);
        assertTrue(!extractedActivities.isEmpty());
    }
}