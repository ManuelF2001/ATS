package JUnit_Test;

import MakeItFit.MakeItFitController;
import MakeItFit.exceptions.*;
import MakeItFit.users.Gender;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MakeItFitControllerTest {
    private MakeItFitController controller;
    private String email;
    private MakeItFitDate date;

    @BeforeEach
    void setUp() throws EntityDoesNotExistException, ExistingEntityConflictException, InvalidTypeException {
        controller = new MakeItFitController();
        email = "test@example.com";
        date = new MakeItFitDate();

        controller.setNewEmail(email);
        controller.createUser("Jane Smith", 28, Gender.Female, 60.0f, 165, 70, 2,
                "456 Oak St", "555-5678", 4, "Amateur");
        controller.login(email);
    }

    @Test
    void testSetEmail() throws EntityDoesNotExistException {
        controller.setEmail(email);
        assertEquals(email, controller.getEmail());
        assertEquals("Jane Smith", controller.getName());

        // Test non-existing email
        assertThrows(EntityDoesNotExistException.class, () ->
                controller.setEmail("invalid@email.com"));
    }

    @Test
    void testSetTrainingPlan() {
        controller.createTrainingPlan(date);
        UUID planId = controller.trainingPlan;
        controller.setTrainingPlan(planId);
        assertEquals(planId, controller.trainingPlan);
    }

    @Test
    void testUpdateAge() {
        controller.updateAge(30);
        assertTrue(controller.getUserDetails().contains("30"));
    }

    @Test
    void testUpdateGender() {
        controller.updateGender(Gender.Male);
        assertTrue(controller.getUserDetails().contains("Male"));
    }

    @Test
    void testUpdateBpm() {
        controller.updateBpm(75);
        assertTrue(controller.getUserDetails().contains("75"));
    }

    @Test
    void testUpdateLevel() {
        controller.updateLevel(3);
        assertTrue(controller.getUserDetails().contains("3"));
    }

    @Test
    void testUpdateAddress() {
        controller.updateAddress("789 Pine St");
        assertTrue(controller.getUserDetails().contains("789 Pine St"));
    }

    @Test
    void testUpdatePhone() {
        controller.updatePhone("555-9999");
        assertTrue(controller.getUserDetails().contains("555-9999"));
    }

    @Test
    void testGetAllUsers() {
        String users = controller.getAllUsers();
        assertNotNull(users);
        assertTrue(users.contains("Jane Smith"));
    }

    @Test
    void testRemoveActivityFromUser() {
        controller.addActivityToUser(date, 30, "Workout", "Pushups", 15, 3);
        UUID activityId = controller.makeItFit.getActivitiesFromUser(email).get(0).getCode();

        controller.removeActivityFromUser(activityId);
        assertFalse(controller.getActivities().contains("Pushups"));
    }

    @Test
    void testConstructTrainingPlanByObjectives() {
        controller.createTrainingPlan(date);
        assertDoesNotThrow(() ->
                controller.constructTrainingPlanByObjectives(true, 2, 3, 4, 1000)
        );
    }

    @Test
    void testRemoveTrainingPlan() {
        controller.createTrainingPlan(date);
        UUID planId = controller.trainingPlan;
        controller.removeTrainingPlan();
        assertFalse(controller.getTrainingPlans().contains(planId.toString()));
    }

    @Test
    void testRemoveActivityFromTrainingPlan() {
        controller.createTrainingPlan(date);
        controller.addActivityToTrainingPlan(date, 30, "Workout", "Squats", 12, 4, 70.0, 3);
        UUID activityId = controller.makeItFit.getTrainingPlan(controller.trainingPlan)
                .getActivities().get(0).getItem2().getCode();

        controller.removeActivityFromTrainingPlan(activityId);
        assertFalse(controller.getTrainingPlans().contains("Squats"));
    }

    @Test
    void testGetTrainingPlansFromUser() {
        controller.createTrainingPlan(date);
        String plans = controller.getTrainingPlansFromUser();
        assertNotNull(plans);
        assertTrue(plans.contains(date.toString()));
    }
/* 
    @Test
    void testExecuteQueryHowManyKMsDoneWithDates() {
        controller.addActivityToUser(date, 30, "Morning run", "Running", 5.0, 10.0);
        double result = controller.executeQueryHowManyKMsDone(date, date.plusDays(1));
        assertEquals(5.0, result, 0.01);
    }
*/
    @Test
    void testExecuteQueryHowManyKMsDoneWithoutDates() {
        controller.addActivityToUser(date, 30, "Morning run", "Running", 5000.0, 10.0);
        double result = controller.executeQueryHowManyKMsDone();
        assertEquals(5.0, result, 0.01);
    }

    /* 
    @Test
    void testExecuteQueryHowManyAltimetryDoneWithDates() {

        controller.addActivityToUser(date, 120, "Mountain trail", "Hiking",
                10000, 300, 150, 2);
        double result = controller.executeQueryHowManyAltimetryDone(date, date.plusDays(1));
        assertEquals(450.0, result, 0.01); // 300 + 150
    }*/

    @Test
    void testExecuteQueryHowManyAltimetryDoneWithoutDates() {
        controller.addActivityToUser(date, 120, "Mountain trail", "Hiking",
                10000, 300, 150, 2);
        double result = controller.executeQueryHowManyAltimetryDone();
        assertEquals(450.0, result, 0.01);
    }
/* 
    @Test
    void testExecuteQueryMostDemandingTrainingPlan() {
        controller.createTrainingPlan(date);
        String result = controller.executeQueryMostDemandingTrainingPlan();
        assertNotNull(result);
        assertTrue(result.contains("TrainingPlan"));
    }
*/
/* 
    @Test
    void testExecuteQuerywhoBurnsMoreCaloriesWithDates() {
        String result = controller.executeQuerywhoBurnsMoreCalories(date, date.plusDays(7));
        assertNotNull(result);
        assertTrue(result.contains("User"));
    }
        */
/* 
    @Test
    void testExecuteQueryWhoDidTheMostActivitiesWithDates() {
        String result = controller.executeQueryWhoDidTheMostActivities(date, date.plusDays(7));
        assertNotNull(result);
        assertTrue(result.contains("User"));
    }
*/
/* 
    @Test
    void testExecuteQueryWhoDidTheMostActivitiesWithoutDates() {
        String result = controller.executeQueryWhoDidTheMostActivities();
        assertNotNull(result);
        assertTrue(result.contains("User"));
    }
    */

    // Existing tests from original file
    @Test
    void testLogin() {
        assertEquals(email, controller.getEmail());
        assertEquals("Jane Smith", controller.getName());
    }

    
    /*
    @Test
    void testUpdateUserDetails() {
        controller.updateName("Jane Doe");
        assertEquals("Jane Doe", controller.getName());

        controller.updateWeight(62.5f);
        controller.updateHeight(167);
        assertTrue(controller.getUserDetails().contains("62.5"));
    }
*/
    @Test
    void testAddActivityToUser() {
        controller.addActivityToUser(date, 30, "Morning run", "Running", 5000, 10.0);
        assertTrue(controller.getActivities().contains("Running"));
    }

    @Test
    void testCreateTrainingPlan() {
        controller.createTrainingPlan(date);
        assertNotNull(controller.getTrainingPlans());
    }
/* 
    @Test
    void testExecuteQueries() {
        double kms = controller.executeQueryHowManyKMsDone();
        assertEquals(0.0, kms);

        String mostDone = controller.executeQueryMostDoneActivity();
        assertEquals("No activities", mostDone);
    }
*/
    @Test
    void testUpdateSystemDate() {
        controller.addActivityToUser(date.plusDays(1), 30, "Past workout", "Pushups", 15, 3);
        assertDoesNotThrow(() -> controller.updateSystemDate(2));
        assertTrue(controller.getActivities().contains("Pushups"));
    }

    @Test
    void testSaveAndLoadSystem() {
        assertDoesNotThrow(() -> {
            controller.saveSystem("test_system.dat");
            controller.loadSystem("test_system.dat");
        });
    }

    @Test
    void testRemoveUser() {
        assertDoesNotThrow(() -> controller.removeUser());
        assertThrows(IllegalArgumentException.class, () -> controller.login(email));
    }

    /* 
    @Test
    void testUpdateEmail() {
        String newEmail = "new@example.com";
        controller.updateEmail(newEmail);
        assertEquals(newEmail, controller.getEmail());
    }
*/

/* 
    @Test
    void testAddActivityToTrainingPlan() {
        controller.createTrainingPlan(date);
        controller.addActivityToTrainingPlan(date, 30, "Workout", "Pushups", 15, 3, 5);
        assertTrue(controller.getTrainingPlans().contains("Pushups"));
    }
    */
/* 
    @Test
    void testExecuteQueryWhoBurnsMoreCalories() {
        String result = controller.executeQuerywhoBurnsMoreCalories();
        assertNotNull(result);
    }
    */    
}