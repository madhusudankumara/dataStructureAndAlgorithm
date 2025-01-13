package java_collection.DSA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumbersBetween {
    public static void main(String[] args) {
        int num1 = 0, num2 = 200;
        System.out.println("Print prime numbers between " + num1 + " and " + num2);
        System.out.println(printNumbersBetweenRangeByPrimeCheck6k(num1, num2));
        getNumbersBetweenRangeBySieveOfEratosthenes(num2);
    }

    private static void getNumbersBetweenRangeBySieveOfEratosthenes(int num2) {
        Boolean[] isPrime = new Boolean[num2 + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

//        for (int i = 2; i <= Math.sqrt(num2); i++) {
        for (int i = 2; i * i <= num2; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= num2; j += i) {
                    isPrime[j] = false;
                }
            }
        }


        printNumbersBetweenRangeBySieveOfEratosthenes(isPrime);
    }

    private static void printNumbersBetweenRangeBySieveOfEratosthenes(Boolean[] isPrime) {
        IntStream.rangeClosed(2, isPrime.length-1)
                        .filter(i -> isPrime[i])
                        .forEach(i -> System.out.printf(i + ", "));
//        result -  2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
//        103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,


        System.out.println(IntStream.rangeClosed(2, isPrime.length-1)
                .filter(i -> isPrime[i])
                .mapToObj(Integer::toString)
                .collect(Collectors.toList()));
//        result -  [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
//        103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199]


        System.out.println(IntStream.rangeClosed(2, isPrime.length-1)
                .filter(i -> isPrime[i])
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ")));

//        result -  , 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
//        103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199
    }

    private static List<Integer> printNumbersBetweenRangeByPrimeCheck6k(int num1, int num2) {
        List<Integer> result = new LinkedList<>();
        for (int i = num1; i <= num2; i++) {
            if (primeCheckBy6k(i)) result.add(i);
        }
        return result;
    }

    private static boolean primeCheckBy6k(int n) {
        /*
         * Most optimized
         * 6k -1 and 6k + 1
         * */
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 | n % 3 == 0) return false;

        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
