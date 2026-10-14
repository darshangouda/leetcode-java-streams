import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LeetCode3005 {
        public int maxFrequencyElements(int[] nums) {
            var counts = Arrays.stream(nums).boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            long max = counts.values().stream().max(Long::compareTo).orElse(0L);

            return (int) counts.values().stream()
                    .filter(v -> v == max)
                    .mapToLong(Long::longValue)
                    .sum();
        }
}
