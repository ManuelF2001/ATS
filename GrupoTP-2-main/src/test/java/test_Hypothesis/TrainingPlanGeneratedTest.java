package test_Hypothesis;

import MakeItFit.trainingPlan.TrainingPlan;
import MakeItFit.activities.implementation.*;
import MakeItFit.utils.MakeItFitDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainingPlanGeneratedTest {

@Test
    public void testTrainingPlan_0() {
        TrainingPlan tp0 = new TrainingPlan(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2000, 1, 1));
        assertNotNull(tp0);
        assertEquals(MakeItFitDate.of(2000, 1, 1), tp0.getStartDate());

        Running a0_0 = new Running(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2014, 6, 2), 171, "LmuhRxxKqH", "Rnpcx", 36.62, 1.9);
        tp0.addActivity(1, a0_0);
        UUID code0 = a0_0.getCode();
        
        assertFalse(tp0.getActivities().isEmpty());

        // Update activities with index 1.5
        tp0.updateActivities(MakeItFitDate.of(2000, 1, 1), 1.5f);

        // Remove first activity
        tp0.removeActivity(code0);

        // Extract past activities
        var extracted = tp0.extractActivities(MakeItFitDate.of(2000, 1, 1));
        assertNotNull(extracted);
        
        assertNotNull(tp0.toString());
        
        assertEquals(MakeItFitDate.of(2000, 1, 1), tp0.getStartDate());

        MakeItFitDate novaData = MakeItFitDate.of(2025, 1, 1);
        tp0.setStartDate(novaData);
        assertEquals(novaData, tp0.getStartDate());

        var clone = tp0.clone();
        assertEquals(tp0, clone);
        assertDoesNotThrow(() -> tp0.compareTo(clone));
    }
@Test
    public void testTrainingPlan_1() {
        TrainingPlan tp1 = new TrainingPlan(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2000, 1, 1));
        assertNotNull(tp1);
        assertEquals(MakeItFitDate.of(2000, 1, 1), tp1.getStartDate());

        Running a1_0 = new Running(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2014, 6, 2), 171, "LmuhRxxKqH", "Rnpcx", 36.62, 1.9);
        tp1.addActivity(1, a1_0);
        UUID code0 = a1_0.getCode();
        
        assertFalse(tp1.getActivities().isEmpty());

        // Update activities with index 1.5
        tp1.updateActivities(MakeItFitDate.of(2000, 1, 1), 1.5f);

        // Remove first activity
        tp1.removeActivity(code0);

        // Extract past activities
        var extracted = tp1.extractActivities(MakeItFitDate.of(2000, 1, 1));
        assertNotNull(extracted);
        
        assertNotNull(tp1.toString());
        
        assertEquals(MakeItFitDate.of(2000, 1, 1), tp1.getStartDate());

        MakeItFitDate novaData = MakeItFitDate.of(2025, 1, 1);
        tp1.setStartDate(novaData);
        assertEquals(novaData, tp1.getStartDate());

        var clone = tp1.clone();
        assertEquals(tp1, clone);
        assertDoesNotThrow(() -> tp1.compareTo(clone));
    }
@Test
    public void testTrainingPlan_2() {
        TrainingPlan tp2 = new TrainingPlan(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2014, 5, 26));
        assertNotNull(tp2);
        assertEquals(MakeItFitDate.of(2014, 5, 26), tp2.getStartDate());

        Running a2_0 = new Running(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2014, 6, 2), 171, "LmuhRxxKqH", "Rnpcx", 36.62, 1.9);
        tp2.addActivity(5, a2_0);
        UUID code0 = a2_0.getCode();
        
        assertFalse(tp2.getActivities().isEmpty());

        // Update activities with index 1.5
        tp2.updateActivities(MakeItFitDate.of(2014, 5, 26), 1.5f);

        // Remove first activity
        tp2.removeActivity(code0);

        // Extract past activities
        var extracted = tp2.extractActivities(MakeItFitDate.of(2014, 5, 26));
        assertNotNull(extracted);
        
        assertNotNull(tp2.toString());
        
        assertEquals(MakeItFitDate.of(2014, 5, 26), tp2.getStartDate());

        MakeItFitDate novaData = MakeItFitDate.of(2025, 1, 1);
        tp2.setStartDate(novaData);
        assertEquals(novaData, tp2.getStartDate());

        var clone = tp2.clone();
        assertEquals(tp2, clone);
        assertDoesNotThrow(() -> tp2.compareTo(clone));
    }
