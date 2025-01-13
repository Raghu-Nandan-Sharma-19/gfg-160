package twoPonterTechnique;

import java.util.Scanner;

public class Day60ContainerWithMostWater {
    private static class Solution {
        public int maxWater(int[] arr) {
            int n = arr.length;
            int left =  0, right = n - 1;
            int res = 0;
            
            while(left < right) {
                int water = Math.min(arr[left], arr[right]) * (right - left);
                res = Math.max(res, water);
                if(arr[left] < arr[right]) left++;
                else right--;
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
        System.out.println(sol.maxWater(arr));

        scanner.close();
    }
}
