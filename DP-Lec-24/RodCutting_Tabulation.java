import java.util.*;


public class RodCutting_Tabulation { 
  
  static int INT_MIN = (int) -1e7;
  
  static int rodCuttingUtil(int [] val, int target ,int index) {
    
    int [][] dp = new int[index][target+1];
    
    for(int i = 0 ; i <= target ;i++)
      dp[0][i] = i* val[0];

    for(int ind = 1 ; ind < index ; ind++){
      for(int itr = 0 ; itr <= target ; itr++){

      int notTaken = 0 + dp[ind-1][itr];

      int taken = INT_MIN;
      int rodLength = ind+1 ; 
    
      if(rodLength <= itr)
      taken = val[ind]+ dp[ind][itr - rodLength];
      

       dp[ind][itr] = Math.max(notTaken,taken);

      }
    }
   
    return  dp[index-1][target] ;
     
    }

   public static void main(String[] args) {
    int val[] = {2,5,7,8,10};
    int N = 5;

    int n = val.length;

    System.out.println(rodCuttingUtil(val,N,n));	
   }

}