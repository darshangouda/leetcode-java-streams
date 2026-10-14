import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LeetCode1897 {
    // Redistribute Characters to Make All Strings Equal
    public boolean makeEqual1(String[] words) {

        int[] freq = new int['z' + 1];

        for (String s : words) {
            for (char ch : s.toCharArray()) {
                freq[ch]++;
            }
        }

        for (int i = 'a'; i <= 'z'; i++) {
            if (freq[i] % words.length != 0)
                return false;
        }

        return true;
    }
    public boolean makeEqual2(String[] words) {
        return Arrays.stream(words).flatMap( n -> n.chars().mapToObj(c -> (char)c) ).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .allMatch( entry -> entry.getValue() % words.length ==0);


       // return false;
    }

    public boolean makeEqual(String[] words) {
        return Arrays.stream(words)
                .flatMapToInt(String::chars)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .allMatch(count -> count % words.length == 0);
    }

    public static void main(String[] args) {

        LeetCode1897 obj = new LeetCode1897();

        String[] words = {"abc", "aabc", "bc"};

        System.out.println(obj.makeEqual(words));
    }
}