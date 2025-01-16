package prefixSum;

import java.util.HashMap;
import java.util.Scanner;

public class Day63LargestSubarrayOf0sAnd1s {
    private static class Solution {
        public int maxLen(int[] arr) {
            HashMap<Integer, Integer> mpp = new HashMap<>();
            int prefSum = 0;
            int res = 0;
            
            for(int i = 0; i < arr.length; i++) {
                prefSum += (arr[i] == 0) ? -1 : 1;
                
                if(prefSum == 0) {
                    res = i + 1;
                
                    
                }
                
                if(mpp.containsKey(prefSum)) {
                    res = Math.max(res, i - mpp.get(prefSum));
                } else {
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

        Solution sol = new Solution();
        System.out.println(sol.maxLen(arr));

        scanner.close();
    }
}
