package bootcamp.io;

import bootcamp.data.Result;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistogramWriterImplTest {

    @Test
    public void shouldWriteHistogramToOutputStream() {
        String outputTestData = new String("data data data data data data");
        Map<String, Integer> histogram = new HashMap<>();
        histogram.put("data", 6);
        String expectedHistogram = histogram.toString();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HistogramWriter histogramWriter = new HistogramWriterImpl(outputStream);
        histogramWriter.writeHistogram(histogram);
        String actualHistogram = histogramWriter.getOutStream().toString();
        assertEquals(actualHistogram, expectedHistogram);
    }

    @Test
    public void shouldReturnSuccessResultObjectOnSuccessfulWriteOperation() {
        Map<String, Integer> histogram = Collections.singletonMap("histogram", 5);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HistogramWriter histogramWriter = new HistogramWriterImpl(byteArrayOutputStream);
        Result<?> actualResult = histogramWriter.writeHistogram(histogram);
        Result<?> expectedResult = new Result<>();
        assertEquals(expectedResult, actualResult);
    }
}
