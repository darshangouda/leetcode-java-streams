import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

//2042. Check if Numbers Are Ascending in a Sentence

public class LeetCode2042 {
    public boolean areNumbersAscending(String s) {
        Pattern pattern = Pattern.compile("\\d+"); // \\d+ matches one or more digits

        List<Integer> list = pattern.matcher(s)
                .results()                          // Stream of MatchResults
                .map(MatchResult::group) // Extract the matched string
                .map(Integer::parseInt)
                .toList();

        return IntStream.range(0,list.size()-1)
                .allMatch(i-> list.get(i)<list.get(i+1));
    }
}
