import java.util.Arrays;

//1598. Crawler Log Folder
public class LeetCode1598 {
    public int minOperations(String[] logs) {
        return Arrays.stream(logs)
                .mapToInt(s -> s.equals("../") ? -1 : (s.equals("./") ? 0 : 1))
                .reduce(0, (sum, cu) -> {
                    sum += cu;
                    return Math.max(sum, 0);
                });
    }
}
