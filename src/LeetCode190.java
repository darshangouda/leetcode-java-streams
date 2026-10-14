import java.util.stream.IntStream;

//190. Reverse Bits
public class LeetCode190 {

        public int reverseBits(int n) {
            return IntStream.range(0, 32)
                    .map(j -> ((n >> j & 1) << (31 - j)))
                    .sum();
        }

}
