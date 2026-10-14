import java.util.Arrays;

public class LeetCode1935 {
    //Using Stream API 7ms
        public int canBeTypedWords(String text, String brokenLetters) {
            return (int) Arrays.stream(text.split(" "))
                    .filter(word -> brokenLetters.chars().noneMatch(ch -> word.indexOf(ch) >= 0))
                    .count();
        }
}
