public class MinInsertionDeletion{

    public static int findLCS(int n, int m, String s1, String s2) {
        
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
        return dp[n][m] ;
    }

    public static void main(String[] args) {
        String s = "edl";
        String str2 = "xcqja";

        int K = findLCS(s.length(), str2.length(), s, str2);
        
        System.out.println("CanYouMakeString1: " + (s.length() + str2.length()  - 2 * K) );
    }
}
