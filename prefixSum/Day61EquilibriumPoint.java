package prefixSum;

import java.util.Scanner;

public class Day61EquilibriumPoint {
    private static class Solution {
        public int findEquilibrium(int[] arr) {
            int prefSum = 0, total = 0;
            
            for(int i = 0; i < arr.length; i++) {
                total += arr[i];
            }
            
            for(int i = 0; i < arr.length; i++) {
                int suffSum = total - prefSum - arr[i];
                if(prefSum == suffSum) {
                    return i;
                }
                prefSum += arr[i];
            }
            
            return -1;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Solution sol = new Solution();
        System.out.println(sol.findEquilibrium(arr));

        scanner.close();
    }
}
