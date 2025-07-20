import java.util.Scanner;
import java.util.*;

public class MaxProfit_Tabular{

      public static int maxProfit(int[] prices,int n) {
        
        int [][] dp = new int[n+2][2];

        for(int ind = n-1 ; ind >= 0 ; ind --){
            for(int j = 0; j < 2; j++){

                if(j == 1){ // we can buy the stock 
                  int buy = - prices[ind] + dp[ind+1][0];
                  int notBuy = 0 + dp[ind+1][1];

                  dp[ind][j] = Math.max(buy,notBuy);
                 }

                  if(j == 0){ // we can buy the stock 
                  int  sell = prices[ind] + dp[ind+2][1];
                  int notsell = 0 + dp[ind+1][0];

                  dp[ind][j] = Math.max(sell,notsell);
                 }
            }
        }
        
        return dp[0][1] ;
        
    }

    public static void main(String[] args) {
    int [] prices = {1,2,3,0,2};
    int n = prices.length ;

    System.out.println( maxProfit(prices,n));
    }
}