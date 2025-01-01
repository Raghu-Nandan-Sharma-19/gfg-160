import java.util.Scanner;

public class Day10KadanesAlgorithm {
    private class Solution {
        int maxSubarraySum(int[] arr) {
            int n = arr.length;
            int sum = 0, maxi = Integer.MIN_VALUE;
            
            for(int i = 0; i < n; i++) {
                sum += arr[i];
                if(sum > maxi) {
                    maxi = sum;
                }
                if(sum < 0) {
                    sum = 0;
                }
            }
            
            return maxi;
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
        sol = new Day10KadanesAlgorithm().new Solution();
        System.out.println(sol.maxSubarraySum(arr));

        scanner.close();
    }
}
