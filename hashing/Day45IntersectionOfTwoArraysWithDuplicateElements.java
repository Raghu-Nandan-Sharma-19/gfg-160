import java.util.*;

public class Day45IntersectionOfTwoArraysWithDuplicateElements {
    private class Solution {
        public List<Integer> intersectionWithDuplicates(List<Integer> a, List<Integer> b) {
            Set<Integer> sa = new HashSet<>(a);
            List<Integer> res = new ArrayList<>();
            
            for (int i = 0; i < b.size(); i++) {
                if (sa.contains(b.get(i))) {
                    res.add(b.get(i));
                    sa.remove(b.get(i));
                }
            }
            
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }

        int m = scanner.nextInt();
        for(int i = 0; i < m; i++) {
            b.add(scanner.nextInt());
        }

        Solution sol;
        sol = new Day45IntersectionOfTwoArraysWithDuplicateElements().new Solution();
        List<Integer> res = sol.intersectionWithDuplicates(a, b);
        for (int x : res) {
            System.out.print(x + " ");
        }

        scanner.close();
    }
}
