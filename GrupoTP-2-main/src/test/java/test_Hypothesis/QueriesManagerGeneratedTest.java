package test_Hypothesis;

import MakeItFit.queries.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.UUID;
import MakeItFit.users.types.*;
import MakeItFit.users.UserManager;
import MakeItFit.activities.Activity;
import MakeItFit.users.*;
import MakeItFit.activities.implementation.*;
import MakeItFit.trainingPlan.*;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueriesManagerGeneratedTest {

@Test
    public void testQueriesManager_0() {
        UserManager um = new UserManager();
        TrainingPlanManager tpm = new TrainingPlanManager();
        QueriesManager qm = new QueriesManager(um, tpm);

        MakeItFitDate data1 = MakeItFitDate.of(2000, 8, 12);
        MakeItFitDate data2 = MakeItFitDate.of(2009, 10, 27);

        // Criar utilizadores
        
            User user0 = new Professional("nx", 61, Gender.Other, 149.0f, 191, 81,
                                       0, "Rua M", "992535166", "nxe3c836@dkc.pt", 13);
            user0.setCode(UUID.fromString("51d7b4d3-0726-4444-8a2a-944c8203da10"));
            um.insertUser(user0);
            
            User user1 = new Professional("xTceCYFd", 99, Gender.Male, 30.0f, 154, 152,
                                       7, "Rua VX", "973983599", "xTceCYFdc05ba7@jelbyt.pt", 10);
            user1.setCode(UUID.fromString("b1486da1-8a2b-49b9-a8a9-0bc60b809cc8"));
            um.insertUser(user1);
            
            User user2 = new Occasional("Hl", 62, Gender.Other, 31.0f, 180, 71,
                                       5, "Rua AXE", "907169915", "Hl6d78be@ksodei.pt", 13);
            user2.setCode(UUID.fromString("50b05803-a19e-43a5-94ac-bc6f1943d76b"));
            um.insertUser(user2);
            

        // Criar atividades
        
            Trail act_0 = new Trail(user0.getCode(), MakeItFitDate.of(2012, 3, 6), 99, "RwzdCgkuis", "faGSseOcPf", 1.5, 1499.0, 0.0, 9);
            user0.addActivity(act_0);
        
            PushUp act_1 = new PushUp(user1.getCode(), MakeItFitDate.of(2013, 11, 8), 78, "IPJU", "LOtOBLG", 25, 4);
            user1.addActivity(act_1);
        
            PushUp act_2 = new PushUp(user0.getCode(), MakeItFitDate.of(2021, 4, 2), 66, "DZtq", "pSAmv", 45, 9);
            user0.addActivity(act_2);
        
            WeightSquat act_3 = new WeightSquat(user1.getCode(), MakeItFitDate.of(2012, 10, 26), 36, "IbSG", "acvH", 19, 10, 1.9);
            user1.addActivity(act_3);
        
            WeightSquat act_4 = new WeightSquat(user2.getCode(), MakeItFitDate.of(2013, 2, 1), 161, "brJt", "BhgwguR", 27, 10, 1.0);
            user2.addActivity(act_4);
        

        // Inserir planos
        
            TrainingPlan tp_0 = new TrainingPlan(user0.getCode(), MakeItFitDate.of(2012, 10, 6));
            tpm.insertTrainingPlan(tp_0);
        
                tp_0.addActivity(9, act_0);
            
            TrainingPlan tp_1 = new TrainingPlan(user1.getCode(), MakeItFitDate.of(2025, 2, 28));
            tpm.insertTrainingPlan(tp_1);
        
                tp_1.addActivity(6, act_1);
            
            TrainingPlan tp_2 = new TrainingPlan(user2.getCode(), MakeItFitDate.of(2001, 1, 13));
            tpm.insertTrainingPlan(tp_2);
        
                tp_2.addActivity(2, act_4);
            

        // Queries:
        

        double expectedAltimetry = 1499.0;
        double resultAltimetry = qm.executeQueryHowManyAltimetryDone(um, "nxe3c836@dkc.pt");
        assertEquals(expectedAltimetry, resultAltimetry, 0.001);

        double expectedAltimetryWithDates = 0;
        double resultAltimetryWithDates = qm.executeQueryHowManyAltimetryDone(um, "nxe3c836@dkc.pt", data1, data2);
        assertEquals(expectedAltimetryWithDates, resultAltimetryWithDates, 0.001);
     // nao testavam se estava dentro das datas e altimetria sem datas tinha sinal trocado
        

        double expectedKMs = 0.0015;
        double resultKMs = qm.executeQueryHowManyKMsDone(um, "nxe3c836@dkc.pt");
        assertEquals(expectedKMs, resultKMs, 0.001);

        double expectedKMsWithDates = 0.0;
        double resultKMsWithDates = qm.executeQueryHowManyKMsDone(um, "nxe3c836@dkc.pt", data1, data2);
        assertEquals(expectedKMsWithDates, resultKMsWithDates, 0.001);
    
        
        TrainingPlan resultDemanding = qm.executeQueryMostDemandingTrainingPlan(tpm, um);
        if (resultDemanding != null) {
            assertEquals(UUID.fromString("b1486da1-8a2b-49b9-a8a9-0bc60b809cc8"), resultDemanding.getUserCode());
        }
    
        
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        String resultMoreDone = qm.executeQueryMostDoneActivity(um);
        assertEquals("RepetitionsWithWeights", resultMoreDone);
     // as repeticoes e repeticoes com peso estavam trocadas no java
        
        User resultado = qm.executeQuerywhoBurnsMoreCalories(um, data1, data2);
        if (resultado != null) {
            Set<String> expected = new HashSet<>(Arrays.asList("nxe3c836@dkc.pt", "xTceCYFdc05ba7@jelbyt.pt", "Hl6d78be@ksodei.pt"));
            assertTrue(expected.contains(resultado.getEmail()), "Utilizador vencedor não está no empate: " + resultado.getEmail());
        }
        
        

        User result = qm.executeQueryWhoDidTheMostActivities(um, data1, data2);
        if (result != null) {
            Set<String> expected = new HashSet<>(Arrays.asList("nxe3c836@dkc.pt", "xTceCYFdc05ba7@jelbyt.pt", "Hl6d78be@ksodei.pt"));
            assertTrue(expected.contains(result.getEmail()), "Utilizador vencedor não está no empate: " + result.getEmail());
        }
        
        
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "nxe3c836@dkc.pt"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "nxe3c836@dkc.pt", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "nxe3c836@dkc.pt"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "nxe3c836@dkc.pt", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryMostDemandingTrainingPlan(tpm, um));
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um, data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um, data1, data2));
    
    }
