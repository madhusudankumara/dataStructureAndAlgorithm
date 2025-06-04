package java_collection.DSA.SUBSTRING.VariableSlidingWindow;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
    public static void main(String[] args) throws IOException {
        String s = "abdefgabef";
        System.out.println(getLongestUniqueSubstring(s));
    }

    private static int getLongestUniqueSubstring(String s) {
        int start = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> freMap = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            freMap.put(endChar, freMap.getOrDefault(endChar, 0) + 1);
            while (freMap.get(endChar) > 1) {
                char startChar = s.charAt(start);
                freMap.put(startChar, freMap.get(startChar) - 1);
                if (freMap.get(startChar) == 0) {
                    freMap.remove(startChar);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}