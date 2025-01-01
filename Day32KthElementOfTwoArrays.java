import java.util.Scanner;
import java.util.Arrays;

public class Day32KthElementOfTwoArrays {
    private class Solution {
        public int kthElement(int a[], int b[], int k) {
            int[] mergedArray = new int[a.length + b.length];
            System.arraycopy(a, 0, mergedArray, 0, a.length);
            System.arraycopy(b, 0, mergedArray, a.length, b.length);
            Arrays.sort(mergedArray);
            return mergedArray[k - 1];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];

        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for(int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        Solution sol;
        sol = new Day32KthElementOfTwoArrays().new Solution();
        System.out.println(sol.kthElement(a, b, k));

        scanner.close();
    }
}
