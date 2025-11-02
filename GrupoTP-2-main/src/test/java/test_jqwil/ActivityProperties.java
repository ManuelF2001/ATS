package test_jqwil;

import MakeItFit.activities.implementation.*;
import MakeItFit.activities.Activity;
import MakeItFit.users.Gender;
import MakeItFit.utils.MakeItFitDate;
import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

public class ActivityProperties {

    @Provide
    Arbitrary<Running> runningActivities() {
        return Combinators.combine(
                Arbitraries.create(UUID::randomUUID),
                Arbitraries.integers().between(10, 180),
                Arbitraries.strings().ofMinLength(3).ofMaxLength(10),
                Arbitraries.strings().ofMinLength(3).ofMaxLength(10),
                Arbitraries.doubles().between(0.1, 50.0),
                Arbitraries.doubles().between(1.0, 20.0)
        ).as((uuid, duration, designation, name, distance, speed) ->
                new Running(uuid, MakeItFitDate.of(2024, 5, 8), duration, designation, name, distance, speed));
    }


    @Provide
    Arbitrary<PushUp> pushUpActivities() {
        return Combinators.combine(
                Arbitraries.create(UUID::randomUUID),
                Arbitraries.integers().between(10, 180),
                Arbitraries.strings().ofMinLength(3).ofMaxLength(10),
                Arbitraries.strings().ofMinLength(3).ofMaxLength(10),
                Arbitraries.integers().between(1, 50),
                Arbitraries.integers().between(1, 10)
        ).as((uuid, duration, designation, name, reps, series) ->
                new PushUp(uuid, MakeItFitDate.of(2024, 5, 8), duration, designation, name, reps, series));
    }

    @Provide
    Arbitrary<WeightSquat> weightSquatActivities() {
        return Combinators.combine(
                Arbitraries.create(UUID::randomUUID),
                Arbitraries.integers().between(10, 180),
                Arbitraries.strings().ofMinLength(3).ofMaxLength(10),
                Arbitraries.strings().ofMinLength(3).ofMaxLength(10),
                Arbitraries.integers().between(1, 50),
                Arbitraries.integers().between(1, 10),
                Arbitraries.doubles().between(0.0, 100.0)
        ).as((uuid, duration, designation, name, reps, series, weight) ->
                new WeightSquat(uuid, MakeItFitDate.of(2024, 5, 8), duration, designation, name, reps, series, weight));
    }

    @Property
    boolean caloricWasteShouldIncreaseWithIndex(@ForAll("runningActivities") Running r) {
        int low = r.caloricWaste(1.0f);
        int high = r.caloricWaste(3.0f);
        return high >= low;
    }

    @Property
    boolean cloneShouldBeEqualButNotSameInstance(@ForAll("pushUpActivities") PushUp p) {
        PushUp c = p.clone();
        return p.equals(c) && p != c;
    }

    @Property
    boolean expectedDurationAlwaysPositive(@ForAll("runningActivities") Running r) {
        return r.getExpectedDuration() > 0;
    }

    @Property
    boolean weightSquatZeroWeightMeansZeroCalories(@ForAll("weightSquatActivities") WeightSquat ws) {
        ws.setWeight(0);
        return ws.caloricWaste(2.0f) == 0;
    }

    @Property
    boolean pushupCaloriesShouldBeNonNegative(@ForAll("pushUpActivities") PushUp p) {
        return p.caloricWaste(1.5f) >= 0;
    }


    @Property
    boolean runningDistanceNonNegative(@ForAll("runningActivities") Running r) {
        return r.getDistance() >= 0;
    }

    @Property
    boolean runningSpeedNonNegative(@ForAll("runningActivities") Running r) {
        return r.getSpeed() >= 0;
    }

    @Property
    boolean weightSquatCaloriesIncreaseWithWeight(@ForAll("weightSquatActivities") WeightSquat ws) {
        ws.setWeight(5);
        int low = ws.caloricWaste(1.0f);
        ws.setWeight(15);
        int high = ws.caloricWaste(1.0f);
        return high >= low;
    }
}
