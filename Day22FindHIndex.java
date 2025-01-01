import java.util.Arrays;
import java.util.Scanner;

public class Day22FindHIndex {
    private class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int n = citations.length;
            int idx = 0;
    
            while (idx < n && citations[n-1-idx] > idx) {
                idx += 1;
            }
            
            return idx;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] citations = new int[n];
        
        for (int i = 0; i < n; i++) {
            citations[i] = scanner.nextInt();
        }

        Solution sol;
        sol = new Day22FindHIndex().new Solution();
        System.out.println(sol.hIndex(citations));

        scanner.close();
    }
}
