//136. Single Number

import java.util.Arrays;

public class LeetCode136 {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums)
                .reduce((a, b)->a^b)
                .getAsInt();
    }
}
