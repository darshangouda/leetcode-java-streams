import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class LeetCode2395 {
    // 2395. Find Subarrays With Equal Sum

    public boolean findSubarrays(int[] nums) {
        Set<Integer> visited = HashSet.newHashSet(nums.length);

        return IntStream.range(1, nums.length)
                .boxed()
                .anyMatch(index -> !visited.add(nums[index - 1] + nums[index]));
    }
}
