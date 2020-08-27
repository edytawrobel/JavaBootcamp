package bootcamp.io;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordReaderImplTest {

    @Test
    public void shouldReadWordsFromInput() {
        String someInput = "some input here some input here";
        ByteArrayInputStream inStream = new ByteArrayInputStream(someInput.getBytes());
        WordReader reader = new WordReaderImpl(inStream);
        List<String> result = reader.getWords().getValue().get();

        List<String> expectedWords = new ArrayList<>();
        expectedWords.add("some");
        expectedWords.add("input");
        expectedWords.add("here");
        expectedWords.add("some");
        expectedWords.add("input");
        expectedWords.add("here");

        assertEquals(expectedWords, result);
    }
}

//    public Result<List<String>> getWords() {
//        List<String> words = new ArrayList<>();
//        try (Scanner scanner = new Scanner(inStream)) {
//            while (scanner.hasNext()) {
//                words.add(scanner.next());
//            }
//        }
//        return new Result(Optional.of(words));
//    }