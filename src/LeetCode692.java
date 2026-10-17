import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//692. Top K Frequent Words
public class LeetCode692 {
    public List<String> topKFrequent(String[] words, int k) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(str->str,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.<Map.Entry<String,Long>>comparingLong(Map.Entry::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey,Comparator.naturalOrder()))
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }
}
