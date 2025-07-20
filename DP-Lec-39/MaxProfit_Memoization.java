import java.util.Scanner;
import java.util.*;

public class MaxProfit_Memoization{

  public static int maxProfit(int[] prices,int index,int n, int canBuy , int [][] dp) {

        if(index >= n) return 0 ;
        if(dp[index][canBuy] != -1) return dp[index][canBuy] ;

        if(canBuy == 1){ 
         int buy    = - prices[index] + maxProfit(prices,index+1,n,0,dp);
         int notBuy = 0 + maxProfit(prices,index+1,n,1,dp);

         dp[index][canBuy] = Math.max(buy,notBuy);

        }
        
        if(canBuy == 0){ 
         int sell    =  prices[index] + maxProfit(prices,index+2,n,1,dp);
         int notSell = 0 + maxProfit(prices,index+1,n,0,dp);
         dp[index][canBuy] = Math.max(sell,notSell);
        }

        return dp[index][canBuy] ;
        
    }

    public static void main(String[] args) {
    int [] prices = {1,2,3,0,2};
    int n = prices.length ;
    int canBuy = 1;

    int [][] dp = new int[n][2];
    for(int rows[] : dp)
    Arrays.fill(rows,-1);

    System.out.println( maxProfit(prices,0,n,canBuy,dp));
    }
}