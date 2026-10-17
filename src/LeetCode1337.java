import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

//1337. The K Weakest Rows in a Matrix
public class LeetCode1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        return IntStream.range(0,mat.length)
                .boxed()
                .sorted(Comparator.<Integer>comparingInt( i  -> Arrays.stream(mat[i]).sum()).thenComparing(i->i))
                .limit(k)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
