package test_Hypothesis;

import MakeItFit.users.*;
import MakeItFit.users.types.*;
import MakeItFit.users.UserManager;
import MakeItFit.activities.*;
import MakeItFit.activities.implementation.*;
import MakeItFit.utils.MakeItFitDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerGeneratedTest {

@Test
    public void testUserManager_0() {
        UserManager um = new UserManager();

        User u0 = um.createUser(
            "BPhY", 10, Gender.Male, 149.0f, 143,
            113, 7, "Rua MH", "989659791",
            "BPhYf1254f@mipn.pt", 0, "Amateur"
        );
        u0.setCode(UUID.fromString("cd0c054a-34ea-4fd4-9536-ad0a5ffe49ed"));
        assertNotNull(u0);

        User u0Copia = um.createUser(
            "BPhY", 10, Gender.Male, 149.0f, 143,
            113, 7, "Rua MH", "989659791",
            "BPhYf1254f@mipn.pt", 0, "Amateur"
        );
        u0Copia.setCode(UUID.fromString("cd0c054a-34ea-4fd4-9536-ad0a5ffe49ed"));

        um.insertUser(u0);
        assertTrue(um.existsUserWithEmail("BPhYf1254f@mipn.pt"));

        User porEmail = um.getUserByEmail("BPhYf1254f@mipn.pt");
        assertEquals("BPhY", porEmail.getName());

        um.updateUser(u0);
        assertFalse(um.getAllUsers().isEmpty());

        User porCodigo = um.getUserByCode(u0.getCode());
        assertEquals(u0.getEmail(), porCodigo.getEmail());

        // === Testar atividades ===
        Trail act0_0 = new Trail(UUID.fromString("cd0c054a-34ea-4fd4-9536-ad0a5ffe49ed"), MakeItFitDate.of(2010, 11, 20), 76, "QhivEHudx", "NIL", 1.9, 0.33, 0.0, -1);
        Trail act0_1 = new Trail(UUID.fromString("cd0c054a-34ea-4fd4-9536-ad0a5ffe49ed"), MakeItFitDate.of(2006, 12, 4), 156, "dGgXgJLDXi", "PLd", 0.5, 0.0, 0.0, 2);
        for (Activity act : List.of(act0_0, act0_1)) {
            um.addActivityToUser("bphyf1254f@mipn.pt", act);
        }
        assertEquals(2, um.getUserByEmail("bphyf1254f@mipn.pt").getListActivities().size());

        um.removeActivityFromUser("bphyf1254f@mipn.pt", act0_0.getCode());
        assertEquals(1, um.getUserByEmail("bphyf1254f@mipn.pt").getListActivities().size());

        // === Testar getActivitiesFromUser ===
        List<Activity> atividades = um.getActivitiesFromUser("bphyf1254f@mipn.pt");
        assertEquals(1, atividades.size());

        // === Testar addActivitiesToUser ===
        um.addActivitiesToUser(u0.getCode(), List.of(act0_0, act0_1));
        assertEquals(3, um.getUserByEmail("bphyf1254f@mipn.pt").getListActivities().size());
    
        
        

        assertDoesNotThrow(() -> um.updateSystem());

        // === Remoções ===
        um.removeUserByCode(u0.getCode());
        assertFalse(um.existsUserWithEmail(u0.getEmail()));

        um.insertUser(u0Copia);
        um.removeUserByEmail("BPhYf1254f@mipn.pt");
        assertFalse(um.existsUserWithEmail("BPhYf1254f@mipn.pt"));
    }
@Test
    public void testUserManager_1() {
        UserManager um = new UserManager();

        User u1 = um.createUser(
            "pmH", 81, Gender.Other, 31.0f, 178,
            163, 3, "Rua ZI", "998814244",
            "pmH86fef6@lahp.net", 6, "Professional"
        );
        u1.setCode(UUID.fromString("f395cc7b-8aca-469e-b96f-08371aa1ad2a"));
        assertNotNull(u1);

        User u1Copia = um.createUser(
            "pmH", 81, Gender.Other, 31.0f, 178,
            163, 3, "Rua ZI", "998814244",
            "pmH86fef6@lahp.net", 6, "Professional"
        );
        u1Copia.setCode(UUID.fromString("f395cc7b-8aca-469e-b96f-08371aa1ad2a"));

        um.insertUser(u1);
        assertTrue(um.existsUserWithEmail("pmH86fef6@lahp.net"));

        User porEmail = um.getUserByEmail("pmH86fef6@lahp.net");
        assertEquals("pmH", porEmail.getName());

        um.updateUser(u1);
        assertFalse(um.getAllUsers().isEmpty());

        User porCodigo = um.getUserByCode(u1.getCode());
        assertEquals(u1.getEmail(), porCodigo.getEmail());

        // === Testar atividades ===
        WeightSquat act1_0 = new WeightSquat(UUID.fromString("f395cc7b-8aca-469e-b96f-08371aa1ad2a"), MakeItFitDate.of(2012, 1, 24), 33, "oWV", "UsmxjbPaLP", 41, 2, 2.0);
        PushUp act1_1 = new PushUp(UUID.fromString("f395cc7b-8aca-469e-b96f-08371aa1ad2a"), MakeItFitDate.of(2008, 6, 2), 138, "vRo", "dtXoh", 29, 2);
        for (Activity act : List.of(act1_0, act1_1)) {
            um.addActivityToUser("pmh86fef6@lahp.net", act);
        }
        assertEquals(2, um.getUserByEmail("pmh86fef6@lahp.net").getListActivities().size());

        um.removeActivityFromUser("pmh86fef6@lahp.net", act1_0.getCode());
        assertEquals(1, um.getUserByEmail("pmh86fef6@lahp.net").getListActivities().size());

        // === Testar getActivitiesFromUser ===
        List<Activity> atividades = um.getActivitiesFromUser("pmh86fef6@lahp.net");
        assertEquals(1, atividades.size());

        // === Testar addActivitiesToUser ===
        um.addActivitiesToUser(u1.getCode(), List.of(act1_0, act1_1));
        assertEquals(3, um.getUserByEmail("pmh86fef6@lahp.net").getListActivities().size());
    
        
        

        assertDoesNotThrow(() -> um.updateSystem());

        // === Remoções ===
        um.removeUserByCode(u1.getCode());
        assertFalse(um.existsUserWithEmail(u1.getEmail()));

        um.insertUser(u1Copia);
        um.removeUserByEmail("pmH86fef6@lahp.net");
        assertFalse(um.existsUserWithEmail("pmH86fef6@lahp.net"));
    }
@Test
    public void testUserManager_2() {
        UserManager um = new UserManager();

        User u2 = um.createUser(
            "AA", 10, Gender.Male, 30.0f, 120,
            40, 0, "Rua A", "900000000",
            "AAa21958@aaa.com", 1, "Professional"
        );
        u2.setCode(UUID.fromString("37ba7b6d-62aa-4056-afb8-39d3df59a89f"));
        assertNotNull(u2);

        User u2Copia = um.createUser(
            "AA", 10, Gender.Male, 30.0f, 120,
            40, 0, "Rua A", "900000000",
            "AAa21958@aaa.com", 1, "Professional"
        );
        u2Copia.setCode(UUID.fromString("37ba7b6d-62aa-4056-afb8-39d3df59a89f"));

        um.insertUser(u2);
        assertTrue(um.existsUserWithEmail("AAa21958@aaa.com"));

        User porEmail = um.getUserByEmail("AAa21958@aaa.com");
        assertEquals("AA", porEmail.getName());

        um.updateUser(u2);
        assertFalse(um.getAllUsers().isEmpty());

        User porCodigo = um.getUserByCode(u2.getCode());
        assertEquals(u2.getEmail(), porCodigo.getEmail());

        // === Testar atividades ===
        WeightSquat act2_0 = new WeightSquat(UUID.fromString("37ba7b6d-62aa-4056-afb8-39d3df59a89f"), MakeItFitDate.of(2005, 10, 3), 56, "qLAs", "Szk", 39, 9, 2.0);
        Running act2_1 = new Running(UUID.fromString("37ba7b6d-62aa-4056-afb8-39d3df59a89f"), MakeItFitDate.of(2003, 9, 22), 128, "JmoRQBzjiG", "OPQFMHod", 28.9, 2.0);
        Trail act2_2 = new Trail(UUID.fromString("37ba7b6d-62aa-4056-afb8-39d3df59a89f"), MakeItFitDate.of(2002, 2, 11), 82, "kHx", "SDpGWxSNdb", 1.0, 0.0, 327.26, 0);
        Running act2_3 = new Running(UUID.fromString("37ba7b6d-62aa-4056-afb8-39d3df59a89f"), MakeItFitDate.of(2021, 5, 23), 118, "eoJ", "OTcE", 11.28, 4.93);
        Running act2_4 = new Running(UUID.fromString("37ba7b6d-62aa-4056-afb8-39d3df59a89f"), MakeItFitDate.of(2006, 1, 17), 25, "BcOG", "vzW", 50.0, 20.0);
        for (Activity act : List.of(act2_0, act2_1, act2_2, act2_3, act2_4)) {
            um.addActivityToUser("aaa21958@aaa.com", act);
        }
        assertEquals(5, um.getUserByEmail("aaa21958@aaa.com").getListActivities().size());

        um.removeActivityFromUser("aaa21958@aaa.com", act2_0.getCode());
        assertEquals(4, um.getUserByEmail("aaa21958@aaa.com").getListActivities().size());

        // === Testar getActivitiesFromUser ===
        List<Activity> atividades = um.getActivitiesFromUser("aaa21958@aaa.com");
        assertEquals(4, atividades.size());

        // === Testar addActivitiesToUser ===
        um.addActivitiesToUser(u2.getCode(), List.of(act2_0, act2_1, act2_2, act2_3, act2_4));
        assertEquals(9, um.getUserByEmail("aaa21958@aaa.com").getListActivities().size());
    
        
        

        assertDoesNotThrow(() -> um.updateSystem());

        // === Remoções ===
        um.removeUserByCode(u2.getCode());
        assertFalse(um.existsUserWithEmail(u2.getEmail()));

        um.insertUser(u2Copia);
        um.removeUserByEmail("AAa21958@aaa.com");
        assertFalse(um.existsUserWithEmail("AAa21958@aaa.com"));
    }
@Test
    public void testUserManager_3() {
        UserManager um = new UserManager();

        User u3 = um.createUser(
            "uXJt", 24, Gender.Male, 149.0f, 154,
            164, 3, "Rua A", "927964372",
            "uXJtd63249@wry.org", 6, "Professional"
        );
        u3.setCode(UUID.fromString("70d775a8-2201-40d9-adb1-cea43e107e3d"));
        assertNotNull(u3);

        User u3Copia = um.createUser(
            "uXJt", 24, Gender.Male, 149.0f, 154,
            164, 3, "Rua A", "927964372",
            "uXJtd63249@wry.org", 6, "Professional"
        );
        u3Copia.setCode(UUID.fromString("70d775a8-2201-40d9-adb1-cea43e107e3d"));

        um.insertUser(u3);
        assertTrue(um.existsUserWithEmail("uXJtd63249@wry.org"));

        User porEmail = um.getUserByEmail("uXJtd63249@wry.org");
        assertEquals("uXJt", porEmail.getName());

        um.updateUser(u3);
        assertFalse(um.getAllUsers().isEmpty());

        User porCodigo = um.getUserByCode(u3.getCode());
        assertEquals(u3.getEmail(), porCodigo.getEmail());

        // === Testar atividades ===
        Running act3_0 = new Running(UUID.fromString("70d775a8-2201-40d9-adb1-cea43e107e3d"), MakeItFitDate.of(2020, 9, 12), 94, "sdZfjV", "ELL", 6.6, 1.0);
        PushUp act3_1 = new PushUp(UUID.fromString("70d775a8-2201-40d9-adb1-cea43e107e3d"), MakeItFitDate.of(2025, 6, 22), 39, "UaNQs", "zgwdNcqk", 34, 10);
        for (Activity act : List.of(act3_0, act3_1)) {
            um.addActivityToUser("uxjtd63249@wry.org", act);
        }
        assertEquals(2, um.getUserByEmail("uxjtd63249@wry.org").getListActivities().size());

        um.removeActivityFromUser("uxjtd63249@wry.org", act3_0.getCode());
        assertEquals(1, um.getUserByEmail("uxjtd63249@wry.org").getListActivities().size());

        // === Testar getActivitiesFromUser ===
        List<Activity> atividades = um.getActivitiesFromUser("uxjtd63249@wry.org");
        assertEquals(1, atividades.size());

        // === Testar addActivitiesToUser ===
        um.addActivitiesToUser(u3.getCode(), List.of(act3_0, act3_1));
        assertEquals(3, um.getUserByEmail("uxjtd63249@wry.org").getListActivities().size());
    
        
        

        assertDoesNotThrow(() -> um.updateSystem());

        // === Remoções ===
        um.removeUserByCode(u3.getCode());
        assertFalse(um.existsUserWithEmail(u3.getEmail()));

        um.insertUser(u3Copia);
        um.removeUserByEmail("uXJtd63249@wry.org");
        assertFalse(um.existsUserWithEmail("uXJtd63249@wry.org"));
    }
@Test
    public void testUserManager_4() {
        UserManager um = new UserManager();

        User u4 = um.createUser(
            "YeMDBwDUWWo", 15, Gender.Female, 150.0f, 220,
            175, 3, "Rua XR", "997785080",
            "YeMDBwDUWWoa9b94c@then.net", 2, "Professional"
        );
        u4.setCode(UUID.fromString("0dd5dcdb-9ac9-49a2-8629-8385fbe0f510"));
        assertNotNull(u4);

        User u4Copia = um.createUser(
            "YeMDBwDUWWo", 15, Gender.Female, 150.0f, 220,
            175, 3, "Rua XR", "997785080",
            "YeMDBwDUWWoa9b94c@then.net", 2, "Professional"
        );
        u4Copia.setCode(UUID.fromString("0dd5dcdb-9ac9-49a2-8629-8385fbe0f510"));

        um.insertUser(u4);
        assertTrue(um.existsUserWithEmail("YeMDBwDUWWoa9b94c@then.net"));

        User porEmail = um.getUserByEmail("YeMDBwDUWWoa9b94c@then.net");
        assertEquals("YeMDBwDUWWo", porEmail.getName());

        um.updateUser(u4);
        assertFalse(um.getAllUsers().isEmpty());

        User porCodigo = um.getUserByCode(u4.getCode());
        assertEquals(u4.getEmail(), porCodigo.getEmail());

        // === Testar atividades ===
        Trail act4_0 = new Trail(UUID.fromString("0dd5dcdb-9ac9-49a2-8629-8385fbe0f510"), MakeItFitDate.of(2003, 1, 3), 70, "NULL", "xdR", 1.0, 0.0, 1500.0, -8);
        WeightSquat act4_1 = new WeightSquat(UUID.fromString("0dd5dcdb-9ac9-49a2-8629-8385fbe0f510"), MakeItFitDate.of(2022, 7, 26), 11, "aku", "Inf", 14, 10, 2.0);
        for (Activity act : List.of(act4_0, act4_1)) {
            um.addActivityToUser("yemdbwduwwoa9b94c@then.net", act);
        }
        assertEquals(2, um.getUserByEmail("yemdbwduwwoa9b94c@then.net").getListActivities().size());

        um.removeActivityFromUser("yemdbwduwwoa9b94c@then.net", act4_0.getCode());
        assertEquals(1, um.getUserByEmail("yemdbwduwwoa9b94c@then.net").getListActivities().size());

        // === Testar getActivitiesFromUser ===
        List<Activity> atividades = um.getActivitiesFromUser("yemdbwduwwoa9b94c@then.net");
        assertEquals(1, atividades.size());

        // === Testar addActivitiesToUser ===
        um.addActivitiesToUser(u4.getCode(), List.of(act4_0, act4_1));
        assertEquals(3, um.getUserByEmail("yemdbwduwwoa9b94c@then.net").getListActivities().size());
    
        
        

        assertDoesNotThrow(() -> um.updateSystem());

        // === Remoções ===
        um.removeUserByCode(u4.getCode());
        assertFalse(um.existsUserWithEmail(u4.getEmail()));

        um.insertUser(u4Copia);
        um.removeUserByEmail("YeMDBwDUWWoa9b94c@then.net");
        assertFalse(um.existsUserWithEmail("YeMDBwDUWWoa9b94c@then.net"));
    }
@Test
    public void testUserManager_5() {
        UserManager um = new UserManager();

        User u5 = um.createUser(
            "GPH", 30, Gender.Other, 30.0f, 183,
            69, 8, "Rua S", "913141738",
            "GPHdcc43d@geh.net", 6, "Occasional"
        );
        u5.setCode(UUID.fromString("5c56f973-5aac-4cd4-9665-e6b90ac8f2c6"));
        assertNotNull(u5);

        User u5Copia = um.createUser(
            "GPH", 30, Gender.Other, 30.0f, 183,
            69, 8, "Rua S", "913141738",
            "GPHdcc43d@geh.net", 6, "Occasional"
        );
        u5Copia.setCode(UUID.fromString("5c56f973-5aac-4cd4-9665-e6b90ac8f2c6"));

        um.insertUser(u5);
        assertTrue(um.existsUserWithEmail("GPHdcc43d@geh.net"));

        User porEmail = um.getUserByEmail("GPHdcc43d@geh.net");
        assertEquals("GPH", porEmail.getName());

        um.updateUser(u5);
        assertFalse(um.getAllUsers().isEmpty());

        User porCodigo = um.getUserByCode(u5.getCode());
        assertEquals(u5.getEmail(), porCodigo.getEmail());

        // === Testar atividades ===
        Running act5_0 = new Running(UUID.fromString("5c56f973-5aac-4cd4-9665-e6b90ac8f2c6"), MakeItFitDate.of(2000, 1, 1), 10, "AAA", "AAA", 0.5, 1.0);
        Running act5_1 = new Running(UUID.fromString("5c56f973-5aac-4cd4-9665-e6b90ac8f2c6"), MakeItFitDate.of(2000, 1, 1), 10, "AAA", "AAA", 0.5, 1.0);
        Running act5_2 = new Running(UUID.fromString("5c56f973-5aac-4cd4-9665-e6b90ac8f2c6"), MakeItFitDate.of(2000, 1, 1), 10, "AAA", "AAA", 0.5, 1.0);
        for (Activity act : List.of(act5_0, act5_1, act5_2)) {
            um.addActivityToUser("gphdcc43d@geh.net", act);
        }
        assertEquals(3, um.getUserByEmail("gphdcc43d@geh.net").getListActivities().size());

        um.removeActivityFromUser("gphdcc43d@geh.net", act5_0.getCode());
        assertEquals(2, um.getUserByEmail("gphdcc43d@geh.net").getListActivities().size());

        // === Testar getActivitiesFromUser ===
        List<Activity> atividades = um.getActivitiesFromUser("gphdcc43d@geh.net");
        assertEquals(2, atividades.size());

        // === Testar addActivitiesToUser ===
        um.addActivitiesToUser(u5.getCode(), List.of(act5_0, act5_1, act5_2));
        assertEquals(5, um.getUserByEmail("gphdcc43d@geh.net").getListActivities().size());
    
        
        

        assertDoesNotThrow(() -> um.updateSystem());

        // === Remoções ===
        um.removeUserByCode(u5.getCode());
        assertFalse(um.existsUserWithEmail(u5.getEmail()));

        um.insertUser(u5Copia);
        um.removeUserByEmail("GPHdcc43d@geh.net");
        assertFalse(um.existsUserWithEmail("GPHdcc43d@geh.net"));
    }
@Test
    public void testUserManager_6() {
        UserManager um = new UserManager();

        User u6 = um.createUser(
            "oSw", 31, Gender.Female, 150.0f, 168,
            120, 0, "Rua KVR", "989244558",
            "oSw497492@nqof.net", 0, "Amateur"
        );
        u6.setCode(UUID.fromString("1a566d84-ae0c-4987-8500-bea1b70a5760"));
        assertNotNull(u6);

        User u6Copia = um.createUser(
            "oSw", 31, Gender.Female, 150.0f, 168,
            120, 0, "Rua KVR", "989244558",
            "oSw497492@nqof.net", 0, "Amateur"
        );
        u6Copia.setCode(UUID.fromString("1a566d84-ae0c-4987-8500-bea1b70a5760"));

        um.insertUser(u6);
        assertTrue(um.existsUserWithEmail("oSw497492@nqof.net"));

        User porEmail = um.getUserByEmail("oSw497492@nqof.net");
        assertEquals("oSw", porEmail.getName());

        um.updateUser(u6);
        assertFalse(um.getAllUsers().isEmpty());

        User porCodigo = um.getUserByCode(u6.getCode());
        assertEquals(u6.getEmail(), porCodigo.getEmail());

        // === Testar atividades ===
        Running act6_0 = new Running(UUID.fromString("1a566d84-ae0c-4987-8500-bea1b70a5760"), MakeItFitDate.of(2009, 2, 3), 39, "XCqFZBLTnk", "VBqmkCx", 46.84, 1.5);
        WeightSquat act6_1 = new WeightSquat(UUID.fromString("1a566d84-ae0c-4987-8500-bea1b70a5760"), MakeItFitDate.of(2020, 11, 20), 157, "hxL", "WWgCNygqUe", 32, 3, 44.89);
        Running act6_2 = new Running(UUID.fromString("1a566d84-ae0c-4987-8500-bea1b70a5760"), MakeItFitDate.of(2012, 6, 18), 51, "xkqGhhUY", "sBmD", 31.07, 1.0);
        for (Activity act : List.of(act6_0, act6_1, act6_2)) {
            um.addActivityToUser("osw497492@nqof.net", act);
        }
        assertEquals(3, um.getUserByEmail("osw497492@nqof.net").getListActivities().size());

        um.removeActivityFromUser("osw497492@nqof.net", act6_0.getCode());
        assertEquals(2, um.getUserByEmail("osw497492@nqof.net").getListActivities().size());

        // === Testar getActivitiesFromUser ===
        List<Activity> atividades = um.getActivitiesFromUser("osw497492@nqof.net");
        assertEquals(2, atividades.size());

        // === Testar addActivitiesToUser ===
        um.addActivitiesToUser(u6.getCode(), List.of(act6_0, act6_1, act6_2));
        assertEquals(5, um.getUserByEmail("osw497492@nqof.net").getListActivities().size());
    
        
        

        assertDoesNotThrow(() -> um.updateSystem());

        // === Remoções ===
        um.removeUserByCode(u6.getCode());
        assertFalse(um.existsUserWithEmail(u6.getEmail()));

        um.insertUser(u6Copia);
        um.removeUserByEmail("oSw497492@nqof.net");
        assertFalse(um.existsUserWithEmail("oSw497492@nqof.net"));
    }
@Test
    public void testUserManager_7() {
        UserManager um = new UserManager();

        User u7 = um.createUser(
            "yziICGy", 63, Gender.Male, 44.14f, 162,
            46, 9, "Rua CHM", "992207920",
            "yziICGy59a15c@vftx.com", 0, "Amateur"
        );
        u7.setCode(UUID.fromString("0ae83c06-594c-4950-93cb-383cde4c546d"));
        assertNotNull(u7);

        User u7Copia = um.createUser(
            "yziICGy", 63, Gender.Male, 44.14f, 162,
            46, 9, "Rua CHM", "992207920",
            "yziICGy59a15c@vftx.com", 0, "Amateur"
        );
        u7Copia.setCode(UUID.fromString("0ae83c06-594c-4950-93cb-383cde4c546d"));

        um.insertUser(u7);
        assertTrue(um.existsUserWithEmail("yziICGy59a15c@vftx.com"));

        User porEmail = um.getUserByEmail("yziICGy59a15c@vftx.com");
        assertEquals("yziICGy", porEmail.getName());

        um.updateUser(u7);
        assertFalse(um.getAllUsers().isEmpty());

        User porCodigo = um.getUserByCode(u7.getCode());
        assertEquals(u7.getEmail(), porCodigo.getEmail());

        // === Testar atividades ===
        PushUp act7_0 = new PushUp(UUID.fromString("0ae83c06-594c-4950-93cb-383cde4c546d"), MakeItFitDate.of(2019, 12, 6), 126, "JaZ", "OTdx", 7, 3);
        Trail act7_1 = new Trail(UUID.fromString("0ae83c06-594c-4950-93cb-383cde4c546d"), MakeItFitDate.of(2019, 9, 13), 83, "sHxu", "hOY", 1.5, 1.0, 0.0, 3);
        Running act7_2 = new Running(UUID.fromString("0ae83c06-594c-4950-93cb-383cde4c546d"), MakeItFitDate.of(2005, 12, 2), 73, "yPKi", "MgBQLwZjuz", 50.0, 1.1);
        for (Activity act : List.of(act7_0, act7_1, act7_2)) {
            um.addActivityToUser("yziicgy59a15c@vftx.com", act);
        }
        assertEquals(3, um.getUserByEmail("yziicgy59a15c@vftx.com").getListActivities().size());

        um.removeActivityFromUser("yziicgy59a15c@vftx.com", act7_0.getCode());
        assertEquals(2, um.getUserByEmail("yziicgy59a15c@vftx.com").getListActivities().size());

        // === Testar getActivitiesFromUser ===
        List<Activity> atividades = um.getActivitiesFromUser("yziicgy59a15c@vftx.com");
        assertEquals(2, atividades.size());

        // === Testar addActivitiesToUser ===
        um.addActivitiesToUser(u7.getCode(), List.of(act7_0, act7_1, act7_2));
        assertEquals(5, um.getUserByEmail("yziicgy59a15c@vftx.com").getListActivities().size());
    
        
        

        assertDoesNotThrow(() -> um.updateSystem());

        // === Remoções ===
        um.removeUserByCode(u7.getCode());
        assertFalse(um.existsUserWithEmail(u7.getEmail()));

        um.insertUser(u7Copia);
        um.removeUserByEmail("yziICGy59a15c@vftx.com");
        assertFalse(um.existsUserWithEmail("yziICGy59a15c@vftx.com"));
    }
@Test
    public void testUserManager_8() {
        UserManager um = new UserManager();

        User u8 = um.createUser(
            "AA", 10, Gender.Male, 30.0f, 120,
            40, 0, "Rua A", "900000000",
            "AAa919e7@aaa.com", 1, "Professional"
        );
        u8.setCode(UUID.fromString("4ddf601e-78f1-4908-a981-28933c8dcb64"));
        assertNotNull(u8);

        User u8Copia = um.createUser(
            "AA", 10, Gender.Male, 30.0f, 120,
            40, 0, "Rua A", "900000000",
            "AAa919e7@aaa.com", 1, "Professional"
        );
        u8Copia.setCode(UUID.fromString("4ddf601e-78f1-4908-a981-28933c8dcb64"));

        um.insertUser(u8);
        assertTrue(um.existsUserWithEmail("AAa919e7@aaa.com"));

        User porEmail = um.getUserByEmail("AAa919e7@aaa.com");
        assertEquals("AA", porEmail.getName());

        um.updateUser(u8);
        assertFalse(um.getAllUsers().isEmpty());

        User porCodigo = um.getUserByCode(u8.getCode());
        assertEquals(u8.getEmail(), porCodigo.getEmail());

        // === Testar atividades ===
        Running act8_0 = new Running(UUID.fromString("4ddf601e-78f1-4908-a981-28933c8dcb64"), MakeItFitDate.of(2000, 1, 1), 10, "AAA", "AAA", 0.5, 1.0);
        Running act8_1 = new Running(UUID.fromString("4ddf601e-78f1-4908-a981-28933c8dcb64"), MakeItFitDate.of(2000, 1, 1), 10, "AAA", "AAA", 0.5, 1.0);
        for (Activity act : List.of(act8_0, act8_1)) {
            um.addActivityToUser("aaa919e7@aaa.com", act);
        }
        assertEquals(2, um.getUserByEmail("aaa919e7@aaa.com").getListActivities().size());

        um.removeActivityFromUser("aaa919e7@aaa.com", act8_0.getCode());
        assertEquals(1, um.getUserByEmail("aaa919e7@aaa.com").getListActivities().size());

        // === Testar getActivitiesFromUser ===
        List<Activity> atividades = um.getActivitiesFromUser("aaa919e7@aaa.com");
        assertEquals(1, atividades.size());

        // === Testar addActivitiesToUser ===
        um.addActivitiesToUser(u8.getCode(), List.of(act8_0, act8_1));
        assertEquals(3, um.getUserByEmail("aaa919e7@aaa.com").getListActivities().size());
    
        
        

        assertDoesNotThrow(() -> um.updateSystem());

        // === Remoções ===
        um.removeUserByCode(u8.getCode());
        assertFalse(um.existsUserWithEmail(u8.getEmail()));

        um.insertUser(u8Copia);
        um.removeUserByEmail("AAa919e7@aaa.com");
        assertFalse(um.existsUserWithEmail("AAa919e7@aaa.com"));
    }
@Test
    public void testUserManager_9() {
        UserManager um = new UserManager();

        User u9 = um.createUser(
            "TmOdNxdvBnBD", 53, Gender.Male, 150.0f, 204,
            114, 10, "Rua WLC", "928183563",
            "TmOdNxdvBnBD2936d1@rmhkr.pt", 12, "Occasional"
        );
        u9.setCode(UUID.fromString("46d6cd64-03d2-4205-b1b2-d920a81a5faa"));
        assertNotNull(u9);

        User u9Copia = um.createUser(
            "TmOdNxdvBnBD", 53, Gender.Male, 150.0f, 204,
            114, 10, "Rua WLC", "928183563",
            "TmOdNxdvBnBD2936d1@rmhkr.pt", 12, "Occasional"
        );
        u9Copia.setCode(UUID.fromString("46d6cd64-03d2-4205-b1b2-d920a81a5faa"));

        um.insertUser(u9);
        assertTrue(um.existsUserWithEmail("TmOdNxdvBnBD2936d1@rmhkr.pt"));

        User porEmail = um.getUserByEmail("TmOdNxdvBnBD2936d1@rmhkr.pt");
        assertEquals("TmOdNxdvBnBD", porEmail.getName());

        um.updateUser(u9);
        assertFalse(um.getAllUsers().isEmpty());

        User porCodigo = um.getUserByCode(u9.getCode());
        assertEquals(u9.getEmail(), porCodigo.getEmail());

        // === Testar atividades ===
        PushUp act9_0 = new PushUp(UUID.fromString("46d6cd64-03d2-4205-b1b2-d920a81a5faa"), MakeItFitDate.of(2010, 5, 17), 88, "False", "JwgxHSnhiB", 4, 5);
        WeightSquat act9_1 = new WeightSquat(UUID.fromString("46d6cd64-03d2-4205-b1b2-d920a81a5faa"), MakeItFitDate.of(2024, 4, 23), 153, "BvjMkEoejP", "xrVtDjtlhg", 27, 4, 1.9);
        Trail act9_2 = new Trail(UUID.fromString("46d6cd64-03d2-4205-b1b2-d920a81a5faa"), MakeItFitDate.of(2006, 2, 17), 91, "ywnDXnIUuC", "ENBuv", 1.5, 694.64, 1.5, 7);
        for (Activity act : List.of(act9_0, act9_1, act9_2)) {
            um.addActivityToUser("tmodnxdvbnbd2936d1@rmhkr.pt", act);
        }
        assertEquals(3, um.getUserByEmail("tmodnxdvbnbd2936d1@rmhkr.pt").getListActivities().size());

        um.removeActivityFromUser("tmodnxdvbnbd2936d1@rmhkr.pt", act9_0.getCode());
        assertEquals(2, um.getUserByEmail("tmodnxdvbnbd2936d1@rmhkr.pt").getListActivities().size());

        // === Testar getActivitiesFromUser ===
        List<Activity> atividades = um.getActivitiesFromUser("tmodnxdvbnbd2936d1@rmhkr.pt");
        assertEquals(2, atividades.size());

        // === Testar addActivitiesToUser ===
        um.addActivitiesToUser(u9.getCode(), List.of(act9_0, act9_1, act9_2));
        assertEquals(5, um.getUserByEmail("tmodnxdvbnbd2936d1@rmhkr.pt").getListActivities().size());
    
        
        

        assertDoesNotThrow(() -> um.updateSystem());

        // === Remoções ===
        um.removeUserByCode(u9.getCode());
        assertFalse(um.existsUserWithEmail(u9.getEmail()));

        um.insertUser(u9Copia);
        um.removeUserByEmail("TmOdNxdvBnBD2936d1@rmhkr.pt");
        assertFalse(um.existsUserWithEmail("TmOdNxdvBnBD2936d1@rmhkr.pt"));
    }

}