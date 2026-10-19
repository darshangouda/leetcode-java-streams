import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//3843. First Element with Unique Frequency

public class LeetCode3843 {

    //198ms
    public int firstUniqueFreq(int[] nums) {
        var freqMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(num -> num, num -> 1, Integer::sum, LinkedHashMap::new));

        //System.out.println(freqMap);
        var groupMap = freqMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (ex, ne)->ex,LinkedHashMap::new)); //take same freq min number

        //System.out.println(groupMap);

        var groupFreqMap = freqMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, en -> 1, Integer::sum,LinkedHashMap::new)); //take same freq min number

        //System.out.println(groupFreqMap);

        var firstEntry = groupFreqMap.entrySet().stream()
                .filter( en -> en.getValue()==1)
                .findFirst();

        return firstEntry.isPresent() ? groupMap.get(firstEntry.get().getKey()) :-1;

    }

    //above method is simplified, int[]{count,number}
    public int firstUniqueFreq1(int[] nums) {
        var freqMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(num -> num, num -> 1, Integer::sum, LinkedHashMap::new));

        //System.out.println(freqMap);
        var groupMap = freqMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, en -> new int[]{1,en.getKey()},(ex, ne) ->{ ex[0]++; return ex; },LinkedHashMap::new));

        //System.out.println(groupMap);

        var firstEntry = groupMap.entrySet().stream()
                .filter( en -> en.getValue()[0]==1)
                .findFirst();

        return firstEntry.isPresent() ? firstEntry.get().getValue()[1] :-1;
    }


    //279ms
    public int firstUniqueFreq2(int[] nums) {
        var freqMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.summingInt(e -> 1)));

        //System.out.println(freqMap);
        var groupMap = freqMap.keySet().stream()
                .collect(Collectors.groupingBy(freqMap::get, Collectors.toList()));

        //System.out.println(groupMap);

        var set = groupMap.values().stream()
                .filter(li -> li.size() == 1)
                .map(List::getFirst)
                .collect(Collectors.toSet());

        return set.isEmpty() ? -1 : Arrays.stream(nums).filter(set::contains).findFirst().orElse(-1);
    }

    //334ms
    public int firstUniqueFreq3(int[] nums) {
        var indexMap = IntStream.range(0, nums.length)
                .boxed()
                .collect(Collectors.toMap(idx -> nums[idx], idx -> idx, (ex, ne) -> ex));

        var freqMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.summingInt(e -> 1)));

        //System.out.println(freqMap);
        var groupMap = freqMap.keySet().stream()
                .collect(Collectors.groupingBy(freqMap::get, Collectors.toList()));

        //System.out.println(groupMap);

        return groupMap.values().stream()
                .filter(li -> li.size() == 1)
                .map(List::getFirst)
                .min(Comparator.comparingInt(indexMap::get))
                .orElse(-1);
    }


}
