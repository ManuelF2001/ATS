package JUnit_Test;

import MakeItFit.activities.ActivityManager;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ActivityManagerTest {

    @Test
    void testGetRandomActivity() {
        ActivityManager manager = new ActivityManager();
        List<String> validActivities = Arrays.asList("PushUp", "Running", "Trail", "WeightSquat");

        for (int i = 0; i < 10; i++) {
            String activity = manager.getRandomActivity();
            assertTrue(validActivities.contains(activity));
        }
    }
    @Test
    void testRandomActivityNotNull() {
        ActivityManager manager = new ActivityManager();

        for (int i = 0; i < 10; i++) {
            String activity = manager.getRandomActivity();
            assertNotNull(activity);
        }
    }

    @Test
    void testRandomActivityConsistency() {
        ActivityManager manager = new ActivityManager();
        List<String> validActivities = Arrays.asList("PushUp", "Running", "Trail", "WeightSquat");

        for (int i = 0; i < 100; i++) {
            String activity = manager.getRandomActivity();
            assertTrue(validActivities.contains(activity));
        }
    }
    @Test
    void testRandomActivityAlwaysValid() {
        ActivityManager manager = new ActivityManager();
        List<String> validActivities = Arrays.asList("PushUp", "Running", "Trail", "WeightSquat");

        for (int i = 0; i < 1000; i++) {
            String activity = manager.getRandomActivity();
            assertTrue(validActivities.contains(activity), "Invalid activity returned: " + activity);
        }
    }

    @Test
    void testRandomActivityDistribution() {
        ActivityManager manager = new ActivityManager();
        Map<String, Integer> activityCount = new HashMap<>();
        List<String> validActivities = Arrays.asList("PushUp", "Running", "Trail", "WeightSquat");

        for (String activity : validActivities) {
            activityCount.put(activity, 0);
        }

        for (int i = 0; i < 10000; i++) {
            String activity = manager.getRandomActivity();
            assertTrue(validActivities.contains(activity), "Invalid activity returned: " + activity);
            activityCount.put(activity, activityCount.get(activity) + 1);
        }

        for (String activity : validActivities) {
            assertTrue(activityCount.get(activity) > 0, "Activity " + activity + " was never returned.");
        }
    }

    @Test
    void testRandomActivityEdgeCases() {
        ActivityManager manager = new ActivityManager();
        List<String> validActivities = Arrays.asList("PushUp", "Running", "Trail", "WeightSquat");

        for (int i = 0; i < 100; i++) {
            String activity = manager.getRandomActivity();
            assertNotNull(activity, "Activity returned is null.");
            assertTrue(validActivities.contains(activity), "Invalid activity returned: " + activity);
        }
    }

    @Test
    void testRandomActivityStressTest() {
        ActivityManager manager = new ActivityManager();

        for (int i = 0; i < 100000; i++) {
            String activity = manager.getRandomActivity();
            assertNotNull(activity, "Activity returned is null.");
        }
    }

}