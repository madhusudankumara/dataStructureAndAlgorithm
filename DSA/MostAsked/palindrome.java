package java_collection.DSA.MostAsked;

import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter string to check for anagram?");
        String str = sn.next();

        System.out.println(checkForpalindrome(str) + "string provided is palindrome");
    }

    private static boolean checkForpalindrome(String str) {
        char[] charArr = str.toCharArray();
        int length = charArr.length;
        int itr = length / 2;
        for (int i = 0; i < itr; i++) {
            if (charArr[i] != charArr[length - i-1]) {
                return false;
            }
        }
        return true;
    }
}
