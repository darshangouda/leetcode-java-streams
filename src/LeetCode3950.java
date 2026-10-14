import java.util.stream.IntStream;

//3950. Exactly One Consecutive Set Bits Pair
public class LeetCode3950 {

    public boolean consecutiveSetBits(int n) {
        String strNum = Integer.toBinaryString(n);
        return IntStream.range(0, strNum.length() - 1)
                .filter(i -> strNum.charAt(i) == '1' && strNum.charAt(i + 1) == '1')
                .count() == 1;
    }
}
