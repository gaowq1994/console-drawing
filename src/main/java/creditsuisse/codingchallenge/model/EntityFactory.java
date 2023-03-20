package creditsuisse.codingchallenge.model;

import creditsuisse.codingchallenge.command.BucketFillCommand;
import creditsuisse.codingchallenge.command.DrawEntityCommand;
import creditsuisse.codingchallenge.command.DrawLineCommand;
import creditsuisse.codingchallenge.command.DrawRectangleCommand;

public class EntityFactory {
    public Entity getEntity(DrawEntityCommand command) {
        if (command instanceof DrawLineCommand) {
            DrawLineCommand drawLineCommand = (DrawLineCommand) command;
            return new Line(drawLineCommand.getX1(), drawLineCommand.getY1(), drawLineCommand.getX2(),
                    drawLineCommand.getY2());
        } else if (command instanceof DrawRectangleCommand) {
            DrawRectangleCommand drawRectangleCommand = (DrawRectangleCommand) command;
            return new Rectangle(drawRectangleCommand.getX1(), drawRectangleCommand.getY1(),
                    drawRectangleCommand.getX2(), drawRectangleCommand.getY2());
        } else if (command instanceof BucketFillCommand) {
            BucketFillCommand bucketFillCommand = (BucketFillCommand) command;
            return new BucketFill(bucketFillCommand.getX(), bucketFillCommand.getY(), bucketFillCommand.getC());
        }
        return null;
    }
}
