import java.util.stream.IntStream;

public class LeetCode1455 {
    //4ms
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split("\\s+");
        return IntStream.range(1,words.length+1)
                .boxed()
                .filter(i -> words[i-1].startsWith(searchWord))
                .findFirst()
                .orElse(-1);
    }
}
