package twoPonterTechnique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day53SumPairClosestToTarget {
    private static class Solution {
        public List<Integer> sumClosest(int[] arr, int target) {
            int n = arr.length;

            List<Integer> res = new ArrayList<>();
            int minDiff = Integer.MAX_VALUE;

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {

                    int currSum = arr[i] + arr[j];
                    int currDiff = Math.abs(currSum - target);

                    if (currDiff < minDiff) {
                        minDiff = currDiff;
                        res = Arrays.asList(Math.min(arr[i], arr[j]), 
                                            Math.max(arr[i], arr[j]));
                    } else if (currDiff == minDiff && 
                               (res.get(1) - res.get(0)) < Math.abs(arr[i] - arr[j])) {
                        res = Arrays.asList(Math.min(arr[i], arr[j]), 
                                            Math.max(arr[i], arr[j]));
                    }
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

        int target = scanner.nextInt();

        Solution sol = new Solution();
        List<Integer> res = sol.sumClosest(arr, target);
        for (int i : res) {
            System.out.print(i + " ");
        }

        scanner.close();
    }
}
