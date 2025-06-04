package java_collection.DSA.SearchingAlgo.BinarySearch;

public class RotatedSortedArrayMinimum {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(arr));
    }

    private static int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;
        if (arr[left] <= arr[right]) {
            return arr[left];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
