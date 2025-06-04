package java_collection.DSA.SUBSTRING.PrefixSumHashMap;

import java.util.Arrays;
import java.util.HashMap;

public class ContiguousBinaryArray {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1};
        System.out.println(a.length+"\n"+Arrays.toString(a));
        System.out.println(Arrays.toString(contiguousBinaryArray(a)));
    }

    private static int[] contiguousBinaryArray(int[] a) {
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        int maxLength = 0, start = -1, end = -1;
        int prefixSum = 0;
        prefixMap.put(0, -1);
        for (int i = 0; i < a.length; i++) {
            prefixSum += (a[i] == 0) ? -1 : 1;
            if (prefixMap.containsKey(prefixSum)) {
                int length = i - prefixMap.get(prefixSum);
                if (length > maxLength) {
                    maxLength = length;
                    start = prefixMap.get(prefixSum) + 1;
                    end = i;
                }
            } else {
                prefixMap.put(prefixSum, i); // Store first occurrence of prefixSum
            }
        }
        System.out.println(maxLength);
        if (start != -1 && end != -1) {
            return Arrays.copyOfRange(a, start, end + 1);
        } else {
            return new int[0];
        }
    }
}
