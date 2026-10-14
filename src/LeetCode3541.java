import java.util.function.Function;
import java.util.stream.Collectors;

//3541. Find Most Frequent Vowel and Consonant
public class LeetCode3541 {
    public int maxFreqSum(String s) {
        var outerMap = s.chars().boxed().collect(Collectors.partitioningBy(
                c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u',
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())));

        var res = outerMap.values()
                .stream() //.peek(System.out::println)
                .map(innerMap -> innerMap.values().stream().max(Long::compareTo).orElse(0L))
                .reduce(0L, Long::sum);

        return (int) res.longValue();
    }
}
