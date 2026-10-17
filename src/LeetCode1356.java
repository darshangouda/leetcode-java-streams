import java.util.Arrays;
import java.util.Comparator;

//1356. Sort Integers by The Number of 1 Bits
public class LeetCode1356 {

    //Runtime: 92ms
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.<Integer>comparingInt(
                                n-> (int)Integer.toBinaryString(n).chars().filter(bit -> bit=='1').count() )
                        .thenComparing(n->n)
                )
                .mapToInt(Integer::intValue)
                .toArray();
    }

    //32ms
    public int[] sortByBits_1(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.<Integer>comparingInt(
                                n-> {
                                    int c=0;
                                    while(n!=0){
                                        c+=n&1;
                                        n=n>>1;
                                    }
                                    return c;} )
                        .thenComparing(n->n)
                )
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
