import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//2595. Number of Even and Odd Bits
public class LeetCode2595 {
    public int[] evenOddBit_1(int n) {
        var map = IntStream.range(0,31)
                .boxed()
                .filter( idx -> (n>>idx &1) == 1)
                .collect(Collectors.groupingBy( idx -> idx%2==0, Collectors.counting()));

        return new int[]{map.getOrDefault(true, 0L).intValue(),map.getOrDefault(false, 0L).intValue()};
    }

    //we may get only odd ex: num = 1, so, use Collectors.partitioningBy()
    public int[] evenOddBit(int n) {
        var map = IntStream.range(0, 31)
                .boxed()
                .filter(idx -> (n >> idx & 1) == 1)
                .collect(Collectors.partitioningBy(idx -> idx % 2 == 0, Collectors.counting()));

        return new int[] { map.get(true).intValue(), map.get(false).intValue() };
    }
}
