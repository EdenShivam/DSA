import java.util.Scanner;
import java.util.*;

public class UnboundedKnapsack_Memoization{
    
  static int INT_MIN = (int) -1e7;
  
  static int unboundedKnapsack(int[] wt ,int [] val, int W ,int index, int [] [] dp) {
    
    if(index == 0) {
      if( wt[0] <= W)
        return W/wt[0] * val[0];
      else
        return 0 ;
    }

    if(dp[index][W] != -1) return dp[index][W] ; 
        
    
    int notTaken = 0 + unboundedKnapsack(wt,val,W,index-1,dp);

    int taken =INT_MIN;
    
    if(wt[index] <= W)
    taken = val[index]+ unboundedKnapsack(wt,val, W - wt[index],index,dp);

    return dp[index][W] = Math.max(notTaken,taken) ;
     
    }

   public static void main(String[] args) {
   int wt[] = { 2, 4, 6 };
   int val[] = { 5, 11, 13 };
   int W = 10;

   int n = wt.length;

   int dp[][] = new int[n][W+1];
    
    for(int row[]: dp)
    Arrays.fill(row,-1);
        
    System.out.println(unboundedKnapsack(wt,val,W,n-1,dp));	
    
   }
}