import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//2215. Find the Difference of Two Arrays
public class LeetCode2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        res.add(Minus(set1, set2));
        res.add(Minus(set2, set1));
        return res;
    }

    private List<Integer> Minus(Set<Integer> set1, Set<Integer> set2) {
        return set1.stream().filter(num -> !set2.contains(num)).toList();
    }
}
