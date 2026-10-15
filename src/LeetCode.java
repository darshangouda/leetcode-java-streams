import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetCode {
    public boolean isPalindrome(int x) {
        char[] nums = Integer.toString(x).toCharArray();
        return x >= 0 && IntStream.range(0,nums.length).allMatch( i -> nums[i] == nums[nums.length-1-i]);
    }

    public int[] rearrangeArray(int[] nums) {
        var map = Arrays.stream(nums).boxed()
                .collect(Collectors.toMap( n ->n, n->1,Integer::sum,TreeMap::new));

        int[] res = new int[nums.length];
        int start =0;
        while(!map.isEmpty()) {
            Set<Integer> set = map.keySet();
            for (int key : set) {
                res[start++] = key;
                if (map.get(key) == 1)
                    map.remove(key);
                else
                    map.put(key,map.get(key)-1);
            }
        }
        return res;
    }
}
