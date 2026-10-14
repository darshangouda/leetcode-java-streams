import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class LeetCode4 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int tLen = nums1.length + nums2.length;
            int skip = tLen % 2 == 0 ? tLen / 2 - 1 : tLen / 2;
            int limit = tLen % 2 == 0 ? 2 : 1;

            OptionalDouble res = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                    .sorted()
                    .skip(skip)
                    .limit(limit)
                    .average();

            return res.getAsDouble();
        }
}
