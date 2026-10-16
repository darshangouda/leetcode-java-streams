import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//2138. Divide a String Into Groups of Size k
public class LeetCode2138 {

    //Runtime: 7ms
    public String[] divideString(String s, int k, char fill) {
        int remainder = s.length() % k;

        String str = remainder != 0 ? s.concat(String.valueOf(fill).repeat(k - remainder)) : s;

        return  IntStream.iterate(0, j -> j < str.length(), j -> j += k)
                .mapToObj(j -> str.substring(j, j + k))
                .toList()
                .toArray(new String[0]);
    }
}
