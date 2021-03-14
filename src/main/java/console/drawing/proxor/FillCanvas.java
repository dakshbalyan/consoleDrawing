package console.drawing.proxor;

import java.util.List;

public class FillCanvas extends Command{
    public FillCanvas(String input) {
        super(input);
        try {
            execute(getParams());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void execute(List<String> params) throws Exception {
        if (params.size() < 3 || !validParams(params)) {
            throw new Exception(
                    "Fill command requires 3 parameters, " + params.size() + " params provided.");
        }
        int x = Integer.parseInt(params.get(0));
        int y = Integer.parseInt(params.get(1));
        char fillChar = params.get(2).charAt(0);

        fill(x, y, fillChar);
        display(shape);
    }

    private boolean validParams(List<String> params) {
        return isInteger(params.get(0)) && isInteger(params.get(1)) && params.get(2).length() == 1;
    }

    private boolean isInteger(String str) {
        return str.matches("-?\\d+?");
    }

    private void fill(int x, int y, char ch) {
        if (shape[y][x] != 0) {
            return;
        }

        if (x > 0 || x < height || y > 0 || y < width) {
            if (shape[y][x] == 0)
                shape[y][x] = ch;
            fill(x + 1, y, ch);
            fill(x - 1, y, ch);
            fill(x, y - 1, ch);
            fill(x, y + 1, ch);
        }
    }
}