@Test
    public void testQueriesManager_1() {
        UserManager um = new UserManager();
        TrainingPlanManager tpm = new TrainingPlanManager();
        QueriesManager qm = new QueriesManager(um, tpm);

        MakeItFitDate data1 = MakeItFitDate.of(2002, 12, 24);
        MakeItFitDate data2 = MakeItFitDate.of(2019, 5, 5);

        // Criar utilizadores
        
            User user0 = new Professional("gVoQmMsSsoR", 52, Gender.Female, 30.0f, 204, 125,
                                       4, "Rua K", "911837337", "gVoQmMsSsoR3c8d0f@oie.com", 7);
            user0.setCode(UUID.fromString("6ab84b76-024f-47a7-88c3-9a9eed930a17"));
            um.insertUser(user0);
            
            User user1 = new Professional("BVFfxzJbHTwh", 79, Gender.Male, 150.0f, 184, 91,
                                       2, "Rua AEU", "943105667", "BVFfxzJbHTwhf0fd5a@yxwb.org", 9);
            user1.setCode(UUID.fromString("ac90f93a-5514-466b-9503-a26f1d57ac83"));
            um.insertUser(user1);
            
            User user2 = new Occasional("qQeC", 23, Gender.Female, 30.0f, 129, 45,
                                       4, "Rua QQV", "908365047", "qQeCb73996@wrpyc.org", 11);
            user2.setCode(UUID.fromString("1460b0ef-42ca-4c83-89a1-5322a360e726"));
            um.insertUser(user2);
            

        // Criar atividades
        
            Running act_0 = new Running(user1.getCode(), MakeItFitDate.of(2003, 7, 20), 151, "VvXMdf", "none", 1.5, 20.0);
            user1.addActivity(act_0);
        
            PushUp act_1 = new PushUp(user1.getCode(), MakeItFitDate.of(2003, 2, 12), 158, "UFNVYw", "xUXsJCDZnM", 44, 7);
            user1.addActivity(act_1);
        
            Trail act_2 = new Trail(user0.getCode(), MakeItFitDate.of(2012, 8, 23), 27, "True", "wauC", 0.5, 1.0, 1.0, 5);
            user0.addActivity(act_2);
        
            PushUp act_3 = new PushUp(user1.getCode(), MakeItFitDate.of(2020, 4, 1), 15, "kxkambGCuS", "GBjL", 19, 2);
            user1.addActivity(act_3);
        
            WeightSquat act_4 = new WeightSquat(user2.getCode(), MakeItFitDate.of(2016, 3, 17), 83, "Infinity", "PqmIz", 15, 5, 1.1);
            user2.addActivity(act_4);
        

        // Inserir planos
        
            TrainingPlan tp_0 = new TrainingPlan(user0.getCode(), MakeItFitDate.of(2012, 7, 1));
            tpm.insertTrainingPlan(tp_0);
        
                tp_0.addActivity(7, act_2);
            
            TrainingPlan tp_1 = new TrainingPlan(user1.getCode(), MakeItFitDate.of(2015, 6, 24));
            tpm.insertTrainingPlan(tp_1);
        
                tp_1.addActivity(4, act_3);
            
                tp_1.addActivity(5, act_1);
            
                tp_1.addActivity(3, act_0);
            
            TrainingPlan tp_2 = new TrainingPlan(user2.getCode(), MakeItFitDate.of(2024, 2, 10));
            tpm.insertTrainingPlan(tp_2);
        
                tp_2.addActivity(1, act_4);
            

        // Queries:
        

        double expectedAltimetry = 2.0;
        double resultAltimetry = qm.executeQueryHowManyAltimetryDone(um, "gVoQmMsSsoR3c8d0f@oie.com");
        assertEquals(expectedAltimetry, resultAltimetry, 0.001);

        double expectedAltimetryWithDates = 2.0;
        double resultAltimetryWithDates = qm.executeQueryHowManyAltimetryDone(um, "gVoQmMsSsoR3c8d0f@oie.com", data1, data2);
        assertEquals(expectedAltimetryWithDates, resultAltimetryWithDates, 0.001);
     // nao testavam se estava dentro das datas e altimetria sem datas tinha sinal trocado
        

        double expectedKMs = 0.0005;
        double resultKMs = qm.executeQueryHowManyKMsDone(um, "gVoQmMsSsoR3c8d0f@oie.com");
        assertEquals(expectedKMs, resultKMs, 0.001);

        double expectedKMsWithDates = 0.0005;
        double resultKMsWithDates = qm.executeQueryHowManyKMsDone(um, "gVoQmMsSsoR3c8d0f@oie.com", data1, data2);
        assertEquals(expectedKMsWithDates, resultKMsWithDates, 0.001);
    
        
        TrainingPlan resultDemanding = qm.executeQueryMostDemandingTrainingPlan(tpm, um);
        if (resultDemanding != null) {
            assertEquals(UUID.fromString("ac90f93a-5514-466b-9503-a26f1d57ac83"), resultDemanding.getUserCode());
        }
    
        
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        String resultMoreDone = qm.executeQueryMostDoneActivity(um);
        assertEquals("Repetitions", resultMoreDone);
     // as repeticoes e repeticoes com peso estavam trocadas no java
        

        User r = qm.executeQuerywhoBurnsMoreCalories(um, data1, data2);
        if (r != null) {
            assertEquals("BVFfxzJbHTwhf0fd5a@yxwb.org", r.getEmail());
        }
        
        

        User result = qm.executeQueryWhoDidTheMostActivities(um, data1, data2);
        if (result != null) {
            assertEquals("BVFfxzJbHTwhf0fd5a@yxwb.org", result.getEmail());
        }
        
        
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "gVoQmMsSsoR3c8d0f@oie.com"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "gVoQmMsSsoR3c8d0f@oie.com", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "gVoQmMsSsoR3c8d0f@oie.com"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "gVoQmMsSsoR3c8d0f@oie.com", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryMostDemandingTrainingPlan(tpm, um));
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um, data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um, data1, data2));
    
    }