@Test
    public void testTrainingPlan_3() {
        TrainingPlan tp3 = new TrainingPlan(UUID.fromString("6651a372-cf9c-41d3-86e3-d1bdaa64e6ad"), MakeItFitDate.of(2024, 6, 13));
        assertNotNull(tp3);
        assertEquals(MakeItFitDate.of(2024, 6, 13), tp3.getStartDate());

        Running a3_0 = new Running(UUID.fromString("6651a372-cf9c-41d3-86e3-d1bdaa64e6ad"), MakeItFitDate.of(2000, 1, 1), 10, "AAA", "AAA", 0.5, 1.0);
        tp3.addActivity(6, a3_0);
        UUID code0 = a3_0.getCode();
        

        Running a3_1 = new Running(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2005, 5, 27), 173, "true", "XNhtnf", 1.5, 20.0);
        tp3.addActivity(6, a3_1);
        UUID code1 = a3_1.getCode();
        

        WeightSquat a3_2 = new WeightSquat(UUID.fromString("6651a372-cf9c-41d3-86e3-d1bdaa64e6ad"), MakeItFitDate.of(2013, 5, 26), 42, "lzrL", "HQi", 7, 6, 1.5);
        tp3.addActivity(10, a3_2);
        UUID code2 = a3_2.getCode();
        
        assertFalse(tp3.getActivities().isEmpty());

        // Update activities with index 1.5
        tp3.updateActivities(MakeItFitDate.of(2024, 6, 13), 1.5f);

        // Remove first activity
        tp3.removeActivity(code0);

        // Extract past activities
        var extracted = tp3.extractActivities(MakeItFitDate.of(2024, 6, 13));
        assertNotNull(extracted);
        
        assertNotNull(tp3.toString());
        
        assertEquals(MakeItFitDate.of(2024, 6, 13), tp3.getStartDate());

        MakeItFitDate novaData = MakeItFitDate.of(2025, 1, 1);
        tp3.setStartDate(novaData);
        assertEquals(novaData, tp3.getStartDate());

        var clone = tp3.clone();
        assertEquals(tp3, clone);
        assertDoesNotThrow(() -> tp3.compareTo(clone));
    }
@Test
    public void testTrainingPlan_4() {
        TrainingPlan tp4 = new TrainingPlan(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2023, 8, 16));
        assertNotNull(tp4);
        assertEquals(MakeItFitDate.of(2023, 8, 16), tp4.getStartDate());

        WeightSquat a4_0 = new WeightSquat(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2011, 5, 21), 77, "LRNVp", "FviZOAe", 35, 7, 1.0);
        tp4.addActivity(5, a4_0);
        UUID code0 = a4_0.getCode();
        

        WeightSquat a4_1 = new WeightSquat(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2013, 12, 19), 149, "TceC", "rypuKMmz", 12, 8, 18.56);
        tp4.addActivity(3, a4_1);
        UUID code1 = a4_1.getCode();
        

        Trail a4_2 = new Trail(UUID.fromString("6651a372-cf9c-41d3-86e3-d1bdaa64e6ad"), MakeItFitDate.of(2017, 7, 21), 180, "fwrJBlXKPa", "pQPb", 6.37, 0.0, 1.1, -2);
        tp4.addActivity(8, a4_2);
        UUID code2 = a4_2.getCode();
        
        assertFalse(tp4.getActivities().isEmpty());

        // Update activities with index 1.5
        tp4.updateActivities(MakeItFitDate.of(2023, 8, 16), 1.5f);

        // Remove first activity
        tp4.removeActivity(code0);

        // Extract past activities
        var extracted = tp4.extractActivities(MakeItFitDate.of(2023, 8, 16));
        assertNotNull(extracted);
        
        assertNotNull(tp4.toString());
        
        assertEquals(MakeItFitDate.of(2023, 8, 16), tp4.getStartDate());

        MakeItFitDate novaData = MakeItFitDate.of(2025, 1, 1);
        tp4.setStartDate(novaData);
        assertEquals(novaData, tp4.getStartDate());

        var clone = tp4.clone();
        assertEquals(tp4, clone);
        assertDoesNotThrow(() -> tp4.compareTo(clone));
    }
