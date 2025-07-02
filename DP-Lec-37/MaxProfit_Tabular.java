import java.util.Scanner;
import java.util.*;

public class MaxProfit_Tabular{

      public static int maxProfit(int[] prices,int n) {
        
        int [][][] dp = new int[n+1][2][3];
        
        for(int ind = 0 ; ind <= n ; ind++){
            for(int buy = 0; buy < 2; buy++){
                dp[ind][buy][0] = 0;
            }
        }

        for(int buy = 0; buy < 2; buy++){
           for(int cap = 0; cap < 2; cap++){
            dp[n][buy][cap] = 0;
        }
        }

        for(int ind = n-1 ; ind >= 0 ; ind --){
            for(int j = 0; j < 2; j++){
            for(int cap = 1; cap <= 2; cap++){

                if(j == 1){ // we can buy the stock 
                  int buy = - prices[ind] + dp[ind+1][0][cap];
                  int notBuy = 0 + dp[ind+1][1][cap];

                  dp[ind][j][cap] = Math.max(buy,notBuy);
                 }

                  if(j == 0){ // we can buy the stock 
                  int  sell = prices[ind] + dp[ind+1][1][cap-1];
                  int notsell = 0 + dp[ind+1][0][cap];

                  dp[ind][j][cap] = Math.max(sell,notsell);
                 }
            }
        }
    }
        
        return dp[0][1][2] ;
        
    }

    public static void main(String[] args) {
    
    int [] prices = {3,3,5,0,0,3,1,4} ;

    // int [] prices = {1,2,3,4,5};


    int n = prices.length ;

    System.out.println( maxProfit(prices,n));
    }
}