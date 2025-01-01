import java.util.HashMap;
import java.util.Scanner;

public class Day43CountPairsWithGIvenSum {
    private class Solution {
        int countPairs(int[] arr, int target) {
            int count = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int x : arr) {
                if (map.containsKey(target - x)) {
                    count += map.get(target - x);
                }
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int target = scanner.nextInt();

        Solution sol;
        sol = new Day43CountPairsWithGIvenSum().new Solution();
        System.out.println(sol.countPairs(arr, target));

        scanner.close();
    }
}
