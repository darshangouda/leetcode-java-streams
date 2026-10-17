import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//This is Just for Practicing java Stream
public class LeetCode {
    //2423
    public boolean equalFrequency1(String word) {
        var freqMap = word.chars()
                .boxed()
                .collect(Collectors.groupingBy(ch -> ch, Collectors.summingInt(e -> 1)));

        System.out.println(freqMap);
        var groupMap = freqMap.values().stream().collect(Collectors.toMap(ch -> ch,
                c -> 1, (ex,cu) -> ex+cu ,TreeMap::new));

        System.out.println(groupMap);
        if(groupMap.size() == 1 && groupMap.firstEntry().getKey() == 1)
            return true;
        else if(groupMap.size() == 2 &&
                (groupMap.lastEntry().getValue() == 1 || groupMap.firstEntry().getValue() == 1))
            return true;
        else
            return false;
    }

    public boolean equalFrequency(String word) {
        var freqMap = word.chars()
                .boxed()
                .collect(Collectors.groupingBy(ch -> ch, Collectors.summingInt(e -> 1)));

        System.out.println(freqMap);
        var maxKey = freqMap.keySet().stream()
                .max(Comparator.comparingInt(freqMap::get))
                .get();

        freqMap.put(maxKey,freqMap.get(maxKey)-1);
        int maxVal = freqMap.get(maxKey);

        return freqMap.entrySet().stream().allMatch( e -> e.getValue()==maxVal);
    }
}
