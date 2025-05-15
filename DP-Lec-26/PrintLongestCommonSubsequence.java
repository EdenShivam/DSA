public class PrintLongestCommonSubsequence{

    public static String findLCS(int n, int m, String s1, String s2) {
        int[][] dp = new int[n + 1][m + 1];

        for(int i=0;i<=n;i++){
        dp[i][0] = 0;
         }

        for(int i=0;i<=m;i++){
        dp[0][i] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }

        int i = n, j = m;
        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        String lcs = findLCS(s1.length(), s2.length(), s1, s2);
        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("Longest Common Subsequence: " + lcs);
    }
}
