import java.util.stream.Collectors;
import java.util.stream.IntStream;

//541. Reverse String II
public class LeetCode541 {

    public String reverseStr(String s, int k) {
        return IntStream.range(0, (s.length() + k) / k)
                .mapToObj(i -> {
                    int start = i * k;
                    String str = s.substring(start, Math.min(start + k, s.length()));
                    return i % 2 == 0 ? new StringBuilder(str).reverse().toString() : str;
                })
                .collect(Collectors.joining());
    }

    //with regexp to split the string by k size
    public String reverseStr_2(String s, int k) {
        String[] str = s.split("(?<=\\G.{" + k + "})");
        return IntStream.range(0, str.length)
                .mapToObj(i -> (i % 2 == 0) ? new StringBuilder(str[i]).reverse().toString() : str[i])
                .collect(Collectors.joining());
    }
}
