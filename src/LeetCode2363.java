import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//2363. Merge Similar Items
public class LeetCode2363 {

        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            return Stream.of(items1, items2)
                    .flatMap(Arrays::stream)
                    .collect(Collectors.collectingAndThen(
                            Collectors.toMap(
                                    arr -> arr[0], // Key: Item value
                                    arr -> arr[1], // Value: Item weight
                                    Integer::sum, // Merge function if keys collide
                                    TreeMap::new // Map supplier to keep keys sorted
                            ),
                            map -> map.entrySet().stream()
                                    .map(entry -> List.of(entry.getKey(), entry.getValue()))
                                    .toList()));
        }

}
