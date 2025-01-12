import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day36SpirallyTraversingAMatrix {
    private class Solution {
        public List<Integer> spirallyTraverse(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int n = matrix.length, m = matrix[0].length;
            int left = 0, right = m-1;
            int top = 0, bottom = n-1;

            while(top <= bottom && left <= right) {
                for(int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;

                for(int i = top; i <= bottom; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;

                if(top <= bottom) {
                    for(int i = right; i >= left; i--) {
                        ans.add(matrix[bottom][i]);
                    }
                    bottom--;
                }

                if(left <= right) {
                    for(int i = bottom; i >= top; i--) {
                        ans.add(matrix[i][left]);
                    }
                    left++;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        Solution sol;
        sol = new Day36SpirallyTraversingAMatrix().new Solution();
        List<Integer> ans = sol.spirallyTraverse(matrix);
        for(int i : ans) {
            System.out.print(i + " ");
        }

        scanner.close();
    }
}
