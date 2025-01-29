package recursionAndBacktracking;

import java.util.Scanner;

public class Day76ImplementPow {
    private static class Solution {
        public double power(double b, int e) {
            if (e == 0) return 1;
            
            if (e < 0) return 1 / power(b, -e);
            
            double temp = power(b, e / 2);
            
            if (e % 2 == 0) return temp * temp;
            else return b * temp * temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double b = scanner.nextDouble();
        int e = scanner.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.power(b, e));

        scanner.close();
    }
}
