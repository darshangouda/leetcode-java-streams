import java.util.Arrays;
import java.util.stream.Collectors;
//2644. Find the Maximum Divisibility Score

public class LeetCode2644 {

    //Runtime: 1065ms
    public int maxDivScore1(int[] nums, int[] divisors) {
        var map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.summingInt(e -> 1)));

        return Arrays.stream(divisors)
                .boxed()
                .collect(Collectors.toMap(
                        n -> n,
                        n -> map.keySet().stream()
                                .filter(m -> m % n == 0)
                                .map(map::get)
                                .reduce(Integer::sum).orElse(0),
                        (ex, cu) -> ex
                ))
                .entrySet()
                .stream()
                .max((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()) == 0 ?
                        Integer.compare(e2.getKey(), e1.getKey()) : Integer.compare(e1.getValue(), e2.getValue()))
                .get()
                .getKey();
    }

    //1105ms
    public int maxDivScore(int[] nums, int[] divisors) {
        var map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.summingInt(e -> 1)));

        var max = Arrays.stream(divisors)
                .boxed()
                .distinct()
                .map(n -> {
                    int sum = 0;
                    for (int m : map.keySet())
                        if (m % n == 0)
                            sum += map.get(m);
                    return new int[] { n, sum };
                })
                .max((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        return max.get()[0];
    }
}
