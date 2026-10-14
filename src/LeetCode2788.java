import java.util.Arrays;
import java.util.List;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class LeetCode2788 {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        // Pattern.quote safely escapes characters like '.' or '$' automatically
        String regex = Pattern.quote(String.valueOf(separator));

        return words.stream()
                .map(str -> str.split(regex))
                .flatMap(Arrays::stream)
                .filter(s -> !s.isEmpty())
                .toList();
    }

    static void main(String[] args) {
        LeetCode2788 solver = new LeetCode2788();

        // Test Case 1: Dot (.) separator
        List<String> words1 = Arrays.asList("one.two.three", "four.five", "six");
        List<String> result1 = solver.splitWordsBySeparator(words1, '.');
        System.out.println("Test 1 Result: " + result1);
        // Output: [one, two, three, four, five, six]

        // Test Case 2: Dollar ($) separator
        List<String> words2 = Arrays.asList("$easy$", "$problem$");
        List<String> result2 = solver.splitWordsBySeparator(words2, '$');
        System.out.println("Test 2 Result: " + result2);
        // Output: [easy, problem]
    }
}

