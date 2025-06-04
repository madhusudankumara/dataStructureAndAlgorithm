package java_collection.DSA.MostAsked;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aab", "a.*"));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        
    }

    public static boolean isMatch(String t, String p) {
        int n = t.length();
        int m = p.length();

        // DP table where dp[i][j] means whether first i characters in t
        // match the first j characters in p
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Empty pattern matches empty text
        dp[0][0] = true;

        // Deals with patterns like a*, a*b*, a*b*c* etc, where '*'
        // can eliminate the preceding character
        for (int j = 1; j <= m; ++j) {
            if (p.charAt(j - 1) == '*' && j > 1) {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill the table
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {

                // Characters match
                if (p.charAt(j - 1) == '.' || t.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // Handle '*' in the pattern
                else if (p.charAt(j - 1) == '*' && j > 1) {

                    // Two cases:
                    // 1. '*' represents zero occurrence of the preceding character
                    // 2. '*' represents one or more occurrence of the preceding character
                    dp[i][j] = dp[i][j - 2] ||
                            (dp[i - 1][j] && (p.charAt(j - 2) == t.charAt(i - 1) ||
                                    p.charAt(j - 2) == '.'));
                }
            }
        }

        return dp[n][m];
    }
}
