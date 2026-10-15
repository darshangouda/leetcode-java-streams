import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//459. Repeated Substring Pattern
public class LeetCode459 {

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        return IntStream.rangeClosed(1, len / 2)
                .filter(i -> len % i == 0) // Only check lengths that divide perfectly
                .anyMatch(i -> {
                    String sub = s.substring(0, i);
                    // Check if the remaining parts of the string match the pattern
                    return IntStream.iterate(i, j -> j < len, j -> j + i)
                            .allMatch(j -> s.startsWith(sub, j));
                });
    }

    public boolean repeatedSubstringPattern_2(String s) {
            return IntStream.rangeClosed(0,s.length()/2)
                    .anyMatch( i -> s.length() % i == 0  &&
                            Arrays.stream(s.split("(?<=\\G.{" + i + "})")).collect(Collectors.toSet()).size()==1
                    );
    }

}
