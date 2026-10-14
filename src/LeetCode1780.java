//1780  Check if Number is a Sum of Powers of Three
public class LeetCode1780 {
    public boolean checkPowersOfThree(int n) {
        return Integer.toString(n,3).chars().allMatch(d -> d=='1' || d=='0');
    }
}
