import java.util.*;
import java.util.stream.Collectors;

public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        var set = Arrays.stream(nums).boxed()
                                        .collect(Collectors.toCollection(LinkedHashSet::new));
        int i=0;
        for(var num:set)
            nums[i++]=num;
        return set.size();
    }
}
