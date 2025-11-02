package test_Hypothesis;

import MakeItFit.*;
import MakeItFit.activities.Activity;
import MakeItFit.activities.implementation.PushUp;
import MakeItFit.trainingPlan.TrainingPlan;
import MakeItFit.users.*;

import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class MakeItFitMutationTest {

    private MakeItFit makeItFit;
    private String email;
    private UUID userCode;

    @BeforeEach
    void setUp() {
        makeItFit = new MakeItFit();
        email = "test@example.com";
        makeItFit.createUser("Test User", 30, Gender.Male, 70, 180, 65, 3, "Test Street", "123456789", email, 2, "Amateur");
        userCode = makeItFit.getUser(email).getCode();
    }

    @Test
    void testCreateUserAndExistsUserWithEmail() {
        assertTrue(makeItFit.existsUserWithEmail(email));
        assertFalse(makeItFit.existsUserWithEmail("notfound@example.com"));
    }

    @Test
    void testGetUserByEmailAndByCode() {
        User userByEmail = makeItFit.getUser(email);
        User userByCode = makeItFit.getUser(userByEmail.getCode());
        assertEquals(userByEmail, userByCode);
    }

    @Test
    void testUpdateUserNameAndAge() {
        makeItFit.updateUserName("New Name", email);
        assertEquals("New Name", makeItFit.getUser(email).getName());

        makeItFit.updateUserAge(40, email);
        assertEquals(40, makeItFit.getUser(email).getAge());
    }

    /* 
    @Test
    void testUpdateUserGenderWeightHeightBpmLevelAddressPhoneEmail() {
        makeItFit.updateUserGender(Gender.Female, email);
        assertEquals(Gender.Female, makeItFit.getUser(email).getGender());

        makeItFit.updateUserWeight(80f, email);
        assertEquals(80f, makeItFit.getUser(email).getWeight());

        makeItFit.updateUserHeight(190, email);
        assertEquals(190, makeItFit.getUser(email).getHeight());

        makeItFit.updateUserBpm(90, email);
        assertEquals(90, makeItFit.getUser(email).getBpm());

        makeItFit.updateUserLevel(5, email);
        assertEquals(5, makeItFit.getUser(email).getLevel());

        makeItFit.updateUserAddress("New Address", email);
        assertEquals("New Address", makeItFit.getUser(email).getAddress());

        makeItFit.updateUserPhone("999999999", email);
        assertEquals("999999999", makeItFit.getUser(email).getPhone());

        makeItFit.updateUserEmail(email, "newemail@example.com");
        assertNotNull(makeItFit.getUser("newemail@example.com"));
    }
    */

    @Test
    void testRemoveUserByEmailAndCode() {
        // Remove by email
        makeItFit.removeUser(email);
        assertFalse(makeItFit.existsUserWithEmail(email));

        // Recreate and remove by code
        makeItFit.createUser("Test User", 30, Gender.Male, 70, 180, 65, 3, "Test Street", "123456789", email, 2, "Amateur");
        User user = makeItFit.getUser(email);
        makeItFit.removeUser(user.getCode());
        assertFalse(makeItFit.existsUserWithEmail(email));
    }

    @Test
    void testGetAllUsersAndGetActivitiesFromUser() {
        List<User> users = makeItFit.getAllUsers();
        assertFalse(users.isEmpty());
        assertEquals(email, users.get(0).getEmail());

        List<Activity> activities = makeItFit.getActivitiesFromUser(email);
        assertNotNull(activities);
        assertTrue(activities.isEmpty());
    }

    @Test
    void testAddAndRemoveActivityToUser() {
        Activity activity = new PushUp(userCode, MakeItFitDate.of(2024, 5, 1), 10, "Push", "PushUp", 10, 2);
        makeItFit.addActivityToUser(email, activity);
        List<Activity> activities = makeItFit.getActivitiesFromUser(email);
        assertEquals(1, activities.size());

        makeItFit.removeActivityFromUser(email, activity.getCode());
        assertTrue(makeItFit.getActivitiesFromUser(email).isEmpty());
    }

    @Test
    void testTrainingPlanCRUD() {
        MakeItFitDate startDate = MakeItFitDate.of(2024, 5, 1);
        UUID planCode = makeItFit.createTrainingPlan(userCode, startDate);
        TrainingPlan plan = makeItFit.getTrainingPlan(planCode);
        assertNotNull(plan);

        makeItFit.removeTrainingPlan(planCode);
        assertThrows(Exception.class, () -> makeItFit.getTrainingPlan(planCode));
    }

    @Test
    void testGetAllTrainingPlansAndGetTrainingPlansFromUser() {
        MakeItFitDate startDate = MakeItFitDate.of(2024, 5, 1);
        UUID planCode = makeItFit.createTrainingPlan(userCode, startDate);
        assertFalse(makeItFit.getAllTrainingPlans().isEmpty());
        assertFalse(makeItFit.getTrainingPlansFromUser(userCode).isEmpty());
    }

    @Test
    void testAddAndRemoveActivityToTrainingPlan() {
        MakeItFitDate startDate = MakeItFitDate.of(2024, 5, 1);
        UUID planCode = makeItFit.createTrainingPlan(userCode, startDate);
        Activity activity = new PushUp(userCode, MakeItFitDate.of(2024, 5, 2), 10, "Push", "PushUp", 10, 2);

        makeItFit.addActivityToTrainingPlan(planCode, activity, 5);
        TrainingPlan plan = makeItFit.getTrainingPlan(planCode);
        assertFalse(plan.getActivities().isEmpty());

        makeItFit.removeActivityFromTrainingPlan(planCode, activity.getCode());
        assertTrue(plan.getActivities().isEmpty());
    }

    @Test
    void testUpdateSystem() {
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 1);
        makeItFit.updateSystem(date, userCode);
        // No assert, just coverage for updateSystem
    }

    @Test
    void testSaveAndLoadSystem() throws Exception {
        String fileName = "test_makeitfit_save.dat";
        makeItFit.saveSystem(fileName);
        File file = new File(fileName);
        assertTrue(file.exists());
        makeItFit.loadSystem(fileName);
        file.delete();
    }
}
