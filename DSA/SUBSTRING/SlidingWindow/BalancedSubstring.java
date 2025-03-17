//package java_collection.DSA.SUBSTRING.SlidingWindow;
//
//import java.util.HashMap;
//
//
//// Wrong approach
//
//
//public class BalancedSubstring {
//    public static void main(String[] args) {
//        String s = "ababab";
//        System.out.println(longestBalancedSubstring(s));  // Expected Output: 6
//    }
//
//    private static int longestBalancedSubstring(String s) {
//        int maxLength = 0;
//        HashMap<Character, Integer> freqMap = new HashMap<>();
//        int left = 0;
//
//        for (int right = 0; right < s.length(); right++) {
//            // Expand the window by adding the right character
//            char rightChar = s.charAt(right);
//            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
//
//            // Shrink the window if unbalanced
//            while (!isBalanced(freqMap) && left <= right) {
//                char leftChar = s.charAt(left);
//                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
//                if (freqMap.get(leftChar) == 0) {
//                    freqMap.remove(leftChar);
//                }
//                left++;  // Move left pointer forward
//            }
//
//            // Update maxLength if the current window is balanced
//            if (isBalanced(freqMap)) {
//                maxLength = Math.max(maxLength, right - left + 1);
//            }
//        }
//
//        return maxLength;
//    }
//
//    private static boolean isBalanced(HashMap<Character, Integer> map) {
//        if (map.isEmpty()) return false;
//        int count = -1;
//        for (int val : map.values()) {
//            if (count == -1) count = val;
//            else if (count != val) return false;
//        }
//        return true;
//    }
//}