@Test
    public void testQueriesManager_2() {
        UserManager um = new UserManager();
        TrainingPlanManager tpm = new TrainingPlanManager();
        QueriesManager qm = new QueriesManager(um, tpm);

        MakeItFitDate data1 = MakeItFitDate.of(2011, 6, 5);
        MakeItFitDate data2 = MakeItFitDate.of(2025, 4, 28);

        // Criar utilizadores
        
            User user0 = new Occasional("zqYMp", 51, Gender.Female, 30.0f, 121, 152,
                                       9, "Rua YYX", "952896809", "zqYMpf4259e@wrbv.net", 8);
            user0.setCode(UUID.fromString("dcc1f143-9078-4b7a-acff-bfbe0c045714"));
            um.insertUser(user0);
            
            User user1 = new Amateur("MbaONtHnBt", 43, Gender.Other, 30.0f, 153, 41,
                                       4, "Rua GL", "968539837", "MbaONtHnBt9e6cb2@xgfegs.net");
            user1.setCode(UUID.fromString("c7d7901a-b23a-413b-b455-0534d82ed193"));
            um.insertUser(user1);
            

        // Criar atividades
        
            Running act_0 = new Running(user1.getCode(), MakeItFitDate.of(2008, 5, 20), 53, "uvSwuh", "wttBflze", 1.0, 20.0);
            user1.addActivity(act_0);
        
            WeightSquat act_1 = new WeightSquat(user1.getCode(), MakeItFitDate.of(2020, 12, 10), 137, "zZee", "ial", 35, 7, 97.21);
            user1.addActivity(act_1);
        
            WeightSquat act_2 = new WeightSquat(user0.getCode(), MakeItFitDate.of(2013, 7, 12), 98, "sooA", "null", 41, 7, 1.0);
            user0.addActivity(act_2);
        
            Trail act_3 = new Trail(user0.getCode(), MakeItFitDate.of(2000, 6, 25), 120, "tzo", "QfP", 50.0, 1.0, 0.0, -7);
            user0.addActivity(act_3);
        
            WeightSquat act_4 = new WeightSquat(user1.getCode(), MakeItFitDate.of(2021, 2, 8), 23, "HLedqib", "umgBgFV", 2, 10, 2.0);
            user1.addActivity(act_4);
        

        // Inserir planos
        
            TrainingPlan tp_0 = new TrainingPlan(user0.getCode(), MakeItFitDate.of(2013, 3, 12));
            tpm.insertTrainingPlan(tp_0);
        
                tp_0.addActivity(8, act_3);
            
                tp_0.addActivity(4, act_2);
            
            TrainingPlan tp_1 = new TrainingPlan(user1.getCode(), MakeItFitDate.of(2000, 11, 22));
            tpm.insertTrainingPlan(tp_1);
        
                tp_1.addActivity(9, act_1);
            

        // Queries:
        

        double expectedAltimetry = 1.0;
        double resultAltimetry = qm.executeQueryHowManyAltimetryDone(um, "zqYMpf4259e@wrbv.net");
        assertEquals(expectedAltimetry, resultAltimetry, 0.001);

        double expectedAltimetryWithDates = 0;
        double resultAltimetryWithDates = qm.executeQueryHowManyAltimetryDone(um, "zqYMpf4259e@wrbv.net", data1, data2);
        assertEquals(expectedAltimetryWithDates, resultAltimetryWithDates, 0.001);
     // nao testavam se estava dentro das datas e altimetria sem datas tinha sinal trocado
        

        double expectedKMs = 0.05;
        double resultKMs = qm.executeQueryHowManyKMsDone(um, "zqYMpf4259e@wrbv.net");
        assertEquals(expectedKMs, resultKMs, 0.001);

        double expectedKMsWithDates = 0.0;
        double resultKMsWithDates = qm.executeQueryHowManyKMsDone(um, "zqYMpf4259e@wrbv.net", data1, data2);
        assertEquals(expectedKMsWithDates, resultKMsWithDates, 0.001);
    
        
        TrainingPlan resultDemanding = qm.executeQueryMostDemandingTrainingPlan(tpm, um);
        if (resultDemanding != null) {
            assertEquals(UUID.fromString("c7d7901a-b23a-413b-b455-0534d82ed193"), resultDemanding.getUserCode());
        }
    
        
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        String resultMoreDone = qm.executeQueryMostDoneActivity(um);
        assertEquals("RepetitionsWithWeights", resultMoreDone);
     // as repeticoes e repeticoes com peso estavam trocadas no java
        

        User r = qm.executeQuerywhoBurnsMoreCalories(um, data1, data2);
        if (r != null) {
            assertEquals("MbaONtHnBt9e6cb2@xgfegs.net", r.getEmail());
        }
        
        

        User result = qm.executeQueryWhoDidTheMostActivities(um, data1, data2);
        if (result != null) {
            assertEquals("MbaONtHnBt9e6cb2@xgfegs.net", result.getEmail());
        }
        
        
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "zqYMpf4259e@wrbv.net"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "zqYMpf4259e@wrbv.net", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "zqYMpf4259e@wrbv.net"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "zqYMpf4259e@wrbv.net", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryMostDemandingTrainingPlan(tpm, um));
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um, data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um, data1, data2));
    
    }
@Test
    public void testQueriesManager_3() {
        UserManager um = new UserManager();
        TrainingPlanManager tpm = new TrainingPlanManager();
        QueriesManager qm = new QueriesManager(um, tpm);

        MakeItFitDate data1 = MakeItFitDate.of(2004, 5, 7);
        MakeItFitDate data2 = MakeItFitDate.of(2013, 1, 25);

        // Criar utilizadores
        
            User user0 = new Amateur("DmOFn", 27, Gender.Other, 150.0f, 192, 42,
                                       2, "Rua TIL", "959854667", "DmOFnbbc6d3@obxtm.org");
            user0.setCode(UUID.fromString("803cab38-53f1-4a04-bbc8-126c79ff5d19"));
            um.insertUser(user0);
            
            User user1 = new Occasional("sGbwcXzs", 49, Gender.Male, 87.82f, 187, 63,
                                       10, "Rua V", "956157267", "sGbwcXzs5ea3b8@hgdnyu.pt", 1);
            user1.setCode(UUID.fromString("d69432f5-4ec0-481e-817d-a133f12a078f"));
            um.insertUser(user1);
            
            User user2 = new Occasional("GSZENgFp", 14, Gender.Other, 31.0f, 187, 80,
                                       7, "Rua MDF", "999166370", "GSZENgFpb34575@lkk.com", 1);
            user2.setCode(UUID.fromString("a3ad727e-bb91-4e9b-a730-ba6f4ee4a1eb"));
            um.insertUser(user2);
            

        // Criar atividades
        
            PushUp act_0 = new PushUp(user2.getCode(), MakeItFitDate.of(2000, 1, 7), 169, "pzFM", "CRawljerVP", 19, 6);
            user2.addActivity(act_0);
        
            Running act_1 = new Running(user1.getCode(), MakeItFitDate.of(2004, 7, 26), 120, "etT", "uhPbTZx", 49.0, 19.0);
            user1.addActivity(act_1);
        
            PushUp act_2 = new PushUp(user1.getCode(), MakeItFitDate.of(2021, 2, 23), 180, "HkrdJ", "lSBydArNwr", 5, 4);
            user1.addActivity(act_2);
        
            Running act_3 = new Running(user2.getCode(), MakeItFitDate.of(2004, 8, 9), 79, "NsSzKGX", "ZtdN", 0.5, 3.51);
            user2.addActivity(act_3);
        
            PushUp act_4 = new PushUp(user1.getCode(), MakeItFitDate.of(2025, 11, 26), 178, "BofPpCRs", "nFpGPbAsaS", 14, 2);
            user1.addActivity(act_4);
        
            PushUp act_5 = new PushUp(user1.getCode(), MakeItFitDate.of(2024, 2, 19), 151, "FgKWYMbaJI", "gaRJw", 45, 10);
            user1.addActivity(act_5);
        
            Trail act_6 = new Trail(user2.getCode(), MakeItFitDate.of(2011, 10, 12), 34, "bCGUGDdkTC", "RGY", 0.5, 1.0, 0.0, -10);
            user2.addActivity(act_6);
        

        // Inserir planos
        
            TrainingPlan tp_0 = new TrainingPlan(user1.getCode(), MakeItFitDate.of(2011, 6, 8));
            tpm.insertTrainingPlan(tp_0);
        
                tp_0.addActivity(5, act_4);
            
            TrainingPlan tp_1 = new TrainingPlan(user2.getCode(), MakeItFitDate.of(2006, 12, 2));
            tpm.insertTrainingPlan(tp_1);
        
                tp_1.addActivity(9, act_3);
            
                tp_1.addActivity(10, act_0);
            

        // Queries:
        

        double expectedAltimetry = 0;
        double resultAltimetry = qm.executeQueryHowManyAltimetryDone(um, "DmOFnbbc6d3@obxtm.org");
        assertEquals(expectedAltimetry, resultAltimetry, 0.001);

        double expectedAltimetryWithDates = 0;
        double resultAltimetryWithDates = qm.executeQueryHowManyAltimetryDone(um, "DmOFnbbc6d3@obxtm.org", data1, data2);
        assertEquals(expectedAltimetryWithDates, resultAltimetryWithDates, 0.001);
     // nao testavam se estava dentro das datas e altimetria sem datas tinha sinal trocado
        

        double expectedKMs = 0.0;
        double resultKMs = qm.executeQueryHowManyKMsDone(um, "DmOFnbbc6d3@obxtm.org");
        assertEquals(expectedKMs, resultKMs, 0.001);

        double expectedKMsWithDates = 0.0;
        double resultKMsWithDates = qm.executeQueryHowManyKMsDone(um, "DmOFnbbc6d3@obxtm.org", data1, data2);
        assertEquals(expectedKMsWithDates, resultKMsWithDates, 0.001);
    
        
        TrainingPlan resultDemanding = qm.executeQueryMostDemandingTrainingPlan(tpm, um);
        if (resultDemanding != null) {
            assertEquals(UUID.fromString("a3ad727e-bb91-4e9b-a730-ba6f4ee4a1eb"), resultDemanding.getUserCode());
        }
    
        
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        String resultMoreDone = qm.executeQueryMostDoneActivity(um);
        assertEquals("Repetitions", resultMoreDone);
     // as repeticoes e repeticoes com peso estavam trocadas no java
        

        User r = qm.executeQuerywhoBurnsMoreCalories(um, data1, data2);
        if (r != null) {
            assertEquals("sGbwcXzs5ea3b8@hgdnyu.pt", r.getEmail());
        }
        
        

        User result = qm.executeQueryWhoDidTheMostActivities(um, data1, data2);
        if (result != null) {
            assertEquals("GSZENgFpb34575@lkk.com", result.getEmail());
        }
        
        
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "DmOFnbbc6d3@obxtm.org"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "DmOFnbbc6d3@obxtm.org", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "DmOFnbbc6d3@obxtm.org"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "DmOFnbbc6d3@obxtm.org", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryMostDemandingTrainingPlan(tpm, um));
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um, data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um, data1, data2));
    
    }
