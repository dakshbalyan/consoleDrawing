package console.drawing.proxor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

public class CommandTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testValidateWhenInvalidPoints() {
        Command command = new Command("C 20 10");
        List<String> params = command.getParams();
        command.setHeight(Integer.parseInt(params.get(1)));
        command.setWidth(Integer.parseInt(params.get(0)));
        command.validate(-1,12,45,64);
        assertEquals("Points entered invalid : going out of scope of canvas !\n",outContent.toString());
    }

    @Test
    public void testValidate(){
        Command command = new Command("C 20 10");
        List<String> params = command.getParams();
        command.setHeight(Integer.parseInt(params.get(1)));
        command.setWidth(Integer.parseInt(params.get(0)));
        command.validate(1,1,4,4);
        assertEquals("",outContent.toString());
    }
}