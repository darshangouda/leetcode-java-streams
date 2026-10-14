import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetCode896 {

    //Stream API : relational operator matching
    public static boolean isMonotonic(int[] nums) {
          boolean asc = IntStream.range(0, nums.length - 1).allMatch(i -> nums[i] <= nums[i + 1]);
          boolean des = IntStream.range(0, nums.length - 1).allMatch(i -> nums[i] >= nums[i + 1]);
          return asc || des;
    }

    //Stream API : get difference
    public static boolean isMonotonic_2(int[] nums) {
        var values = IntStream.range(0, nums.length - 1).mapToObj(i -> nums[i] - nums[i + 1]).toList();
        return values.stream().allMatch(n -> n <= 0) || values.stream().allMatch(n -> n >= 0);
    }


    public static boolean isMonotonic_3(int[] nums) {
        return IntStream.range(0, nums.length - 1)
                .mapToObj(i -> nums[i] - nums[i + 1])
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.stream().allMatch(n -> n <= 0) || list.stream().allMatch(n -> n >= 0)
                ));
    }

}
