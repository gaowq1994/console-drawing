package creditsuisse.codingchallenge.command;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BucketFillCommandTest {
    @Test
    public void testBucketFillCommand() {
        new BucketFillCommand(new String[] { "1", "1", "o" });
    }

    @Test
    public void testBucketFillCommand2() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    new BucketFillCommand(new String[] { "1", "1", "1", "1" });
                });
    }

    @Test
    public void testBucketFillCommand3() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    new BucketFillCommand(new String[] { "1" });
                });
    }

    @Test
    public void testBucketFillCommand4() {
        assertThrows(InvalidParamsException.class,
                () -> {
                    new BucketFillCommand(new String[] {});
                });
    }
}
