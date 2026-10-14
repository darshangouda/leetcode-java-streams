public class LeetCode191 {
    public int hammingWeight(int n) {
       return (int)Integer.toBinaryString(n).chars()
                       .filter(digit -> digit=='1')
                       .count();
    }
}
