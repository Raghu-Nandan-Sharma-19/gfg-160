import java.util.Arrays;
import java.util.Scanner;

public class Day9MinimizeTheHeights2 {
    private class Solution {
        int getMinDiff(int[] arr, int k) {
            int n = arr.length;
            if(n == 1) return 0;  // If there's only one tower, difference is 0.
            
            // Sort the array to handle elements in order.
            Arrays.sort(arr);
    
            // Initialize the result as the difference between the max and min height in the sorted array.
            int result = arr[n-1]-arr[0];
    
            // The smallest possible height and largest possible height after adjusting with k
            int smallest = arr[0]+k;
            int largest = arr[n-1]-k;
    
            // Traverse through the array to explore the different possibilities
            for (int i = 0; i < n-1; i++) {
                int minHeight = Math.min(smallest, arr[i+1]-k);
                int maxHeight = Math.max(largest, arr[i]+k);
                
                // If the new height is negative, skip to avoid invalid cases
                if(minHeight < 0) continue;
    
                // Update the result with the minimum possible difference
                result = Math.min(result, maxHeight-minHeight);
            }
    
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        Solution sol;
        sol = new Day9MinimizeTheHeights2().new Solution();
        System.out.println(sol.getMinDiff(arr, k));

        scanner.close();
    }
}
