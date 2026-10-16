import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//905. Sort Array By Parity
public class LeetCode905 {
    public int[] sortArrayByParity(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                //.sorted(Comparator.comparingInt(n -> n % 2==0 ? 0 : 1)) //14ms
                //.sorted(Comparator.comparingInt(n -> n % 2)) //12ms
                .sorted(Comparator.comparingInt(n -> n & 1)) //14ms
                .mapToInt(Integer::intValue)
                .toArray();
    }

    //Using Map<Integer,Values> : Runtime: 18ms
    // No need to sort keys {0, 1}; they naturally group into buckets 0 and 1 by remainder.
    //More info search google
    public int[] sortArrayByParity1(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n->n%2))
                .values()
                .stream()
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
