import java.util.Scanner;
import java.util.*;

public class CoinChange_Memoization{
    
    static int maxValue = (int) 1e9 ;
    
    static int coinChangeProblem(int index, int target , int [] arr , int [] [] dp) {
     
     if (target == 0) return 0;

     if(index == 0){
       if(target % arr[0] == 0) return target / arr[index];
       else return maxValue ;
       }
    
    if(dp[index][target] != -1 )
    return dp[index][target] ;
        
    int notTaken = 0 + coinChangeProblem(index - 1, target, arr ,dp);

    int taken = maxValue;
    
    if(arr[index] <= target)
    taken = 1 + coinChangeProblem(index, target - arr[index] , arr, dp);
   
     dp[index][target] = Math.min(notTaken,taken);
    
     return  dp[index][target] ; 
    
     
     }

   public static void main(String[] args) {
    int arr[] = {1, 2, 3};
    int k = 7;
    int n = arr.length;

    int dp[][] = new int[n][k + 1];
    for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        
    System.out.println(coinChangeProblem(n-1,k,arr,dp));	
}
}