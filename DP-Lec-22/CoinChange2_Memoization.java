import java.util.Scanner;
import java.util.*;

public class CoinChange2_Memoization{
    
  static int noOfWaysCoinChange(int[] arr , int target,int index, int [][] dp) {
    
    if(index == 0) return target % arr[0] == 0 ? 1 : 0 ; 

    if(dp[index][target] ! = -1) return   dp[index][target] ;

    int notTaken = noOfWaysCoinChange(arr,target ,index-1,dp);

    int taken =0;
    if(arr[index] <= target)
    taken=noOfWaysCoinChange(arr,target - arr[index],index,dp);
    
    dp[index][target] = notTaken + taken ; 
    return dp[index][target] ;
     }

   public static void main(String[] args) {
    int arr[] = { 1, 2, 3 };
   int target = 4;
   int n = arr.length;

   int dp[][] = new int[n][target+1];
    
    for(int row[]: dp)
    Arrays.fill(row,-1);
        
    System.out.println(noOfWaysCoinChange(arr,target,n-1,dp));	
    
   }
}