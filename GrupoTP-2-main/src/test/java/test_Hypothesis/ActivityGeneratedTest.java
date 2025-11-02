package test_Hypothesis;

import MakeItFit.activities.implementation.*;
import MakeItFit.utils.MakeItFitDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ActivityGeneratedTest {

@Test
    public void test_Trail_0() {
        Trail a0 = new Trail(UUID.fromString("53118cff-0f1c-4e77-a804-965f9c27bf07"), MakeItFitDate.of(2005, 6, 15), 10, "JNhcdlioQY", "wNUudm", 1.9, 3.13, 1.5, -3);
        assertNotNull(a0);
        assertEquals("JNhcdlioQY", a0.getDesignation());
        assertEquals("wNUudm", a0.getName());
        assertEquals(10, a0.getExpectedDuration());
        
        assertEquals(1.9, a0.getDistance(), 0.01);
        assertEquals(3.13, a0.getElevationGain(), 0.01);
        assertEquals(1.5, a0.getElevationLoss(), 0.01);

        // O construtor passa a aplica validação ao trailType
        //assertEquals(0, a0.getTrailType());

        a0.setElevationGain(100.1);
        a0.setElevationLoss(50.1);
        assertEquals(100.1, a0.getElevationGain(), 0.01);
        assertEquals(50.1, a0.getElevationLoss(), 0.01);
        
        a0.setDuration(60);
        a0.setCaloricWaste(300);
        a0.setExpectedDuration(123);
        a0.setDesignation("Nova Designação");

        assertEquals(123, a0.getExpectedDuration());
        assertEquals("Nova Designação", a0.getDesignation());
        assertEquals(60, a0.getDuration());
        assertEquals(300, a0.getCaloricWaste());

        var clone = a0.clone();
        assertEquals(a0, clone);
        assertNotNull(a0.toString());
        assertDoesNotThrow(() -> a0.compareTo(clone));
    }
@Test
    public void test_Running_1() {
        Running a1 = new Running(UUID.fromString("53118cff-0f1c-4e77-a804-965f9c27bf07"), MakeItFitDate.of(2014, 3, 21), 10, "FzkPBtE", "EdPLoXlnza", 41.58, 10.13);
        assertNotNull(a1);
        assertEquals("FzkPBtE", a1.getDesignation());
        assertEquals("EdPLoXlnza", a1.getName());
        assertEquals(10, a1.getExpectedDuration());
        
        assertEquals(41.58, a1.getDistance(), 0.01);
        assertEquals(10.13, a1.getSpeed(), 0.01);
        a1.setDistance(12.34);
        a1.setSpeed(8.88);
        assertEquals(12.34, a1.getDistance(), 0.01);
        assertEquals(8.88, a1.getSpeed(), 0.01);
        
        a1.setDuration(60);
        a1.setCaloricWaste(300);
        a1.setExpectedDuration(123);
        a1.setDesignation("Nova Designação");

        assertEquals(123, a1.getExpectedDuration());
        assertEquals("Nova Designação", a1.getDesignation());
        assertEquals(60, a1.getDuration());
        assertEquals(300, a1.getCaloricWaste());

        var clone = a1.clone();
        assertEquals(a1, clone);
        assertNotNull(a1.toString());
        assertDoesNotThrow(() -> a1.compareTo(clone));
    }
@Test
    public void test_Trail_2() {
        Trail a2 = new Trail(UUID.fromString("53118cff-0f1c-4e77-a804-965f9c27bf07"), MakeItFitDate.of(2004, 8, 7), 25, "NhCTZKSKCl", "RKMONSiRR", 1.9, 1500.0, 0.0, 4);
        assertNotNull(a2);
        assertEquals("NhCTZKSKCl", a2.getDesignation());
        assertEquals("RKMONSiRR", a2.getName());
        assertEquals(25, a2.getExpectedDuration());
        
        assertEquals(1.9, a2.getDistance(), 0.01);
        assertEquals(1500.0, a2.getElevationGain(), 0.01);
        assertEquals(0.0, a2.getElevationLoss(), 0.01);

        // O construtor passa a aplica validação ao trailType
        //assertEquals(2, a2.getTrailType());

        a2.setElevationGain(100.1);
        a2.setElevationLoss(50.1);
        assertEquals(100.1, a2.getElevationGain(), 0.01);
        assertEquals(50.1, a2.getElevationLoss(), 0.01);
        
        a2.setDuration(60);
        a2.setCaloricWaste(300);
        a2.setExpectedDuration(123);
        a2.setDesignation("Nova Designação");

        assertEquals(123, a2.getExpectedDuration());
        assertEquals("Nova Designação", a2.getDesignation());
        assertEquals(60, a2.getDuration());
        assertEquals(300, a2.getCaloricWaste());

        var clone = a2.clone();
        assertEquals(a2, clone);
        assertNotNull(a2.toString());
        assertDoesNotThrow(() -> a2.compareTo(clone));
    }
@Test
    public void test_Trail_3() {
        Trail a3 = new Trail(UUID.fromString("53118cff-0f1c-4e77-a804-965f9c27bf07"), MakeItFitDate.of(2007, 12, 8), 116, "ige", "GrnWJjiGq", 50.0, 0.0, 1500.0, -10);
        assertNotNull(a3);
        assertEquals("ige", a3.getDesignation());
        assertEquals("GrnWJjiGq", a3.getName());
        assertEquals(116, a3.getExpectedDuration());
        
        assertEquals(50.0, a3.getDistance(), 0.01);
        assertEquals(0.0, a3.getElevationGain(), 0.01);
        assertEquals(1500.0, a3.getElevationLoss(), 0.01);

        // O construtor passa a aplica validação ao trailType
        //assertEquals(0, a3.getTrailType());

        a3.setElevationGain(100.1);
        a3.setElevationLoss(50.1);
        assertEquals(100.1, a3.getElevationGain(), 0.01);
        assertEquals(50.1, a3.getElevationLoss(), 0.01);
        
        a3.setDuration(60);
        a3.setCaloricWaste(300);
        a3.setExpectedDuration(123);
        a3.setDesignation("Nova Designação");

        assertEquals(123, a3.getExpectedDuration());
        assertEquals("Nova Designação", a3.getDesignation());
        assertEquals(60, a3.getDuration());
        assertEquals(300, a3.getCaloricWaste());

        var clone = a3.clone();
        assertEquals(a3, clone);
        assertNotNull(a3.toString());
        assertDoesNotThrow(() -> a3.compareTo(clone));
    }
@Test
    public void test_Running_4() {
        Running a4 = new Running(UUID.fromString("53118cff-0f1c-4e77-a804-965f9c27bf07"), MakeItFitDate.of(2000, 1, 1), 10, "AAA", "AAA", 0.5, 1.0);
        assertNotNull(a4);
        assertEquals("AAA", a4.getDesignation());
        assertEquals("AAA", a4.getName());
        assertEquals(10, a4.getExpectedDuration());
        
        assertEquals(0.5, a4.getDistance(), 0.01);
        assertEquals(1.0, a4.getSpeed(), 0.01);
        a4.setDistance(12.34);
        a4.setSpeed(8.88);
        assertEquals(12.34, a4.getDistance(), 0.01);
        assertEquals(8.88, a4.getSpeed(), 0.01);
        
        a4.setDuration(60);
        a4.setCaloricWaste(300);
        a4.setExpectedDuration(123);
        a4.setDesignation("Nova Designação");

        assertEquals(123, a4.getExpectedDuration());
        assertEquals("Nova Designação", a4.getDesignation());
        assertEquals(60, a4.getDuration());
        assertEquals(300, a4.getCaloricWaste());

        var clone = a4.clone();
        assertEquals(a4, clone);
        assertNotNull(a4.toString());
        assertDoesNotThrow(() -> a4.compareTo(clone));
    }
@Test
    public void test_Running_5() {
        Running a5 = new Running(UUID.fromString("53118cff-0f1c-4e77-a804-965f9c27bf07"), MakeItFitDate.of(2005, 2, 15), 122, "rqdZs", "njF", 13.83, 13.08);
        assertNotNull(a5);
        assertEquals("rqdZs", a5.getDesignation());
        assertEquals("njF", a5.getName());
        assertEquals(122, a5.getExpectedDuration());
        
        assertEquals(13.83, a5.getDistance(), 0.01);
        assertEquals(13.08, a5.getSpeed(), 0.01);
        a5.setDistance(12.34);
        a5.setSpeed(8.88);
        assertEquals(12.34, a5.getDistance(), 0.01);
        assertEquals(8.88, a5.getSpeed(), 0.01);
        
        a5.setDuration(60);
        a5.setCaloricWaste(300);
        a5.setExpectedDuration(123);
        a5.setDesignation("Nova Designação");

        assertEquals(123, a5.getExpectedDuration());
        assertEquals("Nova Designação", a5.getDesignation());
        assertEquals(60, a5.getDuration());
        assertEquals(300, a5.getCaloricWaste());

        var clone = a5.clone();
        assertEquals(a5, clone);
        assertNotNull(a5.toString());
        assertDoesNotThrow(() -> a5.compareTo(clone));
    }
@Test
    public void test_WeightSquat_6() {
        WeightSquat a6 = new WeightSquat(UUID.fromString("53118cff-0f1c-4e77-a804-965f9c27bf07"), MakeItFitDate.of(2006, 7, 6), 16, "ZWF", "guKTJDYMz", 15, 3, 76.54);
        assertNotNull(a6);
        assertEquals("ZWF", a6.getDesignation());
        assertEquals("guKTJDYMz", a6.getName());
        assertEquals(16, a6.getExpectedDuration());
        
        assertEquals(15, a6.getRepetitions());
        assertEquals(3, a6.getSeries());
        assertEquals(76.54, a6.getWeight(), 0.01);
        a6.setWeight(44.4);
        assertEquals(44.4, a6.getWeight(), 0.01);
        
        a6.setDuration(60);
        a6.setCaloricWaste(300);
        a6.setExpectedDuration(123);
        a6.setDesignation("Nova Designação");

        assertEquals(123, a6.getExpectedDuration());
        assertEquals("Nova Designação", a6.getDesignation());
        assertEquals(60, a6.getDuration());
        assertEquals(300, a6.getCaloricWaste());

        var clone = a6.clone();
        assertEquals(a6, clone);
        assertNotNull(a6.toString());
        assertDoesNotThrow(() -> a6.compareTo(clone));
    }
@Test
    public void test_Running_7() {
        Running a7 = new Running(UUID.fromString("53118cff-0f1c-4e77-a804-965f9c27bf07"), MakeItFitDate.of(2008, 4, 20), 59, "iniJgp", "OiuO", 1.5, 19.0);
        assertNotNull(a7);
        assertEquals("iniJgp", a7.getDesignation());
        assertEquals("OiuO", a7.getName());
        assertEquals(59, a7.getExpectedDuration());
        
        assertEquals(1.5, a7.getDistance(), 0.01);
        assertEquals(19.0, a7.getSpeed(), 0.01);
        a7.setDistance(12.34);
        a7.setSpeed(8.88);
        assertEquals(12.34, a7.getDistance(), 0.01);
        assertEquals(8.88, a7.getSpeed(), 0.01);
        
        a7.setDuration(60);
        a7.setCaloricWaste(300);
        a7.setExpectedDuration(123);
        a7.setDesignation("Nova Designação");

        assertEquals(123, a7.getExpectedDuration());
        assertEquals("Nova Designação", a7.getDesignation());
        assertEquals(60, a7.getDuration());
        assertEquals(300, a7.getCaloricWaste());

        var clone = a7.clone();
        assertEquals(a7, clone);
        assertNotNull(a7.toString());
        assertDoesNotThrow(() -> a7.compareTo(clone));
    }
@Test
    public void test_Running_8() {
        Running a8 = new Running(UUID.fromString("53118cff-0f1c-4e77-a804-965f9c27bf07"), MakeItFitDate.of(2000, 1, 1), 10, "AAA", "AAA", 0.5, 1.0);
        assertNotNull(a8);
        assertEquals("AAA", a8.getDesignation());
        assertEquals("AAA", a8.getName());
        assertEquals(10, a8.getExpectedDuration());
        
        assertEquals(0.5, a8.getDistance(), 0.01);
        assertEquals(1.0, a8.getSpeed(), 0.01);
        a8.setDistance(12.34);
        a8.setSpeed(8.88);
        assertEquals(12.34, a8.getDistance(), 0.01);
        assertEquals(8.88, a8.getSpeed(), 0.01);
        
        a8.setDuration(60);
        a8.setCaloricWaste(300);
        a8.setExpectedDuration(123);
        a8.setDesignation("Nova Designação");

        assertEquals(123, a8.getExpectedDuration());
        assertEquals("Nova Designação", a8.getDesignation());
        assertEquals(60, a8.getDuration());
        assertEquals(300, a8.getCaloricWaste());

        var clone = a8.clone();
        assertEquals(a8, clone);
        assertNotNull(a8.toString());
        assertDoesNotThrow(() -> a8.compareTo(clone));
    }
@Test
    public void test_Running_9() {
        Running a9 = new Running(UUID.fromString("53118cff-0f1c-4e77-a804-965f9c27bf07"), MakeItFitDate.of(2001, 2, 24), 26, "ncjQd", "NQr", 50.0, 1.1);
        assertNotNull(a9);
        assertEquals("ncjQd", a9.getDesignation());
        assertEquals("NQr", a9.getName());
        assertEquals(26, a9.getExpectedDuration());
        
        assertEquals(50.0, a9.getDistance(), 0.01);
        assertEquals(1.1, a9.getSpeed(), 0.01);
        a9.setDistance(12.34);
        a9.setSpeed(8.88);
        assertEquals(12.34, a9.getDistance(), 0.01);
        assertEquals(8.88, a9.getSpeed(), 0.01);
        
        a9.setDuration(60);
        a9.setCaloricWaste(300);
        a9.setExpectedDuration(123);
        a9.setDesignation("Nova Designação");

        assertEquals(123, a9.getExpectedDuration());
        assertEquals("Nova Designação", a9.getDesignation());
        assertEquals(60, a9.getDuration());
        assertEquals(300, a9.getCaloricWaste());

        var clone = a9.clone();
        assertEquals(a9, clone);
        assertNotNull(a9.toString());
        assertDoesNotThrow(() -> a9.compareTo(clone));
    }

}