import java.util.Scanner;

public class Day19MinCharsToAddForPalindrome {
    private class Solution {
        public int minChar(String s) {
            int n = s.length();
            String rev_s = new StringBuilder(s).reverse().toString();

            String combined = s+'#'+rev_s; // Combine original string, separator, and reversed string
            int m = combined.length();

            // Compute the LPS (Longest Prefix Suffix) array
            int[] lps = new int[m];
            for (int i = 1; i < m; i++) {
                int len = lps[i-1];
                while (len > 0 && combined.charAt(i) != combined.charAt(len)) {
                    len = lps[len-1];
                }
                if (combined.charAt(i) == combined.charAt(len)) {
                    len++;
                }
                lps[i] = len;
            }

            // Minimum characters to add
            return n-lps[m-1];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        
        Solution sol;
        sol = new Day19MinCharsToAddForPalindrome().new Solution();
        System.out.println(sol.minChar(s));

        scanner.close();
    }
}
