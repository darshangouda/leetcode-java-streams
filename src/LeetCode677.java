import java.util.HashMap;
import java.util.Map;

//677. Map Sum Pairs

public class LeetCode677 {
    class MapSum {
        Map<String,Integer> map;
        public MapSum() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key,val);
        }

        public int sum(String prefix) {
            return map.entrySet()
                    .stream()
                    .filter( en -> en.getKey().startsWith(prefix))
                    .map(Map.Entry::getValue)
                    .reduce(Integer::sum)
                    .orElse(0);
        }
    }
}
