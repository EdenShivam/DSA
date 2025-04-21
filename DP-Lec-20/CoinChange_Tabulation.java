import java.util.*;

public class CoinChange_Tabulation {

  static int maxValue = (int) 1e9 ;
    
  static int coinChangeProblem(int index, int target , int [] arr) {
     
     int dp[][] = new int[index][target + 1];
      
     for(int itar =0 ; itar <= target; itar++ ){
      if( itar % arr[0] == 0) 
      dp[0][itar] =  itar / arr[0];
      else
        dp[0][itar] = maxValue ;
     }
    
    for(int ind = 1 ; ind <index ; ind++){
      for(int cap =0; cap <= target ; cap++){
       int notTaken = 0 + dp[ind - 1][cap];
       int taken = maxValue;
    
       if(arr[ind] <= cap)
       taken = 1 + dp[ind][cap - arr[ind]];
       
       dp[ind][cap] = Math.min(notTaken,taken);
      }
    }
    
     return  dp[index-1][target] ; 
    
     
     }

   public static void main(String[] args) {
    int arr[] = {1, 2, 3};
    int k = 7;
    int n = arr.length;
        
    System.out.println(coinChangeProblem(n,k,arr));	
}
}
