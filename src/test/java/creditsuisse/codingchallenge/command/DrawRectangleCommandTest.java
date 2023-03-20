package creditsuisse.codingchallenge.command;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DrawRectangleCommandTest {
    @Test
    public void testDrawRectangleCommand() {
        new DrawRectangleCommand(new String[] { "1", "1", "1", "1" });
    }

    @Test
    public void testDrawRectangleCommand2() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    new DrawRectangleCommand(new String[] { "1", "1", "1", "1", "1" });
                });
    }

    @Test
    public void testDrawRectangleCommand3() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    new DrawRectangleCommand(new String[] { "1" });
                });
    }

    @Test
    public void testDrawRectangleCommand4() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    new DrawRectangleCommand(new String[] {});
                });
    }
}
