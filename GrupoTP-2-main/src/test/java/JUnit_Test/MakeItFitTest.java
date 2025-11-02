package JUnit_Test;

import MakeItFit.activities.Activity;
import MakeItFit.activities.implementation.*;
import MakeItFit.exceptions.*;
import MakeItFit.trainingPlan.TrainingPlan;
import MakeItFit.users.Gender;
import MakeItFit.users.User;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.*;
import MakeItFit.MakeItFit;

import java.io.*;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MakeItFitTest {
    private MakeItFit makeItFit;
    private String email;
    private MakeItFitDate date;
    private UUID userCode;
    private UUID trainingPlanCode;
    private UUID activityCode;

    @BeforeEach
    void setUp() throws ExistingEntityConflictException, InvalidTypeException {
        makeItFit = new MakeItFit();
        email = "test@example.com";
        date = new MakeItFitDate();

        // Create a test user
        makeItFit.createUser("John Doe", 30, Gender.Male, 70.0f, 180, 75, 3,
                "123 Main St", "555-1234", email, 5,"Amateur");
        userCode = makeItFit.getUser(email).getCode();

        // Create a training plan
        trainingPlanCode = makeItFit.createTrainingPlan(userCode, date);

        // Create an activity
        Activity activity = new PushUp(userCode, date, 30, "Morning workout", "Pushups", 15, 3);
        makeItFit.addActivityToUser(email, activity);
        activityCode = activity.getCode();
    }

    // Test User Management
    @Test
    void testCreateUser() {
        assertTrue(makeItFit.existsUserWithEmail(email));
    }

    @Test
    void testRemoveUserByEmail() {
        assertDoesNotThrow(() -> makeItFit.removeUser(email));
        assertFalse(makeItFit.existsUserWithEmail(email));
    }

    @Test
    void testRemoveUserByUUID() {
        assertDoesNotThrow(() -> makeItFit.removeUser(userCode));
        assertFalse(makeItFit.existsUserWithEmail(email));
    }

    @Test
    void testExistsUserWithEmail() {
        assertTrue(makeItFit.existsUserWithEmail(email));
    }

    @Test
    void testGetUserByEmail() {
        User user = makeItFit.getUser(email);
        assertEquals("John Doe", user.getName());
    }

    @Test
    void testGetUserByUUID() {
        User user = makeItFit.getUser(userCode);
        assertEquals("John Doe", user.getName());
    }

    @Test
    void testUpdateUserName() {
        makeItFit.updateUserName("John Smith", email);
        assertEquals("John Smith", makeItFit.getUser(email).getName());
    }

    @Test
    void testUpdateUserAge() {
        makeItFit.updateUserAge(31, email);
        assertEquals(31, makeItFit.getUser(email).getAge());
    }

    @Test
    void testUpdateUserGender() {
        makeItFit.updateUserGender(Gender.Female, email);
        assertEquals(Gender.Female, makeItFit.getUser(email).getGender());
    }

    @Test
    void testUpdateUserWeight() {
        makeItFit.updateUserWeight(72.5f, email);
        assertEquals(72.5f, makeItFit.getUser(email).getWeight());
    }

    @Test
    void testUpdateUserHeight() {
        makeItFit.updateUserHeight(182, email);
        assertEquals(182, makeItFit.getUser(email).getHeight());
    }

    @Test
    void testUpdateUserBpm() {
        makeItFit.updateUserBpm(80, email);
        assertEquals(80, makeItFit.getUser(email).getBpm());
    }

    @Test
    void testUpdateUserLevel() {
        makeItFit.updateUserLevel(4, email);
        assertEquals(4, makeItFit.getUser(email).getLevel());
    }

    @Test
    void testUpdateUserAddress() {
        makeItFit.updateUserAddress("456 Oak St", email);
        assertEquals("456 Oak St", makeItFit.getUser(email).getAddress());
    }

    @Test
    void testUpdateUserPhone() {
        makeItFit.updateUserPhone("555-5678", email);
        assertEquals("555-5678", makeItFit.getUser(email).getPhone());
    }
/*
    @Test
    void testUpdateUserEmail() {
        String newEmail = "new@example.com";
        makeItFit.updateUserEmail(email, newEmail);
        assertNotNull(makeItFit.getUser(newEmail));
        assertEquals("John Doe", makeItFit.getUser(newEmail).getName());
    }
        */

    @Test
    void testGetAllUsers() {
        List<User> users = makeItFit.getAllUsers();
        assertEquals(1, users.size());
        assertEquals("John Doe", users.get(0).getName());
    }

    // Test Activity Management
    @Test
    void testGetActivitiesFromUser() {
        List<Activity> activities = makeItFit.getActivitiesFromUser(email);
        assertEquals(1, activities.size());
        assertEquals("Pushups", activities.get(0).getName());
    }

    @Test
    void testAddActivityToUser() {
        Activity newActivity = new Running(userCode, date, 60, "Evening run", "Running", 5000, 10.0);
        makeItFit.addActivityToUser(email, newActivity);
        assertEquals(2, makeItFit.getActivitiesFromUser(email).size());
    }

    @Test
    void testRemoveActivityFromUser() {
        makeItFit.removeActivityFromUser(email, activityCode);
        assertEquals(0, makeItFit.getActivitiesFromUser(email).size());
    }

    // Test Training Plan Management
    @Test
    void testCreateTrainingPlan() {
        assertNotNull(trainingPlanCode);
    }

    @Test
    void testConstructTrainingPlanByObjectives() {
        TrainingPlan plan = makeItFit.getTrainingPlan(trainingPlanCode);
        assertDoesNotThrow(() ->
                makeItFit.constructTrainingPlanByObjectives(plan, true, 2, 3, 4, 1000)
        );
        assertFalse(plan.getActivities().isEmpty());
    }

    @Test
    void testRemoveTrainingPlan() {
        makeItFit.removeTrainingPlan(trainingPlanCode);
        assertThrows(IllegalArgumentException.class,
                () -> makeItFit.getTrainingPlan(trainingPlanCode)
        );
    }

    @Test
    void testGetTrainingPlan() {
        TrainingPlan plan = makeItFit.getTrainingPlan(trainingPlanCode);
        assertEquals(userCode, plan.getUserCode());
    }

    @Test
    void testUpdateTrainingPlan() {
        TrainingPlan plan = makeItFit.getTrainingPlan(trainingPlanCode);
        MakeItFitDate newDate = date.plusDays(1);
        plan.setStartDate(newDate);

        assertDoesNotThrow(() -> makeItFit.updateTrainingPlan(plan));
        assertEquals(newDate, makeItFit.getTrainingPlan(trainingPlanCode).getStartDate());
    }

    @Test
    void testGetAllTrainingPlans() {
        List<TrainingPlan> plans = makeItFit.getAllTrainingPlans();
        assertEquals(1, plans.size());
        assertEquals(trainingPlanCode, plans.get(0).getCode());
    }

    @Test
    void testAddActivityToTrainingPlan() {
        Activity activity = new WeightSquat(userCode, date, 45, "Leg day", "Squats", 12, 4, 70.0);
        makeItFit.addActivityToTrainingPlan(trainingPlanCode, activity, 3);

        TrainingPlan plan = makeItFit.getTrainingPlan(trainingPlanCode);
        assertEquals(1, plan.getActivities().size());
    }

    @Test
    void testRemoveActivityFromTrainingPlan() {
        Activity activity = new WeightSquat(userCode, date, 45, "Leg day", "Squats", 12, 4, 70.0);
        makeItFit.addActivityToTrainingPlan(trainingPlanCode, activity, 3);
        makeItFit.removeActivityFromTrainingPlan(trainingPlanCode, activity.getCode());

        TrainingPlan plan = makeItFit.getTrainingPlan(trainingPlanCode);
        assertTrue(plan.getActivities().isEmpty());
    }

    @Test
    void testGetTrainingPlansFromUser() {
        List<TrainingPlan> plans = makeItFit.getTrainingPlansFromUser(userCode);
        assertEquals(1, plans.size());
        assertEquals(trainingPlanCode, plans.get(0).getCode());
    }

    // Test System Operations
    @Test
    void testUpdateSystem() {
        // Create activity with past date
        MakeItFitDate pastDate = date.plusDays(1);
        Activity activity = new Trail(userCode, pastDate, 120, "Mountain trail", "Hiking",
                10000, 300, 150, Trail.TRAIL_TYPE_HARD);
        makeItFit.addActivityToUser(email, activity);

        // Update system to process past activity
        makeItFit.updateSystem(date, userCode);

        // Verify caloric waste was calculated
        Activity processed = makeItFit.getActivitiesFromUser(email).get(1);
        assertTrue(processed.getCaloricWaste() > 0);
    }

    @Test
    void testSaveAndLoadSystem() throws IOException {
        // Create temp file
        File tempFile = File.createTempFile("makeitfit", ".dat");
        tempFile.deleteOnExit();

        // Save system
        makeItFit.saveSystem(tempFile.getAbsolutePath());

        // Create new system instance
        MakeItFit newSystem = new MakeItFit();
        newSystem.loadSystem(tempFile.getAbsolutePath());

        // Verify data was loaded
        assertTrue(newSystem.existsUserWithEmail(email));
        assertEquals(1, newSystem.getAllTrainingPlans().size());
    }

    // Test Query Methods
    @Test
    void testExecuteQueryHowManyKMsDoneWithDates() {
        double result = makeItFit.executeQueryHowManyKMsDone(email, date, date.plusDays(7));
        assertEquals(0.0, result);
    }

    @Test
    void testExecuteQueryHowManyKMsDone() {
        double result = makeItFit.executeQueryHowManyKMsDone(email);
        assertEquals(0.0, result);
    }

    @Test
    void testExecuteQueryHowManyAltimetryDoneWithDates() {
        double result = makeItFit.executeQueryHowManyAltimetryDone(email, date, date.plusDays(7));
        assertEquals(0.0, result);
    }

    @Test
    void testExecuteQueryHowManyAltimetryDone() {
        double result = makeItFit.executeQueryHowManyAltimetryDone(email);
        assertEquals(0.0, result);
    }

    @Test
    void testExecuteQueryMostDemandingTrainingPlan() {
        // O método pode retornar null se não houver plano, então aceite null
        TrainingPlan plan = makeItFit.executeQueryMostDemandingTrainingPlan();
        assertNull(plan);
    }

    @Test
    void testExecuteQueryMostDoneActivity() {
        String result = makeItFit.executeQueryMostDoneActivity();
        assertNotNull(result);
    }
/* 
     @Test
    void testExecuteQueryWhoBurnsMoreCaloriesWithDates() {
        // O método pode retornar null se não houver usuário, então aceite null
        User user = makeItFit.executeQuerywhoBurnsMoreCalories(date, date);
        assertNull(user);
    }
*/
    @Test
    void testExecuteQueryWhoBurnsMoreCalories() {
        User user = makeItFit.executeQuerywhoBurnsMoreCalories();
        assertNotNull(user);
    }

    /* 
    @Test
    void testExecuteQueryWhoDidTheMostActivitiesWithDates() {
        // O método pode retornar null se não houver usuário, então aceite null
        User user = makeItFit.executeQueryWhoDidTheMostActivities(date, date);
        assertNull(user);
    }
*/
    @Test
    void testExecuteQueryWhoDidTheMostActivities() {
        User user = makeItFit.executeQueryWhoDidTheMostActivities();
        assertNotNull(user);
    }

    // Test Exception Handling
    @Test
    void testInvalidTypeException() {
        assertThrows(InvalidTypeException.class, () -> makeItFit.getUser(123));
    }

    @Test
    void testEntityDoesNotExistException() {
        assertThrows(EntityDoesNotExistException.class,
                () -> makeItFit.removeUser(UUID.randomUUID())
        );
    }

    @Test
    void testFileNotFoundExceptionOnSave() {
        assertThrows(FileNotFoundException.class,
                () -> makeItFit.saveSystem("/invalid/path/system.dat")
        );
    }

    @Test
    void testFileNotFoundExceptionOnLoad() {
        assertThrows(FileNotFoundException.class,
                () -> makeItFit.loadSystem("nonexistent.dat")
        );
    }
}