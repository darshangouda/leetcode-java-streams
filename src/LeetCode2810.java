import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collector;

//2810. Faulty Keyboard
public class LeetCode2810 {
    public String finalString(String s) {
        StringBuilder sb = s.chars().collect(
                StringBuilder::new, // Supplier: creates the initial StringBuilder
                (builder, c) -> {   // Accumulator: handles each character
                    if (c == 'i') {
                        builder.reverse();
                    } else {
                        builder.append((char) c);
                    }
                },
                StringBuilder::append // Combiner: merges results if run in parallel
        );
        return sb.toString();
    }

    public String finalString_2(String s) {
        //Collections.reverse();
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collector.of(                                        // Collect.of(1,2,3,4)
                        StringBuilder::new,                                   // 1. Supplier
                        (sb, c) -> { if (c == 'i') sb.reverse(); else sb.append(c); }, // 2. Accumulator
                        StringBuilder::append,                                // 3. Combiner
                        StringBuilder::toString                               // 4. Finisher (returns String directly)
                ));
    }
}
