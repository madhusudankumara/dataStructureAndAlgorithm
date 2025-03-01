package java_collection.DSA.SUBSTRING.PrefixSumHashMap;

import java.util.HashMap;
import java.util.Map;
/*
* in this string other then 'a' and 'b' are ignored like 'c'
* */
public class BalancedSubstringByPrefixSumHashMap {
    public static void main(String[] args) {
        String str = "aabbabcaba";
        char c1 = 'a', c2 = 'b';
        System.out.println(findLongestBalancedSubstring(str, c1, c2));
    }

    private static int findLongestBalancedSubstring(String str, char c1, char c2) {
        Map<Integer, Integer> prefMap = new HashMap<>();

        int prefSum = 0;
        int maxLength = 0;

        prefMap.put(0, -1);

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == c1) {
                prefSum += 1;
            } else if (ch == c2) {
                prefSum -= 1;
            } else {
                continue;
            }

            if (prefMap.containsKey(prefSum)) {
                maxLength = Math.max(maxLength, i - prefMap.get(prefSum));
            } else {
                prefMap.put(prefSum, i);
            }
        }
        return maxLength;
    }
}