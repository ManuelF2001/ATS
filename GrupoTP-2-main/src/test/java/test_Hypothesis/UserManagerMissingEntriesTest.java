package test_Hypothesis;

import MakeItFit.users.*;
import MakeItFit.users.types.*;
import MakeItFit.exceptions.*;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerMissingEntriesTest {

@Test
    public void testEmailOuCodigoInexistente_0() {
        UserManager um = new UserManager();

        assertFalse(um.existsUserWithEmail("nweoe5fa77@vlt.pt"));

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByEmail("nweoe5fa77@vlt.pt");
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByEmail("nweoe5fa77@vlt.pt");
        });

        UUID codigo = UUID.fromString("e5046bad-ea71-43e5-80fe-d2c47f074386");
        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByCode(codigo);
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByCode(codigo);
        });
    }
@Test
    public void testEmailOuCodigoInexistente_1() {
        UserManager um = new UserManager();

        assertFalse(um.existsUserWithEmail("yesuxitx19eafb@aaa.com"));

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByEmail("yesuxitx19eafb@aaa.com");
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByEmail("yesuxitx19eafb@aaa.com");
        });

        UUID codigo = UUID.fromString("5fd6f2bf-92d8-49b9-a8e6-51e65c221572");
        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByCode(codigo);
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByCode(codigo);
        });
    }
@Test
    public void testEmailOuCodigoInexistente_2() {
        UserManager um = new UserManager();

        assertFalse(um.existsUserWithEmail("nahfxyhba52cd9@tgn.org"));

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByEmail("nahfxyhba52cd9@tgn.org");
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByEmail("nahfxyhba52cd9@tgn.org");
        });

        UUID codigo = UUID.fromString("2ec3e19b-e337-4b80-b2e8-74e62eefe78d");
        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByCode(codigo);
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByCode(codigo);
        });
    }
@Test
    public void testEmailOuCodigoInexistente_3() {
        UserManager um = new UserManager();

        assertFalse(um.existsUserWithEmail("hgy8663f3@sdbukb.com"));

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByEmail("hgy8663f3@sdbukb.com");
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByEmail("hgy8663f3@sdbukb.com");
        });

        UUID codigo = UUID.fromString("4b7fb42f-d6eb-4916-a953-b08855d0af3c");
        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByCode(codigo);
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByCode(codigo);
        });
    }
@Test
    public void testEmailOuCodigoInexistente_4() {
        UserManager um = new UserManager();

        assertFalse(um.existsUserWithEmail("ousmfmyd45e54e@aaa.com"));

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByEmail("ousmfmyd45e54e@aaa.com");
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByEmail("ousmfmyd45e54e@aaa.com");
        });

        UUID codigo = UUID.fromString("cb7fcf85-f5c5-4713-acd1-0b5a29ac9c25");
        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByCode(codigo);
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByCode(codigo);
        });
    }
@Test
    public void testEmailOuCodigoInexistente_5() {
        UserManager um = new UserManager();

        assertFalse(um.existsUserWithEmail("czzzox4e41f4@avqawy.org"));

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByEmail("czzzox4e41f4@avqawy.org");
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByEmail("czzzox4e41f4@avqawy.org");
        });

        UUID codigo = UUID.fromString("9373a999-6542-4d49-98f7-21d423cbe09d");
        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByCode(codigo);
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByCode(codigo);
        });
    }
@Test
    public void testEmailOuCodigoInexistente_6() {
        UserManager um = new UserManager();

        assertFalse(um.existsUserWithEmail("nij7dfc9e@mztgtm.org"));

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByEmail("nij7dfc9e@mztgtm.org");
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByEmail("nij7dfc9e@mztgtm.org");
        });

        UUID codigo = UUID.fromString("46455e60-e4a8-4113-a83e-be5aad105780");
        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByCode(codigo);
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByCode(codigo);
        });
    }
