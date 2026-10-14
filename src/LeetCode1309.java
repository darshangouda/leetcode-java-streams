import java.util.regex.Pattern;
import java.util.stream.Collectors;

//1309. Decrypt String from Alphabet to Integer Mapping
public class LeetCode1309 {
    public String freqAlphabets(String s) {
        return Pattern.compile("\\d{2}#|\\d")
                .matcher(s)
                .results()
                .map(mr -> mr.group())
                .map(str -> str.replace("#", ""))
                .map(str -> String.valueOf((char) (Integer.parseInt(str) - 1 + 'a')))
                .collect(Collectors.joining());
    }
}
