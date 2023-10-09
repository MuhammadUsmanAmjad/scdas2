import java.util.ArrayList;
import java.util.List;

public class Task3 {
  public static List<int[]> createIntervals() {
    List<int[]> intervals = new ArrayList<>();
    intervals.add(new int[] {1, 3});
    intervals.add(new int[] {2, 6});
    intervals.add(new int[] {8, 10});
    intervals.add(new int[] {15, 18});
    return intervals;
  }

  public static void main(String[] args) {
    List<int[]> intervals = createIntervals();

    for (int[] interval : intervals) {
      System.out.println("[" + interval[0] + ", " + interval[1] + "]");
    }
  }
}
