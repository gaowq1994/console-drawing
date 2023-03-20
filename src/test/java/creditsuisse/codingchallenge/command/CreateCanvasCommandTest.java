package creditsuisse.codingchallenge.command;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CreateCanvasCommandTest {
    @Test
    public void testCreateCanvasCommand() {
        new CreateCanvasCommand(new String[] { "1", "1" });
    }

    @Test
    public void testCreateCanvasCommand2() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    new CreateCanvasCommand(new String[] { "1", "1", "1" });
                });
    }

    @Test
    public void testCreateCanvasCommand3() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    new CreateCanvasCommand(new String[] { "1" });
                });
    }

    @Test
    public void testCreateCanvasCommand4() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    new CreateCanvasCommand(new String[] {});
                });
    }
}
