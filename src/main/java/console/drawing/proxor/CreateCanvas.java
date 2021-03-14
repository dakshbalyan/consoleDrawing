package console.drawing.proxor;

import java.util.List;

public class CreateCanvas extends Command{
    public CreateCanvas(String input) {
        super(input);
        try {
            execute(getParams());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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

    private void drawCanvas() {

        shape = new char[height+2][width+2];
        // Draw upper border
        draw(0, 0, width + 1, 0, '-');
        // Draw left border
        draw(0, 1, 0, height, '|');
        // Draw right border
        draw(width + 1 , 1, width + 1,height, '|');
        // Draw lower border
        draw(0, height + 1, width + 1, height + 1, '-');

    }
}
