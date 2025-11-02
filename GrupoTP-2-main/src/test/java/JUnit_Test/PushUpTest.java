package JUnit_Test;

import MakeItFit.utils.MakeItFitDate;
import MakeItFit.activities.implementation.PushUp;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

public class PushUpTest {

    @Test
    void testCaloricCalculation() {
        PushUp pushUp = new PushUp(
                UUID.randomUUID(),
                new MakeItFitDate(),
                30,
                "Strength",
                "Pushups",
                15,  // repetitions
                4    // series
        );

        pushUp.calculateCaloricWaste(1.5f);
        assertEquals(9, pushUp.getCaloricWaste()); // 15*4*1.5*0.1 = 9
    }

    @Test
    void testClone() {
        PushUp original = new PushUp(
                UUID.randomUUID(),
                new MakeItFitDate(),
                30,
                "Strength",
                "Pushups",
                10,
                3
        );

        PushUp clone = original.clone();
        assertNotSame(original, clone);
        assertEquals(original.getRepetitions(), clone.getRepetitions());
        assertEquals(original.getSeries(), clone.getSeries());
    }
    @Test
    void testDefaultConstructor() {
        PushUp pushUp = new PushUp();
        assertNotNull(pushUp);
        assertEquals(0, pushUp.getRepetitions());
        assertEquals(0, pushUp.getSeries());
    }
    @Test
    void testEquals() {
        UUID userCode = UUID.randomUUID();
        MakeItFitDate date = new MakeItFitDate();
        PushUp pushUp1 = new PushUp(userCode, date, 20, "Strength", "Pushups", 10, 3);
        PushUp pushUp2 = new PushUp(userCode, date, 20, "Strength", "Pushups", 10, 3);

        assertTrue(pushUp1.equals(pushUp2));
    }
    @Test
    void testToString() {
        PushUp pushUp = new PushUp(
                UUID.randomUUID(),
                new MakeItFitDate(),
                30,
                "Strength",
                "Pushups",
                15,
                4
        );

        String expected = "PushUp{...}"; // Substitua com o formato esperado
        assertNotNull(pushUp.toString());
        assertTrue(pushUp.toString().contains("Pushups"));
    }
    @Test
    void testCaloricWasteMethod() {
        PushUp pushUp = new PushUp(
                UUID.randomUUID(),
                new MakeItFitDate(),
                30,
                "Strength",
                "Pushups",
                20,  // repetitions
                5    // series
        );

        int caloricWaste = pushUp.caloricWaste(2.0f);
        assertEquals(20, caloricWaste); // 20*5*2.0*0.1 = 20
    }
    @Test
    void testCaloricWasteEdgeCases() {
        PushUp pushUp = new PushUp(
                UUID.randomUUID(),
                new MakeItFitDate(),
                30,
                "Strength",
                "Pushups",
                0,  // repetitions
                0   // series
        );

        assertEquals(0, pushUp.caloricWaste(1.0f)); // 0*0*1.0*0.1 = 0

        assertEquals(0, pushUp.caloricWaste(-1.0f)); // Negative index should result in 0 caloric waste
    }

    @Test
    void testEqualsWithDifferentAttributes() {
        UUID userCode = UUID.randomUUID();
        MakeItFitDate date = new MakeItFitDate();
        PushUp pushUp1 = new PushUp(userCode, date, 20, "Strength", "Pushups", 10, 3);
        PushUp pushUp2 = new PushUp(userCode, date, 20, "Strength", "Pushups", 15, 4);

        assertFalse(pushUp1.equals(pushUp2)); // Different repetitions and series
    }
    @Test
    void testCloneModification() {
        PushUp original = new PushUp(
                UUID.randomUUID(),
                new MakeItFitDate(),
                30,
                "Strength",
                "Pushups",
                10,
                3
        );

        PushUp clone = original.clone();
        clone.setRepetitions(20);
        clone.setSeries(5);

        assertNotEquals(original.getRepetitions(), clone.getRepetitions());
        assertNotEquals(original.getSeries(), clone.getSeries());
    }
    @Test
    void testToStringEdgeCases() {
        PushUp pushUp = new PushUp();
        String result = pushUp.toString();

        assertNotNull(result);
        assertTrue(result.contains("0")); // Default values should be reflected in the string
    }
}