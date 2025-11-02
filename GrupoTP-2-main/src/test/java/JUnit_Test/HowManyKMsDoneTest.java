package JUnit_Test;

import MakeItFit.activities.Activity;
import MakeItFit.activities.types.Distance;
import MakeItFit.activities.implementation.Running;
import MakeItFit.queries.HowManyKMsDone;
import MakeItFit.users.User;
import MakeItFit.users.UserManager;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class HowManyKMsDoneTest {
    private UserManager userManager;
    private HowManyKMsDone query;
    private MakeItFitDate date1, date2;

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

    static abstract class StubUser extends User {
        private List<Distance> activities = new ArrayList<>();

        public void addActivity(Distance activity) {
            activities.add(activity);
        }

        @Override
        public List<Activity> getListActivities() {
            return new ArrayList<>(activities);
        }
    }

    @BeforeEach
    void setUp() {
        date1 = MakeItFitDate.fromString("01/01/2023");
        date2 =MakeItFitDate.fromString("01/01/2024");
        query = new HowManyKMsDone();
    }

    @Test
    void testExecuteQueryWithDates() {
        StubUser user = new StubUser() {
            @Override
            public User clone() {
                return null;
            }
        };
        user.addActivity(new Running(UUID.randomUUID(), date1.plusDays(10), 60, "Run1", "Running", 5000, 10));
        user.addActivity(new Running(UUID.randomUUID(), date1.plusDays(20), 60, "Run2", "Running", 8000, 12));

        userManager = new StubUserManager(user);

        double result = query.executeQuery(userManager, "test@example.com", date1, date2);
        assertEquals(13.0, result); // (5000 + 8000) / 1000 = 13 km
    }

    @Test
    void testExecuteQueryWithoutDates() {
        StubUser user = new StubUser() {
            @Override
            public User clone() {
                return null;
            }
        };
        user.addActivity(new Running(UUID.randomUUID(), date1, 60, "Run1", "Running", 5000, 10));

        userManager = new StubUserManager(user);

        double result = query.executeQuery(userManager, "test@example.com");
        assertEquals(5.0, result); // 5000 / 1000 = 5 km
    }
    @Test
    void testExecuteQueryWithEmptyActivityList() {
        StubUser user = new StubUser() {
            @Override
            public User clone() {
                return null;
            }
        };

        userManager = new StubUserManager(user);

        double result = query.executeQuery(userManager, "test@example.com", date1, date2);
        assertEquals(0.0, result); // No activities, distance should be 0
    }

}