package JUnit_Test;

import MakeItFit.time.TimeManager;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeManagerTest {
    private TimeManager timeManager;
    private MakeItFitDate initialDate;

    @BeforeEach
    void setUp() {
        initialDate = MakeItFitDate.fromString("01/01/2023");
        timeManager = new TimeManager(initialDate);
    }

    @Test
    void testAdvanceTime() {
        MakeItFitDate newDate = timeManager.advanceTime(5);
        assertEquals(initialDate.plusDays(5), newDate);
        assertEquals(newDate, timeManager.getCurrentDate());
    }

    @Test
    void testAdvanceTimeWithNegativeDays() {
        assertThrows(IllegalArgumentException.class, () -> timeManager.advanceTime(-1));
    }

    @Test
    void testGetCurrentDate() {
        assertEquals(initialDate, timeManager.getCurrentDate());
    }
    @Test
    void testAdvanceTimeWithZeroDays() {
        MakeItFitDate newDate = timeManager.advanceTime(0);
        assertEquals(initialDate, newDate);
        assertEquals(initialDate, timeManager.getCurrentDate());
    }
    @Test
    void testAdvanceTimeMultipleCalls() {
        timeManager.advanceTime(5);
        timeManager.advanceTime(10);
        assertEquals(initialDate.plusDays(15), timeManager.getCurrentDate());
    }
    @Test
    void testInvalidDateInput() {
        assertThrows(IllegalArgumentException.class, () -> MakeItFitDate.fromString("invalid-date"));
    }
    @Test
    void testAdvanceTimeWithLargeDays() {
        MakeItFitDate newDate = timeManager.advanceTime(10000);
        assertEquals(initialDate.plusDays(10000), newDate);
    }
    @Test
    void testAdvanceTimeWithBoundaryValues() {
        MakeItFitDate newDate = timeManager.advanceTime(Integer.MAX_VALUE);
        assertEquals(initialDate.plusDays(Integer.MAX_VALUE), newDate);
    }
}