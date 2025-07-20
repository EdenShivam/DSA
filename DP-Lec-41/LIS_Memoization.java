import java.util.Scanner;
import java.util.*;

public class LIS_Memoization{
    
 static int lisUtil(int index,int prev_index,int n, int [] nums, int [] [] dp) {

    if(index == n) return 0 ;

    if(dp[index][prev_index+1] != -1) return dp[index][prev_index+1] ;
    
    int nottaken = 0 + lisUtil(index+1,prev_index,n,nums,dp);
    int taken = 0; 
    if(prev_index == -1 || nums[index] > nums[prev_index])
    taken = 1 + lisUtil(index+1,index,n,nums,dp);

    return dp[index][prev_index+1] = Math.max(nottaken,taken);
     
    }

   public static void main(String[] args) {
   
   int [] nums = {10,9,2,5,3,7,101,18};
   int n = nums.length ; 
   int prev_index = -1;

   int [][] dp = new int[n][n+1];
   for(int [] rows :dp)
   Arrays.fill(rows,-1);
    
   System.out.println(lisUtil(0,prev_index,n,nums,dp));	
}

}