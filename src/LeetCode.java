import java.util.Arrays;

public class LeetCode{
    public double average(int[] salary) {
        int min = Arrays.stream(salary).min().getAsInt();
        int max = Arrays.stream(salary).max().getAsInt();

        return Arrays.stream(salary).filter( n -> n!=min && n!=max).average().getAsDouble();
    }
}
