import java.util.Scanner;
import java.util.*;

public class MaxProfit_Tabular{

      public static int maxProfit(int[] prices,int n,int fee) {
        
        int [][] dp = new int[n+1][2];
        
        dp[n][0] = 0 ;
        dp[n][1] = 0 ;

        for(int ind = n-1 ; ind >= 0 ; ind --){
            for(int j = 1 ; j >=0 ; j--){
                if(j == 1){ // we can buy the stock 
                  int buy = - prices[ind] + dp[ind+1][0];
                  int notBuy = 0 + dp[ind+1][1];

                  dp[ind][j] = Math.max(buy,notBuy);
                 }

                  if(j == 0){ // we can buy the stock 
                  int  sell = prices[ind]  - fee + dp[ind+1][1];
                  int notsell = 0 + dp[ind+1][0];

                  dp[ind][j] = Math.max(sell,notsell);
                 }
            }
        }
        
        return dp[0][1] ;
        
    }

    public static void main(String[] args) {
    
    int [] prices = {1,3,2,8,4,9} ;
    int n = prices.length ;
    int fee = 2 ;

    System.out.println(maxProfit(prices,n,fee));
    }
}