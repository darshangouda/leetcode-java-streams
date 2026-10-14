import java.util.stream.IntStream;

//1486. XOR Operation in an Array
public class LeetCode1486 {
    public int xorOperation(int n, int start) {
        return IntStream.range(0,n)
                .mapToObj( i -> start + 2 * i)
                .reduce((a,b) -> a ^b)
                .get();
    }
}
