import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetCode{
    public int maxLengthBetweenEqualCharacters(String s) {
           int max = -1;
           int l = s.length();
           Map<Character,Integer> map = new HashMap<>();
           for(int i=0;i<l;i++){
               char ch =s.charAt(i);
               if(map.containsKey(ch))
               {
                   max = Math.max(max,map.get(ch)-i-1);
               }
               else {
                   map.put(ch,i);
               }
           }
           return max;
    }
}
