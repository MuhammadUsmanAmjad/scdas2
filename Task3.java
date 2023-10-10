import java.util.ArrayList;
import java.util.List;

public class Task3 {
  public static List<int[]> mergeIntervals(List<int[]> intervals) {
    if (intervals == null || intervals.isEmpty()) {
      return intervals;
    }

    List<int[]> merged_Intervals = new ArrayList<>();
    int[] current_Interval = intervals.get(0);

    for (int i = 1; i < intervals.size(); i++) {
      int[] next_Interval = intervals.get(i);

      if (current_Interval[1] >= next_Interval[0]) {
        current_Interval[1] = Math.max(current_Interval[1], next_Interval[1]);
      } else {
        merged_Intervals.add(current_Interval);
        current_Interval = next_Interval;
      }
    }

    // Add the last interval to the result
    merged_Intervals.add(current_Interval);

    return merged_Intervals;
  }

  public static void main(String[] args) {
    List<int[]> intervals = new ArrayList<>();
    intervals.add(new int[] {1, 3});
    intervals.add(new int[] {2, 6});
    intervals.add(new int[] {8, 10});
    intervals.add(new int[] {15, 18});

    List<int[]> merged_Intervals = mergeIntervals(intervals);

    for (int[] interval : merged_Intervals) {
      System.out.println("[" + interval[0] + ", " + interval[1] + "]");
    }
  }
}
