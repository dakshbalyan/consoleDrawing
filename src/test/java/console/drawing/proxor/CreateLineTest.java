package console.drawing.proxor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CreateLineTest {
    @Mock
    CreateLine createLine;

    @Before
    public void setUp() throws Exception {
    }

    @Test(expected = Exception.class)
    public void executeThrowsExceptionWhenLessParams() throws Exception {
        List<String> params = new ArrayList<>(3) ;
        params.add("1");
        params.add("1");
        params.add("3");
        createLine.execute(params);
    }

    @Test(expected = Exception.class)
    public void executeThrowsExceptionWhenInvalidPoints() throws Exception {
        CreateCanvas createCanvas = new CreateCanvas("C 20 10");
        List<String> params = new ArrayList<>(4) ;
        params.add("1");
        params.add("3");
        params.add("1");
        params.add("1");
        createLine.execute(params);
    }
    @Test
    public void testExecute() throws Exception{
        CreateCanvas createCanvas = new CreateCanvas("C 4 4");
        createLine = new CreateLine("L 2 2 4 2");
        char[][] expected = { { '-', '-', '-', '-', '-', '-' }, { '|', 0, 0, 0, 0, '|' },
                { '|', 0, 'x', 'x', 'x', '|' }, { '|', 0, 0, 0, 0, '|' }, { '|', 0, 0, 0, 0, '|' },
                { '-', '-', '-', '-', '-', '-' } };
        assertEquals(expected, createCanvas.getShape());
    }

}