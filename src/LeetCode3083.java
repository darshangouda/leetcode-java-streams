import java.util.stream.IntStream;

public class LeetCode3083 {
    class Solution {
        public boolean isSubstringPresent(String s) {
            char[] chars = new char[2];
            return IntStream.range(0, s.length() - 1)
                    .mapToObj(i -> {
                        chars[1] = s.charAt(i);
                        chars[0] = s.charAt(i + 1);
                        return String.valueOf(chars);
                    })
                    .anyMatch(s::contains);
        }
    }

    public boolean isSubstringPresent1(String s) {
        int len = s.length();
        for (int i = 0; i + 1 < len; i++) {
            for (int j = 0; j + 1 < len; j++) {
                if (s.charAt(i) == s.charAt(j+1) && s.charAt(i + 1) == s.charAt(j))
                    return true;
            }
        }

        return false;
    }
}
