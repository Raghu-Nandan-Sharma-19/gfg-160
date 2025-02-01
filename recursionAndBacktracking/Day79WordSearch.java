package recursionAndBacktracking;

import java.util.Scanner;

public class Day79WordSearch {
    private static class Solution {
        private boolean dfs(int i,int j,int s,String word,char[][] mat,boolean[][] vis){
            if (s == word.length()) return true;
            if (word.charAt(s) != mat[i][j]) return false;
            vis[i][j] = true;
            int[] dir = {0, 1, 0, -1, 0};
            int n = mat.length;
            int m = mat[0].length;
            
            for (int d = 0; d < 4; d++){
                int nI = dir[d] + i;
                int nJ = dir[d + 1] + j;
                if (isValid(nI, nJ, n, m) && !vis[nI][nJ]){
                    if (dfs(nI, nJ, s + 1, word, mat, vis)) return true;
                }
            }
            
            vis[i][j] = false;
            return false;
        }
        
        private boolean isValid(int i, int j, int n, int m){
            return i >= 0 && j >= 0 && i < n && j < m;
        }
        
        public boolean isWordExist(char[][] mat, String word) {
            int n = mat.length;
            int m = mat[0].length;
            boolean[][] vis = new boolean[n][m];
            
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (dfs(i, j, 0, word, mat, vis)) return true;
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] mat = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.next().charAt(0);
            }
        }

        String word = scanner.next();

        Solution solution = new Solution();
        System.out.println(solution.isWordExist(mat, word));

        scanner.close();
    }
}
