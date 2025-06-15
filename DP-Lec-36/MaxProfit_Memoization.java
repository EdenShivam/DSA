import java.util.Scanner;
import java.util.*;

public class MaxProfit_Memoization{

  public static int maxProfit(int[] prices,int index,int n, int canBuy , int [][] dp ) {

        // 1  meaning we can buy stock 
        // 0  meaning we cannot buy stock 

        if(index == n) return 0 ;
        if(dp[index][canBuy] != -1) return dp[index][canBuy] ;

        if(canBuy == 1){ // we can buy the stock 
         int buy    = - prices[index] + maxProfit(prices,index+1,n,0,dp);
         int notBuy = 0 + maxProfit(prices,index+1,n,1,dp);

         dp[index][canBuy] = Math.max(buy,notBuy);

        }
        
        if(canBuy == 0){ // we can sell the stock 
         int sell    =  prices[index] + maxProfit(prices,index+1,n,1,dp);
         int notSell = 0 + maxProfit(prices,index+1,n,0,dp);
         dp[index][canBuy] = Math.max(sell,notSell);
        }

        return dp[index][canBuy] ;
        
    }

    public static void main(String[] args) {
    
    int [] prices = {7,1,5,3,6,4} ;
    int n = prices.length ;
    int canBuy = 1;

    int [][] dp = new int[n][2];
    for(int rows[] : dp)
    Arrays.fill(rows,-1);

    System.out.println( maxProfit(prices,0,n,canBuy,dp));
    }
}