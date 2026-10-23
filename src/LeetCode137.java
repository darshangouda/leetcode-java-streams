//137. Single Number II

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LeetCode137 {
    //22ms
    public int singleNumber1(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(en -> en.getValue() == 1)
                .findFirst()
                .get()
                .getKey();
    }


}
