import java.util.*;
import java.util.stream.Collectors;

//1128. Number of Equivalent Domino Pairs
public class LeetCode1128 {

    //Runtime: 14ms
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

    //Runtime: 14ms
    public int numEquivDominoPairs(int[][] dominoes) {
        var res = Arrays.stream(dominoes)
                .collect(Collectors.groupingBy(a -> Math.min(a[0] * 10 + a[1] , a[1] * 10 + a[0]),
                        Collectors.summingInt(e->1)))
                .values()
                .stream()
                .mapToInt(freq -> freq * (freq - 1) / 2)
                .reduce(Integer::sum);

        return res.getAsInt();
    }
}
