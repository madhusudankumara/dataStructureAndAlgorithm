package java_collection.DSA.SearchingAlgo.BinarySearch;

public class MinimumNumberDaysToMakeBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;
        System.out.println("Minimum days to make bouquets" + minDay(bloomDay, m, k));
    }

    private static int minDay(int[] bloomDay, int m, int k) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            left = Math.min(day, left);
            right = Math.max(day, right);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    private static boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
        int bouquetCompleted = 0;
        int flowers = 0;
        for (int d : bloomDay) {
            if (d <= days) {
                flowers++;
                if (flowers == k) {
                    bouquetCompleted++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquetCompleted >= m;
    }
}
