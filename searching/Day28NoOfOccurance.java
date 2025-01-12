import java.util.Scanner;

public class Day28NoOfOccurance {
    private class Solution {
        public int countFreq(int[] arr, int target) {
            int n = arr.length;
            int cnt = 0;

            for(int i = 0; i < n; i++) {
                if(arr[i] == target) {
                    cnt++;
                }
            }

            return cnt;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int target = scanner.nextInt();

        Solution sol;
        sol = new Day28NoOfOccurance().new Solution();
        System.out.println(sol.countFreq(arr, target));

        scanner.close();
    }
}
