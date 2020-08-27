package bootcamp.io;

import bootcamp.data.Result;
import java.io.*;
import java.util.*;

public class WordReaderImpl extends WordReader {

    public WordReaderImpl(InputStream inStream) {
        super(inStream);
    }

    @Override
    public Result<List<String>> getWords() {
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(inStream)) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        }
        return new Result(Optional.of(words));
    }
}
