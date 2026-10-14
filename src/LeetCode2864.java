import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//2864. Maximum Odd Binary Number
public class LeetCode2864 {
    public String maximumOddBinaryNumber(String s) {
        var res = s.chars()
                .mapToObj(n -> (char) n)
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());
        return res.substring(1)+"1";
    }

    public String maximumOddBinaryNumber_2(String s) {
        var res = s.chars()
                .mapToObj(n -> (char) n)
                .collect(Collectors.partitioningBy(n-> n=='0'))
                .entrySet()
                .stream()
                .flatMap(n -> n.getValue().stream())
                .map(String::valueOf)
                .collect(Collectors.joining());
        return res.substring(1)+"1";
    }

    static void main() {
        LeetCode2864 obj = new LeetCode2864();
        System.out.println(obj.maximumOddBinaryNumber("010"));
    }
}
