import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//2351. First Letter to Appear Twice
public class LeetCode2351 {

    public char repeatedCharacter(String s) {
        var map = IntStream.range(0, s.length())
                .boxed()
                .collect(Collectors.groupingBy(s::charAt));

        var index = map.values()
                .stream()
                .filter(l -> l.size() > 1)
                .min(Comparator.<List<Integer>>comparingInt(l -> l.get(1)))
                .get();

        return index.getFirst() != -1 ? s.charAt(index.getFirst()) : '0';
    }

    public char repeatedCharacter_1(String s) {

        // Just a creative way dont follow blindly
        var map = IntStream.range(0, s.length())
                .boxed()
                .collect(Collectors.groupingBy(i -> s.indexOf(s.charAt(i), s.indexOf(s.charAt(i)) + 1)));

        //You can see the distance between same char
        System.out.println(map);

        var index = map.keySet()
                .stream()
                .sorted()
                .dropWhile(i -> i == -1)
                .findFirst();

        //return index.isPresent() ? s.charAt(index.get().intValue()): '0';
        return index.map(s::charAt).orElse('0');
    }

    public char repeatedCharacter_2(String s) {
        // Just a creative way dont follow blindly
        var set = IntStream.range(0, s.length())
                .boxed()
                .map(i -> s.indexOf(s.charAt(i), s.indexOf(s.charAt(i)) + 1))
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
