package console.drawing.proxor;

import java.util.ArrayList;
import java.util.List;

public class Command {
    private List<String> params;
    protected int width;
    protected int height;
    protected static char[][] shape;

    public char[][] getShape() {
        return shape;
    }
    public void setShape(char[][] shape) {
        this.shape = shape;
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

    public Command(String input) {
        String[] tokens = input.split(" ");
        this.params = new ArrayList<String>();
        for (int i = 1; i < tokens.length; i++) {
            this.params.add(tokens[i]);
        }
    }

    public List<String> getParams() {
        return params;
    }
    public void setParams(List<String> params) {
        this.params = params;
    }

    public void draw(int x1, int y1, int x2, int y2, char drawChar) {
        try {
            validate(x1, y1, x2, y2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (x1 == x2) {
            // vertical line
            for (int i = y1; i <= y2; i++) {
                shape[i][x1] = drawChar;
            }
        } else if (y1 == y2) {
            // horizontal line
            for (int i = x1; i <= x2; i++) {
                shape[y1][i] = drawChar;
            }
        }
    }

    public void display(char[][] shape) {
        // This is the function that draws
        for (int i = 0; i < shape.length; ++i) {
            for (int j = 0; j < shape[i].length; j++) {
                if ((shape[i][j]) == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(shape[i][j]);
                }
            }
            System.out.println();
        }
    }

    protected void validate(int x1, int y1, int x2, int y2) throws Exception {
        try {
            if (x1 >= 1 && y1 >= 1 && x2 >= 1 && y2 >= 1 && x1 < width
                    && y1 < height && x2 < width && y2 < height && x1 <= x2
                    && y1 <= y2) {
                return;
            }
        }
        catch (Exception e){
            System.out.println("Points entered invalid : going out of scope of canvas !");
            return;
        }
    }
}
