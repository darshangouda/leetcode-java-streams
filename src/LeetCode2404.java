import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

//2404. Most Frequent Even Element
public class LeetCode2404 {
    public int mostFrequentEven(int[] nums) {
        var max = Arrays.stream(nums)
                .boxed()
                .filter(n-> (n&1)==0)
                .collect(Collectors.groupingBy(n->n,Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.<Map.Entry<Integer, Long>>comparingLong(Map.Entry::getValue)
                        .thenComparing(Map.Entry::getKey,Comparator.reverseOrder()));
        return max.isPresent() ? max.get().getKey() : -1;
    }
}
