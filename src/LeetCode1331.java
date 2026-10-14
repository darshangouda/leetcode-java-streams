import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetCode1331 {
    class Solution {
        public int[] arrayRankTransform1(int[] arr) {

            int[] distinctSorted = Arrays.stream(arr).distinct().sorted().toArray();

            var map = IntStream.range(0, distinctSorted.length)
                    .mapToObj(ind -> Map.entry(distinctSorted[ind], ind))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            return IntStream.range(0, arr.length)
                    .mapToObj(ind -> map.get(arr[ind]) + 1)
                    .mapToInt(Integer::intValue).toArray();
        }

        public int[] arrayRankTransform(int[] arr) {
            int[] sorted = Arrays.stream(arr).distinct().sorted().toArray();

            Map<Integer, Integer> rank = IntStream.range(0, sorted.length)
                    .boxed()
                    .collect(Collectors.toMap(i -> sorted[i], i -> i + 1));

            return Arrays.stream(arr).map(rank::get).toArray();
        }
    }
}
