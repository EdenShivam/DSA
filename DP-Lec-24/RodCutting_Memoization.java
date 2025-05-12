import java.util.Scanner;
import java.util.*;

public class RodCutting_Memoization{
    
  static int INT_MIN = (int) -1e7;
  
  static int rodCuttingUtil(int [] val, int target ,int index, int [][] dp) {
    
    if(index == 0)
      return  target * val[0];

    if(dp[index][target] != -1) return dp[index][target] ;

    int notTaken = 0 + rodCuttingUtil(val,target,index-1,dp);

    int taken = INT_MIN;
    int rodLength = index+1 ; 
    
    if(rodLength <= target)
    taken = val[index]+ rodCuttingUtil(val,target - rodLength ,index,dp);
   
    return  dp[index][target] = Math.max(notTaken,taken) ;
     
    }
  

   public static void main(String[] args) {
   int val[] = {2,5,7,8,10};
   int N = 5;

   int n = val.length;
   
   int dp[][] = new int[n][N+1];
    
    for(int row[]: dp)
    Arrays.fill(row,-1);
        
    System.out.println(rodCuttingUtil(val,N,n-1,dp));	
    
   }
}