@Test
    public void testQueriesManager_4() {
        UserManager um = new UserManager();
        TrainingPlanManager tpm = new TrainingPlanManager();
        QueriesManager qm = new QueriesManager(um, tpm);

        MakeItFitDate data1 = MakeItFitDate.of(2002, 1, 2);
        MakeItFitDate data2 = MakeItFitDate.of(2004, 10, 1);

        // Criar utilizadores
        
            User user0 = new Professional("MdX", 44, Gender.Male, 146.81f, 135, 58,
                                       7, "Rua SEV", "955554746", "MdX0f1695@fqkaej.pt", 1);
            user0.setCode(UUID.fromString("70505af1-e1e0-471d-b335-24769f986a77"));
            um.insertUser(user0);
            
            User user1 = new Occasional("kFeozZQ", 50, Gender.Female, 31.0f, 215, 63,
                                       9, "Rua QN", "967892959", "kFeozZQ8a1ffc@ild.org", 9);
            user1.setCode(UUID.fromString("43d0d698-cdd0-4853-947e-29952e2b4211"));
            um.insertUser(user1);
            
            User user2 = new Amateur("jDMd", 81, Gender.Other, 31.0f, 177, 159,
                                       0, "Rua NJS", "918940580", "jDMd2bf62a@qrmf.com");
            user2.setCode(UUID.fromString("3dd6d52d-e7be-48b2-86c0-1d545ea8792e"));
            um.insertUser(user2);
            

        // Criar atividades
        
            WeightSquat act_0 = new WeightSquat(user0.getCode(), MakeItFitDate.of(2003, 4, 9), 99, "nXWMjV", "gns", 38, 8, 1.5);
            user0.addActivity(act_0);
        
            Running act_1 = new Running(user1.getCode(), MakeItFitDate.of(2006, 3, 27), 67, "MSeQEAltEz", "HaG", 1.1, 1.1);
            user1.addActivity(act_1);
        
            Running act_2 = new Running(user2.getCode(), MakeItFitDate.of(2016, 1, 25), 172, "VeOIi", "egw", 1.5, 16.63);
            user2.addActivity(act_2);
        
            WeightSquat act_3 = new WeightSquat(user2.getCode(), MakeItFitDate.of(2007, 4, 25), 65, "pFU", "Azpup", 33, 2, 100.0);
            user2.addActivity(act_3);
        
            Trail act_4 = new Trail(user1.getCode(), MakeItFitDate.of(2008, 9, 10), 143, "nDePAmV", "iPzz", 2.47, 0.0, 1.5, -5);
            user1.addActivity(act_4);
        
            Trail act_5 = new Trail(user2.getCode(), MakeItFitDate.of(2011, 1, 18), 82, "XgdeQXB", "lqDAtbGAlM", 0.5, 790.38, 2.0, -8);
            user2.addActivity(act_5);
        

        // Inserir planos
        
            TrainingPlan tp_0 = new TrainingPlan(user0.getCode(), MakeItFitDate.of(2007, 8, 28));
            tpm.insertTrainingPlan(tp_0);
        
                tp_0.addActivity(5, act_0);
            
            TrainingPlan tp_1 = new TrainingPlan(user1.getCode(), MakeItFitDate.of(2024, 8, 3));
            tpm.insertTrainingPlan(tp_1);
        
                tp_1.addActivity(3, act_4);
            
                tp_1.addActivity(8, act_1);
            
            TrainingPlan tp_2 = new TrainingPlan(user2.getCode(), MakeItFitDate.of(2009, 6, 16));
            tpm.insertTrainingPlan(tp_2);
        
                tp_2.addActivity(9, act_2);
            
                tp_2.addActivity(1, act_3);
            

        // Queries:
        

        double expectedAltimetry = 0;
        double resultAltimetry = qm.executeQueryHowManyAltimetryDone(um, "MdX0f1695@fqkaej.pt");
        assertEquals(expectedAltimetry, resultAltimetry, 0.001);

        double expectedAltimetryWithDates = 0;
        double resultAltimetryWithDates = qm.executeQueryHowManyAltimetryDone(um, "MdX0f1695@fqkaej.pt", data1, data2);
        assertEquals(expectedAltimetryWithDates, resultAltimetryWithDates, 0.001);
     // nao testavam se estava dentro das datas e altimetria sem datas tinha sinal trocado
        

        double expectedKMs = 0.0;
        double resultKMs = qm.executeQueryHowManyKMsDone(um, "MdX0f1695@fqkaej.pt");
        assertEquals(expectedKMs, resultKMs, 0.001);

        double expectedKMsWithDates = 0.0;
        double resultKMsWithDates = qm.executeQueryHowManyKMsDone(um, "MdX0f1695@fqkaej.pt", data1, data2);
        assertEquals(expectedKMsWithDates, resultKMsWithDates, 0.001);
    
        
        TrainingPlan resultDemanding = qm.executeQueryMostDemandingTrainingPlan(tpm, um);
        if (resultDemanding != null) {
            assertEquals(UUID.fromString("70505af1-e1e0-471d-b335-24769f986a77"), resultDemanding.getUserCode());
        }
    
        
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        String resultMoreDone = qm.executeQueryMostDoneActivity(um);
        assertEquals("DistanceWithAltimetry", resultMoreDone);
     // as repeticoes e repeticoes com peso estavam trocadas no java
        

        User r = qm.executeQuerywhoBurnsMoreCalories(um, data1, data2);
        if (r != null) {
            assertEquals("MdX0f1695@fqkaej.pt", r.getEmail());
        }
        
        

        User result = qm.executeQueryWhoDidTheMostActivities(um, data1, data2);
        if (result != null) {
            assertEquals("MdX0f1695@fqkaej.pt", result.getEmail());
        }
        
        
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "MdX0f1695@fqkaej.pt"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "MdX0f1695@fqkaej.pt", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "MdX0f1695@fqkaej.pt"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "MdX0f1695@fqkaej.pt", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryMostDemandingTrainingPlan(tpm, um));
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um, data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um, data1, data2));
    
    }
