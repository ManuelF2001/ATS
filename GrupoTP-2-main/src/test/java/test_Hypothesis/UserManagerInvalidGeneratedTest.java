package test_Hypothesis;

import MakeItFit.users.*;
import MakeItFit.users.types.*;
import MakeItFit.exceptions.*;
import MakeItFit.users.Gender;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerInvalidGeneratedTest {

@Test
    public void testCreateUserInvalido_0() {
        UserManager um = new UserManager();
        // Espera-se erro com: bpm <= 0
        assertThrows(IllegalArgumentException.class, () -> {
            um.createUser("JZ", 20, Gender.Female, 60.98f, 142, -2, 9, "Rua W", "961143744", "JZ51a83f@vpxeou.pt", 3, "Professional");
        });
    }
@Test
    public void testCreateUserInvalido_1() {
        UserManager um = new UserManager();
        // Espera-se erro com: idade <= 0
        assertThrows(IllegalArgumentException.class, () -> {
            um.createUser("AA", 0, Gender.Male, 30.0f, 120, 40, 0, "Rua A", "900000000", "AAf23b36@aaa.com", 0, "Amateur");
        });
    }
@Test
    public void testCreateUserInvalido_2() {
        UserManager um = new UserManager();
        // Espera-se erro com: idade <= 0
        assertThrows(IllegalArgumentException.class, () -> {
            um.createUser("AA", 0, Gender.Male, 30.0f, 120, 40, 0, "Rua A", "900000000", "AAcb9237@aaa.com", 0, "Amateur");
        });
    }
@Test
    public void testCreateUserInvalido_3() {
        UserManager um = new UserManager();
        // Espera-se erro com: 
        assertThrows(IllegalArgumentException.class, () -> {
            um.createUser("vM", 32, Gender.Male, 30.0f, 217, 112, 3, "Rua S", null, "vM7b2d54@chiws.com", 3, "Professional");
        });
    }
@Test
    public void testCreateUserInvalido_4() {
        UserManager um = new UserManager();
        // Espera-se erro com: 
        assertThrows(IllegalArgumentException.class, () -> {
            um.createUser(null, 23, Gender.Other, 31.0f, 152, 63, 5, "Rua TX", "989369213", "OXGYCsa26161@akr.net", 13, "Professional");
        });
    }
@Test
    public void testCreateUserInvalido_5() {
        UserManager um = new UserManager();
        // Espera-se erro com: 
        assertThrows(IllegalArgumentException.class, () -> {
            um.createUser(null, 66, Gender.Male, 150.0f, 180, 160, 8, "Rua S", "981725090", "pvAb1bd2f@none.org", 15, "Occasional");
        });
    }
@Test
    public void testCreateUserInvalido_6() {
        UserManager um = new UserManager();
        // Espera-se erro com: 
        assertThrows(IllegalArgumentException.class, () -> {
            um.createUser("icRmPBSwA", 99, Gender.Other, 31.0f, 202, 111, 6, null, "958844164", "icRmPBSwA9b366a@tcnlo.com", 8, "Occasional");
        });
    }
@Test
    public void testCreateUserInvalido_7() {
        UserManager um = new UserManager();
        // Espera-se erro com: 
        assertThrows(IllegalArgumentException.class, () -> {
            um.createUser(null, 15, Gender.Other, 150.0f, 170, 121, 7, "Rua NVV", "914534795", "eclYw53a0db@wba.pt", 3, "Professional");
        });
    }
@Test
    public void testCreateUserInvalido_8() {
        UserManager um = new UserManager();
        // Espera-se erro com: 
        assertThrows(IllegalArgumentException.class, () -> {
            um.createUser("EVofCfuOCAkD", 74, Gender.Other, 113.86f, 155, 140, 1, "Rua F", null, "EVofCfuOCAkDf9959b@nvv.com", 0, "Amateur");
        });
    }
@Test
    public void testCreateUserInvalido_9() {
        UserManager um = new UserManager();
        // Espera-se erro com: idade <= 0
        assertThrows(IllegalArgumentException.class, () -> {
            um.createUser("AA", 0, Gender.Male, 30.0f, 120, 40, 0, "Rua A", "900000000", "AA4b9ba7@aaa.com", 0, "Amateur");
        });
    }

}