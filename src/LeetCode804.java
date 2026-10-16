import java.util.Arrays;
import java.util.stream.Collectors;

//804. Unique Morse Code Words

public class LeetCode804 {
    private static final String[] MORSE_CODE = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
            ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        return (int) Arrays.stream(words)
                .map(word -> word.chars()
                        .mapToObj(c -> MORSE_CODE[c - 'a'])
                        .collect(Collectors.joining()))
                .distinct()
                .count();
    }
}
