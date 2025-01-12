package twoPonterTechnique;

import java.util.Scanner;

public class Day52CountPairsWhoseSumIsLessThanTarget {
    private static class Solution {
        public int countPairs(int[] arr, int target) {
            int cnt = 0;
    
            // Generating all possible pairs
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
    
                    // If sum of this pair is less than
                    // target, then increment the cnt
                    if (arr[i] + arr[j] < target)
                        cnt++;
                }
            }
    
            return cnt;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int target = scanner.nextInt();

        Solution sol = new Solution();
        System.out.println(sol.countPairs(arr, target));

        scanner.close();
    }
}
