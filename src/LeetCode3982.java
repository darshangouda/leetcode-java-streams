import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

//3982. Sum of Integers with Maximum Digit Range
public class LeetCode3982 {
    public int maxDigitRange(int[] nums) {
        var map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num ->
                        Integer.toString(num).chars().map(d -> d - '0').max().orElse(0) -
                                Integer.toString(num).chars().map(d -> d - '0').min().orElse(0))
                );

        var maxEntry = map.entrySet().stream().max((Comparator.comparingInt(Map.Entry::getKey)));

        return maxEntry.get().getValue()
                .stream()
                .reduce(Integer::sum).orElse(0);
    }
}
