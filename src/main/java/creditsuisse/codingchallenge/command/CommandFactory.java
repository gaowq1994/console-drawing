package creditsuisse.codingchallenge.command;

import java.util.Arrays;

import creditsuisse.codingchallenge.constants.CommandConstants;

public class CommandFactory {
    public Command getCommand(String input) throws InvalidCommandException, InvalidParamsException {
        String[] split = input.split(" ");
        String[] params = Arrays.copyOfRange(split, 1, split.length);
        switch (split[0].toUpperCase()) {
            case CommandConstants.CREATE_CANVAS:
                return new CreateCanvasCommand(params);
            case CommandConstants.DRAW_LINE:
                return new DrawLineCommand(params);
            case CommandConstants.DRAW_RECTANGLE:
                return new DrawRectangleCommand(params);
            case CommandConstants.BUCKET_FILL:
                return new BucketFillCommand(params);
            case CommandConstants.QUIT:
                return new QuitCommand();
            default:
                throw new InvalidCommandException();
        }
    }
}
