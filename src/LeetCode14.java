//14. Longest Common Prefix

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        String min = Arrays.stream(strs).min(Comparator.naturalOrder()).get();
        String max = Arrays.stream(strs).max(Comparator.naturalOrder()).get();

        int len = Math.min(min.length(),max.length());

        return IntStream.iterate(len,i -> i >=0, i -> --i)
                .filter(i -> min.startsWith(max.substring(0,i)))
                .mapToObj(i -> min.substring(0,i))
                .peek(System.out::println)
                .findFirst()
                .get();
    }
}
