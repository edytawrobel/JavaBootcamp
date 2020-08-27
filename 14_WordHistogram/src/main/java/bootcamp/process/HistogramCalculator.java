package bootcamp.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class HistogramCalculator {
    public Map<String, Integer> calculate(final List<String> words) {
//        Map<String, Integer> histogram = new HashMap<String, Integer>();
        Map<String, Integer> histogram = words.stream()
                .collect(toMap(
                        s -> s,
                        s -> 1,
                        Integer::sum));

//        for (String word : words) {
//            histogram.put(word, histogram.get(word) + 1);
//        }
        return histogram;
    }
}

//takes a list of strings and returns a map of strings to integers representing the histogram of word in the input