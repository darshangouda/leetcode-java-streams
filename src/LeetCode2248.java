//2248. Intersection of Multiple Arrays

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode2248 {

    public List<Integer> intersection(int[][] nums) {
        return Arrays.stream(nums)
                .flatMap(arr -> Arrays.stream(arr).boxed())
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == nums.length)
                //.sorted(Comparator.comparingInt(Map.Entry::getKey)) //28 ms
                .map(Map.Entry::getKey)
                .sorted() //25ms
                .toList();
    }

    //21 ms
    public List<Integer> intersection_2(int[][] nums) {
        return Arrays.stream(nums)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toMap( n-> n, n-> 1, Integer::sum,TreeMap::new))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == nums.length)
                .map(Map.Entry::getKey)
                .toList();
    }


    //20ms
    public List<Integer> intersection_3(int[][] nums) {
        return Arrays.stream(nums)
                .flatMap(arr -> Arrays.stream(arr).boxed())
                .collect(Collectors.groupingBy(n -> n, Collectors.summingInt(e->1)))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == nums.length)
                .map(Map.Entry::getKey)
                .sorted()
                .toList();
    }
}