@Test
    public void testQueriesManager_5() {
        UserManager um = new UserManager();
        TrainingPlanManager tpm = new TrainingPlanManager();
        QueriesManager qm = new QueriesManager(um, tpm);

        MakeItFitDate data1 = MakeItFitDate.of(2005, 5, 1);
        MakeItFitDate data2 = MakeItFitDate.of(2024, 8, 9);

        // Criar utilizadores
        
            User user0 = new Professional("YD", 17, Gender.Other, 150.0f, 140, 109,
                                       2, "Rua F", "985101835", "YDd07405@toz.pt", 10);
            user0.setCode(UUID.fromString("94a29a83-026d-4c38-a810-8bd14cc339de"));
            um.insertUser(user0);
            
            User user1 = new Amateur("tQWbwkpcwyOG", 31, Gender.Female, 31.0f, 219, 93,
                                       10, "Rua FPU", "941118387", "tQWbwkpcwyOG86ff27@rslogj.pt");
            user1.setCode(UUID.fromString("457a4e02-3a7b-4526-947c-9d41e8393c40"));
            um.insertUser(user1);
            

        // Criar atividades
        
            PushUp act_0 = new PushUp(user1.getCode(), MakeItFitDate.of(2000, 2, 10), 95, "hedl", "IyBo", 50, 3);
            user1.addActivity(act_0);
        
            PushUp act_1 = new PushUp(user0.getCode(), MakeItFitDate.of(2017, 7, 16), 172, "ITsZY", "icl", 19, 2);
            user0.addActivity(act_1);
        
            Running act_2 = new Running(user0.getCode(), MakeItFitDate.of(2010, 6, 6), 148, "uWG", "uQK", 50.0, 20.0);
            user0.addActivity(act_2);
        
            PushUp act_3 = new PushUp(user1.getCode(), MakeItFitDate.of(2013, 3, 1), 112, "SthI", "loMRj", 2, 10);
            user1.addActivity(act_3);
        
            PushUp act_4 = new PushUp(user1.getCode(), MakeItFitDate.of(2008, 2, 26), 175, "wqY", "dgVmw", 43, 2);
            user1.addActivity(act_4);
        
            WeightSquat act_5 = new WeightSquat(user0.getCode(), MakeItFitDate.of(2021, 5, 19), 115, "QuFbPYRmDG", "pcA", 20, 4, 1.9);
            user0.addActivity(act_5);
        

        // Inserir planos
        
            TrainingPlan tp_0 = new TrainingPlan(user0.getCode(), MakeItFitDate.of(2002, 10, 17));
            tpm.insertTrainingPlan(tp_0);
        
                tp_0.addActivity(4, act_1);
            
                tp_0.addActivity(4, act_5);
            
                tp_0.addActivity(7, act_2);
            
            TrainingPlan tp_1 = new TrainingPlan(user1.getCode(), MakeItFitDate.of(2004, 12, 8));
            tpm.insertTrainingPlan(tp_1);
        
                tp_1.addActivity(1, act_3);
            

        // Queries:
        

        double expectedAltimetry = 0;
        double resultAltimetry = qm.executeQueryHowManyAltimetryDone(um, "YDd07405@toz.pt");
        assertEquals(expectedAltimetry, resultAltimetry, 0.001);

        double expectedAltimetryWithDates = 0;
        double resultAltimetryWithDates = qm.executeQueryHowManyAltimetryDone(um, "YDd07405@toz.pt", data1, data2);
        assertEquals(expectedAltimetryWithDates, resultAltimetryWithDates, 0.001);
     // nao testavam se estava dentro das datas e altimetria sem datas tinha sinal trocado
        

        double expectedKMs = 0.05;
        double resultKMs = qm.executeQueryHowManyKMsDone(um, "YDd07405@toz.pt");
        assertEquals(expectedKMs, resultKMs, 0.001);

        double expectedKMsWithDates = 0.05;
        double resultKMsWithDates = qm.executeQueryHowManyKMsDone(um, "YDd07405@toz.pt", data1, data2);
        assertEquals(expectedKMsWithDates, resultKMsWithDates, 0.001);
    
        
        TrainingPlan resultDemanding = qm.executeQueryMostDemandingTrainingPlan(tpm, um);
        if (resultDemanding != null) {
            assertEquals(UUID.fromString("94a29a83-026d-4c38-a810-8bd14cc339de"), resultDemanding.getUserCode());
        }
    
        
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        String resultMoreDone = qm.executeQueryMostDoneActivity(um);
        assertEquals("Repetitions", resultMoreDone);
     // as repeticoes e repeticoes com peso estavam trocadas no java
        

        User r = qm.executeQuerywhoBurnsMoreCalories(um, data1, data2);
        if (r != null) {
            assertEquals("YDd07405@toz.pt", r.getEmail());
        }
        
        

        User result = qm.executeQueryWhoDidTheMostActivities(um, data1, data2);
        if (result != null) {
            assertEquals("YDd07405@toz.pt", result.getEmail());
        }
        
        
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "YDd07405@toz.pt"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "YDd07405@toz.pt", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "YDd07405@toz.pt"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "YDd07405@toz.pt", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryMostDemandingTrainingPlan(tpm, um));
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um, data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um, data1, data2));
    
    }
