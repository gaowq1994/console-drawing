package creditsuisse.codingchallenge.model;

public class BucketFill implements Entity {
    private int x;
    private int y;
    private char colour;

    public BucketFill(int _x, int _y, char _c) {
        this.x = _x;
        this.y = _y;
        this.colour = _c;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getColour() {
        return colour;
    }

    public void setColour(char colour) {
        this.colour = colour;
    }

    public static void validateOutOfBounds(int x, int y, int width, int height) {
        if (x < 1 || x > width || y < 1 || y > height) {
            throw new InvalidEntityException("bucket fill exceeds canvas");
        }
    }
}
