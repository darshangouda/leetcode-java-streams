import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//2942. Find Words Containing Character
public class LeetCode2942 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        return IntStream.range(0, words.length)
                .boxed()
                .filter( i -> words[i].indexOf(x)>=0)
                .toList();
    }
}
