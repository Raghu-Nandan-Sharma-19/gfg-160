import java.util.Scanner;

public class Day12MaxCircularSubarraySum {
    private class Solution {
        public int circularSubarraySum(int arr[]) {
            int totalSum = 0;
            int currMaxSum = 0, currMinSum = 0;
            int maxSum = arr[0], minSum = arr[0];
        
            for(int i = 0; i < arr.length; i++) {
                currMaxSum = Math.max(currMaxSum+arr[i], arr[i]);
                maxSum = Math.max(maxSum, currMaxSum);
        
                // Kadane's to find minimum sum subarray
                currMinSum = Math.min(currMinSum+arr[i], arr[i]);
                minSum = Math.min(minSum, currMinSum);
        
                totalSum = totalSum+arr[i];
            }
        
            int normalSum = maxSum;
            int circularSum = totalSum-minSum;

            if(minSum == totalSum) return normalSum;
        
            return Math.max(normalSum, circularSum);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Solution sol;
        sol = new Day12MaxCircularSubarraySum().new Solution();
        System.out.println(sol.circularSubarraySum(arr));

        scanner.close();
    }
}
