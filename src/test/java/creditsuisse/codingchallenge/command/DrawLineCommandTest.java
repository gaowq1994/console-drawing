package creditsuisse.codingchallenge.command;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DrawLineCommandTest {
    @Test
    public void testDrawLineCommand() {
        new DrawLineCommand(new String[] { "1", "1", "1", "1" });
    }

    @Test
    public void testDrawLineCommand2() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    new DrawLineCommand(new String[] { "1", "1", "1", "1", "1" });
                });
    }

    @Test
    public void testDrawLineCommand3() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    new DrawLineCommand(new String[] { "1" });
                });
    }

    @Test
    public void testDrawLineCommand4() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    new DrawLineCommand(new String[] {});
                });
    }

    @Test
    public void testDrawLineCommand5() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    new DrawLineCommand(new String[] { "1", "1", "2", "2" });
                });
    }
}
