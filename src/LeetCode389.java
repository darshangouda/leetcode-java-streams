//389. Find the Difference
public class LeetCode389 {
    public char findTheDifference(String s, String t) {
        int sum_S = s.chars().reduce(0, Integer::sum);
        int sum_T = t.chars().reduce(0, Integer::sum);
        return (char) (sum_T - sum_S);
    }
}
