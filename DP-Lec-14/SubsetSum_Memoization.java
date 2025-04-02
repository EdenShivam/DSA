import java.util.Scanner;
import java.util.*;

public class SubsetSum_Memoization{
    
  static int subSetSumK(int[] arr , int target,int index, int [][] dp ) {

        if(target == 0) return 1 ;
        if(index == 0)  return arr[0] == target  ? 1 : 0;
        
        if(dp[index][target] != -1 ) 
        return dp[index][target] ; 

        int notTaken = subSetSumK(arr,target,index-1,dp);

        int taken = 0;
        if(arr[index] <= target)
        taken=subSetSumK(arr,target - arr[index],index-1,dp);
   
        dp[index][target] = (notTaken == 1  || taken == 1 ) ? 1: 0 ;
        
        return dp[index][target] ;
     }

   public static void main(String[] args) {
   int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;
        
    int [][] dp = new int[n][k+1];
    for (int i = 0; i < n; i++) {
          Arrays.fill(dp[i], -1);
      }


    boolean result = subSetSumK(arr, k, n - 1,dp) == 1;
    if(result)
    System.out.println("SubsetSum is possible : " + result);
    else
    System.out.println("SubsetSum is not possible");
   }
}