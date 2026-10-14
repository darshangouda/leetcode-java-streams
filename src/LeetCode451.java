import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//451. Sort Characters By Frequency
public class LeetCode451 {

    //Runtime: 36ms , Clear approach
    public String frequencySort(String s) {
        Map<String, String> map = s.chars()  // Ex: key:"A",Value:"AAA"
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.joining()));

        return map.values().stream()
                .sorted(Comparator.comparingInt(String::length)
                        .reversed())
                .collect(Collectors.joining());
    }

    public String frequencySort_2(String s) {
        // 1. Build frequency map using Character keys
        Map<String, String> map = s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.joining()));

        return map.entrySet()
                .stream()
                .sorted(Comparator.<Map.Entry<String, String>>comparingInt(entry -> entry.getValue().length())
                        .reversed())
                .map(Map.Entry::getValue)
                .collect(Collectors.joining());
    }

    //Method 3: Runtime 98ms
    public String frequencySort_3(String s) {
        // 1. Build frequency map using Character keys
        Map<Character, Integer> map = s.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(i -> 1)));

        // 2. Stream characters, sort by frequency descending, and join
        return s.chars()
                .mapToObj(ch -> (char) ch)
                .sorted(Comparator.comparingInt((Character ch) -> map.get(ch)).reversed()
                        .thenComparing(ch -> ch))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    //Method 4: Runtime 32ms
    public String frequencySort_4(String s) {
        // 1. Build frequency map using Character keys
        Map<String, String> map = s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.joining()));

        // 2. Stream characters, sort by frequency descending, and join
        return map.values()
                .stream()
                .sorted((l1, l2) ->
                        l1.length() != l2.length() ?
                                Integer.compare(l2.length(), l1.length()) :
                                Integer.compare(l1.indexOf(0), l2.indexOf(0))
                )
                .collect(Collectors.joining());
    }

}
