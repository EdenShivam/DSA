import java.util.Scanner;
import java.util.*;

public class ClimbingStair_Memoization{

    public static long countDistinctWayToClimbStair(int nStairs,long dp[]) {
		// Write your code here.

         if(nStairs <=1) return 1;

		if(dp[nStairs] !=-1) return dp[nStairs];
        
		long left =   countDistinctWayToClimbStair(nStairs-1,dp);
		long right =  countDistinctWayToClimbStair(nStairs-2,dp);

		return left+right;
	}


    public static void main(String[] args) {
       
       int n=33;
       long dp [] = new long[n+1];
		Arrays.fill(dp,-1);


        System.out.println(countDistinctWayToClimbStair(n,dp));
    }
}