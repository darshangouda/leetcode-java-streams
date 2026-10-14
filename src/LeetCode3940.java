import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//3940. Limit Occurrences in Sorted Array
public class LeetCode3940 {

    public int[] limitOccurrences(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        return Arrays.stream(nums)
                .filter(key -> freq.merge(key, 1, Integer::sum) <= k)
                .toArray();
    }

    public int[] limitOccurrences_2(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        return Arrays.stream(nums)
                .filter(key -> {
                    freq.put(key, freq.getOrDefault(key, 0) + 1);
                    return freq.get(key) <= k;
                })
                .toArray();
    }
}
