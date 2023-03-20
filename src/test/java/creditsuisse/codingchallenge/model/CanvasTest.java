package creditsuisse.codingchallenge.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CanvasTest {
    private Canvas canvas;

    @BeforeEach
    public void setUp() {
        canvas = new CanvasImpl(20, 4);
    }

    @Test
    void testCreateCanvas() {
        assertEquals(canvas.render(),
                "----------------------\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "----------------------");
    }

    @Test
    void testAddLine() {
        canvas.addEntity(new Line(1, 2, 6, 2));

        assertEquals(canvas.render(),
                "----------------------\n" +
                        "|                    |\n" +
                        "|xxxxxx              |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "----------------------");
    }

    @Test
    void testAddRectangle() {
        canvas.addEntity(new Rectangle(14, 1, 18, 3));

        assertEquals(canvas.render(),
                "----------------------\n" +
                        "|             xxxxx  |\n" +
                        "|             x   x  |\n" +
                        "|             xxxxx  |\n" +
                        "|                    |\n" +
                        "----------------------");
    }

    @Test
    void testBucketFill() {
        canvas.addEntity(new BucketFill(10, 3, 'o'));

        assertEquals(canvas.render(),
                "----------------------\n" +
                        "|oooooooooooooooooooo|\n" +
                        "|oooooooooooooooooooo|\n" +
                        "|oooooooooooooooooooo|\n" +
                        "|oooooooooooooooooooo|\n" +
                        "----------------------");
    }
}