@Test
    public void testQueriesManager_6() {
        UserManager um = new UserManager();
        TrainingPlanManager tpm = new TrainingPlanManager();
        QueriesManager qm = new QueriesManager(um, tpm);

        MakeItFitDate data1 = MakeItFitDate.of(2018, 1, 19);
        MakeItFitDate data2 = MakeItFitDate.of(2024, 2, 9);

        // Criar utilizadores
        
            User user0 = new Professional("None", 94, Gender.Other, 149.0f, 220, 170,
                                       7, "Rua OOP", "928382321", "None4b693a@nhaq.pt", 10);
            user0.setCode(UUID.fromString("9e7ecb97-1fdb-4bfc-b313-bb2324f5fd21"));
            um.insertUser(user0);
            
            User user1 = new Occasional("GNJPGsMbQNVe", 88, Gender.Other, 31.0f, 194, 175,
                                       0, "Rua H", "953420379", "GNJPGsMbQNVe5bab3a@gspiol.net", 14);
            user1.setCode(UUID.fromString("b6dbcce0-695c-4061-9ca2-94adabe058d7"));
            um.insertUser(user1);
            

        // Criar atividades
        
            Trail act_0 = new Trail(user1.getCode(), MakeItFitDate.of(2005, 3, 20), 148, "PevnD", "RMKDakqQ", 0.5, 0.0, 0.0, -8);
            user1.addActivity(act_0);
        
            Trail act_1 = new Trail(user1.getCode(), MakeItFitDate.of(2011, 10, 25), 79, "qZSj", "ozt", 50.0, 812.4, 0.0, -6);
            user1.addActivity(act_1);
        
            PushUp act_2 = new PushUp(user1.getCode(), MakeItFitDate.of(2012, 8, 2), 128, "Sgi", "ATYvWIawFf", 18, 2);
            user1.addActivity(act_2);
        
            Running act_3 = new Running(user1.getCode(), MakeItFitDate.of(2002, 12, 6), 46, "YYHl", "EZp", 36.46, 1.0);
            user1.addActivity(act_3);
        
            Running act_4 = new Running(user1.getCode(), MakeItFitDate.of(2002, 9, 18), 52, "LQhE", "VXu", 1.5, 20.0);
            user1.addActivity(act_4);
        

        // Inserir planos
        
            TrainingPlan tp_0 = new TrainingPlan(user1.getCode(), MakeItFitDate.of(2018, 9, 11));
            tpm.insertTrainingPlan(tp_0);
        
                tp_0.addActivity(10, act_4);
            

        // Queries:
        

        double expectedAltimetry = 0;
        double resultAltimetry = qm.executeQueryHowManyAltimetryDone(um, "None4b693a@nhaq.pt");
        assertEquals(expectedAltimetry, resultAltimetry, 0.001);

        double expectedAltimetryWithDates = 0;
        double resultAltimetryWithDates = qm.executeQueryHowManyAltimetryDone(um, "None4b693a@nhaq.pt", data1, data2);
        assertEquals(expectedAltimetryWithDates, resultAltimetryWithDates, 0.001);
     // nao testavam se estava dentro das datas e altimetria sem datas tinha sinal trocado
        

        double expectedKMs = 0.0;
        double resultKMs = qm.executeQueryHowManyKMsDone(um, "None4b693a@nhaq.pt");
        assertEquals(expectedKMs, resultKMs, 0.001);

        double expectedKMsWithDates = 0.0;
        double resultKMsWithDates = qm.executeQueryHowManyKMsDone(um, "None4b693a@nhaq.pt", data1, data2);
        assertEquals(expectedKMsWithDates, resultKMsWithDates, 0.001);
    
        
        TrainingPlan resultDemanding = qm.executeQueryMostDemandingTrainingPlan(tpm, um);
        if (resultDemanding != null) {
            assertEquals(UUID.fromString("b6dbcce0-695c-4061-9ca2-94adabe058d7"), resultDemanding.getUserCode());
        }
    
        
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        String resultMoreDone = qm.executeQueryMostDoneActivity(um);
        assertEquals("DistanceWithAltimetry", resultMoreDone);
     // as repeticoes e repeticoes com peso estavam trocadas no java
        
        User resultado = qm.executeQuerywhoBurnsMoreCalories(um, data1, data2);
        if (resultado != null) {
            Set<String> expected = new HashSet<>(Arrays.asList("None4b693a@nhaq.pt", "GNJPGsMbQNVe5bab3a@gspiol.net"));
            assertTrue(expected.contains(resultado.getEmail()), "Utilizador vencedor não está no empate: " + resultado.getEmail());
        }
        
        

        User result = qm.executeQueryWhoDidTheMostActivities(um, data1, data2);
        if (result != null) {
            Set<String> expected = new HashSet<>(Arrays.asList("None4b693a@nhaq.pt", "GNJPGsMbQNVe5bab3a@gspiol.net"));
            assertTrue(expected.contains(result.getEmail()), "Utilizador vencedor não está no empate: " + result.getEmail());
        }
        
        
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "None4b693a@nhaq.pt"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "None4b693a@nhaq.pt", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "None4b693a@nhaq.pt"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "None4b693a@nhaq.pt", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryMostDemandingTrainingPlan(tpm, um));
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um, data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um, data1, data2));
    
    }
@Test
    public void testQueriesManager_7() {
        UserManager um = new UserManager();
        TrainingPlanManager tpm = new TrainingPlanManager();
        QueriesManager qm = new QueriesManager(um, tpm);

        MakeItFitDate data1 = MakeItFitDate.of(2005, 10, 22);
        MakeItFitDate data2 = MakeItFitDate.of(2013, 11, 13);

        // Criar utilizadores
        
            User user0 = new Professional("PmG", 24, Gender.Male, 149.0f, 123, 67,
                                       8, "Rua G", "952676716", "PmG647404@gme.net", 2);
            user0.setCode(UUID.fromString("81b41b42-ecc7-4f22-a8b4-1314d946517b"));
            um.insertUser(user0);
            
            User user1 = new Occasional("iYZQjh", 77, Gender.Male, 86.04f, 219, 132,
                                       4, "Rua CZT", "968429586", "iYZQjhd1037f@hjim.org", 11);
            user1.setCode(UUID.fromString("302ee0a2-24cd-414a-a8a4-67374eae6f6c"));
            um.insertUser(user1);
            
            User user2 = new Amateur("tAwpj", 23, Gender.Male, 149.0f, 194, 133,
                                       2, "Rua N", "920310394", "tAwpj6b47f5@tfp.org");
            user2.setCode(UUID.fromString("598f49b3-08fc-4552-9d40-fc64d6b87c26"));
            um.insertUser(user2);
            

        // Criar atividades
        
            Running act_0 = new Running(user0.getCode(), MakeItFitDate.of(2007, 11, 18), 103, "LZWCZRAJgo", "MuGXr", 17.14, 2.0);
            user0.addActivity(act_0);
        
            PushUp act_1 = new PushUp(user1.getCode(), MakeItFitDate.of(2019, 7, 3), 71, "ItFBlVS", "HljfPcPOlj", 43, 4);
            user1.addActivity(act_1);
        
            Trail act_2 = new Trail(user0.getCode(), MakeItFitDate.of(2004, 12, 9), 59, "ivksjQZapZ", "PkKAdn", 12.75, 0.0, 0.0, -3);
            user0.addActivity(act_2);
        
            Running act_3 = new Running(user1.getCode(), MakeItFitDate.of(2001, 1, 21), 151, "fRfAhixBVN", "OhLpw", 50.0, 19.0);
            user1.addActivity(act_3);
        
            WeightSquat act_4 = new WeightSquat(user2.getCode(), MakeItFitDate.of(2004, 8, 11), 52, "TxrPHy", "hbDAZNSmPL", 14, 6, 23.48);
            user2.addActivity(act_4);
        
            PushUp act_5 = new PushUp(user0.getCode(), MakeItFitDate.of(2000, 9, 11), 43, "rlCgNtuOAT", "rXsbIK", 29, 1);
            user0.addActivity(act_5);
        
            Trail act_6 = new Trail(user2.getCode(), MakeItFitDate.of(2011, 4, 19), 77, "AaFxsTyHe", "ageCb", 0.5, 0.0, 0.0, -9);
            user2.addActivity(act_6);
        

        // Inserir planos
        
            TrainingPlan tp_0 = new TrainingPlan(user0.getCode(), MakeItFitDate.of(2013, 6, 20));
            tpm.insertTrainingPlan(tp_0);
        
                tp_0.addActivity(2, act_5);
            
                tp_0.addActivity(9, act_2);
            
            TrainingPlan tp_1 = new TrainingPlan(user1.getCode(), MakeItFitDate.of(2019, 4, 1));
            tpm.insertTrainingPlan(tp_1);
        
                tp_1.addActivity(8, act_3);
            
                tp_1.addActivity(5, act_1);
            
            TrainingPlan tp_2 = new TrainingPlan(user2.getCode(), MakeItFitDate.of(2002, 1, 22));
            tpm.insertTrainingPlan(tp_2);
        
                tp_2.addActivity(9, act_4);
            

        // Queries:
        

        double expectedAltimetry = 0.0;
        double resultAltimetry = qm.executeQueryHowManyAltimetryDone(um, "PmG647404@gme.net");
        assertEquals(expectedAltimetry, resultAltimetry, 0.001);

        double expectedAltimetryWithDates = 0;
        double resultAltimetryWithDates = qm.executeQueryHowManyAltimetryDone(um, "PmG647404@gme.net", data1, data2);
        assertEquals(expectedAltimetryWithDates, resultAltimetryWithDates, 0.001);
     // nao testavam se estava dentro das datas e altimetria sem datas tinha sinal trocado
        

        double expectedKMs = 0.02989;
        double resultKMs = qm.executeQueryHowManyKMsDone(um, "PmG647404@gme.net");
        assertEquals(expectedKMs, resultKMs, 0.001);

        double expectedKMsWithDates = 0.01714;
        double resultKMsWithDates = qm.executeQueryHowManyKMsDone(um, "PmG647404@gme.net", data1, data2);
        assertEquals(expectedKMsWithDates, resultKMsWithDates, 0.001);
    
        
        TrainingPlan resultDemanding = qm.executeQueryMostDemandingTrainingPlan(tpm, um);
        if (resultDemanding != null) {
            assertEquals(UUID.fromString("598f49b3-08fc-4552-9d40-fc64d6b87c26"), resultDemanding.getUserCode());
        }
    
        
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        String resultMoreDone = qm.executeQueryMostDoneActivity(um);
        assertEquals("DistanceWithAltimetry", resultMoreDone);
     // as repeticoes e repeticoes com peso estavam trocadas no java
        

        User r = qm.executeQuerywhoBurnsMoreCalories(um, data1, data2);
        if (r != null) {
            assertEquals("PmG647404@gme.net", r.getEmail());
        }
        
        

        User result = qm.executeQueryWhoDidTheMostActivities(um, data1, data2);
        if (result != null) {
            Set<String> expected = new HashSet<>(Arrays.asList("PmG647404@gme.net", "tAwpj6b47f5@tfp.org"));
            assertTrue(expected.contains(result.getEmail()), "Utilizador vencedor não está no empate: " + result.getEmail());
        }
        
        
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "PmG647404@gme.net"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "PmG647404@gme.net", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "PmG647404@gme.net"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "PmG647404@gme.net", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryMostDemandingTrainingPlan(tpm, um));
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um, data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um, data1, data2));
    
    }
