import java.util.Arrays;
import java.util.Scanner;

public class Day42TwoSumPairWithGivenSum {
    private class Solution {
        private boolean binarySearch(int[] arr, int left, int right, int target) {
            while(left <= right) {
                int mid = left+(right-left)/2;
                if(arr[mid] == target) return true;
                if(arr[mid] < target) left = mid+1;
                else right = mid-1;
            }
            return false;
        }

        public boolean twoSum(int[] arr, int target) {
            Arrays.sort(arr);
            for(int i = 0; i < arr.length; i++) {
                int complement = target-arr[i];
                if(binarySearch(arr, i+1, arr.length-1, complement)) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int target = scanner.nextInt();

        Solution sol;
        sol = new Day42TwoSumPairWithGivenSum().new Solution();
        System.out.println(sol.twoSum(arr, target));

        scanner.close();
    }
}
