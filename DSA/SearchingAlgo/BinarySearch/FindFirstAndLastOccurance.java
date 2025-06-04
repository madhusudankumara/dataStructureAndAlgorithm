package java_collection.DSA.SearchingAlgo.BinarySearch;

import java.util.List;

/*
First and Last Position of Element in Sorted Array
Leetcode 34: Find First and Last Position of Element in Sorted Array

Idea: Use binary search twice (once for first, once for last).
*/
public class FindFirstAndLastOccurance {
    public static void main(String[] args) {
        List<Integer> list = List.of(5, 7, 7, 8, 8, 10);
        int k = 8;
        int first = findOccurance(list, k, true);
        int last = findOccurance(list, k, false);
        System.out.println("first occurance at "+first);
        System.out.println("second occurance at "+last);
    }

    private static int findOccurance(List<Integer> list, int k, boolean isfirst) {
        int left = 0, right = list.size()-1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == k) {
                result = mid;
                if (isfirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (list.get(mid) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
