package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day77NQueenProblem {
    private static class Solution {
        ArrayList<ArrayList<Integer>>list;
        int[][] board;
        
        private boolean isSafe(int row, int col, int N) {
            for (int i = 0; i < col; i++) {
                if (board[row][i] == 1) {
                    return false;
                }
            }
            
            for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
            
            for (int i = row, j = col; i < N && j >= 0; i++, j--) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
            
            return true;
        }
        
        private void solveNQueen(int col,int N) {
            if (col >= N) {
                printSolution(N);
                return;
            }
            
            for (int i = 0;i < N; i++) {
                if (isSafe(i, col, N)) {
                    board[i][col] = 1;
                    solveNQueen(col + 1, N);
                    board[i][col] = 0;
                }
            }
        }
        
        private void printSolution(int N) {
            ArrayList<Integer>ll = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(board[i][j] == 1) {
                        ll.add(j+1);
                    }
                }
            }
            
            list.add(ll);
        }
        
        public ArrayList<ArrayList<Integer>> nQueen(int n) {
            list = new ArrayList<>();
            board = new int[n][n];
            solveNQueen(0, n);
            return list;
            
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Solution sol = new Solution();
        ArrayList<ArrayList<Integer>> ans = sol.nQueen(n);
        Collections.sort(ans, (a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        System.out.println(ans);

        scanner.close();
    }
}
