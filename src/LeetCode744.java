import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class LeetCode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        return (char)IntStream.range(0,letters.length)
                .map(i->letters[i])
                .filter( ch -> ch > target)
                .min()
                .orElse(letters[0]);
    }
}
