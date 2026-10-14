//231 Power of two
public class LeetCode231 {

    public boolean isPowerOfTwo_1(int n) {
        return n > 0 && Integer.toBinaryString(n).chars().skip(1).allMatch(digit -> digit == '0');
    }

    public boolean isPowerOfTwo(int n) {
        String base2 = Integer.toString(n,2);
        return base2.charAt(0)=='1' && base2.chars().skip(1).allMatch(digit -> digit =='0');
    }

    static void main() {
        new LeetCode231().isPowerOfTwo(-2147483648);
    }
}
