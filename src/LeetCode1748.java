//1748. Sum of Unique Elements

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LeetCode1748 {

    //14ms
    public int sumOfUnique(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy( n -> n,Collectors.summingInt(e->1)))
                .entrySet()
                .stream()
                .filter( en -> en.getValue()==1)
                .map(Map.Entry::getKey)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
