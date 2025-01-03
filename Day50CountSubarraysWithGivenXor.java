import java.util.HashMap;
import java.util.Scanner;

public class Day50CountSubarraysWithGivenXor {
    private static class Solution {
        public long subarrayXor(int[] arr, int k) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int xorr = 0, cnt = 0;

            for(int i : arr) {
                xorr ^= i;
                cnt += hashMap.getOrDefault(xorr^k, 0);
                if(xorr == k) cnt++;
                hashMap.put(xorr, hashMap.getOrDefault(xorr, 0)+1);
            }

            return cnt;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        Solution sol = new Solution();
        System.out.println(sol.subarrayXor(nums, k));

        scanner.close();
    }
}
