package bootcamp.io;

import bootcamp.data.Result;
import bootcamp.data.Status;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

public class HistogramWriterImpl extends HistogramWriter{

    public HistogramWriterImpl(OutputStream outStream) {
        super(outStream);
    }

    @Override
    public Result<?> writeHistogram(Map<String, Integer> histogram) {
        try (Writer outputStreamWriter = new OutputStreamWriter(getOutStream())) {
            outputStreamWriter.write(histogram.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
            return new Result(Status.IO_ERROR, "There was a problem writing to file");
        }
        return new Result<>();
    }
}

//HistogramWriter’s writeHistogram method takes a map of strings to integers representing the histogram of words
// and writes it to the OutputStream implementation which is the instance member of HistogramWriter.
// It returns a Result object that always contains empty Optional irrespective of success or failure of the operation.
