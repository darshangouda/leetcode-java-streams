import java.util.Arrays;
import java.util.Comparator;

public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        var arr = Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.comparingInt(n-> n==0 ? 1 : 0))
                .mapToInt(Integer::intValue)
                .toArray();
        System.arraycopy(arr, 0, nums, 0, arr.length);
    }
}
