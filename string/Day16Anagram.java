import java.util.Scanner;

public class Day16Anagram {
    private class Solution {
        public boolean areAnagrams(String s1, String s2) {
            if(s1.length() != s2.length()) {
                return false;
            }

            int[] count = new int[26];
            for(char c : s1.toCharArray()) count[c-'a']++;
            for(char c : s2.toCharArray()) count[c-'a']--;

            for(int i : count) {
                if(i != 0) return false;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();

        Solution sol;
        sol = new Day16Anagram().new Solution();
        System.out.println(sol.areAnagrams(s1, s2));

        scanner.close();
    }
}
