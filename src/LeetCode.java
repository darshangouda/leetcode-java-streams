import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LeetCode {
    //1437. Check If All 1's Are at Least Length K Places Away
    public static boolean kLengthApart(int[] nums, int k) {
        int[] indexes = IntStream.range(0, nums.length).filter(i->nums[i]==1).toArray();

        return IntStream.range(0, indexes.length-1)
                .allMatch( i -> indexes[i+1] - indexes[i]==1 || indexes[i+1] - indexes[i] >k);
    }


}
