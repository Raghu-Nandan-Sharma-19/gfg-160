import java.util.Arrays;
import java.util.Scanner;

public class Day13SmallestPositiveMissing {
    private class Solution {
        public int missingNumber(int[] arr) {
            Arrays.sort(arr);
            int res = 1;
            
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == res) res++;
                else if (arr[i] > res) break;
            }
            
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Solution sol;
        sol = new Day13SmallestPositiveMissing().new Solution();
        System.out.println(sol.missingNumber(arr));

        scanner.close();
    }
}
