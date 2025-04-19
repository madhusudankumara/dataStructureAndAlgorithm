package java_collection.DSA.MostAsked;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        System.out.println(checkForAnagram(str1,str2) + "strings provided are anagram");
    }

    private static boolean checkForAnagram(String str1, String str2) {
        char[] chrA1 = str1.toCharArray();
        char[] chrA2 = str2.toCharArray();

        Arrays.sort(chrA1);
        Arrays.sort(chrA2);

        return Arrays.equals(chrA1,chrA2);
    }
}
