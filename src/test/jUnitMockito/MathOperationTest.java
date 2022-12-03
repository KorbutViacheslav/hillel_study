package jUnitMockito;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MathOperationTest {
    private static MathOperation mathOperation;
    private static ItemSource itemSource;

    @Before
    public void createNewMathOperation() {
        itemSource = mock(ItemSource.class);
        mathOperation = new MathOperation(itemSource);
    }

    @Test(expected = IllegalStateException.class)
    public void mathOperationSumShouldExeption() {
        when(itemSource.getItems()).thenReturn(List.of());
        mathOperation.sum();
    }

    @Test(expected = IllegalStateException.class)
    public void mathOperationAvgShouldExeption() {
        when(itemSource.getItems()).thenReturn(List.of());
        mathOperation.avg();
    }

    @Test(expected = IllegalStateException.class)
    public void mathOperationMaxShouldExeption() {
        when(itemSource.getItems()).thenReturn(List.of());
        mathOperation.max();
    }

    @Test
    public void mathOperationSumTest() {
        when(itemSource.getItems()).thenReturn(Arrays.asList(4, 1, -5, 10));
        assertEquals(10, mathOperation.sum());
    }

    @Test
    public void mathOperationSumZeroTest() {
        when(itemSource.getItems()).thenReturn(Arrays.asList(0, 0, 0, 0));
        assertEquals(0, mathOperation.sum());
    }

    @Test
    public void mathOperationSumOneTest() {
        when(itemSource.getItems()).thenReturn(Arrays.asList(7));
        assertEquals(7, mathOperation.sum());
    }

    @Test
    public void mathOperationAvgTest() {
        when(itemSource.getItems()).thenReturn(Arrays.asList(4, 1, -5, 10, 0));
        assertEquals(2, mathOperation.avg());
    }

    @Test
    public void mathOperationAvgZeroTest() {
        when(itemSource.getItems()).thenReturn(Arrays.asList(0, 0, 0, 0));
        assertEquals(0, mathOperation.avg());
    }

    @Test
    public void mathOperationAvgOneTest() {
        when(itemSource.getItems()).thenReturn(Arrays.asList(16));
        assertEquals(16, mathOperation.sum());
    }

    @Test
    public void mathOperationMaxTest() {
        when(itemSource.getItems()).thenReturn(Arrays.asList(152, 1, -48, 10, 0));
        assertEquals(152, mathOperation.max());
    }

    @Test
    public void mathOperationMaxZeroTest() {
        when(itemSource.getItems()).thenReturn(Arrays.asList(0, 0, 0, 0));
        assertEquals(0, mathOperation.max());
    }

    @Test
    public void mathOperationMaxOneTest() {
        when(itemSource.getItems()).thenReturn(Arrays.asList(88));
        assertEquals(88, mathOperation.max());
    }
}
