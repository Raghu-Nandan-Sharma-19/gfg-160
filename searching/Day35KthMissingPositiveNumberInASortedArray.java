import java.util.HashSet;
import java.util.Scanner;

public class Day35KthMissingPositiveNumberInASortedArray {
    private class Solution {
        public int kthMissing(int[] arr, int k) {
            HashSet<Integer> s = new HashSet<>();
            for (int num : arr) {
                s.add(num);
            }
            int count = 0, curr = 0;
            while (count < k) {
                curr++;
                if (!s.contains(curr)) {
                    count++;
                }
            }
            return curr;
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

        Solution sol;
        sol = new Day35KthMissingPositiveNumberInASortedArray().new Solution();
        System.out.println(sol.kthMissing(arr, k));

        scanner.close();
    }
}
