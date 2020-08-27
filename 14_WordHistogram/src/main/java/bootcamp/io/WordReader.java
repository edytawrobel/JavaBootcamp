package bootcamp.io;

import bootcamp.data.Result;
import bootcamp.data.Status;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class WordReader {
    public InputStream inStream;

    public WordReader(InputStream inStream) {
        this.inStream = inStream;
    }

    public abstract Result<List<String>> getWords();
// use an InputStream implementation object to read text and compose a list of words


}