package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Day75PermutationsOfAString {
    private static class Solution {
        public void permute(String s, HashSet<String> set, int l, int r){
            if (l == r) {
                set.add(s);
                return;
            }
            
            for (int i = l; i < r; i++) {
                s = swap(s, l, i);
                permute(s, set, l + 1, r);
                s = swap(s, l, i);
            }
        }
        
        public String swap(String s, int l, int i){
            StringBuilder str = new StringBuilder(s);
            char ch1 = s.charAt(l);
            char ch2 = s.charAt(i);
            str.setCharAt(l, ch2);
            str.setCharAt(i, ch1);
            return str.toString();
        }
        
        public ArrayList<String> findPermutation(String s) {
            HashSet<String> set = new HashSet<>();
            ArrayList<String> list = new ArrayList<>();
            
            permute(s, set, 0, s.length());
            
            for(String st : set) {
                list.add(st);
            }
            
            return list;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        Solution sol = new Solution();

        System.out.println(sol.findPermutation(s));
        
        scanner.close();
    }
}