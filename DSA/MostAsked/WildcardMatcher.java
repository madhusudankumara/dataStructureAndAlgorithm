package java_collection.DSA.MostAsked;

public class WildcardMatcher {
    public static void main(String[] args) {
        String str1 = "a*b?d";
        String str2 = "axybcd";

        System.out.println("Response of WildcardMatcher is" + isMatch(str1, str2));
        System.out.println("Response of WildcardMatcher is" + isMatch1d(str1, str2));
    }


    /*
    we are using a 2D DP array of size (s.length+1) x (p.length+1).
        🎯 Time Complexity:O(m * n)
        💾 Space Complexity:O(m * n)
    */
    private static boolean isMatch(String p, String s) {
        int pLen = p.length();
        int sLen = s.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];

        dp[0][0] = true;

        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (sChar == pChar || pChar == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[sLen][pLen];
    }

    /*
    We update a 1D array (dp[j]) from right to left so that values we need aren’t overwritten before they’re used.
        🎯 Time Complexity:O(m * n)
        💾 Space Complexity:O(n)


    */
    public static boolean isMatch1d(String p, String s) {
        int m = s.length(), n = p.length();
        boolean[] dp = new boolean[n + 1];
        boolean[] prev = new boolean[n + 1];

        dp[0] = true;

        // Initialize first row for '*'
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[j] = dp[j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            prev = dp.clone(); // keep last row
            dp = new boolean[n + 1];
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (pc == '*') {
                    dp[j] = dp[j - 1] || prev[j];
                } else if (pc == '?' || pc == sc) {
                    dp[j] = prev[j - 1];
                }
            }
        }

        return dp[n];
    }

    /*No way to reduce space complexity because we need to consider all possibilities*/

}
