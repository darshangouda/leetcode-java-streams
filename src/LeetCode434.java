import java.util.stream.IntStream;

//434 Number of Segments in a String
public class LeetCode434 {

    public int countSegments(String s) {
        return (int)
                IntStream.range(0, s.length())
                        .filter(i -> (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')))
                        .count();
    }

}