@Test
    public void testQueriesManager_8() {
        UserManager um = new UserManager();
        TrainingPlanManager tpm = new TrainingPlanManager();
        QueriesManager qm = new QueriesManager(um, tpm);

        MakeItFitDate data1 = MakeItFitDate.of(2001, 1, 8);
        MakeItFitDate data2 = MakeItFitDate.of(2005, 8, 21);

        // Criar utilizadores
        
            User user0 = new Amateur("xOC", 47, Gender.Female, 150.0f, 163, 62,
                                       4, "Rua F", "984290318", "xOCd20581@znzevd.pt");
            user0.setCode(UUID.fromString("78938030-a258-4ba1-b1e3-27f0a0ff597d"));
            um.insertUser(user0);
            
            User user1 = new Occasional("pOuLKLZG", 74, Gender.Other, 148.55f, 127, 43,
                                       1, "Rua NUL", "905266052", "pOuLKLZG790a2b@tfytld.pt", 7);
            user1.setCode(UUID.fromString("215c95d1-9bf5-4f14-ab92-d54dab737b47"));
            um.insertUser(user1);
            

        // Criar atividades
        
            WeightSquat act_0 = new WeightSquat(user1.getCode(), MakeItFitDate.of(2012, 11, 22), 43, "ChtaB", "GVXDblm", 23, 7, 2.0);
            user1.addActivity(act_0);
        
            PushUp act_1 = new PushUp(user0.getCode(), MakeItFitDate.of(2007, 4, 8), 118, "HDcwSCGuTy", "Xjgta", 24, 5);
            user0.addActivity(act_1);
        
            Running act_2 = new Running(user0.getCode(), MakeItFitDate.of(2018, 5, 11), 37, "avQ", "hMkXAjPflz", 50.0, 20.0);
            user0.addActivity(act_2);
        
            PushUp act_3 = new PushUp(user0.getCode(), MakeItFitDate.of(2020, 1, 26), 25, "vFA", "lUODjsjoiw", 30, 5);
            user0.addActivity(act_3);
        
            Trail act_4 = new Trail(user0.getCode(), MakeItFitDate.of(2006, 12, 19), 104, "NrhhiBwiFR", "Infinity", 1.5, 2.0, 0.0, 10);
            user0.addActivity(act_4);
        

        // Inserir planos
        
            TrainingPlan tp_0 = new TrainingPlan(user0.getCode(), MakeItFitDate.of(2016, 12, 1));
            tpm.insertTrainingPlan(tp_0);
        
                tp_0.addActivity(3, act_1);
            
                tp_0.addActivity(8, act_2);
            
                tp_0.addActivity(9, act_4);
            
            TrainingPlan tp_1 = new TrainingPlan(user1.getCode(), MakeItFitDate.of(2018, 8, 7));
            tpm.insertTrainingPlan(tp_1);
        
                tp_1.addActivity(2, act_0);
            

        // Queries:
        

        double expectedAltimetry = 2.0;
        double resultAltimetry = qm.executeQueryHowManyAltimetryDone(um, "xOCd20581@znzevd.pt");
        assertEquals(expectedAltimetry, resultAltimetry, 0.001);

        double expectedAltimetryWithDates = 0;
        double resultAltimetryWithDates = qm.executeQueryHowManyAltimetryDone(um, "xOCd20581@znzevd.pt", data1, data2);
        assertEquals(expectedAltimetryWithDates, resultAltimetryWithDates, 0.001);
     // nao testavam se estava dentro das datas e altimetria sem datas tinha sinal trocado
        

        double expectedKMs = 0.0515;
        double resultKMs = qm.executeQueryHowManyKMsDone(um, "xOCd20581@znzevd.pt");
        assertEquals(expectedKMs, resultKMs, 0.001);

        double expectedKMsWithDates = 0.0;
        double resultKMsWithDates = qm.executeQueryHowManyKMsDone(um, "xOCd20581@znzevd.pt", data1, data2);
        assertEquals(expectedKMsWithDates, resultKMsWithDates, 0.001);
    
        
        TrainingPlan resultDemanding = qm.executeQueryMostDemandingTrainingPlan(tpm, um);
        if (resultDemanding != null) {
            assertEquals(UUID.fromString("215c95d1-9bf5-4f14-ab92-d54dab737b47"), resultDemanding.getUserCode());
        }
    
        
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        String resultMoreDone = qm.executeQueryMostDoneActivity(um);
        assertEquals("Repetitions", resultMoreDone);
     // as repeticoes e repeticoes com peso estavam trocadas no java
        
        User resultado = qm.executeQuerywhoBurnsMoreCalories(um, data1, data2);
        if (resultado != null) {
            Set<String> expected = new HashSet<>(Arrays.asList("xOCd20581@znzevd.pt", "pOuLKLZG790a2b@tfytld.pt"));
            assertTrue(expected.contains(resultado.getEmail()), "Utilizador vencedor não está no empate: " + resultado.getEmail());
        }
        
        

        User result = qm.executeQueryWhoDidTheMostActivities(um, data1, data2);
        if (result != null) {
            Set<String> expected = new HashSet<>(Arrays.asList("xOCd20581@znzevd.pt", "pOuLKLZG790a2b@tfytld.pt"));
            assertTrue(expected.contains(result.getEmail()), "Utilizador vencedor não está no empate: " + result.getEmail());
        }
        
        
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "xOCd20581@znzevd.pt"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "xOCd20581@znzevd.pt", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "xOCd20581@znzevd.pt"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "xOCd20581@znzevd.pt", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryMostDemandingTrainingPlan(tpm, um));
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um, data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um, data1, data2));
    
    }
