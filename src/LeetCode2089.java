import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetCode2089{
    //2089. Find Target Indices After Sorting Array
        public List<Integer> targetIndices(int[] nums, int target) {
            Arrays.sort(nums);
            return IntStream.range(0,nums.length)
                    .boxed()
                    .filter(i -> nums[i]==target)
                    .toList();
        }
}
