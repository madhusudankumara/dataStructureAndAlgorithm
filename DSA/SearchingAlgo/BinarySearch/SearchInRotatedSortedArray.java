package java_collection.DSA.SearchingAlgo.BinarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        int k = 0;
        System.out.println(searchTarget(array, k));
    }

    private static int searchTarget(int[] array, int k) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == k) return mid;
            else if (array[left] <= array[mid]) {
                if (array[left] <= k && k < array[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (array[mid] < k && k <= array[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
