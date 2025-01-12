import java.util.Scanner;

public class Day4RoatateArray {
    private class Solution {
        private void display(int[] nums) {
            for(int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        private void reverse(int[] nums, int start, int end) {
            while(start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        void rotateArray(int[] nums, int d) {
            int n = nums.length;
            d = d % n;

            reverse(nums, 0, n-1);
            reverse(nums, 0, d-1);
            reverse(nums, d, n-1);

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

        int d = scanner.nextInt();

        Solution sol;
        sol = new Day4RoatateArray().new Solution();
        sol.rotateArray(nums, d);

        scanner.close();
    }
}
