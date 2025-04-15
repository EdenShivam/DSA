import java.util.Scanner;
import java.util.*;

public class CountSubsetSum_Memoization{
    
  static int subSetSumK(int[] arr , int target,int index, int [][] dp ) {

        if (index == 0) {
        int cnt = 0;
        if (target == 0) cnt++;            
        if (arr[0] == target) cnt++;
        return cnt;
        }
        
        if(dp[index][target] != -1 ) 
        return dp[index][target] ; 

        int notTaken = subSetSumK(arr,target,index-1,dp);

        int taken = 0;
        if(arr[index] <= target)
        taken=subSetSumK(arr,target - arr[index],index-1,dp);
   
        dp[index][target] = notTaken + taken ;
        
        return dp[index][target] ;
     }

   public static void main(String[] args) {
      int arr[] = {0, 1, 3};
        int k = 4;
        int n = arr.length;
        
        
    int [][] dp = new int[n][k+1];
    for (int i = 0; i < n; i++) {
          Arrays.fill(dp[i], -1);
      }


    int result = subSetSumK(arr, k, n - 1,dp);
    System.out.println("CountSubsetSum : " + result);
   }
}