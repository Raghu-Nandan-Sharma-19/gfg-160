import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Day24OverlappingIntervals {
    private class Solution {
        public List<int[]> mergeOverlap(int[][] arr) {
            Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

            List<int[]> res = new ArrayList<>();
            res.add(arr[0]);

            for (int i = 1; i < arr.length; i++) {
                int[] last = res.get(res.size() - 1);
                int[] curr = arr[i];
                if (curr[0] <= last[1]) last[1] = Math.max(last[1], curr[1]);
                else res.add(curr);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            } 
        }

        Solution sol;
        sol = new Day24OverlappingIntervals().new Solution();
        List<int[]> res = sol.mergeOverlap(arr);

        for(int[] interval : res) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        scanner.close();
    }
}
