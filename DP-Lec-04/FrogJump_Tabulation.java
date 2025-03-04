import java.util.Scanner;
import java.util.*;

public class FrogJump_Tabulation {
    public static int minJumpCost(int n, int k, int[] height) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; 

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) { // Ensure valid jump
                    dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(height[i] - height[i - j]));
                }
            }
        }
        return dp[n - 1]; /
    }

    public static void main(String[] args) {
        int k = 2;
        int[] height = {10, 40, 30, 10};

        System.out.println(minJumpCost(height.length, k, height));
    }
}