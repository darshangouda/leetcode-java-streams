//2099. Find Subsequence of Length K With the Largest Sum

import java.util.Comparator;
import java.util.stream.IntStream;

public class LeetCode2099 {

    //13ms
    public int[] maxSubsequence1(int[] nums, int k) {
        return IntStream.range(0, nums.length)
                .boxed()
                .map(i -> new int[] { i, nums[i] })
                .sorted((A, B) -> B[1] - A[1])
                .limit(k)
                .sorted((A, B) -> A[0] - B[0])
                .mapToInt(R -> R[1])
                .toArray();
    }

    //13ms
    public int[] maxSubsequence2(int[] nums, int k) {
        return IntStream.range(0, nums.length)
                .boxed()
                .sorted((i, j) -> nums[j] - nums[i])
                .limit(k)
                .sorted()
                .mapToInt(i -> nums[i])
                .toArray();
    }

    //16ms
    public int[] maxSubsequence(int[] nums, int k) {
        return IntStream.range(0, nums.length)
                .boxed()
                .sorted(Comparator.<Integer>comparingInt(i->nums[i]).reversed())
                .limit(k)
                .sorted()
                .mapToInt(i -> nums[i])
                .toArray();
    }
}
