import java.util.Scanner;
import java.util.*;

public class KnapSack01_Memoization{
    
  static int knapScakProblem(int weight [] ,int value [] ,int wt,int index, int dp[][]) {
     
     if(index == 0)
     if( weight[index] <= wt)
     return value[0];
     else
     return 0;

    if( dp[index][wt] != -1)
    return   dp[index][wt] ;
      
    int notTaken = 0 + knapScakProblem(weight,value,wt,index-1,dp);

    int taken = (int) -1e9;
    
    if(weight[index] <= wt)
    taken = value[index]+ knapScakProblem(weight,value,wt - weight[index] ,index-1,dp);
   
     dp[index][wt] = Math.max(notTaken,taken) ;
    
    return  dp[index][wt] ;
     
     }


   public static void main(String[] args) {
    int wt[] = {1, 2, 4, 5};
    int val[] = {5, 4, 8, 6};
    int W = 5;
    int n = wt.length;

    int dp[][] = new int[n][W + 1];
    for (int row[] : dp) {
            Arrays.fill(row, -1);
        }



    System.out.println(knapScakProblem(wt,val,W,n-1,dp)); 
   }
}