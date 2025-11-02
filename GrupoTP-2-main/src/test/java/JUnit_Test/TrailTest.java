package JUnit_Test;

import MakeItFit.activities.implementation.Trail;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import MakeItFit. utils. MakeItFitDate;
public class TrailTest {

    @Test
    void testCaloricCalculation() {
        Trail trail = new Trail(
                UUID.randomUUID(),
                new MakeItFitDate(),
                120,
                "Adventure",
                "Mountain Trail",
                10000, // distance (meters)
                300,   // elevation gain
                150,   // elevation loss
                Trail.TRAIL_TYPE_HARD
        );

        trail.calculateCaloricWaste(1.2f);
        int expected = (int) ((10000 * 0.5 + 300 * 0.1 - 150 * 0.1) * 1.2 * 0.01);
        assertEquals(expected, trail.getCaloricWaste());
    }

    @Test
    void testTrailTypeValidation() {
        Trail trail = new Trail();
        trail.setTrailType(5);
        assertEquals(Trail.TRAIL_TYPE_HARD, trail.getTrailType());

        trail.setTrailType(-1);
        assertEquals(Trail.TRAIL_TYPE_EASY, trail.getTrailType());
    }
    @Test
    void testDefaultTrailType() {
        Trail trail = new Trail();
        assertEquals(Trail.TRAIL_TYPE_EASY, trail.getTrailType());
    }

    @Test
    void testCloneTrail() {
        Trail originalTrail = new Trail(
                UUID.randomUUID(),
                new MakeItFitDate(),
                90,
                "Nature Walk",
                "Forest Trail",
                5000, // distance (meters)
                200,  // elevation gain
                100,  // elevation loss
                Trail.TRAIL_TYPE_MEDIUM
        );

        Trail clonedTrail = originalTrail.clone();
        assertEquals(originalTrail, clonedTrail);
        assertEquals(originalTrail.getTrailType(), clonedTrail.getTrailType());
    }

    @Test
    void testCaloricWasteZero() {
        Trail trail = new Trail(
                UUID.randomUUID(),
                new MakeItFitDate(),
                60,
                "Flat Walk",
                "Park Trail",
                0,    // distance (meters)
                0,    // elevation gain
                0,    // elevation loss
                Trail.TRAIL_TYPE_EASY
        );

        trail.calculateCaloricWaste(1.0f);
        assertEquals(0, trail.getCaloricWaste());
    }
    @Test
    void testNegativeDistance() {
        Trail trail = new Trail(
                UUID.randomUUID(),
                new MakeItFitDate(),
                60,
                "Invalid Distance",
                "Negative Trail",
                -5000, // negative distance
                200,   // elevation gain
                100,   // elevation loss
                Trail.TRAIL_TYPE_MEDIUM
        );

        trail.calculateCaloricWaste(1.0f);
        assertEquals(0, trail.getCaloricWaste());
    }
    @Test
    void testExtremeElevationValues() {
        Trail trail = new Trail(
                UUID.randomUUID(),
                new MakeItFitDate(),
                120,
                "Extreme Elevation",
                "High Altitude Trail",
                10000, // distance (meters)
                10000, // extreme elevation gain
                5000,  // extreme elevation loss
                Trail.TRAIL_TYPE_HARD
        );

        trail.calculateCaloricWaste(1.5f);
        int expected = (int) ((10000 * 0.5 + 10000 * 0.1 - 5000 * 0.1) * 1.5 * 0.01);
        assertEquals(expected, trail.getCaloricWaste());
    }
    @Test
    void testInvalidTrailType() {
        Trail trail = new Trail();
        trail.setTrailType(999); // invalid trail type
        assertEquals(Trail.TRAIL_TYPE_HARD, trail.getTrailType());

        trail.setTrailType(-999); // invalid trail type
        assertEquals(Trail.TRAIL_TYPE_EASY, trail.getTrailType());
    }
    @Test
    void testZeroIndexCaloricWaste() {
        Trail trail = new Trail(
                UUID.randomUUID(),
                new MakeItFitDate(),
                90,
                "Zero Index",
                "Flat Trail",
                5000, // distance (meters)
                200,  // elevation gain
                100,  // elevation loss
                Trail.TRAIL_TYPE_MEDIUM
        );

        trail.calculateCaloricWaste(0.0f);
        assertEquals(0, trail.getCaloricWaste());
    }
    @Test
    void testLargeIndexCaloricWaste() {
        Trail trail = new Trail(
                UUID.randomUUID(),
                new MakeItFitDate(),
                90,
                "Large Index",
                "Long Trail",
                10000, // distance (meters)
                500,   // elevation gain
                300,   // elevation loss
                Trail.TRAIL_TYPE_HARD
        );

        trail.calculateCaloricWaste(1000.0f);
        int expected = (int) ((10000 * 0.5 + 500 * 0.1 - 300 * 0.1) * 1000.0 * 0.01);
        assertEquals(expected, trail.getCaloricWaste());
    }
}
