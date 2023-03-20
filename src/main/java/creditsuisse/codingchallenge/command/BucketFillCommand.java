package creditsuisse.codingchallenge.command;

public class BucketFillCommand implements DrawEntityCommand {
    private int x;
    private int y;
    private char c;

    public BucketFillCommand(String[] params) {
        if (params.length != 3) {
            throw new InvalidParamsException("command expects 3 parameters");
        }
        x = Integer.parseInt(params[0]);
        y = Integer.parseInt(params[1]);
        c = params[2].charAt(0);
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

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

}
