import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetCode2006 {

    //It's just a loop, not a standard way
    //Is this good standard way?
    public int countKDifference(int[] nums, int k) {

        Map<Integer,Integer> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n->n,Collectors.summingInt(e->1)));
        return Arrays.stream(nums)
                .map( n -> map.getOrDefault(n+k,0))
                .sum();
    }
}
