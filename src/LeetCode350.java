import java.util.*;
import java.util.stream.Collectors;

//350. Intersection of Two Arrays II
public class LeetCode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = Arrays.stream(nums1).boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.summingInt(e -> 1)));
        return Arrays.stream(nums2)
                .filter(n -> {
                    int key = map.getOrDefault(n, 0);
                    if (key <= 0)
                        return false;
                    map.put(n, key - 1);
                    return true;
                })
                .toArray();
    }

    public int[] intersect_2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = Arrays.stream(nums1).boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.summingInt(e -> 1)));
        return Arrays.stream(nums2)
                .filter(n -> {
                    if(!map.containsKey(n)){
                        return false;
                    }
                    else{
                        if(map.put(n,map.get(n)-1)==1)
                            map.remove(n);
                        return true;
                    }
                })
                .toArray();
    }
}
