import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//3692. Majority Frequency Characters
public class LeetCode3692 {

    //25ms
    public String majorityFrequencyGroup(String s) {
        Map<String, Integer> freqMap = s.chars().boxed() // a:2, b:2, c:1
                .collect(Collectors.groupingBy(Character::toString, Collectors.summingInt(e -> 1)));

        Map<Integer, String> groupMap = freqMap.keySet().stream() // 1:c, 2:ab
                .collect(Collectors.groupingBy(freqMap::get, Collectors.joining()));

        var majority = groupMap.keySet().stream()
                .max(Comparator.<Integer>comparingInt(key -> groupMap.get(key).length())
                        .thenComparing(key -> key))
                .get();

        return groupMap.get(majority);
    }

}
