package java_collection.DSA.SearchingAlgo.BinarySearch;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Binary search is an efficient algorithm used to find the position of a target value within a sorted array (or list).
time complaxity - O(log n)
space complaxity -

*/
public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = Stream.iterate(0, i -> i + 1).limit(5).collect(Collectors.toList());
        int k = 3;
        System.out.println(list);
        System.out.println(binarySearchImplByItrative(list, k));
        System.out.println(binarySearchImplByRecurcion(list, 0, (list.size() - 1), k));
    }

    private static int binarySearchImplByItrative(List<Integer> list, int k) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == list.get(k)) return mid + 1;
            if (list.get(mid) < k) left = mid + 1;
            if (list.get(mid) > k) right = mid - 1;
        }
        return -1;
    }

    private static int binarySearchImplByRecurcion(List<Integer> list, int left, int right, int k) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (list.get(mid) == k) return mid;
        if (list.get(mid) < k) return binarySearchImplByRecurcion(list, mid + 1, right, k);
        else return binarySearchImplByRecurcion(list, left, mid - 1, k);
    }
}
