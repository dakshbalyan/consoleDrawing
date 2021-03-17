package console.drawing.proxor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CreateCanvasTest {

    @Mock
    CreateCanvas createCanvas;
    @Before
    public void setUp() throws Exception {
    }

    @Test(expected = Exception.class)
    public void executeThrowsExceptionWhenParamsAreLess() throws Exception {
        List<String> params = new ArrayList<>(0);
        createCanvas.execute(params);
    }

    @Test
    public void testExecute() throws Exception{
        createCanvas = new CreateCanvas("C 20 10");
        assertEquals(10,createCanvas.getHeight());
        assertEquals(20,createCanvas.getWidth());
    }
}