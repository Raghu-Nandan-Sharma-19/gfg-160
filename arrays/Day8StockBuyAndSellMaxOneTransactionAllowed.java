import java.util.Scanner;

public class Day8StockBuyAndSellMaxOneTransactionAllowed {
    private class Solution {
        public int maximumProfit(int prices[]) {
            int maxPro = 0;
            int n = prices.length;
            int minPrice = Integer.MAX_VALUE;
            
            for(int i = 0; i < n; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                maxPro = Math.max(maxPro, prices[i] - minPrice);
            }
            
            return maxPro;
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
        sol = new Day8StockBuyAndSellMaxOneTransactionAllowed().new Solution();
        System.out.println(sol.maximumProfit(prices));

        scanner.close();
    }
}
