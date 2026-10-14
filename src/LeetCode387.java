import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//387. First Unique Character in a String
public class LeetCode387 {


    //Best Stream Approach
    public int firstUniqChar(String s) {
        var countMap = s.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toMap(ch -> ch, ch -> 1, Integer::sum)); //55ms
        //.collect(Collectors.groupingBy(ch -> ch, Collectors.summingInt(e ->1))); //92ms
        //.collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));  //86ms

        return IntStream.range(0, s.length())
                .filter(i -> countMap.get(s.charAt(i)) == 1)
                .findFirst()
                .orElse(-1);
    }

    //Runtime: 33ms
    public int firstUniqChar_1(String s) {
        return IntStream.range(0,s.length())
                .filter( i-> s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i)))
                .findFirst()
                .orElse(-1);
    }

    public int firstUniqChar_3(String s) {
        var startIndex = IntStream.range(0, s.length())
                .boxed()
                .collect(Collectors.toMap(s::charAt, idx -> idx, (ex, ne) -> ex));

        var countMap = s.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toMap(ch -> ch, ch -> 1, Integer::sum,LinkedHashMap::new));

        var first = countMap.entrySet()
                .stream()
                .filter( en -> en.getValue()==1)
                .findFirst();

        return first.isPresent() ? startIndex.get(first.get().getKey()) : -1;
    }

}
