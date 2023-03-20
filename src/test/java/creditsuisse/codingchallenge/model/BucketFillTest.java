package creditsuisse.codingchallenge.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BucketFillTest {
    @Test
    public void testBucketFill() {
        new BucketFill(1, 2, 'o');
    }

    @Test
    public void testValidateOutOfBounds() {
        assertThrows(InvalidEntityException.class,
                () -> {
                    BucketFill.validateOutOfBounds(-1, 1, 1, 1);
                });
    }
}
