import java.util.Comparator;
import java.util.stream.IntStream;

//747. Largest Number At Least Twice of Others
public class LeetCode747 {
    public int dominantIndex(int[] nums) {
        int maxIndex = IntStream.range(0, nums.length)
                .boxed()
                .max(Comparator.comparingInt(i -> nums[i]))
                .get();

        boolean have = IntStream.range(0, nums.length)
                .filter(i -> nums[maxIndex] != nums[i])
                .allMatch(i -> nums[maxIndex] >= nums[i] * 2);
        return have ? maxIndex : -1;
    }
}
