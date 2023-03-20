package creditsuisse.codingchallenge.model;

public class Rectangle implements Entity {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(int _x1, int _y1, int _x2, int _y2) {
        this.x1 = _x1;
        this.y1 = _y1;
        this.x2 = _x2;
        this.y2 = _y2;
        if ((x1 > x2)) {
            this.x1 = _x2;
            this.x2 = _x1;
        }
        if (y1 > y2) {
            this.y1 = _y2;
            this.y2 = _y1;
        }
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public static void validateOutOfBounds(int x1, int y1, int x2, int y2, int width, int height) {
        if (x1 < 1 || x1 > width || y1 < 1 || y1 > height || x2 < 1 || x2 > width || y2 < 1 || y2 > height) {
            throw new InvalidEntityException("rectangle exceeds canvas");
        }
    }
}
