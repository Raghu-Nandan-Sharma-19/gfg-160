package twoPonterTechnique;

import java.util.Scanner;

public class Day55CountTheNumberOfPossibleTriangles {
    private static class Solution {
        public int countTriangles(int[] arr) {
            int res = 0;
    
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (arr[i] + arr[j] > arr[k] &&
                            arr[i] + arr[k] > arr[j] &&
                            arr[k] + arr[j] > arr[i]) {
                            res++;
                        }
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

        Solution sol = new Solution();
        System.out.println(sol.countTriangles(arr));

        scanner.close();
    }
}
