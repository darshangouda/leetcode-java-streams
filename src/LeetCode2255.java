import java.util.Arrays;

//2255. Count Prefixes of a Given String
public class LeetCode2255 {
    public int countPrefixes(String[] words, String s) {
        return (int) Arrays.stream(words)
                .filter(s::startsWith)
                .count();
    }
}
