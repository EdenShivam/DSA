import java.util.*;

public class PartitionWithMinDiff_SpaceTabulation{

    public static int minSubsetSumDifference(int[] arr, int n) {

        int totalSum = Arrays.stream(arr).sum();
        boolean[] prev = new boolean[totalSum + 1];
        boolean[] curr = new boolean[totalSum + 1];

        prev[0] = true;

        if (arr[0] <= totalSum) {
            prev[arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            curr = new boolean[totalSum + 1]; // reset for the current index
            curr[0] = true;

            for (int sum = 0; sum <= totalSum; sum++) {
                boolean notTake = prev[sum];
                boolean take = false;
                if (arr[i] <= sum) {
                    take = prev[sum - arr[i]];
                }
                curr[sum] = take || notTake;
            }
            prev = curr;
        }

        int minDiff = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= totalSum; s1++) {
            if (prev[s1]) {
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
