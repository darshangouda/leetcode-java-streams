import java.util.Arrays;
import java.util.stream.Collectors;

//2129. Capitalize the Title
public class LeetCode2129 {
    public String capitalizeTitle(String title) {
        return Arrays.stream(title.split(" "))
                .map( s -> s.length()<=2 ? s.toLowerCase() : Character.toUpperCase(s.charAt(0))+s.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
}
