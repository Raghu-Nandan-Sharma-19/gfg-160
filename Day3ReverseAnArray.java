import java.util.Scanner;

public class Day3ReverseAnArray {
    private class Solution {
        private void display(int[] nums) {
            for(int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        private void swap(int[] nums, int num1, int num2) {
            int temp = nums[num1];
            nums[num1] = nums[num2];
            nums[num2] = temp;
        }

        void reverseArray(int[] nums) {
            int n = nums.length;
            int i = 0;
            int j = n-1;

            while(i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }

            display(nums);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution sol;
        sol = new Day3ReverseAnArray().new Solution();
        sol.reverseArray(nums);

        scanner.close();
    }
}
