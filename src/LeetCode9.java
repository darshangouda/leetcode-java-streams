import java.util.stream.IntStream;

//9. Palindrome Number
public class LeetCode9 {
    public boolean isPalindrome(int x) {
        char[] nums = Integer.toString(x).toCharArray();
        return x >= 0 && IntStream.range(0,nums.length).allMatch(i -> nums[i] == nums[nums.length-1-i]);
    }
}
