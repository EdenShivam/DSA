public class LongestCommonSubstring{

    public static int findLCS(int n, int m, String s1, String s2) {
        int[][] dp = new int[n + 1][m + 1];

        for(int i=0;i<=n;i++){
        dp[i][0] = 0;
         }

        for(int i=0;i<=m;i++){
        dp[0][i] = 0;
        }
        
        int ans = 0 ; 
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                     
                    int val = 1 + dp[ind1 - 1][ind2 - 1];
                    dp[ind1][ind2] =  val;
                    ans = Math.max( ans ,dp[ind1][ind2]);
                } else {
                    dp[ind1][ind2] = 0;
                }
            }
        }
        return ans ; 

    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abzd";

        int lcs = findLCS(s1.length(), s2.length(), s1, s2);
        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("Longest Common Substring: " + lcs);
    }
}
