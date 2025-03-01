package java_collection.DSA.SUBSTRING.PrefixSumHashMap;

import java.util.Arrays;
import java.util.HashMap;

public class LongestBalancedSubArray {
    public static void main(String[] args) {
        int[] arr = {1, -1, 2, -2, 3, -3, 4, -4};
        int[] result = findLongestBalancedSubarray(arr);

        System.out.println("Longest balanced subarray length: " + result.length);
        System.out.println("Max balanced subarray: " + Arrays.toString(result));
    }

    private static int[] findLongestBalancedSubarray(int[] arr) {
        HashMap<Integer, Integer> prefMap = new HashMap<>();
        int prefSum = 0, maxLength = 0, start = -1, end = -1;

        prefMap.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            // Increment or decrement prefix sum based on element
            prefSum += (arr[i] > 0) ? 1 : -1;

            // If prefixSum has been seen before, calculate the max length
            if (prefMap.containsKey(prefSum)) {
                int prevIndex = prefMap.get(prefSum);
                if (i - prevIndex > maxLength) {
                    maxLength = i - prevIndex;
                    start = prevIndex + 1;
                    end = i;
                }
            } else {
                prefMap.put(prefSum, i); // Store first occurrence of prefixSum
            }
        }
        if(start != -1 && end !=-1){
            int[] maxArray = new int[end - start + 1];
            System.arraycopy(arr, start, maxArray, 0, maxLength);
            return maxArray;
        }else{
            return new int[0];
        }
    }
}
