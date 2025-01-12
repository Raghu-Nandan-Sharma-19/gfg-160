import java.util.Arrays;
import java.util.Scanner;

public class Day27MergeWithoutExtraSpace {
    private class Solution {
        private void printArray(int[] arr) {
            for(int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        public void mergeArrays(int[] a, int[] b) {
            // Traverse b[] starting from the last element
            for(int i = b.length-1; i >= 0; i--) {
                // If b[i] is smaller than the largest element of a[]
                if(a[a.length-1] > b[i]) {
                  
                    // Place b[i] in the correct position in a[], 
                    // and move last element of a[] to b[]
                    int last = a[a.length-1];
                    int j = a.length-2;
                    while(j >= 0 && a[j] > b[i]) {
                        a[j+1] = a[j];
                        j--;
                    }
                    a[j+1] = b[i];
                    b[i] = last;
                }

                printArray(a);
            }
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

        Solution sol;
        sol = new Day27MergeWithoutExtraSpace().new Solution();
        sol.mergeArrays(a, b);
        System.out.println(Arrays.toString(a));

        scanner.close();
    }
}
