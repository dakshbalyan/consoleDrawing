package console.drawing.proxor;

import java.util.List;

public class CreateCanvas extends Command{
    // Constructor which refers the input to the Command (parent) class and calls the execute method
    public CreateCanvas(String input) {
        super(input);
        try {
            execute(getParams());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This method checks if the given parameters are enough or less
    // sets the variables and calls the methods from the Command (parent) class
    public void execute(final List<String> params) throws Exception {

        if (params.size() < 2) {
            throw new Exception(
                    "Canvas command requires 2 parameters, " + params.size() + " params provided.");
        }

        int width = Integer.parseInt(params.get(0));
        int height = Integer.parseInt(params.get(1));

        // set properties for canvas
        setWidth(width);
        setHeight(height);

        drawCanvas();
        display(shape);
    }

    // Specifying between which points the draw function in Command class should be called for
    private void drawCanvas() {
        // The +2 part is because I am assuming the parameters given in the 'C w h' command
        // is the drawing area and the extra 2 spaces are for drawing the borders
        shape = new char[height+2][width+2];
        // Drawing upper border
        draw(0, 0, width + 1, 0, '-');
        // Drawing left border
        draw(0, 1, 0, height, '|');
        // Drawing right border
        draw(width + 1 , 1, width + 1,height, '|');
        // Drawing lower border
        draw(0, height + 1, width + 1, height + 1, '-');

    }
}
