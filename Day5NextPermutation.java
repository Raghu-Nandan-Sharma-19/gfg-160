import java.util.Scanner;

public class Day5NextPermutation {
    private class Solution {
        private void reverse(int[] nums, int start, int end) {
            while(start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        private void swap(int[] nums, int num1, int num2) {
            int temp = nums[num1];
            nums[num1] = nums[num2];
            nums[num2] = temp;
        }

        void nextPermutation(int[] nums) {
            int n = nums.length;

            // Step 1: Find the break point:
            int ind = -1; // break point
            for(int i = n-2; i >= 0; i--) {
                if(nums[i] < nums[i+1]) {
                    // index i is the break point
                    ind = i;
                    break;
                }
            }

            // If break point does not exist:
            if(ind == -1) {
                // reverse the whole array:
                reverse(nums, 0, n-1);
                return;
            }

            // Step 2: Find the next greater element
            //         and swap it with nums[ind]:
            for(int i = n-1; i > ind; i--) {
                if(nums[i] > nums[ind]) {
                    swap(nums, i, ind);
                    break;
                }
            }

            // Step 3: reverse the right half:
            reverse(nums, ind+1, n-1);
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
        sol = new Day5NextPermutation().new Solution();
        sol.nextPermutation(nums);

        for(int num : nums) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
