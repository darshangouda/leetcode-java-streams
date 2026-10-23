import java.util.Arrays;

public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        var arr = Arrays.stream(nums).filter(n -> n != val).toArray();
        System.arraycopy(arr, 0, nums, 0, arr.length);
        return arr.length;
    }
}
