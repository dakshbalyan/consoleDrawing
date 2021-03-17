package console.drawing.proxor;

import java.util.ArrayList;
import java.util.List;

public class Command {
    // Variables to store the parameters in
    private List<String> params;
    protected static int width;
    protected static int height;
    protected static char[][] shape; // The static variable for the 2D array where the values will be updated

    // The following are the basic getters and setters of the above variables
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

    // This constructor takes in the command input and parses it to extract the parameters
    public Command(String input) {
        String[] tokens = input.split(" ");
        this.params = new ArrayList<String>();
        for (int i = 1; i < tokens.length; i++) {
            this.params.add(tokens[i]);
        }
    }

    // Getter and setter methods for the params list variable

    public List<String> getParams() {
        return params;
    }
    public void setParams(List<String> params) {
        this.params = params;
    }

    // This method first validates the input points and then draws a vertical or
    // horizontal line between point x1,y1 and x2,y2
    protected void draw(int x1, int y1, int x2, int y2, char drawChar) throws Exception {
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

    protected void display(char[][] shape) {
        // This is the function that displays the lines, canvas, rectangle and the fill function
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

    // The validate method for the input params points x1,y1 and x2,y2
    protected void validate(int x1, int y1, int x2, int y2) {
        try {
            if (x1 >= 1 && y1 >= 1 && x2 >= 1 && y2 >= 1 && x1 <= width
                    && y1 <= height && x2 <= width && y2 <= height && x1 <= x2
                    && y1 <= y2) {
                return;
            }
            else{
                throw new Exception();
            }
        }
        catch (Exception e){
            System.out.println("Points entered invalid : going out of scope of canvas !");
        }
    }
}
