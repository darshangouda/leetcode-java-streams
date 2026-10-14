import java.util.Comparator;

//3536. Maximum Product of Two Digits
public class LeetCode3536 {
    public int maxProduct(int n) {
           return Integer.toString(n).chars()
                   .map(d -> d-'0')
                   .boxed()
                   .sorted(Comparator.reverseOrder())
                   .limit(2)
                   .reduce(1,(ex,cu)-> ex * cu);
    }
}
