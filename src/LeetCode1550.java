import java.util.Arrays;
import java.util.stream.IntStream;

//1550. Three Consecutive Odds
public class LeetCode1550 {
    public boolean threeConsecutiveOdds(int[] a) {
        return IntStream.range(0,a.length-2)
                .anyMatch(i ->(1 & a[i] &  a[i+1] &  a[i+2]) == 1);
    }
}
