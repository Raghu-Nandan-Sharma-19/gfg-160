package twoPonterTechnique;

import java.util.Scanner;

public class Day59TrappingRainWater {
    private static class Solution {
        public int maxWater(int[] arr) {
            int res = 0;
    
            for (int i = 1; i < arr.length - 1; i++) {
                int left = arr[i];
                for (int j = 0; j < i; j++)
                    left = Math.max(left, arr[j]);
    
                int right = arr[i];
                for (int j = i + 1; j < arr.length; j++)
                    right = Math.max(right, arr[j]);
    
                res += Math.min(left, right) - arr[i];
            }
    
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Solution sol = new Solution();
        System.out.println(sol.maxWater(arr));

        scanner.close();
    }
}
