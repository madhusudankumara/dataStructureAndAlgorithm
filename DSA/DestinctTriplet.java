package java_collection.DSA;

import java.util.*;

/*
 * question link - https://algo.monster/liteproblems/2964
 * */
public class DestinctTriplet {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(Arrays.asList(3, 3, 4, 7, 8));
        int d = 5;
        System.out.println("number of Triplets = " + getDestinctTriplet(list, d));
        System.out.println("number of Triplets = " + getDestinctTripletPrifixCounting(list, d));
    }


    /*
    * Brute Force: O(n³) — loop over all i, j, k → too slow!
    * Space : O(1)
    * */
    private static int getDestinctTriplet(List<Integer> list, int d) {
        int len = list.size(), count = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if ((list.get(i) + list.get(j) + list.get(k)) % d == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    /*
    * Optimized (O(n²)): Use a hash table to count remainders seen so far (modulo d).
    *
    * Space:
            O(d) for hash map (cnt)
            Often treated as O(1) if d is small/fixed
    * */
    private static int getDestinctTripletPrifixCounting(List<Integer> list, int d) {
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        int result = 0;
        int length = list.size();
        for (int j = 0; j < length; j++) {
            for (int k = j + 1; k < length; k++) {
                int reqNum = (d - (list.get(j) + list.get(k)) % d) % d;
                result += frequencyCount.getOrDefault(reqNum, 0);
            }
            frequencyCount.merge(list.get(j) % d, 1, Integer::sum);
        }
        return result;
    }
}
