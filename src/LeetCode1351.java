import java.util.Arrays;
import java.util.stream.IntStream;

//1351. Count Negative Numbers in a Sorted Matrix
public class LeetCode1351 {
    public int countNegatives(int[][] grid) {
        return Arrays.stream(grid)
                .mapToInt(ints -> (int) Arrays.stream(ints).dropWhile(n -> n >= 0).count())
                .sum();
    }
}
