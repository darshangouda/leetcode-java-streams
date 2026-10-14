import java.util.function.Function;
import java.util.stream.Collectors;

public class LeetCode1941 {
        public boolean areOccurrencesEqual(String s) {
               return s.chars().boxed()
                       .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                       .values()
                       .stream()
                       .distinct()
                       .count() ==1;

        }
}
