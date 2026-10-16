import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//1346. Check If N and Its Double Exist
public class LeetCode1346 {

    //Just a fun
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        return IntStream.range(0, arr.length)
                .anyMatch(i -> {
                    int num = arr[i];
                    boolean found = seen.contains(num * 2) || (num % 2 == 0 && seen.contains(num / 2));
                    seen.add(num);
                    return found;
                });
    }
}
