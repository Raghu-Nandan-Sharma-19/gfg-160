import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day25InsertInterval {
    private class Solution {
        private List<int[]> mergeOverlap(List<int[]> intervals) {
            intervals.sort((a, b) -> Integer.compare(a[0], b[0]));
            List<int[]> res = new ArrayList<>();
            res.add(intervals.get(0));

            for(int i = 1; i < intervals.size(); i++) {
                int[] last = res.get(res.size() - 1);
                int[] curr = intervals.get(i);

                if (curr[0] <= last[1])
                    last[1] = Math.max(last[1], curr[1]);
                else
                    res.add(curr);
            }

            return res;
        }

        public List<int[]> insertInterval(int[][] intervals, int[] newInterval) {
            List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
            intervalList.add(newInterval);
            return mergeOverlap(intervalList);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] intervals = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                intervals[i][j] = scanner.nextInt();
            }
        }

        int[] newInterval = new int[m];
        for(int i = 0; i < m; i++) {
            newInterval[i] = scanner.nextInt();
        }

        Solution sol;
        sol = new Day25InsertInterval().new Solution();
        List<int[]> res = sol.insertInterval(intervals, newInterval);
        for(int[] interval : res) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        scanner.close();
    }
}
