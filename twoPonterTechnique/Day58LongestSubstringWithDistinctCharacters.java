package twoPonterTechnique;

import java.util.Scanner;

public class Day58LongestSubstringWithDistinctCharacters {
    private static class Solution {
        static final int MAX_CHAR = 26;
        public int longestUniqueSubstr(String s) {
            int n = s.length();
            int res = 0;
    
            for (int i = 0; i < n; i++) {
                boolean[] vis = new boolean[MAX_CHAR];
    
                for (int j = i; j < n; j++) {
                    if (vis[s.charAt(j) - 'a'])
                        break;
                    else {
                        res = Math.max(res, j - i + 1);
                        vis[s.charAt(j) - 'a'] = true;
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        Solution sol = new Solution();
        System.out.println(sol.longestUniqueSubstr(s));

        scanner.close();
    }
}
