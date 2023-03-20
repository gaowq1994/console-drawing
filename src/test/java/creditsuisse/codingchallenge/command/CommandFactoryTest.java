package creditsuisse.codingchallenge.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandFactoryTest {
    private CommandFactory commandFactory;

    @BeforeEach
    public void setUp() {
        commandFactory = new CommandFactory();
    }

    @Test
    void testGetCommand() {
        commandFactory.getCommand("Q");
    }

    @Test
    void testGetCommand2() {
        assertThrows(InvalidCommandException.class,
                () -> {
                    commandFactory.getCommand("A");
                });
    }

    @Test
    public void getCommand3() {
        Command command = commandFactory.getCommand("C 20 4");
        assertEquals(command.getClass(), CreateCanvasCommand.class);
    }

    @Test
    public void getCommand4() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    commandFactory.getCommand("C 20");
                });
    }

    @Test
    public void getCommand5() {
        Command command = commandFactory.getCommand("L 1 2 6 2");
        assertEquals(command.getClass(), DrawLineCommand.class);
    }

    @Test
    public void getCommand6() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    commandFactory.getCommand("L 1");
                });
    }

    @Test
    public void getCommand7() {
        Command command = commandFactory.getCommand("R 14 1 18 3");
        assertEquals(command.getClass(), DrawRectangleCommand.class);
    }

    @Test
    public void getCommand8() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    commandFactory.getCommand("R 14");
                });
    }

    @Test
    public void getCommand9() {
        Command command = commandFactory.getCommand("B 10 3 o");
        assertEquals(command.getClass(), BucketFillCommand.class);
    }

    @Test
    public void getCommand10() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    commandFactory.getCommand("B o");
                });
    }

}