@Test
    public void testQueriesManager_9() {
        UserManager um = new UserManager();
        TrainingPlanManager tpm = new TrainingPlanManager();
        QueriesManager qm = new QueriesManager(um, tpm);

        MakeItFitDate data1 = MakeItFitDate.of(2016, 4, 25);
        MakeItFitDate data2 = MakeItFitDate.of(2016, 12, 6);

        // Criar utilizadores
        
            User user0 = new Occasional("MotolXOQ", 69, Gender.Male, 30.0f, 197, 54,
                                       8, "Rua G", "963391985", "MotolXOQ74ec9f@qhshx.org", 3);
            user0.setCode(UUID.fromString("fb59ae81-d42e-4fcd-b4cd-4143784c09ca"));
            um.insertUser(user0);
            
            User user1 = new Amateur("BdlWuEc", 69, Gender.Female, 149.0f, 197, 116,
                                       4, "Rua AWO", "971320753", "BdlWuEc8b6827@rbm.org");
            user1.setCode(UUID.fromString("2a5702e7-a7fa-4166-9bda-8da1f8defcd7"));
            um.insertUser(user1);
            
            User user2 = new Amateur("WkVTbZcQssfg", 72, Gender.Male, 31.0f, 157, 69,
                                       7, "Rua C", "929780730", "WkVTbZcQssfg829868@bdlev.com");
            user2.setCode(UUID.fromString("a62b2789-9a9c-4516-8886-eaaf707c8fae"));
            um.insertUser(user2);
            

        // Criar atividades
        
            Trail act_0 = new Trail(user2.getCode(), MakeItFitDate.of(2013, 3, 5), 113, "uQdw", "QRcavIpu", 1.9, 0.0, 1.0, 9);
            user2.addActivity(act_0);
        
            WeightSquat act_1 = new WeightSquat(user2.getCode(), MakeItFitDate.of(2018, 9, 13), 146, "txbLcq", "dUSKfCqnqv", 5, 9, 100.0);
            user2.addActivity(act_1);
        
            Running act_2 = new Running(user2.getCode(), MakeItFitDate.of(2014, 7, 3), 154, "FdcETyM", "mqs", 1.1, 3.67);
            user2.addActivity(act_2);
        
            Trail act_3 = new Trail(user0.getCode(), MakeItFitDate.of(2023, 2, 6), 92, "NluyWEXeWu", "CfkPuoMdxs", 0.5, 1500.0, 0.0, -4);
            user0.addActivity(act_3);
        
            PushUp act_4 = new PushUp(user0.getCode(), MakeItFitDate.of(2021, 6, 23), 153, "DlfHkNLqsn", "aiCH", 37, 5);
            user0.addActivity(act_4);
        
            Trail act_5 = new Trail(user1.getCode(), MakeItFitDate.of(2015, 11, 13), 104, "gUlIVAaftW", "TuC", 1.5, 0.5, 0.0, -1);
            user1.addActivity(act_5);
        
            Trail act_6 = new Trail(user2.getCode(), MakeItFitDate.of(2003, 5, 17), 170, "djKFoE", "rAAaC", 50.0, 0.33, 2.0, -7);
            user2.addActivity(act_6);
        
            Trail act_7 = new Trail(user2.getCode(), MakeItFitDate.of(2006, 2, 20), 39, "PWhFiXDzJi", "rjgmsLMAMC", 1.5, 0.0, 0.0, 4);
            user2.addActivity(act_7);
        
            Trail act_8 = new Trail(user0.getCode(), MakeItFitDate.of(2023, 10, 3), 176, "FAXrrak", "RVMbyuFoKH", 0.5, 0.0, 0.0, 0);
            user0.addActivity(act_8);
        
            Running act_9 = new Running(user0.getCode(), MakeItFitDate.of(2015, 2, 19), 124, "GbM", "iVFEUQtfXe", 1.0, 2.0);
            user0.addActivity(act_9);
        

        // Inserir planos
        
            TrainingPlan tp_0 = new TrainingPlan(user0.getCode(), MakeItFitDate.of(2014, 4, 24));
            tpm.insertTrainingPlan(tp_0);
        
                tp_0.addActivity(4, act_3);
            
                tp_0.addActivity(5, act_4);
            
            TrainingPlan tp_1 = new TrainingPlan(user1.getCode(), MakeItFitDate.of(2005, 5, 20));
            tpm.insertTrainingPlan(tp_1);
        
                tp_1.addActivity(6, act_5);
            
            TrainingPlan tp_2 = new TrainingPlan(user2.getCode(), MakeItFitDate.of(2003, 2, 24));
            tpm.insertTrainingPlan(tp_2);
        
                tp_2.addActivity(4, act_1);
            

        // Queries:
        

        double expectedAltimetry = 1500.0;
        double resultAltimetry = qm.executeQueryHowManyAltimetryDone(um, "MotolXOQ74ec9f@qhshx.org");
        assertEquals(expectedAltimetry, resultAltimetry, 0.001);

        double expectedAltimetryWithDates = 0;
        double resultAltimetryWithDates = qm.executeQueryHowManyAltimetryDone(um, "MotolXOQ74ec9f@qhshx.org", data1, data2);
        assertEquals(expectedAltimetryWithDates, resultAltimetryWithDates, 0.001);
     // nao testavam se estava dentro das datas e altimetria sem datas tinha sinal trocado
        

        double expectedKMs = 0.002;
        double resultKMs = qm.executeQueryHowManyKMsDone(um, "MotolXOQ74ec9f@qhshx.org");
        assertEquals(expectedKMs, resultKMs, 0.001);

        double expectedKMsWithDates = 0.0;
        double resultKMsWithDates = qm.executeQueryHowManyKMsDone(um, "MotolXOQ74ec9f@qhshx.org", data1, data2);
        assertEquals(expectedKMsWithDates, resultKMsWithDates, 0.001);
    
        
        TrainingPlan resultDemanding = qm.executeQueryMostDemandingTrainingPlan(tpm, um);
        if (resultDemanding != null) {
            assertEquals(UUID.fromString("a62b2789-9a9c-4516-8886-eaaf707c8fae"), resultDemanding.getUserCode());
        }
    
        
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        String resultMoreDone = qm.executeQueryMostDoneActivity(um);
        assertEquals("DistanceWithAltimetry", resultMoreDone);
     // as repeticoes e repeticoes com peso estavam trocadas no java
        
        User resultado = qm.executeQuerywhoBurnsMoreCalories(um, data1, data2);
        if (resultado != null) {
            Set<String> expected = new HashSet<>(Arrays.asList("MotolXOQ74ec9f@qhshx.org", "BdlWuEc8b6827@rbm.org", "WkVTbZcQssfg829868@bdlev.com"));
            assertTrue(expected.contains(resultado.getEmail()), "Utilizador vencedor não está no empate: " + resultado.getEmail());
        }
        
        

        User result = qm.executeQueryWhoDidTheMostActivities(um, data1, data2);
        if (result != null) {
            Set<String> expected = new HashSet<>(Arrays.asList("MotolXOQ74ec9f@qhshx.org", "BdlWuEc8b6827@rbm.org", "WkVTbZcQssfg829868@bdlev.com"));
            assertTrue(expected.contains(result.getEmail()), "Utilizador vencedor não está no empate: " + result.getEmail());
        }
        
        
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "MotolXOQ74ec9f@qhshx.org"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyAltimetryDone(um, "MotolXOQ74ec9f@qhshx.org", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "MotolXOQ74ec9f@qhshx.org"));
        assertDoesNotThrow(() -> qm.executeQueryHowManyKMsDone(um, "MotolXOQ74ec9f@qhshx.org", data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryMostDemandingTrainingPlan(tpm, um));
        assertDoesNotThrow(() -> qm.executeQueryMostDoneActivity(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um));
        assertDoesNotThrow(() -> qm.executeQuerywhoBurnsMoreCalories(um, data1, data2));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um));
        assertDoesNotThrow(() -> qm.executeQueryWhoDidTheMostActivities(um, data1, data2));
    
    }

}