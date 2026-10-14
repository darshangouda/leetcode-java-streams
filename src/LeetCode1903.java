import java.util.stream.IntStream;

public class LeetCode1903 {

        public String largestOddNumber1(String num) {
            return IntStream.rangeClosed(1, num.length())
                    .map(i -> num.length() - i)          // walk indices from the end
                    .filter(i -> (num.charAt(i) - '0') % 2 == 1)
                    .mapToObj(i -> num.substring(0, i + 1))
                    .findFirst()
                    .orElse("");
        }

    public String largestOddNumber(String num) {
        return IntStream.rangeClosed(1, num.length())
                .map(i -> num.length() - i)          // walk indices from the end
                .filter(i -> (num.charAt(i) - '0') % 2 == 1)
                .mapToObj(i -> num.substring(0, i + 1))
                .findFirst()
                .orElse("");


    }
}
