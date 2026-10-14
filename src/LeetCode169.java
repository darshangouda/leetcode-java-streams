import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class LeetCode169 {

    public int majorityElement(int[] nums) {
            return Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .get()
                    .getKey();
    }

    public int majorityElement_2(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.collectingAndThen(
                Collectors.groupingBy(Function.identity(), Collectors.counting()),
                map -> map.entrySet().stream().max((a, b) -> Long.compare(a.getValue(), b.getValue())).get().getKey()));
    }
}
