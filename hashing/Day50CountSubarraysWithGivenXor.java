import java.util.Scanner;

public class Day50CountSubarraysWithGivenXor {
    private static class Solution {
        public int subarrayXor(int[] arr, int k) {
            int res = 0;
    
            // Pick starting point i of subarrays
            for (int i = 0; i < arr.length; i++) {
                int prefXOR = 0;
    
                // Pick ending point j of subarray for each i
                for (int j = i; j < arr.length; j++) {
                    // calculate prefXOR for subarray arr[i ... j]
                    prefXOR = prefXOR ^ arr[j];
    
                    // If prefXOR is equal to given value, increase res by 1
                    if (prefXOR == k)
                        res++;
                }
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

        int k = scanner.nextInt();

        Solution sol = new Solution();
        System.out.println(sol.subarrayXor(arr, k));

        scanner.close();
    }
}
