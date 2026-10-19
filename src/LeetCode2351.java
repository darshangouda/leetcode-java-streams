import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//2351. First Letter to Appear Twice
public class LeetCode2351 {

    public char repeatedCharacter(String s) {
        Set<Integer> set = new HashSet<>();
        return (char)s.chars()
                .filter(ch -> !set.add(ch))
                .findFirst()
                .orElse('\0');
    }

    public char repeatedCharacter1(String s) {
        var map = IntStream.range(0, s.length())
                .boxed()
                .collect(Collectors.groupingBy(s::charAt));

        int index = map.values()
                .stream()
                .filter(l -> l.size() > 1)
                .map(l -> l.get(1))
                .min(Comparator.comparingInt(num -> num))
                .orElse(-1);

        return index != -1 ? s.charAt(index) : '0';
    }

    //Runtime: 11ms
    public char repeatedCharacter_1(String s) {
        // Just a creative way dont follow blindly
        var map = IntStream.range(0, s.length())
                .boxed()
                .collect(Collectors.groupingBy(i -> s.indexOf(s.charAt(i), i + 1)));

        //You can see the distance between same char
        //System.out.println(map);

        var index = map.keySet()
                .stream()
                .sorted()
                .dropWhile(i -> i == -1)
                .findFirst();

        //return index.isPresent() ? s.charAt(index.get().intValue()): '0';
        return index.map(s::charAt).orElse('0');
    }

    //Runtime: 9ms
    public char repeatedCharacter_2(String s) {
        // Just a creative way dont follow blindly
        var set = IntStream.range(0, s.length())
                .boxed()
                .map(i -> s.indexOf(s.charAt(i), i + 1))
                .collect(Collectors.toSet());

        var index = set
                .stream()
                .sorted()
                .dropWhile(i -> i == -1)
                .findFirst();

        //return index.isPresent() ? s.charAt(index.get().intValue()): '0';
        return index.map(s::charAt).orElse('0');
    }
}
