package creditsuisse.codingchallenge.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import creditsuisse.codingchallenge.constants.CanvasConstants;

public class CanvasImpl implements Canvas {
    private final int width;
    private final int height;
    private char[][] canvasArray;
    private LinkedList<Entity> entities;
    private String horizontalEdge;

    public CanvasImpl(int w, int h) {
        width = w;
        height = h;
        entities = new LinkedList<>();

        canvasArray = new char[this.width][this.height];
        Arrays.stream(canvasArray).forEach(chars -> Arrays.fill(chars, CanvasConstants.EMPTY_CHAR));

        horizontalEdge = Stream.generate(() -> String.valueOf(CanvasConstants.HORIZONTAL_EDGE_CHAR)).limit(width + 2)
                .collect(Collectors.joining());
    }

    @Override
    public void addEntity(Entity entity) throws InvalidEntityException {
        entities.add(entity);
        if (entity instanceof Line) {
            addLine((Line) entity);
        } else if (entity instanceof Rectangle) {
            addRectangle((Rectangle) entity);
        } else if (entity instanceof BucketFill) {
            addBucketFill((BucketFill) entity);
        }
    }

    @Override
    public String render() {
        StringBuilder builder = new StringBuilder();
        builder.append(horizontalEdge).append("\n");
        for (int i = 0; i < this.height; i++) {
            builder.append(CanvasConstants.VERTICAL_EDGE_CHAR);
            for (int j = 0; j < this.width; j++) {
                builder.append(canvasArray[j][i]);
            }
            builder.append(CanvasConstants.VERTICAL_EDGE_CHAR);
            builder.append("\n");
        }
        builder.append(horizontalEdge);
        return builder.toString();
    }

    private void addLine(Line line) {
        Line.validateOutOfBounds(line.getX1(), line.getY1(), line.getX2(), line.getY2(), this.width, this.height);

        drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
    }

    private void drawLine(int x1, int y1, int x2, int y2) {
        for (int row = y1 - 1; row <= y2 - 1; row++) {
            for (int col = x1 - 1; col <= x2 - 1; col++) {
                canvasArray[col][row] = CanvasConstants.LINE_CHAR;
            }
        }
    }

    private void addRectangle(Rectangle rectangle) {
        Rectangle.validateOutOfBounds(rectangle.getX1(), rectangle.getY1(), rectangle.getX2(), rectangle.getY2(),
                this.width, this.height);

        drawRectangle(rectangle.getX1(), rectangle.getY1(), rectangle.getX2(), rectangle.getY2());
    }

    private void drawRectangle(int x1, int y1, int x2, int y2) {
        // draw bottom edge
        drawLine(x1, y1, x2, y1);
        // draw left edge
        drawLine(x1, y1, x1, y2);
        // draw right edge
        drawLine(x2, y1, x2, y2);
        // draw top edge
        drawLine(x1, y2, x2, y2);
    }

    private void addBucketFill(BucketFill bucketFill) {
        BucketFill.validateOutOfBounds(bucketFill.getX(), bucketFill.getY(), this.width, this.height);

        fill(bucketFill.getX(), bucketFill.getY(), bucketFill.getColour());
    }

    private void fill(int x, int y, char colour) {
        if (x < 0 || x >= this.width || y < 0 || y >= this.height) {
            return;
        }
        if (canvasArray[x][y] != CanvasConstants.EMPTY_CHAR) {
            return;
        }
        canvasArray[x][y] = colour;

        // Recur for north, east, south and west
        fill(x + 1, y, colour);
        fill(x - 1, y, colour);
        fill(x, y + 1, colour);
        fill(x, y - 1, colour);
    }
}
