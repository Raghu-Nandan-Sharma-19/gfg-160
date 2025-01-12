import java.util.Scanner;

public class Day23CountInversions {
    private class Solution {
        private long merge(int[] nums, int low, int mid, int high) {
            int[] temp = new int[high-low+1];
            int left = low, right = mid+1, k = 0;
            long cnt = 0;

            while(left <= mid && right <= high) {
                if(nums[left] <= nums[right]) {
                    temp[k++] = nums[left++];
                } else {
                    temp[k++] = nums[right++];
                    cnt += (mid - left + 1);
                }
            }

            while (left <= mid) {
                temp[k++] = nums[left++];
            }

            while (right <= high) {
                temp[k++] = nums[right++];
            }

            for (int i = low; i <= high; i++) {
                nums[i] = temp[i - low];
            }

            return cnt;
        }

        private long mergeSort(int[] nums, int low, int high) {
            long cnt = 0;
            if (low < high) {
                int mid = (low + high) / 2;
                cnt += mergeSort(nums, low, mid);
                cnt += mergeSort(nums, mid + 1, high);
                cnt += merge(nums, low, mid, high);
            }
            return cnt;
        }

        public long inversionCount(int[] arr) {
            return mergeSort(arr, 0, arr.length - 1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Solution sol;
        sol = new Day23CountInversions().new Solution();
        System.out.println(sol.inversionCount(arr));

        scanner.close();
    }
}
