import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//2540. Minimum Common Value
public class LeetCode2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toUnmodifiableSet());
        return Arrays.stream(nums2)
                .filter(set1::contains)
                .min()
                .orElse(-1);
    }
}
