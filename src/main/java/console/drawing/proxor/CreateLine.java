package console.drawing.proxor;

import java.util.List;

public class CreateLine extends Command{

    // Constructor which refers the input to the Command (parent) class and calls the execute method
    public CreateLine(String input) {
        super(input);
        try {
            execute(getParams());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This method checks if the given parameters are enough or less
    // sets the variables and calls the methods from the Command (parent) class
    public void execute(List<String> params) throws Exception {

        if (params.size() < 4) {
            throw new Exception(
                    "Line command requires 4 parameters, " + params.size() + " params provided.");
        }

        int x1 = Integer.parseInt(params.get(0));
        int y1 = Integer.parseInt(params.get(1));
        int x2 = Integer.parseInt(params.get(2));
        int y2 = Integer.parseInt(params.get(3));

        // Validating the points whether they belong inside the canvas or not
        validate(x1, y1, x2, y2);

        // Specifying between which points the draw function in Command class should be called for
        draw(x1, y1, x2, y2, 'x');
        display(shape);
    }
}
