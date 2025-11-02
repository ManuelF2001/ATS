package JUnit_Test;

import MakeItFit.activities.implementation.WeightSquat;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

public class WeightSquatTest {

    @Test
    void testCaloricCalculation() {
        WeightSquat squat = new WeightSquat(
                UUID.randomUUID(),
                new MakeItFitDate(),
                45,
                "Strength",
                "Heavy Squats",
                12,  // repetitions
                4,   // series
                70   // weight (kg)
        );

        squat.calculateCaloricWaste(1.5f);
        int expected = (int) (12 * 4 * 70 * 0.2 * 1.5 * 0.5);
        assertEquals(expected, squat.getCaloricWaste());
    }

    @Test
    void testEquality() {
        WeightSquat squat1 = new WeightSquat(
                UUID.randomUUID(),
                new MakeItFitDate(),
                45,
                "A",
                "A",
                10,
                3,
                60
        );

        WeightSquat squat2 = new WeightSquat(squat1);
        assertTrue(squat1.equals(squat2));
    }

    @Test
    void testCloneMethod() {
        WeightSquat original = new WeightSquat(
                UUID.randomUUID(),
                new MakeItFitDate(),
                30,
                "Endurance",
                "Light Squats",
                15,
                3,
                50
        );

        WeightSquat clone = original.clone();
        assertEquals(original, clone);
        assertNotSame(original, clone);
    }

    @Test
    void testToStringMethod() {
        WeightSquat squat = new WeightSquat(
                UUID.randomUUID(),
                new MakeItFitDate(),
                20,
                "Cardio",
                "Quick Squats",
                10,
                2,
                40
        );

        String expected = squat.toString();
        assertNotNull(expected);
        assertTrue(expected.contains("Quick Squats"));
    }

    @Test
    void testCaloricCalculationWithZeroIndex() {
        WeightSquat squat = new WeightSquat(
                UUID.randomUUID(),
                new MakeItFitDate(),
                60,
                "Strength",
                "Zero Index Squats",
                10,
                5,
                80
        );

        squat.calculateCaloricWaste(0.0f);
        assertEquals(0, squat.getCaloricWaste());
    }

    @Test
    void testCaloricCalculationWithNegativeWeight() {
        WeightSquat squat = new WeightSquat(
                UUID.randomUUID(),
                new MakeItFitDate(),
                30,
                "Strength",
                "Negative Weight Squats",
                10,
                3,
                -50 // Negative weight
        );

        squat.calculateCaloricWaste(1.0f);
        int expected = (int) (10 * 3 * -50 * 0.2 * 1.0 * 0.5); // -150
        assertEquals(expected, squat.getCaloricWaste());
    }

    @Test
    void testCaloricCalculationWithZeroRepetitions() {
        WeightSquat squat = new WeightSquat(
                UUID.randomUUID(),
                new MakeItFitDate(),
                30,
                "Strength",
                "Zero Repetition Squats",
                0, // Zero repetitions
                3,
                50
        );

        squat.calculateCaloricWaste(1.0f);
        assertEquals(0, squat.getCaloricWaste());
    }

    @Test
    void testCaloricCalculationWithNegativeSeries() {
        WeightSquat squat = new WeightSquat(
                UUID.randomUUID(),
                new MakeItFitDate(),
                30,
                "Strength",
                "Negative Series Squats",
                10,
                -3, // Negative series
                50
        );

        squat.calculateCaloricWaste(1.0f);
        int expected = (int) (10 * -3 * 50 * 0.2 * 1.0 * 0.5); // -150
        assertEquals(expected, squat.getCaloricWaste());
    }

    @Test
    void testCaloricCalculationWithLargeIndex() {
        WeightSquat squat = new WeightSquat(
                UUID.randomUUID(),
                new MakeItFitDate(),
                30,
                "Strength",
                "Large Index Squats",
                10,
                3,
                50
        );

        squat.calculateCaloricWaste(1000.0f); // Large index value
        int expected = (int) (10 * 3 * 50 * 0.2 * 1000.0 * 0.5);
        assertEquals(expected, squat.getCaloricWaste());
    }

    @Test
    void testCaloricCalculationWithAllZeroValues() {
        WeightSquat squat = new WeightSquat(
                UUID.randomUUID(),
                new MakeItFitDate(),
                0, // Zero duration
                "Strength",
                "Zero Values Squats",
                0, // Zero repetitions
                0, // Zero series
                0.0 // Zero weight
        );

        squat.calculateCaloricWaste(1.0f);
        assertEquals(0, squat.getCaloricWaste());
    }
}