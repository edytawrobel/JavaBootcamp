package bootcamp.process;

import bootcamp.data.Processor;
import bootcamp.data.Summary;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalDouble;

import static org.junit.Assert.*;

public class ProcessorTest {
    @Test
    public void shouldGetSummaryWithCorrectValuesWhenProcessingValidArray() {
        ArrayList<Double> doubleArray = new ArrayList<>();
        doubleArray.add(0, 9.5);
        doubleArray.add(1, 0.5);
        doubleArray.add(2,5.3);
        Processor processor = new Processor(doubleArray);
        Summary summary = processor.process();
        assertEquals(summary.getSum(), 15.3, 1);
    }

    @Test
    public void shouldGetDefaultSummaryWhenProcessingEmptyArray() {
        ArrayList<Double> doubleArray = new ArrayList<>();
        Processor processor = new Processor(doubleArray);
        Summary summary = processor.process();
        assertEquals(summary.getSum(), Double.NaN, 1);
        assertEquals(summary.getMax(), Double.NaN,1);
    }

    @Test
    public void shouldReturnValueAtGivenArrayIndex() {
        ArrayList<Double> doubleArray = new ArrayList<>();
        doubleArray.add(0, 9.5);
        doubleArray.add(1, 0.5);
        doubleArray.add(2,5.3);
        Processor processor = new Processor(doubleArray);
        Optional<Double> value = processor.getValue(0);
        assertTrue(value.isPresent());
        assertEquals(value.get(), 9.5, 1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldGetExceptionFromGetValueWhenIndexTooLarge() {
        ArrayList<Double> doubleArray = new ArrayList<>();
        doubleArray.add(0, 9.5);
        doubleArray.add(1, 0.5);
        doubleArray.add(2,5.3);
        Processor processor = new Processor(doubleArray);
        Optional<Double> value = processor.getValue(4);
        assertTrue(value.isEmpty());
    }
}
