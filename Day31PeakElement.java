import java.util.Scanner;

public class Day31PeakElement {
    private class Solution {
        public int peakElement(int[] arr) {
            int n = arr.length;
            if(arr[0] > arr[1]) return 0;
            if(arr[n-2] < arr[n-1]) return (n-1);
            for(int i = 1; i < n-1; i++) {
                if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
                    return i;
                }
            }
            return 0;
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
        sol = new Day31PeakElement().new Solution();
        System.out.println(sol.peakElement(arr));

        scanner.close();
    }
}
