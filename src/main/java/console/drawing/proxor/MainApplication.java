package console.drawing.proxor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// The main application where all the other functionalities are called from.

public class MainApplication {
    // This regular expression validates if the given command is in line with the
    // command description in printHelp section
    // The regular expression --> The [a-zA-Z]{1} part makes sure the first character is an alphabet
    //                            The (\s\d+)* part makes sure the parameters are digits only
    //                            This (\s[a-zA-z]{1})? part is for the Fill function draw character.
    private final Pattern pattern = Pattern
            .compile("[a-zA-Z]{1}(\\s\\d+)*(\\s[a-zA-z]{1})?+");

    private static final MainApplication app = new MainApplication();

    public static void main(String[] args) {
        printHelp();
        app.inputCommand();
    }

    //This method takes in the input in an infinite loop until the Q command to exit the program is input
    protected void inputCommand(){
        Scanner scanner = new Scanner(System.in);
        try{
            while (true) {
                System.out.print("Enter command: ");
                app.executeCommand(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This method executes the functionalities using switch cases and then calling the corresponding classes' object
    private void executeCommand(final String input) throws Exception {
        validateCommand(input);
        switch (input.charAt(0)) {
            case 'C': {
                new CreateCanvas(input);
                app.inputCommand();
            }
            case 'L': {
                new CreateLine(input);
                app.inputCommand();
            }
            case 'R': {
                new CreateRectangle(input);
                app.inputCommand();
            }
            case 'B': {
                new FillCanvas(input);
                app.inputCommand();
            }
            case 'Q':
                System.exit(0);
            default:
                throw new Exception("Invalid command!");
        }
    }

    // validates the input command based on the above regex
    private void validateCommand(String commandInput){
        Matcher matcher = pattern.matcher(commandInput);
        if (!matcher.matches()) {
            System.out.println("Command string is invalid.");
            app.inputCommand();
        }
    }

    // this method is printed at the start of every program
    private static void printHelp() { // great
        String help = "The work as follows:\n"
                + "1. Create a new canvas \n"
                + "2. Draw on the canvas by issuing various commands \n"
                + "3. Quit \n\n\n"
                + "|Command 		|Description|\n"
                + "|----|----|\n"
                + "|C w h          | Create a new canvas of width w and height h.|\n"
                + "|L x1 y1 x2 y2  | Draw a new line from (x1,y1) to (x2,y2). Currently, only|\n"
                + "|               | horizontal or vertical lines are supported. Horizontal and vertical lines|\n"
                + "|               | will be drawn using the 'x' character.|\n"
                + "|R x1 y1 x2 y2  | Draw a rectangle whose upper left corner is (x1,y1) and|\n"
                + "|               | lower right corner is (x2,y2). Horizontal and vertical lines will be drawn|\n"
                + "|               | using the 'x' character.|\n"
                + "|B x y c        | Fill the entire area connected to (x,y) with \"colour\" c. The|\n"
                + "|               | behaviour of this is the same as that of the \"bucket fill\" tool in paint|\n"
                + "|               | programs.|\n"
                + "|Q              | Quit|\n";
        System.out.println(help);
    }

}
