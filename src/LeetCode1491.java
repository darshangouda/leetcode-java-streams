import java.util.Arrays;

//1491. Average Salary Excluding the Minimum and Maximum Salary
public class LeetCode1491 {
    public double average(int[] salary) {
        int min = Arrays.stream(salary).min().getAsInt();
        int max = Arrays.stream(salary).max().getAsInt();

        return Arrays.stream(salary).filter( n -> n!=min && n!=max).average().getAsDouble();
    }
}
