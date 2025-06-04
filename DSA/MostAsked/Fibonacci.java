package java_collection.DSA.MostAsked;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 *
 * Write the code to find the Fibonacci series upto the nth term.
 * */

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number upto where you want series.");
        int number = scn.nextInt();
        System.out.println("Fibonacci series upto " + number);
        printFibonacci(number);

        List<Integer> fibonacci = Stream.iterate(new int[]{0,1}, fib -> new int[]{fib[1],fib[0]+fib[1]})
                .limit(number)
                .map(fib -> fib[0])
                .toList();
        System.out.print("\n");
        System.out.println(fibonacci);

    }

    private static void printFibonacci(int number) {
        int num1 = 0;
        int num2 = 1;
        System.out.print(num1 + ", " + num2);
        while (number - 2 != 0) {
            int sum = num1 + num2;
            System.out.print(", " + sum);
            num1 = num2;
            num2 = sum;
            number--;
        }
    }
}
