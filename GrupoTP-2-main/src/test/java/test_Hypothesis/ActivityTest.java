package test_Hypothesis;
import MakeItFit.activities.implementation.PushUp;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ActivityTest {

    @Test
    public void testGettersAndEqualsAndCompareTo() {
        UUID userCode = UUID.randomUUID();
        MakeItFitDate date = MakeItFitDate.of(2024, 5, 1);
        PushUp act = new PushUp(userCode, date, 30, "Test", "PushUp", 10, 2);

        // getUserCode
        assertNotNull(act.getUserCode());

        // getCode
        assertNotNull(act.getCode());

        // getRealizationDate
        assertNotNull(act.getRealizationDate());

        // getExpectedDuration
        assertEquals(30, act.getExpectedDuration());

        // getDesignation
        assertEquals("Test", act.getDesignation());

        // getName
        assertEquals("PushUp", act.getName());

        // getDuration (default 0, set and get)
        act.setDuration(42);
        assertEquals(42, act.getDuration());

        // getCaloricWaste (default 0, set and get)
        act.setCaloricWaste(123);
        assertEquals(123, act.getCaloricWaste());

        // calculateCaloricWaste is called by updateActivity
        act.setCaloricWaste(0);
        act.updateActivity(1.5f);
        assertTrue(act.getCaloricWaste() > 0);

        // equals: reflexive, null, different type, and different object
        assertTrue(act.equals(act));
        assertFalse(act.equals(null));
        assertFalse(act.equals("not an activity"));

        PushUp act2 = new PushUp(userCode, date, 30, "Test", "PushUp", 10, 2);
        assertTrue(act.equals(act2));

        PushUp act3 = new PushUp(userCode, date, 31, "Test", "PushUp", 10, 2);
        assertFalse(act.equals(act3));

        PushUp act4 = new PushUp(userCode, date, 30, "Other", "PushUp", 10, 2);
        assertFalse(act.equals(act4));

        // toString
        assertNotNull(act.toString());
        assertFalse(act.toString().isEmpty());

        // compareTo: same date, different expectedDuration
        PushUp act5 = new PushUp(userCode, date, 25, "Test", "PushUp", 10, 2);
        assertTrue(act.compareTo(act5) > 0);

        // compareTo: different date
        PushUp act6 = new PushUp(userCode, MakeItFitDate.of(2023, 1, 1), 30, "Test", "PushUp", 10, 2);
        assertTrue(act.compareTo(act6) > 0 || act.compareTo(act6) < 0);

        // clone
        PushUp clone = (PushUp) act.clone();
        assertEquals(act, clone);
    }
}