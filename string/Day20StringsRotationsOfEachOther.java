import java.util.Scanner;

public class Day20StringsRotationsOfEachOther {
    private class Solution {
        public boolean areRotations(String s1, String s2) {
            if(s1.length() != s2.length()) {
                return false;
            }
            
            return (s1+s1).contains(s2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        
        Solution sol;
        sol = new Day20StringsRotationsOfEachOther().new Solution();
        System.out.println(sol.areRotations(s1, s2));

        scanner.close();
    }
}
