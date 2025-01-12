package twoPonterTechnique;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Day57CountDistinctElementsInEveryWindow {
    private static class Solution {
        public ArrayList<Integer> countDistinct(int[] arr, int k) {
            int n = arr.length;  
            ArrayList<Integer> res = new ArrayList<>();
        
            for (int i = 0; i <= n - k; i++) {
                HashSet<Integer> st = new HashSet<>();
                for(int j = i; j < i + k; j++)
                    st.add(arr[j]);
                res.add(st.size());
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        Solution sol = new Solution();
        ArrayList<Integer> res = sol.countDistinct(arr, k);
        for (int i : res) {
            System.out.print(i + " ");
        }

        scanner.close();
    }
}
