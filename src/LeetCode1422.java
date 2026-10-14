import java.util.stream.IntStream;

//1422. Maximum Score After Splitting a String
public class LeetCode1422 {
    public int maxScore(String s) {
        return (int) IntStream.range(1, s.length())
                .mapToLong(i -> s.substring(0, i).chars().filter(e -> e == '0').count()
                        + s.substring(i).chars().filter(e -> e == '1').count())
                .max()
                .orElse(0);
    }
}
