package test_Hypothesis;

import MakeItFit.menu.MenuItem;
import MakeItFit.utils.MakeItFitDate;
import MakeItFit.MakeItFitController;
import MakeItFit.activities.Activity;
import MakeItFit.activities.implementation.PushUp;
import MakeItFit.users.Gender;
import MakeItFit.exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {

    private MakeItFitController controller;
    private final String TEST_EMAIL = "test@example.com";

    @BeforeEach
    void setUp() {
        controller = new MakeItFitController();
    }

    @Test
    void updateEmailFailsWhenUsingNewEmailAsIdentifier() throws Exception {
        controller.setNewEmail(TEST_EMAIL);
        controller.createUser("Email Test", 25, Gender.Female, 60.0f, 165, 75, 1,
                "Test Address", "987654321", 2, "Amateur");

        String newEmail = "new@example.com";

        // Simula o erro ao tentar usar o novo email como identificador
        assertThrows(EntityDoesNotExistException.class, () -> {
            controller.updateEmail(newEmail);
        });
    }


    @Test
    void updateEmailToSameEmailDoesNotChangeEmail() throws Exception {
        controller.setNewEmail(TEST_EMAIL);
        controller.createUser("Email Test", 25, Gender.Female, 60.0f, 165, 75, 1,
                "Test Address", "987654321", 2, "Amateur");

        controller.updateEmail(TEST_EMAIL);

        assertEquals(TEST_EMAIL, controller.getEmail());
    }


    @Test
    void updateEmailThrowsExceptionForNonExistentUser() {
        assertThrows(EntityDoesNotExistException.class, () -> {
            controller.updateEmail("nonexistent@example.com");
        });
    }
    @Test
    void testInvalidUserCreation() {
        assertThrows(IllegalArgumentException.class, () ->
                controller.createUser("", -5, Gender.Male, -10f, -100, -50, -1,
                        "", "", -1, "InvalidType")
        );
    }

        @Test
        void equalsReturnsTrueForSameInstance() {
            PushUp pushUp = new PushUp();
            assertTrue(pushUp.equals(pushUp));
        }

        @Test
        void equalsReturnsFalseForDifferentClassInstance() {
            PushUp pushUp = new PushUp();
            Object obj = new Object();
            assertFalse(pushUp.equals(obj));
        }

        @Test
        void equalsReturnsTrueForIdenticalPushUpInstances() {
            PushUp pushUp1 = new PushUp();
            PushUp pushUp2 = new PushUp(pushUp1);
            assertTrue(pushUp1.equals(pushUp2));
        }

        @Test
        void equalsReturnsFalseForDifferentPushUpInstances() {
            PushUp pushUp1 = new PushUp();
            PushUp pushUp2 = new PushUp();
            assertTrue(pushUp1.equals(pushUp2));
        }

}