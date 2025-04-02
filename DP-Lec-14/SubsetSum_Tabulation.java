import java.util.*;

public class SubsetSum_Tabulation {
    
    static int subSetSumK(int[] arr , int index,int target) {
        
        int [][] dp = new int[index][target+1]; 

        for(int i=0;i<index;i++){
         dp[i][0] = 1;
        }

        if(arr[0] <= target){
         dp[0][arr[0]] =1;
        }
        
        for(int i = 1 ; i < index ; i++){
         for(int k = 1 ;k <= target ;k++){
            
            int notTaken = dp[i-1][k];
            int taken = 0;
        if(arr[i] <= k)
        taken= dp[i-1][k - arr[i]];
   
        dp[i][k] = (notTaken == 1  || taken == 1 ) ? 1: 0 ;
         }
        }

        return dp[index-1][target] ;
     }

   public static void main(String[] args) {
   int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;

    boolean result = subSetSumK(arr,n,k) == 1;
    if(result)
    System.out.println("SubsetSum is possible : " + result);
    else
    System.out.println("SubsetSum is not possible");
   }

}
