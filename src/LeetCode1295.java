import java.util.Arrays;

//1295. Find Numbers with Even Number of Digits
public class LeetCode1295 {
    public int findNumbers(int[] nums) {
        return (int)Arrays.stream(nums)
                .filter(n -> Integer.toString(n).length()%2==0)
                .count();
    }

    public int findNumbers_2(int[] nums) {
        return (int) Arrays.stream(nums)
                .filter(n -> {
                    int count = 0;
                    while (n != 0) {
                        n /= 10;
                        count++;
                    }
                    return count % 2 == 0;
                })
                .count();
    }
}
