import java.util.stream.Collectors;

//2710. Remove Trailing Zeros From a String

public class LeetCode2710 {
    public String removeTrailingZeros(String num) {
        // 1. Reverse the string so trailing zeros become leading zeros
        String rev = new StringBuilder(num).reverse().toString();

        // 2. Drop the leading zeros from the reversed string using streams
        String trimmed = rev.chars()
                .dropWhile(digit -> digit == '0')
                .mapToObj(Character::toString)
                .collect(Collectors.joining());

        // 3. Reverse it back to the original orientation
        return new StringBuilder(trimmed).reverse().toString();
    }
}
