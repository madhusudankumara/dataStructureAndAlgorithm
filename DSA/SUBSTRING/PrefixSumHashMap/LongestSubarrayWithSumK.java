package java_collection.DSA.SUBSTRING.PrefixSumHashMap;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;

        int[] finalArr = findLongestSubarrayWithSumK(arr, k);
        System.out.println(Arrays.toString(finalArr));
    }

    private static int[] findLongestSubarrayWithSumK(int[] arr, int k) {
        HashMap<Integer, Integer> prefMap = new HashMap<>();
        prefMap.put(0, -1);

        int prefSum = 0, maxLength = 0, start = -1, end = -1;
        for (int i = 0; i < arr.length; i++) {
            prefSum += arr[i];
            if (prefMap.containsKey(prefSum - k)) {
                maxLength = Math.max(maxLength, i - prefMap.get(prefSum - k));
                start = prefMap.get(prefSum - k) + 1;
                end = i;
            } else {
                prefMap.put(prefSum, i);
            }
        }
        System.out.println("maxLength is " + maxLength);
        if (start != -1 && end != -1) {
            int[] maxArray = new int[end - start + 1];
            System.arraycopy(arr, start, maxArray, 0, maxLength);
            return maxArray;
//            return Arrays.copyOfRange(arr, start, end+1);
        } else {
            return new int[0];
        }
    }
}
