package creditsuisse.codingchallenge;

import java.util.Scanner;

import creditsuisse.codingchallenge.command.Command;
import creditsuisse.codingchallenge.command.CommandFactory;
import creditsuisse.codingchallenge.command.CreateCanvasCommand;
import creditsuisse.codingchallenge.command.DrawEntityCommand;
import creditsuisse.codingchallenge.command.InvalidCommandException;
import creditsuisse.codingchallenge.command.InvalidParamsException;
import creditsuisse.codingchallenge.command.QuitCommand;
import creditsuisse.codingchallenge.model.Canvas;
import creditsuisse.codingchallenge.model.CanvasImpl;
import creditsuisse.codingchallenge.model.EntityFactory;
import creditsuisse.codingchallenge.model.InvalidEntityException;

/**
 * Main App
 *
 */
public class App {
    private static Scanner scanner;
    private static Canvas canvas;
    private static CommandFactory commandFactory;
    private static EntityFactory entityFactory;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        commandFactory = new CommandFactory();
        entityFactory = new EntityFactory();

        while (true) {
            System.out.println("enter command: ");
            processCommand(scanner.nextLine());
        }
    }

    private static void processCommand(String input) {
        Command command = null;

        try {
            command = commandFactory.getCommand(input);
        } catch (InvalidCommandException e) {
            System.out.println("invalid command");
        } catch (InvalidParamsException invalidParamsException) {
            System.out.println(invalidParamsException.getMessage());
        }

        if (command instanceof CreateCanvasCommand) {
            createCanvas((CreateCanvasCommand) command);
        }
        if (command instanceof DrawEntityCommand) {
            draw((DrawEntityCommand) command);
        }
        if (command instanceof QuitCommand) {
            quit();
        }
    }

    private static void createCanvas(CreateCanvasCommand command) {
        try {
            canvas = new CanvasImpl(command.getWidth(), command.getHeight());
            System.out.println(canvas.render());
        } catch (InvalidEntityException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void draw(DrawEntityCommand command) {
        if (canvas != null) {
            canvas.addEntity(entityFactory.getEntity(command));
            System.out.println(canvas.render());
        } else {
            System.out.println("please create a new canvas first");
        }
    }

    private static void quit() {
        scanner.close();
        System.exit(0);
    }
}
