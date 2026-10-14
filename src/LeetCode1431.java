import java.util.*;

//1431. Kids With the Greatest Number of Candies
public class LeetCode1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies)
                .max().getAsInt();

        return Arrays.stream(candies)
                .mapToObj(n -> n + extraCandies >= max)
                .toList();
    }
}
