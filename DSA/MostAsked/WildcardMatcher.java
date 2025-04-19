package java_collection.DSA.MostAsked;

public class WildcardMatcher {
    public static void main(String[] args) {
        String str1 = "a*b?d";
        String str2 = "axybcd";

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == '*') {
                int j = i + 1;
                while (str1.charAt(j) != str2.charAt(j) && j < str2.length()) {
                    j++;
                    if(j==str2.length()){
                        System.out.println("Not Matched");
                    }
                }
            } else if (str1.charAt(i) == '?' && str1.charAt(i+1) != str2.charAt(i+1)){
                System.out.println("Not Matched");
            }
        }
        System.out.println("Matched");
    }
}
