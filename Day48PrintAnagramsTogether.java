import java.util.*;

public class Day48PrintAnagramsTogether {
    private class Solution {
        public List<List<String>> anagrams(String[] arr) {
            Map<String, List<String>> mpp = new HashMap<>();
            
            for (String str : arr) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String sortedStr = new String(charArray);
                if (!mpp.containsKey(sortedStr)) {
                    mpp.put(sortedStr, new ArrayList<>());
                }
                mpp.get(sortedStr).add(str);
            }
            
            List<List<String>> ans = new ArrayList<>();
            for (List<String> group : mpp.values()) {
                ans.add(group);
            }
            
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }

        Solution sol;
        sol = new Day48PrintAnagramsTogether().new Solution();
        List<List<String>> res = sol.anagrams(arr);
        for (List<String> group : res) {
            for (String str : group) {
                System.out.print(str + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
