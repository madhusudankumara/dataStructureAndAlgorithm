package java_collection.DSA.MostAsked;

/*
 * Write code of Greatest Common Divisor
 * */

import java.util.Scanner;

public class gcd_or_hcf {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number 1");
        int num1 = scn.nextInt();
        System.out.println("Enter number 2");
        int num2 = scn.nextInt();

        System.out.println("Gcd of num1:"+num1+" and num2:"+num2+" is "+findGcdByRecursion(num1,num2));
        System.out.println("Gcd of num1:"+num1+" and num2:"+num2+" is "+findGcdByIteration(num1,num2));

    }
    private static int findGcdByRecursion(int num1, int num2) {
        if(num2 == 0){
            return num1;
        }
        return findGcdByRecursion(num2,num1%num2);
    }

    private static int findGcdByIteration(int num1, int num2) {
        while(num2 !=0){
            int temp = num2;
            num2 = num1%num2;
            num1=temp;
        }
        return num1;
    }

}
