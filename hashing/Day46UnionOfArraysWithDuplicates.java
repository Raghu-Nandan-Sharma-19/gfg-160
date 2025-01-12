import java.util.HashSet;
import java.util.Scanner;

public class Day46UnionOfArraysWithDuplicates {
    private class Solution {
        int findUnion(int[] a, int[] b) {
            HashSet<Integer> set = new HashSet<>();
            for (int i : a) {
                set.add(i);
            }
            
            for (int i : b) {
                set.add(i);
            }
            
            return set.size();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        Solution sol;
        sol = new Day46UnionOfArraysWithDuplicates().new Solution();
        System.out.println(sol.findUnion(a, b));

        scanner.close();
    }
}
