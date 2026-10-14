import java.util.*;
import java.util.stream.Collectors;

//49:  group-anagrams
public class LeetCode49 {

    //best one
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0)
                return null;
            return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(
                    st -> {
                        char[] chars = st.toCharArray();
                        Arrays.sort(chars);
                        return new String(chars);
                    })).values());
        }
    }

    //CollectorsAndThen - once
    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0)
                return null;
            return Arrays.stream(strs).collect(Collectors.collectingAndThen(Collectors.groupingBy(
                    st -> {
                        char[] chars = st.toCharArray();
                        Arrays.sort(chars);
                        return new String(chars);
                    }), Map::values)).stream().toList();
        }
    }

    //CollectorsAndThen() - Twice
    class Solution3 {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0)
                return null;
            return Arrays.stream(strs)
                    .collect(Collectors.collectingAndThen(Collectors.collectingAndThen(Collectors.groupingBy(
                            st -> {
                                char[] chars = st.toCharArray();
                                Arrays.sort(chars);
                                return new String(chars);
                            }), Map::values), ArrayList::new));
        }
    }

}
