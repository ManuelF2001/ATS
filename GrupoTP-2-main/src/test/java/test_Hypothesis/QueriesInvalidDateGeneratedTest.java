package test_Hypothesis;

import MakeItFit.queries.QueriesManager;
import MakeItFit.users.UserManager;
import MakeItFit.trainingPlan.TrainingPlanManager;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueriesInvalidDateGeneratedTest {

@Test
    public void testHowManyAltimetryDone_InvalidDates_0_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyAltimetryDone(
                new UserManager(),
                "user@example.com",
                MakeItFitDate.of(2024, 6, 22),
                MakeItFitDate.of(2020, 2, 14)
            );
        });
    }

@Test
    public void testHowManyKMsDone_InvalidDates_0_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyKMsDone(
                new UserManager(),
                "user@example.com",
                MakeItFitDate.of(2024, 6, 22),
                MakeItFitDate.of(2020, 2, 14)
            );
        });
    }

@Test
    public void testWhoBurnsMoreCalories_InvalidDates_0_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQuerywhoBurnsMoreCalories(
                new UserManager(),
                MakeItFitDate.of(2024, 6, 22),
                MakeItFitDate.of(2020, 2, 14)
            );
        });
    }

@Test
    public void testWhoDidTheMostActivities_InvalidDates_0_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryWhoDidTheMostActivities(
                new UserManager(),
                MakeItFitDate.of(2024, 6, 22),
                MakeItFitDate.of(2020, 2, 14)
            );
        });
    }

@Test
    public void testHowManyAltimetryDone_InvalidDates_1_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyAltimetryDone(
                new UserManager(),
                "user@example.com",
                MakeItFitDate.of(2020, 4, 11),
                MakeItFitDate.of(2018, 12, 25)
            );
        });
    }

@Test
    public void testHowManyKMsDone_InvalidDates_1_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyKMsDone(
                new UserManager(),
                "user@example.com",
                MakeItFitDate.of(2020, 4, 11),
                MakeItFitDate.of(2018, 12, 25)
            );
        });
    }

@Test
    public void testWhoBurnsMoreCalories_InvalidDates_1_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQuerywhoBurnsMoreCalories(
                new UserManager(),
                MakeItFitDate.of(2020, 4, 11),
                MakeItFitDate.of(2018, 12, 25)
            );
        });
    }

@Test
    public void testWhoDidTheMostActivities_InvalidDates_1_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryWhoDidTheMostActivities(
                new UserManager(),
                MakeItFitDate.of(2020, 4, 11),
                MakeItFitDate.of(2018, 12, 25)
            );
        });
    }

@Test
    public void testHowManyAltimetryDone_InvalidDates_2_data1_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyAltimetryDone(
                new UserManager(),
                "user@example.com",
                null,
                MakeItFitDate.of(2024, 5, 10)
            );
        });
    }

@Test
    public void testHowManyKMsDone_InvalidDates_2_data1_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyKMsDone(
                new UserManager(),
                "user@example.com",
                null,
                MakeItFitDate.of(2024, 5, 10)
            );
        });
    }

@Test
    public void testWhoBurnsMoreCalories_InvalidDates_2_data1_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQuerywhoBurnsMoreCalories(
                new UserManager(),
                null,
                MakeItFitDate.of(2024, 5, 10)
            );
        });
    }

@Test
    public void testWhoDidTheMostActivities_InvalidDates_2_data1_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryWhoDidTheMostActivities(
                new UserManager(),
                null,
                MakeItFitDate.of(2024, 5, 10)
            );
        });
    }

@Test
    public void testHowManyAltimetryDone_InvalidDates_3_data1_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyAltimetryDone(
                new UserManager(),
                "user@example.com",
                null,
                MakeItFitDate.of(2024, 5, 10)
            );
        });
    }

@Test
    public void testHowManyKMsDone_InvalidDates_3_data1_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyKMsDone(
                new UserManager(),
                "user@example.com",
                null,
                MakeItFitDate.of(2024, 5, 10)
            );
        });
    }

@Test
    public void testWhoBurnsMoreCalories_InvalidDates_3_data1_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQuerywhoBurnsMoreCalories(
                new UserManager(),
                null,
                MakeItFitDate.of(2024, 5, 10)
            );
        });
    }

@Test
    public void testWhoDidTheMostActivities_InvalidDates_3_data1_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryWhoDidTheMostActivities(
                new UserManager(),
                null,
                MakeItFitDate.of(2024, 5, 10)
            );
        });
    }

@Test
    public void testHowManyAltimetryDone_InvalidDates_4_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyAltimetryDone(
                new UserManager(),
                "user@example.com",
                MakeItFitDate.of(2024, 11, 4),
                MakeItFitDate.of(2016, 6, 9)
            );
        });
    }

@Test
    public void testHowManyKMsDone_InvalidDates_4_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyKMsDone(
                new UserManager(),
                "user@example.com",
                MakeItFitDate.of(2024, 11, 4),
                MakeItFitDate.of(2016, 6, 9)
            );
        });
    }

@Test
    public void testWhoBurnsMoreCalories_InvalidDates_4_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQuerywhoBurnsMoreCalories(
                new UserManager(),
                MakeItFitDate.of(2024, 11, 4),
                MakeItFitDate.of(2016, 6, 9)
            );
        });
    }

@Test
    public void testWhoDidTheMostActivities_InvalidDates_4_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryWhoDidTheMostActivities(
                new UserManager(),
                MakeItFitDate.of(2024, 11, 4),
                MakeItFitDate.of(2016, 6, 9)
            );
        });
    }

