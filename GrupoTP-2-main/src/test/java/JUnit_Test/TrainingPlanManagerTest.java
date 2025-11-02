package JUnit_Test;

import MakeItFit.activities.Activity;
import MakeItFit.activities.implementation.PushUp;
import MakeItFit.exceptions.EntityDoesNotExistException;
import MakeItFit.trainingPlan.TrainingPlan;
import MakeItFit.trainingPlan.TrainingPlanManager;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TrainingPlanManagerTest {
    private TrainingPlanManager manager;
    private UUID userCode;
    private MakeItFitDate startDate;
    private TrainingPlan trainingPlan;

    @BeforeEach
    void setUp() {
        manager = new TrainingPlanManager();
        userCode = UUID.randomUUID();
        startDate = MakeItFitDate.fromString("01/01/2023");
        trainingPlan = new TrainingPlan(userCode, startDate);
    }

    @Test
    void testCreateAndInsertTrainingPlan() {
        TrainingPlan created = manager.createTrainingPlan(userCode, startDate);
        manager.insertTrainingPlan(created);
        assertDoesNotThrow(() -> manager.getTrainingPlan(created.getCode()));
    }

    @Test
    void testRemoveTrainingPlan() {
        manager.insertTrainingPlan(trainingPlan);
        manager.removeTrainingPlan(trainingPlan.getCode());
        assertThrows(IllegalArgumentException.class, () -> manager.getTrainingPlan(trainingPlan.getCode()));
    }

    @Test
    void testUpdateTrainingPlan() {
        manager.insertTrainingPlan(trainingPlan);
        MakeItFitDate newDate = startDate.plusDays(1);
        trainingPlan.setStartDate(newDate);
        assertDoesNotThrow(() -> manager.updateTrainingPlan(trainingPlan));
        assertEquals(newDate, manager.getTrainingPlan(trainingPlan.getCode()).getStartDate());
    }
    @Test
    void testCreateTrainingPlanWithNullArguments() {
        assertThrows(IllegalArgumentException.class, () -> manager.createTrainingPlan(null, startDate));
        assertThrows(IllegalArgumentException.class, () -> manager.createTrainingPlan(userCode, null));
    }

    @Test
    void testInsertDuplicateTrainingPlan() {
        manager.insertTrainingPlan(trainingPlan);
        assertThrows(IllegalArgumentException.class, () -> manager.insertTrainingPlan(trainingPlan));
    }

    @Test
    void testRemoveNonExistentTrainingPlan() {
        UUID randomCode = UUID.randomUUID();
        assertDoesNotThrow(() -> manager.removeTrainingPlan(randomCode));
    }

    @Test
    void testUpdateNonExistentTrainingPlan() {
        UUID randomCode = UUID.randomUUID();
        TrainingPlan nonExistentPlan = new TrainingPlan(randomCode, startDate);
        assertThrows(EntityDoesNotExistException.class, () -> manager.updateTrainingPlan(nonExistentPlan));
    }

    @Test
    void testGetTrainingPlanWithInvalidCode() {
        UUID randomCode = UUID.randomUUID();
        assertThrows(IllegalArgumentException.class, () -> manager.getTrainingPlan(randomCode));
    }

    @Test
    void testAddActivityToNonExistentTrainingPlan() {
        UUID randomCode = UUID.randomUUID();
        Activity activity = new PushUp(randomCode, startDate, 30, "Test PushUp", "PushUp", 10, 3);
        assertThrows(NullPointerException.class, () -> manager.addActivity(randomCode, 1, activity));
    }

    @Test
    void testRemoveActivityFromNonExistentTrainingPlan() {
        UUID randomCode = UUID.randomUUID();
        UUID randomActivityCode = UUID.randomUUID();
        assertThrows(NullPointerException.class, () -> manager.removeActivity(randomCode, randomActivityCode));
    }

    @Test
    void testGetTrainingPlansFromUserWithNoPlans() {
        UUID randomUserCode = UUID.randomUUID();
        assertTrue(manager.getTrainingPlansFromUser(randomUserCode).isEmpty());
    }

    @Test
    void testExtractActivitiesWithNoMatchingUserCode() {
        UUID randomUserCode = UUID.randomUUID();
        assertTrue(manager.extractActivities(startDate, randomUserCode).isEmpty());
    }
    @Test
    void defaultConstructorInitializesUserCodeToZeroUUID() {
        TrainingPlan trainingPlan = new TrainingPlan();
        assertEquals(new UUID(0L, 0L), trainingPlan.getUserCode());
    }

    @Test
    void defaultConstructorInitializesCodeToNonNullUUID() {
        TrainingPlan trainingPlan = new TrainingPlan();
        assertNotNull(trainingPlan.getCode());
    }

    @Test
    void defaultConstructorInitializesStartDateToCurrentDate() {
        TrainingPlan trainingPlan = new TrainingPlan();
        assertEquals(new MakeItFitDate(), trainingPlan.getStartDate());
    }

    @Test
    void defaultConstructorInitializesActivitiesToEmptyList() {
        TrainingPlan trainingPlan = new TrainingPlan();
        assertTrue(trainingPlan.getActivities().isEmpty());
    }
}
