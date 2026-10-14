import java.util.Comparator;

//1624. Largest Substring Between Two Equal Characters
public class LeetCode1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        return s.chars()
                .map(ch -> s.lastIndexOf(ch) - s.indexOf(ch) - 1)
                .max()
                .getAsInt();
    }
}
