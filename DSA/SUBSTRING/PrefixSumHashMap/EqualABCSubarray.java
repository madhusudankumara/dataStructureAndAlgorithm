package java_collection.DSA.SUBSTRING.PrefixSumHashMap;

import java.util.HashMap;

public class EqualABCSubarray {
    public static void main(String[] args) {
        String s = "ABACBCBACABC";
        System.out.println(findMaxBalancedSubstring(s));
    }

    private static String findMaxBalancedSubstring(String s) {
        HashMap<String, Integer> prefMap = new HashMap<>();

        int maxLength = 0, prfSum = 0, start = -1;
        int countA = 0, countB = 0, countC = 0;

        prefMap.put("0,0", -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'A') countA++;
            else if (ch == 'B') countB++;
            else if (ch == 'C') countC++;

            int difAB = countA - countB;
            int difBC = countB - countC;

            String key = difAB + "," + difBC;

            if(prefMap.containsKey(key)){
                int prevIndex = prefMap.get(key);
                int length = i - prevIndex;

                if (length > maxLength) {
                    maxLength = length;
                    start = prevIndex + 1;
                }
            }else {
                prefMap.put(key,i);
            }
        }
        System.out.println(maxLength);
        return s.substring(start,start+maxLength);
    }
}
