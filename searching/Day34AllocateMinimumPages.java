import java.util.*;

public class Day34AllocateMinimumPages {
    private class Solution {
        private boolean check(int[] arr, int k, int pageLimit) {
            int cnt = 1;
            int pageSum = 0;
            for (int i = 0; i < arr.length; i++) {
                if(pageSum+arr[i] > pageLimit) {
                    cnt++;
                    pageSum = arr[i];
                } else {
                    pageSum += arr[i];
                }
            }
            return (cnt <= k);
        }

        public int findPages(int[] arr, int k) {
            if (k > arr.length) return -1;

            int lo = Arrays.stream(arr).max().getAsInt();
            int hi = Arrays.stream(arr).sum();
            int res = -1;

            while(lo <= hi) {
                int mid = lo+(hi-lo)/2;

                if (check(arr, k, mid)) {
                    res = mid;
                    hi = mid-1;
                } else {
                    lo = mid+1;
                }
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
        
        Solution sol;
        sol = new Day34AllocateMinimumPages().new Solution();
        System.out.println(sol.findPages(arr, k));

        scanner.close();
    }
}
