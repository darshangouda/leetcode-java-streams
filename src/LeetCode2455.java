import java.util.Arrays;

//2455. Average Value of Even Numbers That Are Divisible by Three
public class LeetCode2455 {
    public int averageValue(int[] nums) {
           return (int)Arrays.stream(nums)
                   .filter( n-> n%2==0 && n%3==0)
                   .average()
                   .orElse(0);
    }
}
