import java.util.Scanner;
import java.util.*;

public class MaximumSum_Memoization{
    
    public static int func(ArrayList<Integer> nums, int n, int[] dp) {
        if (n < 0) return 0; 
        if (n == 0) return nums.get(0); 

        if (dp[n] != -1) return dp[n]; 

        int pick = nums.get(n) + func(nums, n - 2, dp);
        int notPick = func(nums, n - 1, dp);

        return dp[n] = Math.max(pick, notPick); 
    }

    public static void main(String[] args) {
       
       ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(3);
        nums.add(2);
        nums.add(7);
        nums.add(10);



        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

    System.out.println(func(nums, n - 1, dp));


    }
}