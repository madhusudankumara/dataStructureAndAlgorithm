package java_collection.DSA.SUBSTRING.SlidingWindow;

import java.util.*;

public class MaximumOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 9, 4, 5, 2, 3, 6};
        int k = 4;
        ArrayList<Integer> res = maxOfSubarrays(arr, k); // time complaxity O(n * k)
        System.out.println(res);
        ArrayList<Integer> pqRes = maxOfSubarraysByPq(arr, k);
        System.out.println(pqRes);
        ArrayList<Integer> dqRes = maxOfSubarraysByDq(arr, k);
        System.out.println(dqRes);
    }

    private static ArrayList<Integer> maxOfSubarraysByDq(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> deq = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {// 1, 4, 2, 5
            while (!deq.isEmpty() && arr[i] > arr[deq.peekLast()]) {
                deq.pollLast();
            }
            deq.addLast(i);
        }
        for (int i = k; i < arr.length; i++) {
            res.add(arr[deq.peekFirst()]);
            while(!deq.isEmpty() && deq.peekFirst() <= i-k){
                deq.pollFirst();
            }
            while (!deq.isEmpty() && arr[i] > arr[deq.peekLast()]) {
                deq.pollLast();
            }
            deq.addLast(i);
        }
        res.add(arr[deq.peekFirst()]);

        return res;
    }

    private static ArrayList<Integer> maxOfSubarraysByPq(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return b.value - a.value;
            }
        });

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }
        res.add(pq.peek().value);
        for (int i = k; i < arr.length; i++) {
            pq.add(new Pair(arr[i], i));
            while (pq.peek().index <= i - k) {
                pq.poll();
            }
            res.add(pq.peek().value);
        }
        return res;
    }

    static class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.index = index;
            this.value = value;
        }
    }

    private static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int right = 0; right <= arr.length - k; right++) {
            int maxOfSa = arr[right];
            for (int i = 1; i < k; i++) {
                if (maxOfSa < arr[right + i]) maxOfSa = arr[right + i];
            }
            list.add(maxOfSa);
        }
        return list;
    }
}