@Test
    public void testTrainingPlan_5() {
        TrainingPlan tp5 = new TrainingPlan(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2009, 11, 16));
        assertNotNull(tp5);
        assertEquals(MakeItFitDate.of(2009, 11, 16), tp5.getStartDate());

        Trail a5_0 = new Trail(UUID.fromString("6651a372-cf9c-41d3-86e3-d1bdaa64e6ad"), MakeItFitDate.of(2017, 7, 21), 180, "fwrJBlXKPa", "pQPb", 6.37, 0.0, 1.1, -2);
        tp5.addActivity(4, a5_0);
        UUID code0 = a5_0.getCode();
        

        WeightSquat a5_1 = new WeightSquat(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2013, 12, 19), 149, "TceC", "rypuKMmz", 12, 8, 18.56);
        tp5.addActivity(6, a5_1);
        UUID code1 = a5_1.getCode();
        

        PushUp a5_2 = new PushUp(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2021, 7, 19), 180, "EkZcPegAvp", "jSZ", 28, 4);
        tp5.addActivity(7, a5_2);
        UUID code2 = a5_2.getCode();
        
        assertFalse(tp5.getActivities().isEmpty());

        // Update activities with index 1.5
        tp5.updateActivities(MakeItFitDate.of(2009, 11, 16), 1.5f);

        // Remove first activity
        tp5.removeActivity(code0);

        // Extract past activities
        var extracted = tp5.extractActivities(MakeItFitDate.of(2009, 11, 16));
        assertNotNull(extracted);
        
        assertNotNull(tp5.toString());
        
        assertEquals(MakeItFitDate.of(2009, 11, 16), tp5.getStartDate());

        MakeItFitDate novaData = MakeItFitDate.of(2025, 1, 1);
        tp5.setStartDate(novaData);
        assertEquals(novaData, tp5.getStartDate());

        var clone = tp5.clone();
        assertEquals(tp5, clone);
        assertDoesNotThrow(() -> tp5.compareTo(clone));
    }
@Test
    public void testTrainingPlan_6() {
        TrainingPlan tp6 = new TrainingPlan(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2011, 3, 22));
        assertNotNull(tp6);
        assertEquals(MakeItFitDate.of(2011, 3, 22), tp6.getStartDate());

        WeightSquat a6_0 = new WeightSquat(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2011, 5, 21), 77, "LRNVp", "FviZOAe", 35, 7, 1.0);
        tp6.addActivity(5, a6_0);
        UUID code0 = a6_0.getCode();
        
        assertFalse(tp6.getActivities().isEmpty());

        // Update activities with index 1.5
        tp6.updateActivities(MakeItFitDate.of(2011, 3, 22), 1.5f);

        // Remove first activity
        tp6.removeActivity(code0);

        // Extract past activities
        var extracted = tp6.extractActivities(MakeItFitDate.of(2011, 3, 22));
        assertNotNull(extracted);
        
        assertNotNull(tp6.toString());
        
        assertEquals(MakeItFitDate.of(2011, 3, 22), tp6.getStartDate());

        MakeItFitDate novaData = MakeItFitDate.of(2025, 1, 1);
        tp6.setStartDate(novaData);
        assertEquals(novaData, tp6.getStartDate());

        var clone = tp6.clone();
        assertEquals(tp6, clone);
        assertDoesNotThrow(() -> tp6.compareTo(clone));
    }
@Test
    public void testTrainingPlan_7() {
        TrainingPlan tp7 = new TrainingPlan(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2009, 9, 16));
        assertNotNull(tp7);
        assertEquals(MakeItFitDate.of(2009, 9, 16), tp7.getStartDate());

        Running a7_0 = new Running(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2014, 6, 2), 171, "LmuhRxxKqH", "Rnpcx", 36.62, 1.9);
        tp7.addActivity(1, a7_0);
        UUID code0 = a7_0.getCode();
        

        Trail a7_1 = new Trail(UUID.fromString("6651a372-cf9c-41d3-86e3-d1bdaa64e6ad"), MakeItFitDate.of(2017, 7, 21), 180, "fwrJBlXKPa", "pQPb", 6.37, 0.0, 1.1, -2);
        tp7.addActivity(8, a7_1);
        UUID code1 = a7_1.getCode();
        

        PushUp a7_2 = new PushUp(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2021, 7, 19), 180, "EkZcPegAvp", "jSZ", 28, 4);
        tp7.addActivity(2, a7_2);
        UUID code2 = a7_2.getCode();
        

        WeightSquat a7_3 = new WeightSquat(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2013, 12, 19), 149, "TceC", "rypuKMmz", 12, 8, 18.56);
        tp7.addActivity(5, a7_3);
        UUID code3 = a7_3.getCode();
        
        assertFalse(tp7.getActivities().isEmpty());

        // Update activities with index 1.5
        tp7.updateActivities(MakeItFitDate.of(2009, 9, 16), 1.5f);

        // Remove first activity
        tp7.removeActivity(code0);

        // Extract past activities
        var extracted = tp7.extractActivities(MakeItFitDate.of(2009, 9, 16));
        assertNotNull(extracted);
        
        assertNotNull(tp7.toString());
        
        assertEquals(MakeItFitDate.of(2009, 9, 16), tp7.getStartDate());

        MakeItFitDate novaData = MakeItFitDate.of(2025, 1, 1);
        tp7.setStartDate(novaData);
        assertEquals(novaData, tp7.getStartDate());

        var clone = tp7.clone();
        assertEquals(tp7, clone);
        assertDoesNotThrow(() -> tp7.compareTo(clone));
    }
