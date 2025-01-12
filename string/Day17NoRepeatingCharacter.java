import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day17NoRepeatingCharacter {
    private class Solution {
        public char nonRepeatingChar(String s) {
            Map<Character, Integer> hash = new HashMap<>();
        
            for(char c : s.toCharArray()) {
                hash.put(c, hash.getOrDefault(c, 0)+1);
            }
            
            for(char c : s.toCharArray()) {
                if(hash.get(c) == 1) {
                    return c;
                }
            }
            
            return '$';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        Solution sol;
        sol = new Day17NoRepeatingCharacter().new Solution();
        System.out.println(sol.nonRepeatingChar(s));

        scanner.close();
    }
}
