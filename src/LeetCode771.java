import java.util.Set;
import java.util.stream.Collectors;

//771. Jewels and Stones
public class LeetCode771 {
    public int numJewelsInStones(String jewels, String stones) {
        var set = jewels.chars().boxed().collect(Collectors.toSet());
        return (int) stones.chars().filter(set::contains).count();
    }
}
