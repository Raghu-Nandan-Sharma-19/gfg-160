import java.util.*;

public class Day44FindAllTripletsWithZeroSum {
    private class Solution {
        public List<List<Integer>> findTriplets(int[] arr) {
            Set<List<Integer>> resSet = new HashSet<>();
            int n = arr.length;
            Map<Integer, List<int[]>> mp = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int sum = arr[i] + arr[j];
                    if (!mp.containsKey(sum)) {
                        mp.put(sum, new ArrayList<>());
                    }
                    mp.get(sum).add(new int[]{i, j});
                }
            }
            
            for (int i = 0; i < n; i++) {
                int rem = -arr[i];
                if (mp.containsKey(rem)) {
                    List<int[]> pairs = mp.get(rem);
                    for (int[] p : pairs) {
                        if (p[0] != i && p[1] != i) {
                            List<Integer> curr = Arrays.asList(arr[i], arr[p[0]], arr[p[1]]);
                            Collections.sort(curr);
                            resSet.add(curr);
                        }
                    }
                }
            }
            
            return new ArrayList<>(resSet);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Solution sol;
        sol = new Day44FindAllTripletsWithZeroSum().new Solution();
        List<List<Integer>> res = sol.findTriplets(arr);
        for (List<Integer> triplet : res) {
            System.out.println(triplet);
        }

        scanner.close();
    }
}
