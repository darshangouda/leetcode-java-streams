import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

//3852. Smallest Pair With Different Frequencies

public class LeetCode3852 {
    public int[] minDistinctFreqPair(int[] nums) {
        var freqMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.summingInt(e -> 1)));

        //System.out.println(freqMap);
        var groupMap = freqMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue,
                        Map.Entry::getKey, Math::min)); //take same freq min number

        var list = groupMap.values().stream()
                .sorted()
                .limit(2)
                .mapToInt(Integer::intValue)
                .toArray();

        return list.length==2 ? list : new int[]{-1,-1};
    }
}
