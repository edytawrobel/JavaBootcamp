package bootcamp.app;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;
import bootcamp.io.HistogramWriterImpl;
import bootcamp.io.WordReader;
import bootcamp.io.WordReaderImpl;
import bootcamp.process.HistogramProcessor;

import java.io.*;
import java.util.Scanner;

public class HistogramApp {
    public static void main(final String[] args) {
        try {
            InputStream fileInputStream = new FileInputStream(args[0]);
            OutputStream fileOutputStream = new FileOutputStream(args[1]);
            WordReader reader = new WordReaderImpl(fileInputStream);
            HistogramWriter writer = new HistogramWriterImpl(fileOutputStream);
            HistogramProcessor processor = new HistogramProcessor();
            Result<?> result = processor.process(reader, writer);
            System.out.println(result.getStatus());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//
    }
}

//HistogramApp should take two command line arguments, name of the input file containing the text
// and the name of the output file in which to store the histogram.

// It should create a FileInputStream and a FileOutputStream objects for WordReader and HistogramWriter instances.
// It should then create a HistogramProcessor instance and call its process method
// with WordReader and HistogramWriter to read text, calculate the histogram and then store in the output file.


//Use try-with-resources to catch exceptions in opening and processing IO streams and to close them successfully afterwards.