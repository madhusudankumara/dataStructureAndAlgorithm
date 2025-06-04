package java_collection.DSA.SearchingAlgo.BinarySearch;

import java.util.List;


/*
* Search Insert Position
Leetcode 35: Return the index if found, or the position where it would be inserted.

Classic binary search variation.
* */
public class SearchInsertPosition {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 5, 6);
        int k = 7;
        int result = searchInsert(list, k);
        System.out.println(result);
    }

    private static int searchInsert(List<Integer> list, int k) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == k) return mid;
            else if (list.get(mid) < k) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
