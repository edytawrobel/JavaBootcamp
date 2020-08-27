package bootcamp.process;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;
import bootcamp.io.HistogramWriterImpl;
import bootcamp.io.WordReader;
import bootcamp.io.WordReaderImpl;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

public class HistogramProcessorTest {
    @Test
    public void shouldReturnResultObjectWithSuccessStatusAndEmptyValueGivenValidInput() {
        String words = "many many words here";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(words.getBytes());
        WordReader wordReader = new WordReaderImpl(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HistogramWriter histogramWriter = new HistogramWriterImpl(byteArrayOutputStream);

        HistogramProcessor histogramProcessor = new HistogramProcessor();
        Result<?> actualResult = histogramProcessor.process(wordReader, histogramWriter);
        Result expectedResult = new Result();
        assertEquals(expectedResult, actualResult);
    }
}