@Test
    public void testTrainingPlan_8() {
        TrainingPlan tp8 = new TrainingPlan(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2021, 5, 14));
        assertNotNull(tp8);
        assertEquals(MakeItFitDate.of(2021, 5, 14), tp8.getStartDate());

        WeightSquat a8_0 = new WeightSquat(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2013, 12, 19), 149, "TceC", "rypuKMmz", 12, 8, 18.56);
        tp8.addActivity(9, a8_0);
        UUID code0 = a8_0.getCode();
        

        WeightSquat a8_1 = new WeightSquat(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2011, 5, 21), 77, "LRNVp", "FviZOAe", 35, 7, 1.0);
        tp8.addActivity(6, a8_1);
        UUID code1 = a8_1.getCode();
        
        assertFalse(tp8.getActivities().isEmpty());

        // Update activities with index 1.5
        tp8.updateActivities(MakeItFitDate.of(2021, 5, 14), 1.5f);

        // Remove first activity
        tp8.removeActivity(code0);

        // Extract past activities
        var extracted = tp8.extractActivities(MakeItFitDate.of(2021, 5, 14));
        assertNotNull(extracted);
        
        assertNotNull(tp8.toString());
        
        assertEquals(MakeItFitDate.of(2021, 5, 14), tp8.getStartDate());

        MakeItFitDate novaData = MakeItFitDate.of(2025, 1, 1);
        tp8.setStartDate(novaData);
        assertEquals(novaData, tp8.getStartDate());

        var clone = tp8.clone();
        assertEquals(tp8, clone);
        assertDoesNotThrow(() -> tp8.compareTo(clone));
    }
@Test
    public void testTrainingPlan_9() {
        TrainingPlan tp9 = new TrainingPlan(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2001, 2, 9));
        assertNotNull(tp9);
        assertEquals(MakeItFitDate.of(2001, 2, 9), tp9.getStartDate());

        WeightSquat a9_0 = new WeightSquat(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2011, 5, 21), 77, "LRNVp", "FviZOAe", 35, 7, 1.0);
        tp9.addActivity(10, a9_0);
        UUID code0 = a9_0.getCode();
        

        WeightSquat a9_1 = new WeightSquat(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2013, 12, 19), 149, "TceC", "rypuKMmz", 12, 8, 18.56);
        tp9.addActivity(6, a9_1);
        UUID code1 = a9_1.getCode();
        

        PushUp a9_2 = new PushUp(UUID.fromString("6462c8d9-4f03-48f7-9692-5ead3ce1c95d"), MakeItFitDate.of(2021, 7, 19), 180, "EkZcPegAvp", "jSZ", 28, 4);
        tp9.addActivity(2, a9_2);
        UUID code2 = a9_2.getCode();
        

        Trail a9_3 = new Trail(UUID.fromString("6651a372-cf9c-41d3-86e3-d1bdaa64e6ad"), MakeItFitDate.of(2017, 7, 21), 180, "fwrJBlXKPa", "pQPb", 6.37, 0.0, 1.1, -2);
        tp9.addActivity(10, a9_3);
        UUID code3 = a9_3.getCode();
        
        assertFalse(tp9.getActivities().isEmpty());

        // Update activities with index 1.5
        tp9.updateActivities(MakeItFitDate.of(2001, 2, 9), 1.5f);

        // Remove first activity
        tp9.removeActivity(code0);

        // Extract past activities
        var extracted = tp9.extractActivities(MakeItFitDate.of(2001, 2, 9));
        assertNotNull(extracted);
        
        assertNotNull(tp9.toString());
        
        assertEquals(MakeItFitDate.of(2001, 2, 9), tp9.getStartDate());

        MakeItFitDate novaData = MakeItFitDate.of(2025, 1, 1);
        tp9.setStartDate(novaData);
        assertEquals(novaData, tp9.getStartDate());

        var clone = tp9.clone();
        assertEquals(tp9, clone);
        assertDoesNotThrow(() -> tp9.compareTo(clone));
    }

}