import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//1207. Unique Number of Occurrences
public class LeetCode1207 {
    public boolean uniqueOccurrences_1(int[] arr) {
        var map = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        var map2 = map.values()
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        var val = map2.values().stream().max(Long::compareTo);
        return val.get() == 1;
    }

    //simple one
    public boolean uniqueOccurrences(int[] arr) {
        var freq = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .values();

        // If the distinct count equals the total count, all frequencies are unique
        return freq.stream().distinct().count() == freq.size();
    }
}
