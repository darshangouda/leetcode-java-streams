import java.util.*;
import java.util.stream.Collectors;

//1128. Number of Equivalent Domino Pairs
public class LeetCode1128 {
    public int numEquivDominoPairs_(int[][] dominoes) {
        var res = Arrays.stream(dominoes)
                .collect(Collectors.groupingBy(a -> a[0] < a[1] ? a[0] * 10 + a[1] : a[1] * 10 + a[0],
                        Collectors.counting()))
                .values()
                .stream()
                .mapToInt(freq -> {
                    freq--;
                    return (int) (freq * (freq + 1)) / 2; //summation
                })
                .reduce(Integer::sum);

        return res.getAsInt();
    }
}
