import java.util.*;

//500. Keyboard Row
public class LeetCode500 {

    public String[] findWords_2(String[] words) {
        String first = "qwertyuiopQWERTYUIOP";
        String second = "asdfghjklASDFGHJKL";
        String third = "zxcvbnmZXCVBNM";
        return Arrays.stream(words)
                .filter(s -> s.chars().allMatch(ch -> first.indexOf(ch) != -1)
                        || s.chars().allMatch(ch -> second.indexOf(ch) != -1)
                        || s.chars().allMatch(ch -> third.indexOf(ch) != -1))
                .toArray(String[]::new); //OR //.toList().toArray(new String[0])
    }

    //simple by string match
    public String[] findWords(String[] words) {
        String firstMatch = "^[qwertyuiopQWERTYUIOP]+$";
        String secondMatch = "^[asdfghjklASDFGHJKL]+$";
        String thirdMatch = "^[zxcvbnmZXCVBNM]+$";

        return Arrays.stream(words)
                .filter(s -> s.matches(firstMatch) || s.matches(secondMatch) || s.matches(thirdMatch))
                .toArray(String[]::new);  //OR //.toList().toArray(new String[0])
    }

}
