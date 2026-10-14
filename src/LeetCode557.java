import java.util.Arrays;
import java.util.stream.Collectors;

//557. Reverse Words in a String III
public class LeetCode557 {
    public String reverseWords(String s) {
        return     Arrays.stream(s.split(" "))
                .map( str -> new StringBuilder(str).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}
