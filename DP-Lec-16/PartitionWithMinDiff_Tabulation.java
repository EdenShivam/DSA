import java.util.*;

public class PartitionWithMinDiff_Tabulation {

    public static int minSubsetSumDifference(int[] arr, int n) {

        int totalSum = Arrays.stream(arr).sum();
        boolean[][] dp = new boolean[n][totalSum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= totalSum) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int sum = 0; sum <= totalSum; sum++) {
                boolean notTake = dp[i - 1][sum];
                boolean take = false;
                if (arr[i] <= sum) {
                    take = dp[i - 1][sum - arr[i]];
                }
                dp[i][sum] = take || notTake;
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= totalSum; s1++) {
            if (dp[n - 1][s1]) {
                int s2 = totalSum - s1;
                minDiff = Math.min(minDiff, Math.abs(s1 - s2));
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 8};
        int n = arr.length;
        System.out.println(minSubsetSumDifference(arr, n));
    }
}
