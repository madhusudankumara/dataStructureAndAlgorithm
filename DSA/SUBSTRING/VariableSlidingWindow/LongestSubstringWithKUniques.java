package java_collection.DSA.SUBSTRING.VariableSlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringWithKUniques {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("provide String"); //aabacbebebe
        String str = sc.nextLine();
        System.out.println("provide k"); //3
        int k = sc.nextInt();

        System.out.println("Longest Substring With K Uniques is" + findLongestSubstringWithKUniques(str, k));
    }

    private static String findLongestSubstringWithKUniques(String s, int k) {
        int longstStringLen = Integer.MIN_VALUE;
        int start = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            freqMap.put(endChar, freqMap.getOrDefault(endChar, 0) + 1);
            while (freqMap.size() > k) {
                char startChar = s.charAt(start);
                freqMap.put(startChar, freqMap.get(startChar) - 1);
                start++;
                if(freqMap.get(startChar)==0){
                    freqMap.remove(startChar);
                }
            }
            longstStringLen = Math.max(longstStringLen,end - start + 1);
        }
        if(freqMap.size()<k) return String.valueOf(-1);
        return String.valueOf(longstStringLen);
    }
}
