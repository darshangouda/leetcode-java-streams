import java.util.stream.IntStream;

//1480. Running Sum of 1d Array
public class LeetCode1480 {
    public int[] runningSum(int[] nums) {
        int[] sum = {0};
        return IntStream.of(nums)
                .map(x -> sum[0] += x)
                .toArray();
    }
}
