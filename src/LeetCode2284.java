import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/// 2284. Sender With Largest Word Count
public class LeetCode2284 {
    public String largestWordCount(String[] messages, String[] senders) {
        var map = IntStream.range(0,messages.length)
                .boxed()
                .collect(Collectors.groupingBy(i->senders[i],
                        Collectors.summingLong(i -> messages[i].chars().filter(Character::isSpaceChar).count()+1
                        )))
                .entrySet()
                .stream()
                .max(Comparator.<Map.Entry<String,Long>>comparingLong(Map.Entry::getValue)
                        .thenComparing(Map.Entry::getKey,Comparator.naturalOrder()));
        return map.isPresent() ? map.get().getKey() : "";
    }
}
