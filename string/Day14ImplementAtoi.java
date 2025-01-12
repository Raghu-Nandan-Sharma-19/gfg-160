import java.util.Scanner;

public class Day14ImplementAtoi {
    private class Solution {
        public int myAtoi(String s) {
            int sign = 1, res = 0, idx = 0;
            int n = s.length();
            int INT_MAX = Integer.MAX_VALUE;
            int INT_MIN = Integer.MIN_VALUE;

            while(idx < n && s.charAt(idx) == ' ') {
                idx++;
            }
        
            if(idx < n && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
                if(s.charAt(idx++) == '-') {
                    sign = -1;
                }
            }
        
            while(idx < n && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                if(res > INT_MAX/10 || (res == INT_MAX/10 && s.charAt(idx)-'0' > 7)) {
                    return sign == 1 ? INT_MAX : INT_MIN;
                }
                res = 10*res+(s.charAt(idx++)-'0');
            }
            return res*sign;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        
        Solution sol;
        sol = new Day14ImplementAtoi().new Solution();
        System.out.println(sol.myAtoi(s));

        scanner.close();
    }
}