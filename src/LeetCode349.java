import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LeetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toUnmodifiableSet());
        return Arrays.stream(nums2)
                //.distinct() //9ms
                .filter(set1::contains)
                .distinct() //9ms
                .toArray();
    }
}
