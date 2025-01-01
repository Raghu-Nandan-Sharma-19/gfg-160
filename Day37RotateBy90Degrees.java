import java.util.Scanner;

public class Day37RotateBy90Degrees {
    private class Solution {
        public void printMatrix(int[][] mat) {
            int n = mat.length;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
        }

        public void rotateBy90(int[][] mat) {
            int n = mat.length;
            int[][] res = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    res[n - j - 1][i] = mat[i][j];
                }
            }

            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = res[i][j];
                }
            }

            printMatrix(mat);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] mat = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        Solution sol;
        sol = new Day37RotateBy90Degrees().new Solution();
        sol.rotateBy90(mat);

        scanner.close();
    }
}
