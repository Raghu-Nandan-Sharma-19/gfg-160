import java.util.Scanner;

public class Day7StockBuyAndSellMultipleTransactionsAllowed {
    private class Solution {
        public int maximumProfit(int prices[]) {
            int n = prices.length;
            if(n == 0) return 0;
            int lMin = prices[0];  // Local Minima
            int lMax = prices[0];  // Local Maxima
            int res = 0;
        
            int i = 0;
            while(i < n-1) {
            
                // Find local minima 
                while(i < n-1 && prices[i] >= prices[i+1]) { 
                    i++; 
                }
                lMin = prices[i];
            
                // Local maxima
                while(i < n-1 && prices[i] <= prices[i+1]) { 
                    i++; 
                }
                lMax = prices[i];
            
                // Add current profit 
                res = res+(lMax-lMin);
            }
        
            return res;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];

        for(int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        Solution sol;
        sol = new Day7StockBuyAndSellMultipleTransactionsAllowed().new Solution();
        System.out.println(sol.maximumProfit(prices));

        scanner.close();
    }
}
