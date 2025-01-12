package twoPonterTechnique;

import java.util.ArrayList;
import java.util.Scanner;

public class Day56IndexesOfSubarraySum {
    private static class Solution {
        public ArrayList<Integer> subarraySum(int[] arr, int target) {
            ArrayList<Integer> res = new ArrayList<>();
            int n = arr.length;

            for (int s = 0; s < n; s++) {
                int curr = 0;

                for (int e = s; e < n; e++) {
                curr += arr[e];
                if (curr == target) {
                    res.add(s + 1);
                    res.add(e + 1);
                    return res;
                }
                }
            }
            res.add(-1);
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

        int target = scanner.nextInt();

        Solution sol = new Solution();
        ArrayList<Integer> res = sol.subarraySum(arr, target);
        for (int i : res) {
            System.out.print(i + " ");
        }

        scanner.close();
    }
}
