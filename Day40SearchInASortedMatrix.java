import java.util.Scanner;

public class Day40SearchInASortedMatrix {
    private class Solution {
        public boolean searchMatrix(int[][] mat, int x) {
            // code here
            int n = mat.length, m = mat[0].length;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(mat[i][j] == x) {
                        return true;
                    } 
                }
            }
            return false;
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

        int x = scanner.nextInt();

        Solution sol;
        sol = new Day40SearchInASortedMatrix().new Solution();
        System.out.println(sol.searchMatrix(mat, x));

        scanner.close();
    }
}
