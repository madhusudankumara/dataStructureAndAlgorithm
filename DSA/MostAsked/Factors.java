package java_collection.DSA.MostAsked;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Factors {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Give number to find factor: ");
        int number = scn.nextInt();
        Set<Integer> factor = printFactor(number);
        System.out.print("\n");
        System.out.println(factor);
        List<Integer> list = new ArrayList<>(factor);
        Collections.reverse(list);
        System.out.println(list);

        printFactorUsingStream(number);
    }

    private static Set<Integer> printFactor(int number) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                System.out.printf(i + " ");
                set.add(i);
                if (i != number / i) {
                    System.out.print(number / i + " ");
                    set.add(number/i);
                }
            }
        }
        return set;
    }

    private static void printFactorUsingStream(int number) {
        List<Integer> list = IntStream.range(1, (int) Math.sqrt(number))
                .filter(n->number%n==0)
                .flatMap(n->number/n==n?IntStream.of(n):IntStream.of(n,number/n))
                .sorted()
                .distinct()
                .boxed()
                .toList();
        System.out.println(list);
    }
}
