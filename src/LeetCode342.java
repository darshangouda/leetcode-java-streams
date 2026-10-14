public class LeetCode342 {
    public boolean isPowerOfFour(int n) {
        System.out.println(Integer.toString(n,4));
        String base4 = Integer.toString(n,4);
        return base4.charAt(0)=='1' && base4.chars().skip(1).allMatch(digit -> digit =='0');
    }

    static void main() {
        new LeetCode342().isPowerOfFour(8);
    }
}
