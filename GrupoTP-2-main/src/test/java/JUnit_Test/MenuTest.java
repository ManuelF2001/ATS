package JUnit_Test;

import MakeItFit.menu.Menu;
import MakeItFit.menu.MenuItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;

class MenuTest {

    @Test
    void displaysAllValidMenuItems() {
        MenuItem item1 = new MenuItem("Option 1", () -> true, () -> {});
        MenuItem item2 = new MenuItem("Option 2", () -> true, () -> {});
        Menu menu = new Menu(Arrays.asList(item1, item2));
        assertDoesNotThrow(() -> menu.display());
    }

    @Test
    void displaysInvalidMenuItemsAsDashes() {
        MenuItem item1 = new MenuItem("Option 1", () -> false, () -> {});
        MenuItem item2 = new MenuItem("Option 2", () -> true, () -> {});
        Menu menu = new Menu(Arrays.asList(item1, item2));
        assertDoesNotThrow(() -> menu.display());
    }

    @Test
    void acceptsValidUserChoice() {
        MenuItem item1 = new MenuItem("Option 1", () -> true, () -> {});
        Menu menu = new Menu(Collections.singletonList(item1));
        System.setIn(new java.io.ByteArrayInputStream("1\n".getBytes()));
        assertEquals(1, menu.getUserChoice());
    }

    @Test
    void rejectsInvalidUserChoice() {
        MenuItem item1 = new MenuItem("Option 1", () -> true, () -> {});
        Menu menu = new Menu(Collections.singletonList(item1));
        System.setIn(new java.io.ByteArrayInputStream("0\n1\n".getBytes()));
        assertEquals(1, menu.getUserChoice());
    }

    @Test
    void executesSelectedOption() {
        boolean[] executed = {false};
        MenuItem item1 = new MenuItem("Option 1", () -> true, () -> executed[0] = true);
        Menu menu = new Menu(Collections.singletonList(item1));
        System.setIn(new java.io.ByteArrayInputStream("1\n".getBytes()));
        menu.executeSelectedOption();
        assertTrue(executed[0]);
    }

    @Test
    void exitsMenuWhenExitOptionSelected() {
        MenuItem item1 = new MenuItem("Option 1", () -> true, () -> {});
        Menu menu = new Menu(Collections.singletonList(item1));
        System.setIn(new java.io.ByteArrayInputStream("2\n".getBytes()));
        menu.executeSelectedOption();
        assertFalse(menu.keepRunning);
    }
}