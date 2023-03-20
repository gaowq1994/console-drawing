package creditsuisse.codingchallenge.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    public void testLine() {
        new Line(1, 1, 1, 1);
    }

    @Test
    void testValidateOutOfBounds() {
        assertThrows(InvalidEntityException.class,
                () -> {
                    Line.validateOutOfBounds(-1, 1, 1, 1, 1, 1);
                });
    }
}
