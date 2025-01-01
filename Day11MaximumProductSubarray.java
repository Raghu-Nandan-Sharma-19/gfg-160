import java.util.Scanner;

public class Day11MaximumProductSubarray {
    private class Solution {
        int maxProduct(int[] arr) {
            int n = arr.length;
            int prefix = 1, suffix = 1;
            int maxi = Integer.MIN_VALUE;
        
            for(int i = 0; i < n; i++) {
                if(prefix == 0) prefix = 1;
                if(suffix == 0) suffix = 1;
                prefix *= arr[i];
                suffix *= arr[n-i-1];
                maxi = Math.max(maxi, Math.max(prefix, suffix));
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
        sol = new Day11MaximumProductSubarray().new Solution();
        System.out.println(sol.maxProduct(arr));

        scanner.close();
    }
}
