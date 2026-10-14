//326 Power of 3
public class LeetCode326 {
    public boolean isPowerOfThree(int n) {
        String base3 = Integer.toString(n, 3);
        return base3.charAt(0) == '1' && base3.chars().skip(1).allMatch(digit -> digit == '0');
    }
}