@Test
    public void testEmailOuCodigoInexistente_7() {
        UserManager um = new UserManager();

        assertFalse(um.existsUserWithEmail("mfgjnp2c43a4@hpsdb.org"));

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByEmail("mfgjnp2c43a4@hpsdb.org");
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByEmail("mfgjnp2c43a4@hpsdb.org");
        });

        UUID codigo = UUID.fromString("ccbc3559-2f9c-4572-bc2c-f98210649904");
        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByCode(codigo);
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByCode(codigo);
        });
    }
@Test
    public void testEmailOuCodigoInexistente_8() {
        UserManager um = new UserManager();

        assertFalse(um.existsUserWithEmail("nilb9ee3e@xfmnw.com"));

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByEmail("nilb9ee3e@xfmnw.com");
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByEmail("nilb9ee3e@xfmnw.com");
        });

        UUID codigo = UUID.fromString("0929ebf4-1d45-43a2-a96c-ca4cdcddd6ca");
        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByCode(codigo);
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByCode(codigo);
        });
    }
@Test
    public void testEmailOuCodigoInexistente_9() {
        UserManager um = new UserManager();

        assertFalse(um.existsUserWithEmail("ntwbtbw9d544b@wrp.com"));

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByEmail("ntwbtbw9d544b@wrp.com");
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByEmail("ntwbtbw9d544b@wrp.com");
        });

        UUID codigo = UUID.fromString("317160c8-e69f-43bd-ba49-243b6b768b58");
        assertThrows(EntityDoesNotExistException.class, () -> {
            um.getUserByCode(codigo);
        });

        assertThrows(EntityDoesNotExistException.class, () -> {
            um.removeUserByCode(codigo);
        });
    }
@Test
    public void testDuplicados_0() {
        UserManager um = new UserManager();

        // Criar dois utilizadores válidos
        User userA0 = um.createUser("AA", 10, Gender.Male, 30.0f, 120, 40, 0, "Rua A", "900000000", "AAecc63a@aaa.com", 0, "Amateur");
        userA0.setCode(UUID.fromString("83999b40-132f-4d39-8064-38adad4a11cd"));
        um.insertUser(userA0);

        User userB0 = um.createUser("AA", 10, Gender.Male, 30.0f, 120, 40, 0, "Rua A", "900000000", "AAecc63a@aaa.com", 0, "Amateur");
        userB0.setCode(UUID.fromString("83999b40-132f-4d39-8064-38adad4a11cd")); // mesmo código

        // Tentar inserir com o mesmo email deve falhar
        assertThrows(ExistingEntityConflictException.class, () -> {
            um.insertUser(userB0);
        });
    }
@Test
    public void testDuplicados_1() {
        UserManager um = new UserManager();

        // Criar dois utilizadores válidos
        User userA1 = um.createUser("JSNeBhdV", 21, Gender.Female, 31.0f, 200, 180, 9, "Rua V", "915771417", "JSNeBhdV17aaf2@afyczo.org", 0, "Amateur");
        userA1.setCode(UUID.fromString("da071185-d03e-4ad3-9def-6877621bb979"));
        um.insertUser(userA1);

        User userB1 = um.createUser("JSNeBhdV", 21, Gender.Female, 31.0f, 200, 180, 9, "Rua V", "915771417", "JSNeBhdV17aaf2@afyczo.org", 0, "Amateur");
        userB1.setCode(UUID.fromString("da071185-d03e-4ad3-9def-6877621bb979")); // mesmo código

        // Tentar inserir com o mesmo email deve falhar
        assertThrows(ExistingEntityConflictException.class, () -> {
            um.insertUser(userB1);
        });
    }
