# consoleDrawing
This project is for now a simple console version of a drawing program with limited functionalities. The basic overview of the program is:

1. Create a new canvas
2. Draw on the canvas by issuing various commands that are given below in the table
3. Quit

| Command | Description |
| --- | --- |
| C w h | Creates a new canvas of width w and height h |
| L x1 y1 x2 y2 | Should create a new line from (x1, y1) to (x2, y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character |
| R x1 y1 x2 y2 | Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2, y2). Horizontal and vertical lines will be drawn using the 'x' character |
| B x y c | Should fill the entire area connected to (x, y) with "colour" c. The behaviour of this is the same as that of the "bucket fill" tool in paint programs |
| Q | Should quit the program |

The basic idea to solve this problem statement was to go for a 2D array with specified width and height and then updating the cells with specified function call and then printing the 2D array. There are 6 classes in this project each with a specific task which are :-
1. **MainApplication.java** - This class is main driver class which takes a command, validates the entered command and then calls for the appropriate object of the class which the command called for.
2. **Command.java** - This class contains the basic methods which are to be used by the other classes like some basic getters, setters, drawing method, validating method, extracting parameters from the given command and displaying the canvas. 
3. **CreateCanvas.java** - This class takes in the input from the main application class then using the functionalities in the command class creates the canvas.
4. **CreateLine.java** - This class takes in the input from the main application class then using the functionalities in the command class creates a line which is within the canvas otherwise just prints the previous canvas.
5. **CreateRectangle.java** - This class takes in the input from the main application class then using the functionalities in the command class creates a rectangle which is within the canvas otherwise just prints the previous canvas.
6. **FillCanvas.java** - This class with the input parameters fills the area connected to the input parameter with the given character. 

To run this program on the terminal there are 2 methods:<br/>
**Method 1** - Go into the target directory of the github repository download the consoleDrawingProxor-1.0-SNAPSHOT.jar file and then from the downloaded directory run the following command in the terminal ---> java -jar consoleDrawingProxor-1.0-SNAPSHOT.jar
**Method 2** - Alternatively you can choose to build an executable jar file. In the project root directory run the following command --> mvn clean package<br/>The mvn clean package command will create a consoleDrawingProxor-1.0-SNAPSHOT.jar in the /target directory. Then from inside that directory run the command --> java -jar consoleDrawingProxor-1.0-SNAPSHOT.jar 
