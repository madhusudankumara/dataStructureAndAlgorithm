package java_collection.DSA.SUBSTRING;

import java.util.HashMap;

public class MaximumBalancedString {
    public static void main(String[] args) {
        String str = "abacdbab";
        System.out.println(findMaxBalancedString(str));// Brut force method
    }

    // Brut force method
    private static int findMaxBalancedString(String str) {
        int len = str.length();
        int maxBalanceStringLen = 0;
        String maxBalanceString = "";
        for (int i = 0; i < len; i++) {
            HashMap<Character, Integer> freqMap = new HashMap<>();
            for (int j = i; j < len; j++) {
                char val = str.charAt(j);
                freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
                if (isBalanceString(freqMap)) {
                    int currentLen = j-i+1;
                    if(currentLen> maxBalanceStringLen){
                        maxBalanceStringLen = Math.max(maxBalanceStringLen, j - i + 1);
                        maxBalanceString = str.substring(i, j + 1);
                    }
                }
            }
        }
        System.out.println(maxBalanceString);
        return maxBalanceStringLen;
    }

    private static boolean isBalanceString(HashMap<Character, Integer> freqMap) {
        if (freqMap.isEmpty()) return false;
        int freq = freqMap.values().iterator().next();
        for (int fq : freqMap.values()) {
            if (fq != freq) return false;
        }
        return true;
    }

}
