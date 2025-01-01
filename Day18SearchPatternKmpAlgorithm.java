import java.util.ArrayList;
import java.util.Scanner;

public class Day18SearchPatternKmpAlgorithm {
    private class Solution {
        static void constructLps(String pat, int[] lps) {
            int len = 0;
            lps[0] = 0;
            int i = 1;

            while (i < pat.length()) {
                if(pat.charAt(i) == pat.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                } else {
                    if(len != 0) {
                        len = lps[len - 1];
                    } else {
                        lps[i] = 0;
                        i++;
                    }
                }
            }
        }
    
        public ArrayList<Integer> search(String pat, String txt) {
            int n = txt.length();
            int m = pat.length();
            int[] lps = new int[m];
            ArrayList<Integer> res = new ArrayList<>();
            constructLps(pat, lps);
            int i = 0;
            int j = 0;
    
            while(i < n) {
                if(txt.charAt(i) == pat.charAt(j)) {
                    i++;
                    j++;
                    if(j == m) {
                        res.add(i-j);
                        j = lps[j-1];
                    }
                } else {
                    if(j != 0)j = lps[j-1];
                    else i++;
                }
            }

            return res; 
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.nextLine();
        String pat = scanner.nextLine();
        
        Solution sol;
        sol = new Day18SearchPatternKmpAlgorithm().new Solution();
        ArrayList<Integer> res = sol.search(pat, txt);
        for(int i : res) {
            System.out.print(i + " ");
        }

        scanner.close();
    }
}
