package prefixSum;

import java.util.Arrays;
import java.util.Scanner;

public class Day64ProductArrayPuzzle {
    private static class Solution {
        public int[] productExceptSelf(int[] arr) {
            int zeros = 0, idx = -1, prod = 1, n = arr.length;
            
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == 0) {
                    zeros++;
                    idx = i;
                } else {
                    prod *= arr[i];
                }
            }
            
            int[] res = new int[n];
            Arrays.fill(res, 0);
            
            if(zeros == 0) {
                for(int i = 0; i < n; i++) {
                    res[i] = prod / arr[i];
                }    
            } else if(zeros == 1) {
                res[idx] = prod;
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

        Solution solution = new Solution();
        int[] ans = solution.productExceptSelf(arr);
        for(int el : ans) {
            System.out.print(el + " ");
        }
        System.out.println();

        scanner.close();
    }
}
