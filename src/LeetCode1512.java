import java.util.Arrays;
import java.util.stream.Collectors;

//1512. Number of Good Pairs

public class LeetCode1512 {

    public int numIdenticalPairs(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.summingInt(e -> 1)))
                .values().stream()
                .mapToInt(count -> count * (count - 1) / 2)
                .sum();
    }

}
