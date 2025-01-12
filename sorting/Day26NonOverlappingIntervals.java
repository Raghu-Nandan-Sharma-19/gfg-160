import java.util.Arrays;
import java.util.Scanner;

public class Day26NonOverlappingIntervals {
    private class Solution {
        public int minRemoval(int intervals[][]) {
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
       
            int maxi = intervals[0][1];
            int ans = 0;
        
            for(int i = 1; i < intervals.length; i++) {
                int f = intervals[i][0];
                int s = intervals[i][1];
         
                if(maxi > f) {
                    ans++;
                } else {
                    maxi = s;
                }
            }
        
            return ans;
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

        Solution sol;
        sol = new Day26NonOverlappingIntervals().new Solution();
        System.out.println(sol.minRemoval(intervals));

        scanner.close();
    }
}