@Test
    public void testHowManyAltimetryDone_InvalidDates_5_data2_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyAltimetryDone(
                new UserManager(),
                "user@example.com",
                MakeItFitDate.of(2024, 5, 10),
                null
            );
        });
    }

@Test
    public void testHowManyKMsDone_InvalidDates_5_data2_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyKMsDone(
                new UserManager(),
                "user@example.com",
                MakeItFitDate.of(2024, 5, 10),
                null
            );
        });
    }

@Test
    public void testWhoBurnsMoreCalories_InvalidDates_5_data2_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQuerywhoBurnsMoreCalories(
                new UserManager(),
                MakeItFitDate.of(2024, 5, 10),
                null
            );
        });
    }

@Test
    public void testWhoDidTheMostActivities_InvalidDates_5_data2_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryWhoDidTheMostActivities(
                new UserManager(),
                MakeItFitDate.of(2024, 5, 10),
                null
            );
        });
    }

@Test
    public void testHowManyAltimetryDone_InvalidDates_6_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyAltimetryDone(
                new UserManager(),
                "user@example.com",
                MakeItFitDate.of(2024, 11, 14),
                MakeItFitDate.of(2016, 1, 15)
            );
        });
    }

@Test
    public void testHowManyKMsDone_InvalidDates_6_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyKMsDone(
                new UserManager(),
                "user@example.com",
                MakeItFitDate.of(2024, 11, 14),
                MakeItFitDate.of(2016, 1, 15)
            );
        });
    }

@Test
    public void testWhoBurnsMoreCalories_InvalidDates_6_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQuerywhoBurnsMoreCalories(
                new UserManager(),
                MakeItFitDate.of(2024, 11, 14),
                MakeItFitDate.of(2016, 1, 15)
            );
        });
    }

@Test
    public void testWhoDidTheMostActivities_InvalidDates_6_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryWhoDidTheMostActivities(
                new UserManager(),
                MakeItFitDate.of(2024, 11, 14),
                MakeItFitDate.of(2016, 1, 15)
            );
        });
    }

@Test
    public void testHowManyAltimetryDone_InvalidDates_7_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyAltimetryDone(
                new UserManager(),
                "user@example.com",
                MakeItFitDate.of(2021, 11, 16),
                MakeItFitDate.of(2017, 4, 15)
            );
        });
    }

@Test
    public void testHowManyKMsDone_InvalidDates_7_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyKMsDone(
                new UserManager(),
                "user@example.com",
                MakeItFitDate.of(2021, 11, 16),
                MakeItFitDate.of(2017, 4, 15)
            );
        });
    }

@Test
    public void testWhoBurnsMoreCalories_InvalidDates_7_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQuerywhoBurnsMoreCalories(
                new UserManager(),
                MakeItFitDate.of(2021, 11, 16),
                MakeItFitDate.of(2017, 4, 15)
            );
        });
    }

@Test
    public void testWhoDidTheMostActivities_InvalidDates_7_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryWhoDidTheMostActivities(
                new UserManager(),
                MakeItFitDate.of(2021, 11, 16),
                MakeItFitDate.of(2017, 4, 15)
            );
        });
    }

@Test
    public void testHowManyAltimetryDone_InvalidDates_8_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyAltimetryDone(
                new UserManager(),
                "user@example.com",
                MakeItFitDate.of(2020, 1, 1),
                MakeItFitDate.of(2015, 1, 1)
            );
        });
    }

@Test
    public void testHowManyKMsDone_InvalidDates_8_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyKMsDone(
                new UserManager(),
                "user@example.com",
                MakeItFitDate.of(2020, 1, 1),
                MakeItFitDate.of(2015, 1, 1)
            );
        });
    }

@Test
    public void testWhoBurnsMoreCalories_InvalidDates_8_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQuerywhoBurnsMoreCalories(
                new UserManager(),
                MakeItFitDate.of(2020, 1, 1),
                MakeItFitDate.of(2015, 1, 1)
            );
        });
    }

@Test
    public void testWhoDidTheMostActivities_InvalidDates_8_data2_antes_ou_igual() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryWhoDidTheMostActivities(
                new UserManager(),
                MakeItFitDate.of(2020, 1, 1),
                MakeItFitDate.of(2015, 1, 1)
            );
        });
    }

@Test
    public void testHowManyAltimetryDone_InvalidDates_9_data1_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyAltimetryDone(
                new UserManager(),
                "user@example.com",
                null,
                MakeItFitDate.of(2024, 5, 10)
            );
        });
    }

@Test
    public void testHowManyKMsDone_InvalidDates_9_data1_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryHowManyKMsDone(
                new UserManager(),
                "user@example.com",
                null,
                MakeItFitDate.of(2024, 5, 10)
            );
        });
    }

@Test
    public void testWhoBurnsMoreCalories_InvalidDates_9_data1_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQuerywhoBurnsMoreCalories(
                new UserManager(),
                null,
                MakeItFitDate.of(2024, 5, 10)
            );
        });
    }

@Test
    public void testWhoDidTheMostActivities_InvalidDates_9_data1_null() {
        QueriesManager qm = new QueriesManager(new UserManager(), new TrainingPlanManager());
        assertThrows(IllegalArgumentException.class, () -> {
            qm.executeQueryWhoDidTheMostActivities(
                new UserManager(),
                null,
                MakeItFitDate.of(2024, 5, 10)
            );
        });
    }

}