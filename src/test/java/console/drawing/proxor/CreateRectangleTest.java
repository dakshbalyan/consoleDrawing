package console.drawing.proxor;

import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CreateRectangleTest {
    @Mock
    CreateRectangle createRectangle;

    @Test(expected = Exception.class)
    public void executeThrowsExceptionWhenLessParams() throws Exception {
        List<String> params = new ArrayList<>(3) ;
        params.add("1");
        params.add("1");
        params.add("3");
        createRectangle.execute(params);
    }

    @Test(expected = Exception.class)
    public void executeThrowsExceptionWhenInvalidPoints() throws Exception {
        CreateCanvas createCanvas = new CreateCanvas("C 20 10");
        List<String> params = new ArrayList<>(4) ;
        params.add("1");
        params.add("3");
        params.add("1");
        params.add("1");
        createRectangle.execute(params);
    }

    @Test
    public void testExecute() throws Exception{
        CreateCanvas createCanvas = new CreateCanvas("C 4 5");
        createRectangle = new CreateRectangle("R 1 1 4 4");
        char[][] expected = { { '-', '-', '-', '-', '-', '-' }, { '|', 'x', 'x', 'x', 'x', '|' },
                { '|', 'x', 0, 0, 'x', '|' }, { '|', 'x', 0, 0, 'x', '|' }, { '|', 'x', 'x', 'x', 'x', '|' },
                { '|', 0, 0, 0, 0, '|' }, { '-', '-', '-', '-', '-', '-' } };
        assertEquals(expected, createCanvas.getShape());
    }
}