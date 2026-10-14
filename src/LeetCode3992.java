import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//3992. Rearrange String to Avoid Character Pair
public class LeetCode3992 {
    public String rearrangeString_1(String s, char x, char y) {
         return s.chars()
                .mapToObj(n -> (char)n)
                .sorted(
                        // 1. Group characters by priority weights
                        Comparator
                        .<Character>comparingInt(ch -> {
                            if (ch == y) return 0; // 'y' always goes to the very front
                            if (ch == x) return 2; // 'x' always goes to the very back
                            return 1;              // All other characters stay in the middle
                        })
                        // 2. Tie-breaker ensures elements with the same weight match consistently
                        //.thenComparing(Character::compareTo)
                )
                 .map(String::valueOf)
                .collect(Collectors.joining());
    }

    //Simple Approach
    public String rearrangeString(String s, char x, char y) {
        return s.chars()
                .mapToObj(n -> (char) n)
                .sorted(Comparator.<Character>comparingInt(ch -> ch == y ? 0 : 1))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    // another approach
    public String rearrangeString2(String s, char x, char y) {
        return s.chars()
                .mapToObj(n -> (char) n)
                .sorted((m, n) -> {
                    if (m == y)
                        return -1; // m is 'y', so m comes first
                    if (n == y)
                        return 1; // n is 'y', so n comes first
                    return m.compareTo(n);
                })
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}
