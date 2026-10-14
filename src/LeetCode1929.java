import java.util.Arrays;
import java.util.stream.Stream;

public class LeetCode1929 {
        public int[] getConcatenation(int[] nums) {
            int[] res = new int[nums.length*2];
            return Stream.concat(Arrays.stream(nums).boxed(),Arrays.stream(nums).boxed()).mapToInt(Integer::intValue).toArray();
            //return res;
        }

    public static void main(String[] args) {

        LeetCode1929 obj = new LeetCode1929();

        int[] nums = new int[]{1,3,2,1};
        obj.getConcatenation(nums);


    }
}
