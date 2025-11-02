package test_Hypothesis;

import MakeItFit.menu.MenuItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuItemGeneratedTest {

@Test
    public void testMenuItem_0() {
        MenuItem.PreCondition cond = () -> true;
        MenuItem.Handler action = () -> System.out.println("Executado!");
        MenuItem item = new MenuItem("ZLEJo", cond, action);

        assertEquals("ZLEJo", item.getName());
        assertEquals(true, item.isValid());

        if (item.isValid()) {
            item.execute();
        }
    }
@Test
    public void testMenuItem_1() {
        MenuItem.PreCondition cond = () -> false;
        MenuItem.Handler action = () -> System.out.println("Executado!");
        MenuItem item = new MenuItem("wyLn", cond, action);

        assertEquals("wyLn", item.getName());
        assertEquals(false, item.isValid());

        if (item.isValid()) {
            item.execute();
        }
    }
@Test
    public void testMenuItem_2() {
        MenuItem.PreCondition cond = () -> true;
        MenuItem.Handler action = () -> System.out.println("Executado!");
        MenuItem item = new MenuItem("jtWtSpQl", cond, action);

        assertEquals("jtWtSpQl", item.getName());
        assertEquals(true, item.isValid());

        if (item.isValid()) {
            item.execute();
        }
    }
@Test
    public void testMenuItem_3() {
        MenuItem.PreCondition cond = () -> false;
        MenuItem.Handler action = () -> System.out.println("Executado!");
        MenuItem item = new MenuItem("AA", cond, action);

        assertEquals("AA", item.getName());
        assertEquals(false, item.isValid());

        if (item.isValid()) {
            item.execute();
        }
    }
@Test
    public void testMenuItem_4() {
        MenuItem.PreCondition cond = () -> false;
        MenuItem.Handler action = () -> System.out.println("Executado!");
        MenuItem item = new MenuItem("UiSnCSL", cond, action);

        assertEquals("UiSnCSL", item.getName());
        assertEquals(false, item.isValid());

        if (item.isValid()) {
            item.execute();
        }
    }
@Test
    public void testMenuItem_5() {
        MenuItem.PreCondition cond = () -> false;
        MenuItem.Handler action = () -> System.out.println("Executado!");
        MenuItem item = new MenuItem("scSEYPxWVwuN", cond, action);

        assertEquals("scSEYPxWVwuN", item.getName());
        assertEquals(false, item.isValid());

        if (item.isValid()) {
            item.execute();
        }
    }
@Test
    public void testMenuItem_6() {
        MenuItem.PreCondition cond = () -> true;
        MenuItem.Handler action = () -> System.out.println("Executado!");
        MenuItem item = new MenuItem("Infinity", cond, action);

        assertEquals("Infinity", item.getName());
        assertEquals(true, item.isValid());

        if (item.isValid()) {
            item.execute();
        }
    }
@Test
    public void testMenuItem_7() {
        MenuItem.PreCondition cond = () -> false;
        MenuItem.Handler action = () -> System.out.println("Executado!");
        MenuItem item = new MenuItem("asHRk", cond, action);

        assertEquals("asHRk", item.getName());
        assertEquals(false, item.isValid());

        if (item.isValid()) {
            item.execute();
        }
    }
@Test
    public void testMenuItem_8() {
        MenuItem.PreCondition cond = () -> true;
        MenuItem.Handler action = () -> System.out.println("Executado!");
        MenuItem item = new MenuItem("GU", cond, action);

        assertEquals("GU", item.getName());
        assertEquals(true, item.isValid());

        if (item.isValid()) {
            item.execute();
        }
    }
@Test
    public void testMenuItem_9() {
        MenuItem.PreCondition cond = () -> false;
        MenuItem.Handler action = () -> System.out.println("Executado!");
        MenuItem item = new MenuItem("HJZaaGoj", cond, action);

        assertEquals("HJZaaGoj", item.getName());
        assertEquals(false, item.isValid());

        if (item.isValid()) {
            item.execute();
        }
    }

}