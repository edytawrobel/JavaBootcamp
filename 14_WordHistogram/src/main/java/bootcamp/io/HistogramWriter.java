package bootcamp.io;

import bootcamp.data.Result;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Map;

public abstract class HistogramWriter {
    private OutputStream outStream;

    public HistogramWriter(OutputStream outStream) {
        this.outStream = outStream;
    }

    public abstract Result<?> writeHistogram(final Map<String, Integer> histogram);

    public OutputStream getOutStream(){
        return outStream;
    }
}
