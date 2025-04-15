import java.util.*;

public class PartitionWithMinDiff_Memoization {

    public static int minSubsetSumDifference(int[] arr, int index, int sum, int[][] dp, int totalSum) {


        if (index == -1) {
            int sum2 = totalSum - sum;
            return Math.abs(sum - sum2);
        }

        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }

        int take = minSubsetSumDifference(arr, index - 1, sum + arr[index], dp,totalSum);
        int notTake = minSubsetSumDifference(arr, index - 1, sum, dp,totalSum);

        return dp[index][sum] = Math.min(take, notTake);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 8};
        int n = arr.length;
        int totalSum = Arrays.stream(arr).sum();
        int[][] dp = new int[n][totalSum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(minSubsetSumDifference(arr, n - 1, 0, dp,totalSum));
    }
}
