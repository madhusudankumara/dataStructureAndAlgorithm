package java_collection.DSA.MostAsked;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number to check for perfect number");
        int number = scn.nextInt();
        System.out.println("Is number: " + number + " is perfect Number?" + isPerfectNumber(number));
    }

    private static boolean isPerfectNumber(int number) {
        if(number <= 1)return false;
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                sum+=i;
                if(i!=number/i){
                    sum+=(number/i);
                }
            }
        }
        return sum==number;
    }
}
