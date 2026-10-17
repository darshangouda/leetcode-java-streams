import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetCode2418 {

    //22ms
    public String[] sortPeople1(String[] names, int[] heights) {
        return IntStream.range(0,heights.length)
                .boxed()
                .sorted(Comparator.<Integer>comparingInt(i->heights[i]).reversed()
                        .thenComparing(i->names[i],Comparator.naturalOrder()))
                .map( i-> names[i])
                .toList()
                .toArray(new String[0]);
    }

    //23ms
    public String[] sortPeople2(String[] names, int[] heights) {
        return IntStream.range(0,heights.length)
                .boxed()
                .map( i -> Map.entry(names[i], heights[i]))
                .sorted(Comparator.<Map.Entry<String,Integer>>comparingInt(Map.Entry::getValue).reversed()
                        .thenComparing(Map.Entry::getKey,Comparator.naturalOrder()))
                .map( Map.Entry::getKey)
                .toList()
                .toArray(String[]::new);
    }

    //15ms
    public String[] sortPeople(String[] names, int[] heights) {
        // 1. Define a composite key that holds both fields
        record Person(int height, String name) implements Comparable<Person> {
            @Override
            public int compareTo(Person other) {
                // Height descending, then name ascending
                int cmp = Integer.compare(other.height, this.height);
                return cmp != 0 ? cmp : this.name.compareTo(other.name);
            }
        }
        return IntStream.range(0, heights.length)
                .boxed()
                .collect(Collectors.toMap(
                        i -> new Person(heights[i], names[i]), // Key contains height + name
                        i -> heights[i],                      // Value
                        (ex, ne) -> ex,
                        TreeMap::new                          // Automatically sorts by Person's compareTo!
                ))
                .keySet()
                .stream()
                .map( per -> per.name)
                .toList()
                .toArray(String[]::new);
    }
}
