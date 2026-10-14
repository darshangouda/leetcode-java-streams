import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//1460. Make Two Arrays Equal by Reversing Subarrays
public class LeetCode1460 {
    public boolean canBeEqual1(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return IntStream.range(0, target.length)
                .allMatch(i -> target[i] == arr[i]);
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        var map1 = Arrays.stream(target)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        var map2 = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map1.equals(map2);
    }
}
