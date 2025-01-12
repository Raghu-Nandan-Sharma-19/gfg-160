import java.util.Scanner;

public class Day29SortedAndRotatedMinimum {
    private class Solution {
        public int findMin(int[] arr) {
            int min = arr[0];
            
            for(int i = 1; i < arr.length; i++) {
                if(arr[i] < min) {
                    min = arr[i];
                }
            }

            return min;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Solution sol;
        sol = new Day29SortedAndRotatedMinimum().new Solution();
        System.out.println(sol.findMin(arr));

        scanner.close();
    }
}
