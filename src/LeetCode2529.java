import java.util.Arrays;
import java.util.stream.Collectors;

public class LeetCode2529 {
    public int maximumCount(int[] nums) {
        var map = Arrays.stream(nums)
                .boxed()
                .filter(n->n!=0)
                .collect(Collectors.groupingBy(n->n>=0,Collectors.summingInt(e->1)));
        return Math.max(map.getOrDefault(true,0),map.getOrDefault(false,0));
    }
}
