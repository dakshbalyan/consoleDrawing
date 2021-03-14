package console.drawing.proxor;

import java.util.List;

public class CreateRectangle extends Command{
    public CreateRectangle(String input) {
        super(input);
        try {
            execute(getParams());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void execute(List<String> params) throws Exception {

        if (params.size() < 4) {
            throw new Exception(
                    "Rectangle command requires 4 parameters, " + params.size() + " params provided.");
        }

        int x1 = Integer.parseInt(params.get(0));
        int y1 = Integer.parseInt(params.get(1));
        int x2 = Integer.parseInt(params.get(2));
        int y2 = Integer.parseInt(params.get(3));

        validate(x1, y1, x2, y2);

        createRectangle(x1, y1, x2, y2);
        display(shape);

    }

    private void createRectangle(int x1, int y1, int x2, int y2) {
        draw(x1, y1, x2, y1, 'x');
        draw(x1, y1, x1, y2, 'x');
        draw(x2, y1, x2, y2, 'x');
        draw(x1, y2, x2, y2, 'x');
    }
}
