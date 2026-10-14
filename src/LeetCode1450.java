import java.util.stream.IntStream;

//1450. Number of Students Doing Homework at a Given Time
public class LeetCode1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        return (int)IntStream.range(0,startTime.length)
                .filter( i -> startTime[i] <= queryTime && queryTime <=endTime[i])
                .count();
    }
}
