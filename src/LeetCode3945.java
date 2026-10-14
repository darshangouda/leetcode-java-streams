import java.util.function.Function;
import java.util.stream.Collectors;

//3945. Digit Frequency Score
public class LeetCode3945 {
    public int digitFrequencyScore(int n) {
        return Integer.toString(n).chars()
                .map(d -> d - '0')
                .sum();
    }

    public int digitFrequencyScore_2(int n) {
        return (int) Integer.toString(n).chars()
                .map(d -> d - '0')
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey() * entry.getValue())
                .sum();
    }
}
