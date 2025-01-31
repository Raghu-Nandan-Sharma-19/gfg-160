package recursionAndBacktracking;

import java.util.Scanner;

public class Day78SolveTheSudoku {
    private static class Solution {
        private boolean isValid(int[][] mat, int row, int col, int num) {
            for (int i = 0; i < 9; i++) {
                if (mat[row][i] == num || mat[i][col] == num) {
                    return false;
                }
            }
            
            int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (mat[startRow + i][startCol + j] == num) {
                        return false;
                    }
                }
            }
            
            return true;
        }
        
        private boolean solve(int[][] mat) {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (mat[row][col] == 0) {
                        for (int num = 1; num <= 9; num++) {
                            if (isValid(mat, row, col, num)) {
                                mat[row][col] = num;
                                
                                if (solve(mat)) {
                                    return true;
                                }
                                mat[row][col] = 0;
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }
        
        public void solveSudoku(int[][] mat) {
            solve(mat);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 9;
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        Solution sol = new Solution();
        sol.solveSudoku(mat);
        for (var row : mat) {
            for (var col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
