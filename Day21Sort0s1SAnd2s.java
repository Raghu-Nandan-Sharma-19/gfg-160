import java.util.Arrays;
import java.util.Scanner;

public class Day21Sort0s1SAnd2s {
    private class Solution {
        private void printArray(int[] arr) {
            for(int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        public void sort012(int[] arr) {
            Arrays.sort(arr);
            printArray(arr);
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
        sol = new Day21Sort0s1SAnd2s().new Solution();
        sol.sort012(arr);

        scanner.close();
    }
}
