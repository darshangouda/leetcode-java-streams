import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//824. Goat Latin
public class LeetCode824 {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        return  IntStream.range(0, words.length)
                .mapToObj(i -> {
                            String s = words[i];
                            char first = s.charAt(0);
                            String repeate = "a".repeat(i+1);
                            return "aeiouAEIOU".indexOf(first) != -1 ?
                                    s.concat("ma").concat(repeate) :
                                    s.substring(1).concat(Character.toString(first).concat("ma")).concat(repeate);
                        }
                )
                .collect(Collectors.joining(" "));
    }
}
