import java.util.stream.Collectors;

//709. To Lower Case
public class LeetCode709 {
    public String toLowerCase(String s) {
        return s.chars()
                .map(Character::toLowerCase)
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }
}
