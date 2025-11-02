package JUnit_Test;

import MakeItFit.activities.implementation.Running;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import MakeItFit.utils.MakeItFitDate;
import static org.junit.jupiter.api.Assertions.*;

public class RunningTest {

    @Test
    void testCaloricCalculation() {
        Running running = new Running(
                UUID.randomUUID(),
                new MakeItFitDate(),
                60,
                "Cardio",
                "Morning Run",
                5000, // distance (meters)
                10    // speed (km/h)
        );

        running.calculateCaloricWaste(1.8f);
        assertEquals(450, running.getCaloricWaste(),1); // 10 * 5000 * 1.8 * 0.005 = 450
    }

    @Test
    void testSpeedHandling() {
        Running running = new Running();
        running.setSpeed(12.5);
        assertEquals(12.5, running.getSpeed());
    }
    @Test
    void testDefaultConstructor() {
        Running running = new Running();
        assertEquals(0, running.getSpeed());
        assertEquals(0, running.getDistance());
        assertNotNull(running.getRealizationDate());
    }

    @Test
    void testCloneMethod() {
        Running original = new Running(
                UUID.randomUUID(),
                new MakeItFitDate(),
                45,
                "Interval Training",
                "Evening Run",
                3000, // distance (meters)
                8.5   // speed (km/h)
        );
        Running clone = original.clone();
        assertEquals(original, clone);
        assertEquals(original.getSpeed(), clone.getSpeed());
        assertEquals(original.getDistance(), clone.getDistance());
    }

    @Test
    void testEqualsMethod() {
        Running running1 = new Running(
                UUID.randomUUID(),
                new MakeItFitDate(),
                30,
                "Sprint",
                "Afternoon Run",
                2000, // distance (meters)
                15    // speed (km/h)
        );
        Running running2 = new Running(
                running1.getUserCode(),
                running1.getRealizationDate(),
                running1.getExpectedDuration(),
                running1.getDesignation(),
                running1.getName(),
                running1.getDistance(),
                running1.getSpeed()
        );
        assertTrue(running1.equals(running2));
        running2.setSpeed(10);
        assertFalse(running1.equals(running2));
    }
    @Test
    void testCaloricWasteEdgeCases() {
        Running running = new Running(
                UUID.randomUUID(),
                new MakeItFitDate(),
                30,
                "Edge Case Test",
                "Boundary Run",
                0,    // distance (meters)
                0     // speed (km/h)
        );
        assertEquals(0, running.caloricWaste(1.8f)); // No distance or speed should result in 0 caloric waste

        running.setSpeed(10);
        running.setDistance(5000);
        assertEquals(450, running.caloricWaste(1.8f),1); // Normal case
    }
    /*
    @Test
    void testToStringMethod() {
        Running running = new Running(
                UUID.randomUUID(),
                new MakeItFitDate(),
                45,
                "Test Description",
                "Test Name",
                3000, // distance (meters)
                8.5   // speed (km/h)
        );
        String expected = "User Code: " + running.getUserCode() +
                "Realization Date: " + running.getRealizationDate() +
                "Expected Duration: 45" +
                "Designation: Test Description" +
                "Name: Test Name" +
                "Distance: 3000.0 meters" +
                "Speed: 8.5 Km/h";
        assertEquals(expected, running.toString());
    }
    */

    @Test
    void testEqualsWithNullAndDifferentTypes() {
        Running running = new Running(
                UUID.randomUUID(),
                new MakeItFitDate(),
                30,
                "Test",
                "Run",
                2000, // distance (meters)
                15    // speed (km/h)
        );
        assertFalse(running.equals(null)); // Should not be equal to null
        assertFalse(running.equals("Not a Running object")); // Should not be equal to a different type
    }
    @Test
    void testCloneWithModifications() {
        Running original = new Running(
                UUID.randomUUID(),
                new MakeItFitDate(),
                60,
                "Original",
                "Clone Test",
                4000, // distance (meters)
                12    // speed (km/h)
        );
        Running clone = original.clone();
        clone.setSpeed(10);
        clone.setDistance(3000);
        assertNotEquals(original, clone); // Modifications should make them unequal
    }
    @Test
    void testSetSpeedInvalidValues() {
        Running running = new Running();
        running.setSpeed(-5); // Negative speed
        assertEquals(-5, running.getSpeed()); // Ensure the class handles invalid values correctly
    }
}