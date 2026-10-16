import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//1122. Relative Sort Array
public class LeetCode1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        var map = IntStream.range(0, arr2.length).boxed()
                .collect(Collectors.toMap(i -> arr2[i], i -> i, (ex, cu) -> ex));

        return Arrays.stream(arr1)
                .boxed()
                .sorted(Comparator.<Integer>comparingInt(n -> map.getOrDefault(n, arr2.length))
                        .thenComparing(n -> n))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
