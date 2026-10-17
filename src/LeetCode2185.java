import java.util.Arrays;
import java.util.stream.IntStream;

//2185. Counting Words With a Given Prefix

public class LeetCode2185 {
    public int prefixCount(String[] words, String pref) {
        return (int) Arrays.stream(words)
                .filter(s -> s.startsWith(pref))
                .count();
    }
}
