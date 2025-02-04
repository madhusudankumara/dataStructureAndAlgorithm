package java_collection.DSA;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};

        quickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int first, int last) {
        if(first < last){
            int i = getParitionIndex(arr,first,last);
            quickSort(arr, first, i-1);
            quickSort(arr, i+1, last);
        }
    }

    private static int getParitionIndex(int[] arr, int first, int last) {
        int pivot = arr[last];
        int i = first-1;

        for(int j = first; j < last; j++){
            if(arr[j] < pivot){
                i++;
                swapData(arr,i, j);
            }
        }

        swapData(arr, i+1, last);
        return i+1;
    }

    private static void swapData(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
