//3158. Find the XOR of Numbers Which Appear Twice

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LeetCode3158 {

    //27ms
    public int duplicateNumbersXOR1(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n->n,Collectors.counting()))
                .entrySet()
                .stream()
                .filter( en -> en.getValue()==2)
                .mapToInt(Map.Entry::getKey)
                .reduce((a,b)-> a^ b)
                .orElse(0);
    }

    //13ms
    //Constraints: Each number in nums appears either once or twice.
    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        return Arrays.stream(nums)
                .boxed()
                .filter(n-> !set.add(n))
                .reduce((a,b)-> a^ b)
                .orElse(0);
    }
}
