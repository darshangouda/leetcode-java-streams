import java.util.stream.IntStream;

//3931. Check Adjacent Digit Differences
public class LeetCode3931 {
    public boolean isAdjacentDiffAtMostTwo(String s) {
           return IntStream.range(0,s.length()-1)
                   .allMatch( index -> Math.abs(s.charAt(index)-s.charAt(index+1))<=2);
    }
}
