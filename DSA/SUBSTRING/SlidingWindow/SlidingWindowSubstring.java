package java_collection.DSA.SUBSTRING.SlidingWindow;

public class SlidingWindowSubstring {
    public static void main(String[] args) {
        String str = "abcd";
        int k = 3;
        generateFixedLengthSubstrings(str, k);
    }

    private static void generateFixedLengthSubstrings(String str, int k) {
        for (int i = 0; i <= str.length()-k; i++){
            System.out.println(str.substring(i,i+k));
        }
    }
}
