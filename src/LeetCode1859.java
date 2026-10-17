//1859. Sorting the Sentence

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LeetCode1859 {
    public String sortSentence(String s) {
        return Arrays.stream(s.split("\\s+"))
                .sorted(Comparator.comparingInt(str -> str.charAt(str.length() - 1)))
                .map(str -> str.substring(0, str.length() - 1))
                .collect(Collectors.joining(" "));
    }
}
