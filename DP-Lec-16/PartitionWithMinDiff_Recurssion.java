import java.util.Scanner;
import java.util.*;

public class PartitionWithMinDiff_Recurssion {

    public static int minSubsetSumDifference(int[] arr, int index, int sum) {

        int totalSum = Arrays.stream(arr).sum();

        if (index == -1) {
            int sum2 = totalSum - sum;
            return Math.abs(sum - sum2);
        }

        int take = minSubsetSumDifference(arr, index - 1, sum + arr[index]);
        int notTake = minSubsetSumDifference(arr, index - 1, sum);

        return Math.min(take, notTake);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 8};
        int n = arr.length;
        System.out.println(minSubsetSumDifference(arr, n - 1, 0));
    }
}
