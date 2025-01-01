import java.util.Scanner;

public class Day41SetMatrixZeroes {
    private class Solution {
        
        public void setMatrixZeroes(int[][] mat) {
            int n = mat.length, m = mat[0].length;

            boolean[] rows = new boolean[n];
            boolean[] cols = new boolean[m];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(mat[i][j] == 0) {
                        rows[i] = true;
                        cols[j] = true;
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(rows[i] || cols[j]) {
                        mat[i][j] = 0;
                    }
                }
            }
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
        sol = new Day41SetMatrixZeroes().new Solution();
        sol.setMatrixZeroes(mat);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