@Test
    public void testDuplicados_2() {
        UserManager um = new UserManager();

        // Criar dois utilizadores válidos
        User userA2 = um.createUser("tmPdEINs", 52, Gender.Other, 149.0f, 161, 179, 6, "Rua OBW", "908491430", "tmPdEINs2e33f3@isrlut.net", 15, "Occasional");
        userA2.setCode(UUID.fromString("c14886eb-1f8f-41ce-bc2e-54ba4942dfbd"));
        um.insertUser(userA2);

        User userB2 = um.createUser("tmPdEINs", 52, Gender.Other, 149.0f, 161, 179, 6, "Rua OBW", "908491430", "tmPdEINs2e33f3@isrlut.net", 15, "Occasional");
        userB2.setCode(UUID.fromString("c14886eb-1f8f-41ce-bc2e-54ba4942dfbd")); // mesmo código

        // Tentar inserir com o mesmo email deve falhar
        assertThrows(ExistingEntityConflictException.class, () -> {
            um.insertUser(userB2);
        });
    }
@Test
    public void testDuplicados_3() {
        UserManager um = new UserManager();

        // Criar dois utilizadores válidos
        User userA3 = um.createUser("RsESkQP", 91, Gender.Other, 30.0f, 126, 137, 0, "Rua KJ", "947742965", "RsESkQPb500ad@miuu.com", 1, "Professional");
        userA3.setCode(UUID.fromString("fcb83e40-a94e-4bde-8d0b-8f04fdc292d7"));
        um.insertUser(userA3);

        User userB3 = um.createUser("RsESkQP", 91, Gender.Other, 30.0f, 126, 137, 0, "Rua KJ", "947742965", "RsESkQPb500ad@miuu.com", 1, "Professional");
        userB3.setCode(UUID.fromString("fcb83e40-a94e-4bde-8d0b-8f04fdc292d7")); // mesmo código

        // Tentar inserir com o mesmo email deve falhar
        assertThrows(ExistingEntityConflictException.class, () -> {
            um.insertUser(userB3);
        });
    }
@Test
    public void testDuplicados_4() {
        UserManager um = new UserManager();

        // Criar dois utilizadores válidos
        User userA4 = um.createUser("TvzM", 44, Gender.Male, 149.0f, 158, 120, 2, "Rua K", "906221766", "TvzMf732a6@czf.pt", 11, "Professional");
        userA4.setCode(UUID.fromString("f1f37f51-ffcc-4ea0-b320-c54f4e05eefc"));
        um.insertUser(userA4);

        User userB4 = um.createUser("TvzM", 44, Gender.Male, 149.0f, 158, 120, 2, "Rua K", "906221766", "TvzMf732a6@czf.pt", 11, "Professional");
        userB4.setCode(UUID.fromString("f1f37f51-ffcc-4ea0-b320-c54f4e05eefc")); // mesmo código

        // Tentar inserir com o mesmo email deve falhar
        assertThrows(ExistingEntityConflictException.class, () -> {
            um.insertUser(userB4);
        });
    }
@Test
    public void testDuplicados_5() {
        UserManager um = new UserManager();

        // Criar dois utilizadores válidos
        User userA5 = um.createUser("NubaQTsigC", 44, Gender.Female, 30.0f, 208, 47, 7, "Rua OKK", "993646355", "NubaQTsigCae9a06@lkvboi.net", 0, "Amateur");
        userA5.setCode(UUID.fromString("69f5c279-0381-4b29-9c1b-540e384c8587"));
        um.insertUser(userA5);

        User userB5 = um.createUser("NubaQTsigC", 44, Gender.Female, 30.0f, 208, 47, 7, "Rua OKK", "993646355", "NubaQTsigCae9a06@lkvboi.net", 0, "Amateur");
        userB5.setCode(UUID.fromString("69f5c279-0381-4b29-9c1b-540e384c8587")); // mesmo código

        // Tentar inserir com o mesmo email deve falhar
        assertThrows(ExistingEntityConflictException.class, () -> {
            um.insertUser(userB5);
        });
    }
