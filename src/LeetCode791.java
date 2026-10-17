import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//791. Custom Sort String
public class LeetCode791 {
    public String customSortString(String order, String s) {
        Map<Character, Integer> orderMap = IntStream.range(0, order.length())
                .boxed()
                .collect(Collectors.toMap(order::charAt,
                        Function.identity()));

        return s.chars()
                .boxed()
                .map(in -> (char) in.intValue())
                .sorted(Comparator.comparingInt(ch -> orderMap.getOrDefault(ch, order.length())))
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
