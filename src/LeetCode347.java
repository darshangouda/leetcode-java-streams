import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.summingInt(e->1)));

        return map.entrySet()
                .stream()
                .sorted(Comparator.<Map.Entry<Integer,Integer>>comparingInt(Map.Entry::getValue).reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
