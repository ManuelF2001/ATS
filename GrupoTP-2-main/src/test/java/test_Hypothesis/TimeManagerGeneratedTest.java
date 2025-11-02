package test_Hypothesis;

import MakeItFit.time.TimeManager;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimeManagerGeneratedTest {

@Test
    public void testTimeManager_0() {
        MakeItFitDate data = MakeItFitDate.of(2012, 7, 1);
        TimeManager tm = new TimeManager(data);
        assertEquals(data, tm.getCurrentDate());

        MakeItFitDate nova = tm.advanceTime(5);
        assertEquals(MakeItFitDate.of(2012, 7, 6), nova);

        assertThrows(IllegalArgumentException.class, () -> tm.advanceTime(-1));
    }
@Test
    public void testMakeItFitDate_0() {
        // fromString e toString
        MakeItFitDate data = MakeItFitDate.fromString("01/07/2012");
        assertEquals("01/07/2012", data.toString());

        // clone
        MakeItFitDate copia = data.clone();
        assertEquals(data.toString(), copia.toString());

        // distance
        MakeItFitDate nova = MakeItFitDate.of(2012, 7, 11);
        int distancia = data.distance(nova);
        assertEquals(10, distancia);

        // comparações
        assertTrue(data.isBeforeOrSame(nova));
        assertTrue(nova.isAfterOrSame(data));
        assertFalse(data.isAfterOrSame(nova));
    }
@Test
    public void testTimeManager_1() {
        MakeItFitDate data = MakeItFitDate.of(2003, 4, 21);
        TimeManager tm = new TimeManager(data);
        assertEquals(data, tm.getCurrentDate());

        MakeItFitDate nova = tm.advanceTime(5);
        assertEquals(MakeItFitDate.of(2003, 4, 26), nova);

        assertThrows(IllegalArgumentException.class, () -> tm.advanceTime(-1));
    }
@Test
    public void testMakeItFitDate_1() {
        // fromString e toString
        MakeItFitDate data = MakeItFitDate.fromString("21/04/2003");
        assertEquals("21/04/2003", data.toString());

        // clone
        MakeItFitDate copia = data.clone();
        assertEquals(data.toString(), copia.toString());

        // distance
        MakeItFitDate nova = MakeItFitDate.of(2003, 5, 1);
        int distancia = data.distance(nova);
        assertEquals(10, distancia);

        // comparações
        assertTrue(data.isBeforeOrSame(nova));
        assertTrue(nova.isAfterOrSame(data));
        assertFalse(data.isAfterOrSame(nova));
    }
@Test
    public void testTimeManager_2() {
        MakeItFitDate data = MakeItFitDate.of(2006, 12, 22);
        TimeManager tm = new TimeManager(data);
        assertEquals(data, tm.getCurrentDate());

        MakeItFitDate nova = tm.advanceTime(5);
        assertEquals(MakeItFitDate.of(2006, 12, 27), nova);

        assertThrows(IllegalArgumentException.class, () -> tm.advanceTime(-1));
    }
@Test
    public void testMakeItFitDate_2() {
        // fromString e toString
        MakeItFitDate data = MakeItFitDate.fromString("22/12/2006");
        assertEquals("22/12/2006", data.toString());

        // clone
        MakeItFitDate copia = data.clone();
        assertEquals(data.toString(), copia.toString());

        // distance
        MakeItFitDate nova = MakeItFitDate.of(2007, 1, 1);
        int distancia = data.distance(nova);
        assertEquals(10, distancia);

        // comparações
        assertTrue(data.isBeforeOrSame(nova));
        assertTrue(nova.isAfterOrSame(data));
        assertFalse(data.isAfterOrSame(nova));
    }
@Test
    public void testTimeManager_3() {
        MakeItFitDate data = MakeItFitDate.of(2000, 1, 1);
        TimeManager tm = new TimeManager(data);
        assertEquals(data, tm.getCurrentDate());

        MakeItFitDate nova = tm.advanceTime(5);
        assertEquals(MakeItFitDate.of(2000, 1, 6), nova);

        assertThrows(IllegalArgumentException.class, () -> tm.advanceTime(-1));
    }
@Test
    public void testMakeItFitDate_3() {
        // fromString e toString
        MakeItFitDate data = MakeItFitDate.fromString("01/01/2000");
        assertEquals("01/01/2000", data.toString());

        // clone
        MakeItFitDate copia = data.clone();
        assertEquals(data.toString(), copia.toString());

        // distance
        MakeItFitDate nova = MakeItFitDate.of(2000, 1, 11);
        int distancia = data.distance(nova);
        assertEquals(10, distancia);

        // comparações
        assertTrue(data.isBeforeOrSame(nova));
        assertTrue(nova.isAfterOrSame(data));
        assertFalse(data.isAfterOrSame(nova));
    }
@Test
    public void testTimeManager_4() {
        MakeItFitDate data = MakeItFitDate.of(2022, 12, 1);
        TimeManager tm = new TimeManager(data);
        assertEquals(data, tm.getCurrentDate());

        MakeItFitDate nova = tm.advanceTime(5);
        assertEquals(MakeItFitDate.of(2022, 12, 6), nova);

        assertThrows(IllegalArgumentException.class, () -> tm.advanceTime(-1));
    }
@Test
    public void testMakeItFitDate_4() {
        // fromString e toString
        MakeItFitDate data = MakeItFitDate.fromString("01/12/2022");
        assertEquals("01/12/2022", data.toString());

        // clone
        MakeItFitDate copia = data.clone();
        assertEquals(data.toString(), copia.toString());

        // distance
        MakeItFitDate nova = MakeItFitDate.of(2022, 12, 11);
        int distancia = data.distance(nova);
        assertEquals(10, distancia);

        // comparações
        assertTrue(data.isBeforeOrSame(nova));
        assertTrue(nova.isAfterOrSame(data));
        assertFalse(data.isAfterOrSame(nova));
    }
@Test
    public void testTimeManager_5() {
        MakeItFitDate data = MakeItFitDate.of(2014, 1, 1);
        TimeManager tm = new TimeManager(data);
        assertEquals(data, tm.getCurrentDate());

        MakeItFitDate nova = tm.advanceTime(5);
        assertEquals(MakeItFitDate.of(2014, 1, 6), nova);

        assertThrows(IllegalArgumentException.class, () -> tm.advanceTime(-1));
    }
@Test
    public void testMakeItFitDate_5() {
        // fromString e toString
        MakeItFitDate data = MakeItFitDate.fromString("01/01/2014");
        assertEquals("01/01/2014", data.toString());

        // clone
        MakeItFitDate copia = data.clone();
        assertEquals(data.toString(), copia.toString());

        // distance
        MakeItFitDate nova = MakeItFitDate.of(2014, 1, 11);
        int distancia = data.distance(nova);
        assertEquals(10, distancia);

        // comparações
        assertTrue(data.isBeforeOrSame(nova));
        assertTrue(nova.isAfterOrSame(data));
        assertFalse(data.isAfterOrSame(nova));
    }
@Test
    public void testTimeManager_6() {
        MakeItFitDate data = MakeItFitDate.of(2006, 10, 5);
        TimeManager tm = new TimeManager(data);
        assertEquals(data, tm.getCurrentDate());

        MakeItFitDate nova = tm.advanceTime(5);
        assertEquals(MakeItFitDate.of(2006, 10, 10), nova);

        assertThrows(IllegalArgumentException.class, () -> tm.advanceTime(-1));
    }
@Test
    public void testMakeItFitDate_6() {
        // fromString e toString
        MakeItFitDate data = MakeItFitDate.fromString("05/10/2006");
        assertEquals("05/10/2006", data.toString());

        // clone
        MakeItFitDate copia = data.clone();
        assertEquals(data.toString(), copia.toString());

        // distance
        MakeItFitDate nova = MakeItFitDate.of(2006, 10, 15);
        int distancia = data.distance(nova);
        assertEquals(10, distancia);

        // comparações
        assertTrue(data.isBeforeOrSame(nova));
        assertTrue(nova.isAfterOrSame(data));
        assertFalse(data.isAfterOrSame(nova));
    }
@Test
    public void testTimeManager_7() {
        MakeItFitDate data = MakeItFitDate.of(2016, 5, 21);
        TimeManager tm = new TimeManager(data);
        assertEquals(data, tm.getCurrentDate());

        MakeItFitDate nova = tm.advanceTime(5);
        assertEquals(MakeItFitDate.of(2016, 5, 26), nova);

        assertThrows(IllegalArgumentException.class, () -> tm.advanceTime(-1));
    }
@Test
    public void testMakeItFitDate_7() {
        // fromString e toString
        MakeItFitDate data = MakeItFitDate.fromString("21/05/2016");
        assertEquals("21/05/2016", data.toString());

        // clone
        MakeItFitDate copia = data.clone();
        assertEquals(data.toString(), copia.toString());

        // distance
        MakeItFitDate nova = MakeItFitDate.of(2016, 5, 31);
        int distancia = data.distance(nova);
        assertEquals(10, distancia);

        // comparações
        assertTrue(data.isBeforeOrSame(nova));
        assertTrue(nova.isAfterOrSame(data));
        assertFalse(data.isAfterOrSame(nova));
    }
@Test
    public void testTimeManager_8() {
        MakeItFitDate data = MakeItFitDate.of(2001, 10, 8);
        TimeManager tm = new TimeManager(data);
        assertEquals(data, tm.getCurrentDate());

        MakeItFitDate nova = tm.advanceTime(5);
        assertEquals(MakeItFitDate.of(2001, 10, 13), nova);

        assertThrows(IllegalArgumentException.class, () -> tm.advanceTime(-1));
    }
@Test
    public void testMakeItFitDate_8() {
        // fromString e toString
        MakeItFitDate data = MakeItFitDate.fromString("08/10/2001");
        assertEquals("08/10/2001", data.toString());

        // clone
        MakeItFitDate copia = data.clone();
        assertEquals(data.toString(), copia.toString());

        // distance
        MakeItFitDate nova = MakeItFitDate.of(2001, 10, 18);
        int distancia = data.distance(nova);
        assertEquals(10, distancia);

        // comparações
        assertTrue(data.isBeforeOrSame(nova));
        assertTrue(nova.isAfterOrSame(data));
        assertFalse(data.isAfterOrSame(nova));
    }
@Test
    public void testTimeManager_9() {
        MakeItFitDate data = MakeItFitDate.of(2000, 1, 1);
        TimeManager tm = new TimeManager(data);
        assertEquals(data, tm.getCurrentDate());

        MakeItFitDate nova = tm.advanceTime(5);
        assertEquals(MakeItFitDate.of(2000, 1, 6), nova);

        assertThrows(IllegalArgumentException.class, () -> tm.advanceTime(-1));
    }
@Test
    public void testMakeItFitDate_9() {
        // fromString e toString
        MakeItFitDate data = MakeItFitDate.fromString("01/01/2000");
        assertEquals("01/01/2000", data.toString());

        // clone
        MakeItFitDate copia = data.clone();
        assertEquals(data.toString(), copia.toString());

        // distance
        MakeItFitDate nova = MakeItFitDate.of(2000, 1, 11);
        int distancia = data.distance(nova);
        assertEquals(10, distancia);

        // comparações
        assertTrue(data.isBeforeOrSame(nova));
        assertTrue(nova.isAfterOrSame(data));
        assertFalse(data.isAfterOrSame(nova));
    }

}