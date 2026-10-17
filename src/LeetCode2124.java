import java.util.stream.IntStream;

//2124. Check if All A's Appears Before All B's
public class LeetCode2124 {
    //5ms
    public boolean checkString(String s) {
        return IntStream.range(0, s.length() - 1)
                .noneMatch(i -> s.charAt(i) == 'b' && s.charAt(i + 1) == 'a');
    }
}
