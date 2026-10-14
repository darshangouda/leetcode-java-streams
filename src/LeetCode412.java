import java.util.List;
import java.util.stream.IntStream;

public class LeetCode412 {

        public List<String> fizzBuzz(int n) {
            return IntStream.range(1, n + 1)
                    .mapToObj(i -> i % 15 == 0 ? "FizzBuzz"
                            : i % 5 == 0 ? "Buzz"
                            : i % 3 == 0 ? "Fizz"
                            : String.valueOf(i))
                    .toList();
        }

}
