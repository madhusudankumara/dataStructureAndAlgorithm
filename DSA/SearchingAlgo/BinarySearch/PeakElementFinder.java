package java_collection.DSA.SearchingAlgo.BinarySearch;

public class PeakElementFinder {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 5, 6, 4};
        int peak = findPeak(arr);
        System.out.println("peak element is " + arr[peak]);
    }

    private static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
