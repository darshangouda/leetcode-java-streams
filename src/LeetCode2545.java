import java.util.Arrays;
import java.util.Comparator;

// 2545. Sort the Students by Their Kth Score

public class LeetCode2545 {

    //8ms
    public int[][] sortTheStudents1(int[][] score, int k) {
        return Arrays.stream(score)
                .sorted(Comparator.<int[]>comparingInt(A-> A[k]).reversed())
                .toList()
                .toArray(int[][]::new);
    }

    //5ms
    public int[][] sortTheStudents(int[][] score, int k) {
        return Arrays.stream(score)
                .sorted( (A,B)->B[k]-A[k])
                .toList()
                .toArray(int[][]::new);
    }
}
