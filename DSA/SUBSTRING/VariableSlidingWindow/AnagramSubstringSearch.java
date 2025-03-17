package java_collection.DSA.SUBSTRING.VariableSlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AnagramSubstringSearch {

    static final int CHAR_COUNT = 256;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("provide string to check for");
        String txt = sc.nextLine(); // BACDGABCDA
        System.out.println("provide pattern for checking anagram");
        String pat = sc.nextLine(); // ABCD

        List<Integer> result = getAnagramSubstringSearch(txt, pat);
        System.out.println("Resultant array is"+result);
    }

    private static List<Integer> getAnagramSubstringSearch(String txt, String pat) {
        int txtSize = txt.length();
        int patSize = pat.length();

        int[] patCount = new int[CHAR_COUNT];
        int[] windCount = new int[CHAR_COUNT];

        List<Integer> anagramStartFromIndex = new ArrayList<>();

        for (int i = 0; i < patSize; i++) {
            patCount[pat.charAt(i)]++;
            windCount[txt.charAt(i)]++;
        }

        for (int i = patSize; i < txtSize; i++) {

            if (areSame(patCount, windCount)) {
                System.out.println("Anagram found at index " + (i - patSize));
                anagramStartFromIndex.add(i - patSize);
            }

            windCount[txt.charAt(i)]++;
            windCount[txt.charAt(i - patSize)]--;

        }

        if (areSame(patCount, windCount)) {
            System.out.println("Anagram found at index " + (txtSize - patSize));
            anagramStartFromIndex.add(txtSize - patSize);
        }
        return anagramStartFromIndex;
    }

    private static boolean areSame(int[] count1, int[] count2) {
        for (int i = 0; i < CHAR_COUNT; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}
