package JUnit_Test;
import MakeItFit.activities.Activity;
import MakeItFit.activities.types.DistanceWithAltimetry;
import MakeItFit.activities.implementation.Trail;
import MakeItFit.queries.HowManyAltimetryDone;
import MakeItFit.users.User;
import MakeItFit.users.UserManager;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class HowManyAltimetryDoneTest {
    private UserManager userManager;
    private HowManyAltimetryDone query;
    private MakeItFitDate date1, date2;

    // Manual stub for UserManager
    static class StubUserManager extends UserManager {
        private User user;

        public StubUserManager(User user) {
            this.user = user;
        }

        @Override
        public User getUserByEmail(String email) {
            return user;
        }
    }

    // Manual stub for User
    static class StubUser extends User {
        private List<DistanceWithAltimetry> activities = new ArrayList<>();

        public void addActivity(DistanceWithAltimetry activity) {
            activities.add(activity);
        }

        @Override
        public List<Activity> getListActivities() {
            return new ArrayList<>(activities);
        }

        @Override
        public User clone() {
            return null;
        }
    }

    @BeforeEach
    void setUp() {
        date1 = MakeItFitDate.fromString("01/01/2023");
        date2 = MakeItFitDate.fromString("01/01/2024");
        query = new HowManyAltimetryDone();
    }

    @Test
    void testExecuteQueryWithDates() {
        // Create real objects
        StubUser user = new StubUser();
        user.addActivity(new Trail(UUID.randomUUID(), date1.plusDays(10), 60, "Trail1", "Trail", 5000, 300, 150, Trail.TRAIL_TYPE_MEDIUM));
        user.addActivity(new Trail(UUID.randomUUID(), date1.plusDays(20), 60, "Trail2", "Trail", 8000, 500, 250, Trail.TRAIL_TYPE_HARD));

        userManager = new StubUserManager(user);

        double result = query.executeQuery(userManager, "test@example.com", date1, date2);
        assertEquals(1200.0, result); // (300+150) + (500+250) = 1200
    }

    @Test
    void testExecuteQueryWithoutDates() {
        StubUser user = new StubUser();
        user.addActivity(new Trail(UUID.randomUUID(), date1, 60, "Trail", "Trail", 5000, 300, 150, Trail.TRAIL_TYPE_MEDIUM));

        userManager = new StubUserManager(user);

        double result = query.executeQuery(userManager, "test@example.com");
        assertEquals(450.0, result); // 300 + 150
    }

    @Test
    void testExecuteQueryWithInvalidDates() {
        assertThrows(IllegalArgumentException.class, () -> {
            query.executeQuery(new StubUserManager(new StubUser()), "test@example.com", date2, date1);
        });
    }
    @Test
    void testExecuteQueryWithNoActivities() {
        StubUser user = new StubUser();
        userManager = new StubUserManager(user);

        double result = query.executeQuery(userManager, "test@example.com");
        assertEquals(0.0, result); // No activities, altimetry should be 0
    }

    @Test
    void testExecuteQueryWithDatesAndNoActivities() {
        StubUser user = new StubUser();
        userManager = new StubUserManager(user);

        double result = query.executeQuery(userManager, "test@example.com", date1, date2);
        assertEquals(0.0, result); // No activities, altimetry should be 0
    }
    @Test
    void testExecuteQueryWithActivitiesOutsideDateRange() {
        StubUser user = new StubUser();
        user.addActivity(new Trail(UUID.randomUUID(), date1, 60, "Trail", "Trail", 5000, 300, 150, Trail.TRAIL_TYPE_MEDIUM));
        user.addActivity(new Trail(UUID.randomUUID(), date2.plusDays(10), 60, "Trail", "Trail", 8000, 500, 250, Trail.TRAIL_TYPE_HARD));

        userManager = new StubUserManager(user);

        double result = query.executeQuery(userManager, "test@example.com", date1, date2);
        assertEquals(0.0, result); // Activities outside the range, altimetry should be 0
    }
    @Test
    void testExecuteQueryWithOverlappingActivities() {
        StubUser user = new StubUser();
        user.addActivity(new Trail(UUID.randomUUID(), date1.plusDays(5), 60, "Trail1", "Trail", 5000, 300, 150, Trail.TRAIL_TYPE_MEDIUM));
        user.addActivity(new Trail(UUID.randomUUID(), date1.plusDays(15), 60, "Trail2", "Trail", 8000, 500, 250, Trail.TRAIL_TYPE_HARD));
        user.addActivity(new Trail(UUID.randomUUID(), date2.plusDays(1), 60, "Trail3", "Trail", 10000, 700, 350, Trail.TRAIL_TYPE_HARD));

        userManager = new StubUserManager(user);

        double result = query.executeQuery(userManager, "test@example.com", date1, date2);
        assertEquals(1200.0, result); // Only activities within the range should be summed
    }
    /* 
    @Test
    void testExecuteQueryWithInvalidEmail() {
        StubUser user = new StubUser();
        user.addActivity(new Trail(UUID.randomUUID(), date1.plusDays(10), 60, "Trail", "Trail", 5000, 300, 150, Trail.TRAIL_TYPE_MEDIUM));

        userManager = new StubUserManager(user);

        assertThrows(NullPointerException.class, () -> {
            query.executeQuery(userManager, "invalid@example.com", date1, date2);
        });
    }
*/

    @Test
    void testExecuteQueryWithZeroElevationActivities() {
        StubUser user = new StubUser();
        user.addActivity(new Trail(UUID.randomUUID(), date1.plusDays(10), 60, "Trail", "Trail", 5000, 0, 0, Trail.TRAIL_TYPE_MEDIUM));

        userManager = new StubUserManager(user);

        double result = query.executeQuery(userManager, "test@example.com", date1, date2);
        assertEquals(0.0, result); // Zero elevation gain/loss, altimetry should be 0
    }
    @Test
    void testExecuteQueryWithNegativeElevationActivities() {
        StubUser user = new StubUser();
        user.addActivity(new Trail(UUID.randomUUID(), date1.plusDays(10), 60, "Trail", "Trail", 5000, -300, -150, Trail.TRAIL_TYPE_MEDIUM));

        userManager = new StubUserManager(user);

        double result = query.executeQuery(userManager, "test@example.com", date1, date2);
        assertEquals(-450.0, result); // Negative elevation gain/loss should be summed correctly
    }
}