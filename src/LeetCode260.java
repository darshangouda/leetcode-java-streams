//260. Single Number III

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCode260 {
    //20ms
    public int[] singleNumber(int[] nums) {
       return Arrays.stream(nums)
               .boxed()
               .collect(Collectors.groupingBy(n->n,Collectors.counting()))
               .entrySet()
               .stream()
               .filter( en -> en.getValue()==1)
               .limit(2)
               .mapToInt(Map.Entry::getKey)
               .toArray();
    }
}
