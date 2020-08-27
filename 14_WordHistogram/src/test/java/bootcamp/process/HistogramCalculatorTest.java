package bootcamp.process;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
//takes a list of strings and returns a map of strings to integers representing the histogram of word in the input
class HistogramCalculatorTest {

    @Test
    void shouldCalculateTheNumberOfWords() {
        final List<String> words = Arrays.asList(new String[]{"many", "different", "words", "many", "different"});
        HistogramCalculator calculator = new HistogramCalculator();
        Map<String, Integer> wordsMap = new HashMap<>();
        wordsMap.put("many", 2);
        wordsMap.put("different", 2);
        wordsMap.put(("words"), 1);
        System.out.println(calculator.calculate(words));
        assertEquals(calculator.calculate(words), wordsMap);
    }
}