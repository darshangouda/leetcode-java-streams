import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//1002. Find Common Characters
public class LeetCode1002 {

    //Runtime: 45ms
    public List<String> commonChars1(String[] words) {
        var map = Arrays.stream(words)
                .map(s -> s.chars().boxed().collect(Collectors.groupingBy(ch -> ch, Collectors.summingInt(e -> 1))))
                .reduce((map1, map2) ->
                        Stream.concat(map1.keySet().stream(), map2.keySet().stream())
                                .distinct()
                                .filter(key -> map1.containsKey(key) && map2.containsKey(key))
                                .collect(Collectors.toMap(key -> key,
                                        key -> Math.min(map1.get(key), map2.get(key)),
                                        (ex, ne) -> ex
                                ))
                );
        if(map.isPresent())
        {
            return map.get().entrySet()
                    .stream()
                    .map( en -> Collections.nCopies(en.getValue(), Character.toString(en.getKey())))
                    .flatMap(List::stream)
                    .toList();
        }
        return null;
    }

    //Runtime: 11ms
    public List<String> commonChars(String[] words) {
        var map = Arrays.stream(words)
                .map(s -> {
                    int[]  aToz = new int[26];
                    int L = s.length();
                    for(int i=0;i<L;i++) aToz[s.charAt(i)-'a']++;
                    return aToz;
                })
                .reduce(( A, B) -> {
                            int[]  minaToz = new int[26];
                            for(int i=0;i<26;i++)
                                minaToz[i] = Math.min(A[i], B[i]);
                            return minaToz;
                        });

        if(map.isPresent())
        {
            int[] AZ = map.get();
            return  IntStream.range(0,26)
                    .boxed()
                    .map( i -> Collections.nCopies( AZ[i], Character.toString(i+'a')))
                    .flatMap(List::stream)
                    .toList();
        }
        return null;
    }
}
