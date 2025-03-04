import java.util.Scanner;
import java.util.*;

public class MaximumSum_Tabulation {
    public static int func(ArrayList<Integer> nums, int n, int [] dp) {

        dp[0]=nums.get(0);

        for(int i=1;i<n;i++){
 
        int pick =nums.get(i);
        int notpick = 0+dp[i-1];

        if(i>1) pick+=dp[i-2]; 

        dp[i] = Math.max(pick,notpick); 
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
       
       ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(3);
        nums.add(2);
        nums.add(7);
        nums.add(10);
        
        int n = nums.size();
        int[] dp = new int[n];
    System.out.println(func(nums,n,dp));


    }
}