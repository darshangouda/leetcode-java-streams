import java.util.Arrays;
import java.util.stream.Collectors;

//3280. Convert Date to Binary
public class LeetCode3280 {
    public String convertDateToBinary(String date) {
        return Arrays.stream(date.split("-"))
                .map(str -> Integer.toBinaryString(Integer.parseInt(str)) )
                .collect(Collectors.joining("-"));
    }
}
