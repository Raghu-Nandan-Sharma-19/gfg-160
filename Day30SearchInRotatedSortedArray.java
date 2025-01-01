import java.util.Scanner;

public class Day30SearchInRotatedSortedArray {
    private class Solution {
        public int search(int[] arr, int key) {
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == key) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int key = scanner.nextInt();

        Solution sol;
        sol = new Day30SearchInRotatedSortedArray().new Solution();
        System.out.println(sol.search(arr, key));

        scanner.close();
    }
}
