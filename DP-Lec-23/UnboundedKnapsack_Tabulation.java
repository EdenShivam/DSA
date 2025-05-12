import java.util.*;


public class UnboundedKnapsack_Tabulation { 
   
    static int INT_MIN = (int) -1e7;
    static int unboundedKnapsack(int[] wt ,int [] val, int W ,int index) {
     
    int dp[][] = new int[index][W+1];
    
    for(int i = 0 ; i <= W ; i++ ){
      dp[0][i] = ((int) i / wt[0]) * val[0];
    }

    for(int ind = 1 ; ind < index ; ind++){
      for(int itrw = 0 ; itrw <= W ; itrw++ ){

        int notTaken = 0 + dp[ind-1][itrw];

        int taken = INT_MIN ;

        if( wt[ind] <= itrw )
        taken = val[ind] + dp[ind][itrw - wt[ind]];

        dp[ind][itrw] =  Math.max(notTaken,taken);
      }    
    }
    
    return dp[index-1][W];
  }

   public static void main(String[] args) {
     int wt[] = { 2, 4, 6 };
     int val[] = { 5, 11, 13 };
     int W = 10;

     int n = wt.length;

    System.out.println(unboundedKnapsack(wt,val,W,n));	
   }

}