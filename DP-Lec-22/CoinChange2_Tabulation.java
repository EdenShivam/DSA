import java.util.*;


public class CoinChange2_Tabulation { 
   
    static int noOfWaysCoinChange(int[] arr , int target,int index) {
    
    int dp[][] = new int[index][target+1];

  for(int i =0 ;i <= target;i++){
  if(i % arr[0] == 0)
  dp[0][i] =1;
  }

  for(int ind = 1; ind < index; ind++){
    for(int tar =0; tar <= target;tar++){

    int notTaken = dp[ind-1][tar];

    int taken =0;
    if(arr[ind] <= tar)
    taken=dp[ind][tar - arr[ind]];
    
    dp[ind][tar] = notTaken + taken ; 
    }
  }

  return dp[index-1][target] ;
     }

   public static void main(String[] args) {
    int arr[] = { 1, 2, 3 };
   int target = 4;
   int n = arr.length;

    System.out.println(noOfWaysCoinChange(arr,target,n));	
   }

}