@Test
    public void testDuplicados_6() {
        UserManager um = new UserManager();

        // Criar dois utilizadores válidos
        User userA6 = um.createUser("AA", 10, Gender.Male, 30.0f, 120, 40, 0, "Rua A", "900000000", "AA279a66@aaa.com", 1, "Occasional");
        userA6.setCode(UUID.fromString("63dedb02-edbd-457a-aa23-3d4aea379b7a"));
        um.insertUser(userA6);

        User userB6 = um.createUser("AA", 10, Gender.Male, 30.0f, 120, 40, 0, "Rua A", "900000000", "AA279a66@aaa.com", 1, "Occasional");
        userB6.setCode(UUID.fromString("63dedb02-edbd-457a-aa23-3d4aea379b7a")); // mesmo código

        // Tentar inserir com o mesmo email deve falhar
        assertThrows(ExistingEntityConflictException.class, () -> {
            um.insertUser(userB6);
        });
    }
@Test
    public void testDuplicados_7() {
        UserManager um = new UserManager();

        // Criar dois utilizadores válidos
        User userA7 = um.createUser("IumixzIbGLyb", 98, Gender.Male, 149.0f, 142, 128, 1, "Rua LD", "990859493", "IumixzIbGLybea6e33@vwehu.net", 4, "Professional");
        userA7.setCode(UUID.fromString("e59c6212-70c5-475c-a1ee-1a9a03fda34e"));
        um.insertUser(userA7);

        User userB7 = um.createUser("IumixzIbGLyb", 98, Gender.Male, 149.0f, 142, 128, 1, "Rua LD", "990859493", "IumixzIbGLybea6e33@vwehu.net", 4, "Professional");
        userB7.setCode(UUID.fromString("e59c6212-70c5-475c-a1ee-1a9a03fda34e")); // mesmo código

        // Tentar inserir com o mesmo email deve falhar
        assertThrows(ExistingEntityConflictException.class, () -> {
            um.insertUser(userB7);
        });
    }
@Test
    public void testDuplicados_8() {
        UserManager um = new UserManager();

        // Criar dois utilizadores válidos
        User userA8 = um.createUser("HBsM", 51, Gender.Other, 150.0f, 139, 133, 0, "Rua AE", "951863693", "HBsM5cd2fd@zvs.org", 15, "Occasional");
        userA8.setCode(UUID.fromString("5eb03c94-644a-4a11-9a4a-d39ee9a69a2b"));
        um.insertUser(userA8);

        User userB8 = um.createUser("HBsM", 51, Gender.Other, 150.0f, 139, 133, 0, "Rua AE", "951863693", "HBsM5cd2fd@zvs.org", 15, "Occasional");
        userB8.setCode(UUID.fromString("5eb03c94-644a-4a11-9a4a-d39ee9a69a2b")); // mesmo código

        // Tentar inserir com o mesmo email deve falhar
        assertThrows(ExistingEntityConflictException.class, () -> {
            um.insertUser(userB8);
        });
    }
@Test
    public void testDuplicados_9() {
        UserManager um = new UserManager();

        // Criar dois utilizadores válidos
        User userA9 = um.createUser("AA", 10, Gender.Male, 30.0f, 120, 40, 0, "Rua A", "900000000", "AA04c689@aaa.com", 1, "Occasional");
        userA9.setCode(UUID.fromString("5015ae22-5f54-407c-a4c8-ee88f6a7db05"));
        um.insertUser(userA9);

        User userB9 = um.createUser("AA", 10, Gender.Male, 30.0f, 120, 40, 0, "Rua A", "900000000", "AA04c689@aaa.com", 1, "Occasional");
        userB9.setCode(UUID.fromString("5015ae22-5f54-407c-a4c8-ee88f6a7db05")); // mesmo código

        // Tentar inserir com o mesmo email deve falhar
        assertThrows(ExistingEntityConflictException.class, () -> {
            um.insertUser(userB9);
        });
    }

}