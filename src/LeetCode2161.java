import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCode2161 {

    private int getBucket(int num,int pivot)
    {
        if(num<pivot) return 1;
        else if(num==pivot) return 2;
        else return 3;
    }

    public int[] pivotArray1(int[] nums, int pivot) {

       var list = Arrays.stream(nums).boxed().collect(Collectors.groupingBy( n -> getBucket(n,pivot) ,
                                            Collectors.toList()))
                .entrySet()
                .stream().sorted(Map.Entry.comparingByKey())
                .flatMap( n -> n.getValue().stream())
               .toList();

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    //Claude
    public int[] pivotArray(int[] nums, int pivot) {
        return Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.comparingInt(n -> getBucket(n, pivot)))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        LeetCode2161 solution = new LeetCode2161();

        // Example 1
        int[] nums1 = {9, 12, 5, 10, 14, 3, 10};
        int pivot1 = 10;
        int[] result1 = solution.pivotArray(nums1, pivot1);
        System.out.println("Result 1: " + java.util.Arrays.toString(result1));

        // Example 2
        int[] nums2 = {-3, 4, 3, 2};
        int pivot2 = 2;
        int[] result2 = solution.pivotArray(nums2, pivot2);
        System.out.println("Result 2: " + java.util.Arrays.toString(result2));
    }
}