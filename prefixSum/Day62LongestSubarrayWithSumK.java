package prefixSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day62LongestSubarrayWithSumK {
    private static class Solution {
        public int longestSubarray(int[] arr, int k) {
            Map<Integer, Integer> mpp = new HashMap<>();
            int res = 0, prefSum = 0;
            
            for(int i = 0; i < arr.length; ++i) {
                prefSum += arr[i];
                
                if(prefSum == k) res = i + 1;
                else if (mpp.containsKey(prefSum - k)) {
                    res = Math.max(res, i - mpp.get(prefSum - k));
                }
                
                if(!mpp.containsKey(prefSum)) {
                    mpp.put(prefSum, i);
                }
            }
            
            return res;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        Solution sol = new Solution();
        System.out.println(sol.longestSubarray(arr, k));

        scanner.close();
    }
}
