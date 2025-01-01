import java.util.*;

public class Day47LongestConsecutiveSubsequence {
    private class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) return 0;
            Arrays.sort(nums);
            int res = 1, cnt = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) continue;
                if (nums[i] == nums[i - 1] + 1) cnt++;
                else cnt = 1;
                res = Math.max(res, cnt);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution sol;
        sol = new Day47LongestConsecutiveSubsequence().new Solution();
        System.out.println(sol.longestConsecutive(nums));

        scanner.close();
    }
}
