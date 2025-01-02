import java.util.HashMap;
import java.util.Scanner;

public class Day49SubarraysWithSumK {
    private static class Solution {
        public int countSubarrays(int[] arr, int k) {
            HashMap<Integer, Integer> prefixSums = new HashMap<>();

            int res = 0, currSum = 0;

            for(int i = 0; i < arr.length; i++) {
                currSum += arr[i];
                if(currSum == k) res++;
                if(prefixSums.containsKey(currSum-k)) {
                    res += prefixSums.get(currSum-k);
                }
                prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0)+1);
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
        System.out.println(sol.countSubarrays(arr, k));

        scanner.close();
    }
}
