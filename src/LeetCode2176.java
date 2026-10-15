import java.util.stream.Collectors;
import java.util.stream.IntStream;

//2176. Count Equal and Divisible Pairs in an Array
public class LeetCode2176 {
    public int countPairs(int[] nums, int k) {
        var map = IntStream.range(0, nums.length)
                .boxed()
                .collect(Collectors.groupingBy(i -> nums[i]));
        System.out.println(map);
        return map.values()
                .stream()
                .filter(l -> l.size() > 1)
                .mapToInt(list -> {
                            int subCount = 0;
                            // Check every distinct pair of indices (i, j) where i < j
                            for (int i = 0; i < list.size(); i++) {
                                for (int j = i + 1; j < list.size(); j++) {
                                    if ((list.get(i) * list.get(j)) % k == 0) {
                                        subCount++;
                                    }
                                }
                            }
                            return subCount;
                        }
                )
                .sum();
    }
}
