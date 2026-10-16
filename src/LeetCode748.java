import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

//748. Shortest Completing Word
public class LeetCode748 {
    //Runtime: 46ms
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Integer, Integer> patternMap = licensePlate.chars()
                .boxed()
                .filter(Character::isAlphabetic)
                .map(Character::toLowerCase)
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));

        var minString = Arrays.stream(words)
                .filter(target -> {
                    var targetMap = target.chars()
                            .boxed()
                            .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));
                    return patternMap.entrySet().stream()
                            .allMatch(entry -> targetMap.getOrDefault(entry.getKey(), 0) >= entry.getValue());
                })
                .collect(Collectors.groupingBy(String::length))
                .entrySet()
                .stream()
                .min((e1, e2) -> Integer.compare(e1.getKey(), e2.getKey()));
        return minString.isPresent() ? minString.get().getValue().getFirst() : "";
    }


    public String shortestCompletingWord_2(String licensePlate, String[] words) {
        Map<Integer, Integer> patternMap = licensePlate.chars()
                .boxed()
                .filter(Character::isAlphabetic)
                .map(Character::toLowerCase)
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));

        var minStringMap = Arrays.stream(words)
                .filter(target -> {
                    var targetMap = target.chars()
                            .boxed()
                            .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));
                    return patternMap.entrySet().stream()
                            .allMatch(entry -> targetMap.getOrDefault(entry.getKey(), 0) >= entry.getValue());
                })
                .collect(Collectors.toMap(
                        String::length,
                        str -> new ArrayList<String>(){{add(str);}},
                        (ex, cu) -> {
                            ex.addAll(cu); // Combine the lists
                            return ex;     // Return the combined list
                        },
                        TreeMap::new
                ));
        return !minStringMap.isEmpty() ? minStringMap.firstEntry().getValue().getFirst() : "";
    }
}
