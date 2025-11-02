package test_jqwil;

import MakeItFit.users.*;
import MakeItFit.users.types.*;
import MakeItFit.activities.Activity;
import MakeItFit.users.Gender;
import net.jqwik.api.*;
import MakeItFit.users.types.Professional;

import net.jqwik.api.constraints.*;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UtilizadorPropriedades {

    @Provide
    Arbitrary<Professional> users() {
        Arbitrary<String> nome = Arbitraries.strings().withCharRange('a', 'z').ofMinLength(3).ofMaxLength(12);
        Arbitrary<Integer> idade = Arbitraries.integers().between(18, 90);
        Arbitrary<Gender> genero = Arbitraries.of(Gender.Male, Gender.Female, Gender.Other);
        Arbitrary<Float> peso = Arbitraries.floats().between(30.0f, 150.0f);
        Arbitrary<Integer> altura = Arbitraries.integers().between(120, 220);
        Arbitrary<Integer> bpm = Arbitraries.integers().between(40, 180);
        Arbitrary<Integer> nivel = Arbitraries.integers().between(1, 10);
        Arbitrary<String> morada = Arbitraries.strings().withCharRange('A', 'Z').ofMinLength(5).ofMaxLength(15);
        Arbitrary<String> telefone = Arbitraries.strings().numeric().ofLength(9);
        Arbitrary<String> email = Arbitraries.strings().ofMinLength(5).ofMaxLength(10)
                .map(s -> s + "@mail.pt");
        Arbitrary<Integer> freq = Arbitraries.integers().between(1, 7);

        // Usar Combinator8 em vez de Arbitrary<Tuple8>
        // 1. Agrupar 8 primeiros como Tuple8
        Arbitrary<Tuple.Tuple8<String, Integer, Gender, Float, Integer, Integer, Integer, String>> base =
                Combinators.combine(nome, idade, genero, peso, altura, bpm, nivel, morada)
                        .as(Tuple::of);

        // 2. Combinar com os restantes campos
        return Combinators.combine(base, telefone, email, freq)
                .as((t, tel, em, fr) ->
                        new Professional(
                                t.get1(), t.get2(), t.get3(), t.get4(), t.get5(), t.get6(),
                                t.get7(), t.get8(), tel, em, fr
                        )
                );


    }


    @Property
    boolean indiceDeveSerPositivo(@ForAll("users") User u) {
        return u.getIndex() > 0;
    }

    @Property
    boolean emailDeveConterArroba(@ForAll("users") User u) {
        return u.getEmail().contains("@");
    }

    @Property
    boolean atividadesIniciaisDevemSerVazias(@ForAll("users") User u) {
        return u.getListActivities().isEmpty();
    }

    @Property
    boolean cloneDeveSerIgual(@ForAll("users") User u) {
        return u.equals(u.clone());
    }

    @Property
    boolean camposNumericosDevemSerPositivos(@ForAll("users") User u) {
        return u.getAge() >= 0 && u.getWeight() >= 0 && u.getHeight() >= 0 && u.getBpm() >= 0;
    }
}


