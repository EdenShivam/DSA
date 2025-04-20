import java.util.*;

public class KnapSack01_Tabulation {
    
     static int knapScakProblem(int weight [] ,int value [] ,int wt,int index) {
      int dp[][] = new int[index][wt + 1];
    
      
      for(int i = weight[0] ; i<=wt;i++)
       dp[0][i] = value[0];
      
      for(int ind = 1 ; ind < index ;ind++){
        for(int iwt =0 ; iwt <= wt ;iwt++){
          
        int notTaken = 0 + dp[ind-1][iwt];

        int taken = (int) -1e9;
       
       if(weight[ind] <= iwt)
       taken = value[ind]+ dp[index-1][iwt - weight[ind]];
          
      dp[ind][iwt] = Math.max(notTaken, taken);
    }
      }
    return  dp[index-1][wt]; 
     
     }


   public static void main(String[] args) {
    int wt[] = {1, 2, 4, 5};
    int val[] = {5, 4, 8, 6};
    int W = 5;
    int n = wt.length;
        
    System.out.println(knapScakProblem(wt,val,W,n-1));	
   
   }

}
