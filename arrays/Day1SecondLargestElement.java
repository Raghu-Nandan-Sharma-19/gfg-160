import java.util.Scanner;

public class Day1SecondLargestElement {
    private class Solution {
        public int getSecondLargest(int[] nums) {
            int n = nums.length;
            int largest = -1;
            int secondLargest = -1;
            
            for(int i = 0; i < n; i++) {
                if(nums[i] > largest) {
                    secondLargest = largest;
                    largest = nums[i];
                } else if(nums[i] > secondLargest && nums[i] != largest) {
                    secondLargest = nums[i];
                }
            }

            return secondLargest;
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
        sol = new Day1SecondLargestElement().new Solution();
        System.out.println(sol.getSecondLargest(nums));

        scanner.close();
    }
}