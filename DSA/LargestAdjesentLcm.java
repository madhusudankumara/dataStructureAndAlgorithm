package java_collection.DSA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestAdjesentLcm {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("largest Adjesent LCM is:" + getLargestAdjesentLcm(list));
    }

    private static int getLargestAdjesentLcm(List<Integer> list) {
        int result = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            Math.max(result, lcm(list.get(i), list.get(i + 1)));
        }
        return result;
    }

    private static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}
