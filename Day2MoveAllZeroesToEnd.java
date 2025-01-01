import java.util.Scanner;

public class Day2MoveAllZeroesToEnd {
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

        void pushZeroesToEnd(int[] nums) {
            int n = nums.length;
            int j = -1;

            for(int i = 0; i < n; i++) {
                if(nums[i] == 0) {
                    j = i;
                    break;
                }
            }

            if(j == -1) return;

            for(int i = j+1; i < n; i++) {
                if(nums[i] != 0) {
                    swap(nums, i, j);
                    j++;
                }
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
        sol = new Day2MoveAllZeroesToEnd().new Solution();
        sol.pushZeroesToEnd(nums);

        scanner.close();
    }
}
