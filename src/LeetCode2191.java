import java.util.Arrays;
import java.util.Comparator;

//2191. Sort the Jumbled Numbers

public class LeetCode2191 {
    int[] map;

    //636ms using this method
    private int assignJumbleNum(int num) {
        String s = Integer.toString(num);
        int val = 0;
        for(int i=0;i<s.length();i++){
            val += val * 10 + map[s.charAt(i)-'0'];
        }
        return val;
    }

    //563ms
    private int assignJumbleNum1(int num) {
        int[] by = new int[9];
        int val = 0 ,len = -1;

        if(num==0) return map[0];

        while(num!=0){
            by[++len] = num % 10;
            num/=10;
        }

        for(int i=len;i>=0;i--){
            val += val * 10 + map[by[i]];
        }
        return val;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        this.map = mapping;
        return Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.comparingInt(this::assignJumbleNum))
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
