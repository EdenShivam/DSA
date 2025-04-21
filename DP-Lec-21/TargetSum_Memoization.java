import java.util.Scanner;
import java.util.*;

public class TargetSum_Memoization{
    
  static int mod =(int)(Math.pow(10,9)+7);

   static int targetSumUtil(int totSum,int d,int ind, int target,int[] arr, int[][] dp){
     
     if(totSum-d<0) return 0;
     if((totSum-d)%2==1) return 0;

     if(ind == 0){
        if(target==0 && arr[0]==0)
            return 2;
        if(target==0 || target == arr[0])
            return 1;
        return 0;
    }
    
    if(dp[ind][target]!=-1)
        return dp[ind][target];
        
    int notTaken = targetSumUtil(totSum,d,ind-1,target,arr,dp);
    
    int taken = 0;
    if(arr[ind]<=target)
        taken = targetSumUtil(totSum,d,ind-1,target-arr[ind],arr,dp);
        
    return dp[ind][target]= (notTaken + taken)%mod;
}

   public static void main(String[] args) {
    int arr[] = {1,1,1,1,1};
      int d = 3;
      int n = arr.length;
      
      int totSum = 0;
      for(int i=0; i<arr.length;i++){
        totSum += arr[i];
      }
    
     int s2 = (totSum-d)/2;
    
     int dp[][] = new int[n][s2+1];
    
    for(int row[]: dp)
    Arrays.fill(row,-1);
    
     System.out.println(targetSumUtil(totSum,d,n-1,s2,arr,dp));	  
   }
}