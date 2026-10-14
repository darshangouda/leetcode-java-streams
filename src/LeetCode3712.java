import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class LeetCode3712 {
    //stream API : easy one
    public static int sumDivisibleByK(int[] nums, int k) {
        Map<Integer, Long> freq = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return freq.entrySet().stream()
                .filter(e -> e.getValue() % k == 0)
                .mapToInt(e -> e.getKey() * e.getValue().intValue())
                .sum();
    }

    //Another approach
    public int sumDivisibleByK_2(int[] nums, int k) {
        var lists = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity()));
        var sum = lists.values().stream()
                .filter(list -> list.size() % k == 0)
                .flatMap(List::stream)
                .reduce(Integer::sum);
        return sum.orElse(0);
    }

    //IN sigle go
    public int sumDivisibleByK_3(int[] nums, int k) {
            return Arrays.stream(nums).boxed()
                    .collect(Collectors.collectingAndThen(
                            Collectors.groupingBy(Function.identity()),
                            map -> map.values().stream()
                                    .filter(list -> list.size() % k == 0)
                                    .flatMap(List::stream)
                                    .reduce(0, Integer::sum)
                    ));
        }
}
