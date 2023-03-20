package creditsuisse.codingchallenge.command;

public class CreateCanvasCommand implements Command {
    private int width;
    private int height;

    public CreateCanvasCommand(String[] params) {
        if (params.length != 2) {
            throw new InvalidParamsException("command expects 2 parameters");
        }
        width = Integer.parseInt(params[0]);
        height = Integer.parseInt(params[1]);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
