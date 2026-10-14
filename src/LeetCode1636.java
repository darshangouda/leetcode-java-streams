import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//1636. Sort Array by Increasing Frequency
public class LeetCode1636 {

    public int[] frequencySort_(int[] nums) {
        // 1. Build an int-based frequency map using summingInt
        Map<Integer, Integer> countMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));

        // 2. Sort by frequency ascending, then by value descending for ties
        return Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.comparingInt((Integer n) -> countMap.get(n))
                        .thenComparing(Comparator.reverseOrder()))
                .mapToInt(i -> i)
                .toArray();
    }


    public int[] frequencySort(int[] nums) {
        // 1. Build an int-based frequency map using summingInt
        Map<Integer, List<Integer>> countMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity()));

        // 2. Sort by frequency ascending, then by value descending for ties
        return countMap
                .values()
                .stream()
                .sorted((list1, list2) ->
                        list1.size() != list2.size() ? Integer.compare(list1.size(), list2.size()) : Integer.compare(list2.getFirst(), list1.getFirst()))
                .flatMap(List::stream)
                .mapToInt(i -> i)
                .toArray();
    }

}
