import java.util.*;

public class CanPartition_Tabulation {
    
    static int subSetPartition(int[] arr , int index,int target) {
        
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

    boolean result = subSetPartition(arr,n,target) == 1;
    if(result)
   System.out.println("Subset Partition is possible : " + result);
   }

}
