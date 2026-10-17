import java.util.Arrays;
import java.util.Comparator;

//3769. Sort Integers by Binary Reflection
public class LeetCode3769 {
    private int getReverseBitNum(int num) {
        int c = 0;
        while (num != 0) {
            c = (c * 2) + (num & 1);
            num = num >> 1;
        }
        return c;
    }

    public int[] sortByReflection(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.comparingInt(this::getReverseBitNum).thenComparing(n -> n))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
