import java.util.Scanner;
import java.util.*;

public class CanPartition_Memoization{
    
  static int subSetPartition(int[] arr , int target,int index, int [][] dp ) {

        if(target == 0) return 1 ;
        if(index == 0)  return arr[0] == target  ? 1 : 0;
        
        if(dp[index][target] != -1 ) 
        return dp[index][target] ; 

        int notTaken = subSetPartition(arr,target,index-1,dp);

        int taken = 0;
        if(arr[index] <= target)
        taken=subSetPartition(arr,target - arr[index],index-1,dp);
   
        dp[index][target] = (notTaken == 1  || taken == 1 ) ? 1: 0 ;
        
        return dp[index][target] ;
     }

   public static void main(String[] args) {
   int arr[] = { 1,5,11,5};
   int n = arr.length;

   int target_sum = 0;
   for(int itr : arr){
    target_sum+=itr;
   }
        
  if(target_sum % 2 != 0)  {
   System.out.println("Subset Partition is not possible");
   return ;
   }
      
  int target = target_sum / 2 ;  
  
  int [][] dp = new int[n][target+1];
    for (int i = 0; i < n; i++) {
          Arrays.fill(dp[i], -1);
      }


    boolean result = subSetPartition(arr,target, n - 1,dp) == 1;
    if(result)
    System.out.println("Subset Partition  is possible : " + result);

   }
}