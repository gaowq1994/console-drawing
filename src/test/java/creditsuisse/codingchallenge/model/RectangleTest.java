package creditsuisse.codingchallenge.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RectangleTest {
    @Test
    public void testRectangle() {
        new Line(1, 1, 2, 2);
    }

    @Test
    void testValidateOutOfBounds() {
        assertThrows(InvalidEntityException.class,
                () -> {
                    Rectangle.validateOutOfBounds(-1, 1, 2, 2, 1, 1);
                });
    }
}
