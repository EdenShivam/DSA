import java.util.*;


public class TargetSum_Tabulation { 
    static int targetSumUtil(int totalSum,int d,int[] arr , int index,int target) {
        
        if(totalSum-d<0) return 0;
        if((totalSum-d)%2==1) return 0;

        int [][] dp = new int[index][target+1]; 

        if (arr[0] == 0) {
        dp[0][0] = 2; 
        } else {
        dp[0][0] = 1;
        if (arr[0] <= target) {
            dp[0][arr[0]] = 1;
        }
    }
        
        for(int i = 1 ; i < index ; i++){
         for(int k = 0 ;k <= target ;k++){
            
            int notTaken = dp[i-1][k];
            int taken = 0;
        if(arr[i] <= k)
        taken= dp[i-1][k - arr[i]];
   
        dp[i][k] = notTaken + taken;
         }
        }

        return dp[index-1][target] ;
     }

   public static void main(String[] args) {
   int arr[] = {1,1,1,1,1};
      int d = 3;
      int n = arr.length;
      
      
    int totalSum = 0;
      for(int i=0; i<arr.length;i++){
        totalSum += arr[i];
      }
        
   int s2 = (totalSum-d)/2;
             
    System.out.println(targetSumUtil(totalSum,d,arr,n,s2));	
   }

}
