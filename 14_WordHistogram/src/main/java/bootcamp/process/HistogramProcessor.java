package bootcamp.process;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;
import bootcamp.io.WordReader;

import java.util.List;
import java.util.Map;

public class HistogramProcessor {
    final HistogramCalculator calculator = new HistogramCalculator();

    public Result<?> process(final WordReader reader, final HistogramWriter writer) {
        Result<List<String>> result = reader.getWords();
        List<String> words = result.getValue().get();
        Map<String, Integer> histogram = calculator.calculate(words);
        Result<?> writerResult = writer.writeHistogram(histogram);
        return writerResult;
    }
}

//HistogramProcessor uses a HistogramCalculator,
// an extension of WordReader and an extension of HistogramWriter
// to read text from an InputStream,
// calculate the histogram of words
// and write it to an OutputStream.