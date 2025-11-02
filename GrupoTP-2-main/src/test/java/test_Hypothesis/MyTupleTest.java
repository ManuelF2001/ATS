package test_Hypothesis;

import MakeItFit.utils.MyTuple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyTupleTest {

    @Test
    void testToStringNotEmpty() {
        MyTuple<String, Integer> tuple = new MyTuple<>("a", 1);
        assertFalse(tuple.toString().isEmpty());
        assertEquals("(a, 1)", tuple.toString());
    }

    @Test
    void testEqualsReflexive() {
        MyTuple<String, Integer> tuple = new MyTuple<>("a", 1);
        assertTrue(tuple.equals(tuple));
    }

    @Test
    void testEqualsNull() {
        MyTuple<String, Integer> tuple = new MyTuple<>("a", 1);
        assertFalse(tuple.equals(null));
    }

    @Test
    void testEqualsDifferentClass() {
        MyTuple<String, Integer> tuple = new MyTuple<>("a", 1);
        assertFalse(tuple.equals("not a tuple"));
    }

    @Test
    void testEqualsDifferentItem1() {
        MyTuple<String, Integer> tuple1 = new MyTuple<>("a", 1);
        MyTuple<String, Integer> tuple2 = new MyTuple<>("b", 1);
        assertFalse(tuple1.equals(tuple2));
    }

    @Test
    void testEqualsDifferentItem2() {
        MyTuple<String, Integer> tuple1 = new MyTuple<>("a", 1);
        MyTuple<String, Integer> tuple2 = new MyTuple<>("a", 2);
        assertFalse(tuple1.equals(tuple2));
    }

    @Test
    void testEqualsTrue() {
        MyTuple<String, Integer> tuple1 = new MyTuple<>("a", 1);
        MyTuple<String, Integer> tuple2 = new MyTuple<>("a", 1);
        assertTrue(tuple1.equals(tuple2));
    }

    @Test
    void testCompareToEquals() {
        MyTuple<String, Integer> tuple1 = new MyTuple<>("a", 1);
        MyTuple<String, Integer> tuple2 = new MyTuple<>("a", 1);
        assertEquals(0, tuple1.compareTo(tuple2));
    }

    @Test
    void testCompareToItem1() {
        MyTuple<String, Integer> tuple1 = new MyTuple<>("a", 1);
        MyTuple<String, Integer> tuple2 = new MyTuple<>("b", 1);
        assertTrue(tuple1.compareTo(tuple2) < 0);
        assertTrue(tuple2.compareTo(tuple1) > 0);
    }

    @Test
    void testCompareToItem2() {
        MyTuple<String, Integer> tuple1 = new MyTuple<>("a", 1);
        MyTuple<String, Integer> tuple2 = new MyTuple<>("a", 2);
        assertTrue(tuple1.compareTo(tuple2) < 0);
        assertTrue(tuple2.compareTo(tuple1) > 0);
    }

    @Test
    void testClone() {
        MyTuple<String, Integer> tuple1 = new MyTuple<>("a", 1);
        MyTuple<String, Integer> tuple2 = tuple1.clone();
        assertEquals(tuple1, tuple2);
        assertNotSame(tuple1, tuple2);
    }
}