import java.util.Scanner;
import java.util.*;

public class MaxProfit_SpaceTabulation{

    public static int maxProfit(int[] prices,int n) {
        
        int [][] after  = new int [2][3];
        int [][] curr = new int [2][3];


        for(int ind = n-1 ; ind >= 0 ; ind --){
            for(int j = 0; j < 2; j++){
            for(int cap = 1; cap <= 2; cap++){

                if(j == 1){ // we can buy the stock 
                  int buy = - prices[ind] + after[0][cap];
                  int notBuy = 0 + after[1][cap];

                  curr[j][cap] = Math.max(buy,notBuy);
                 }

                  if(j == 0){ // we can buy the stock 
                  int  sell = prices[ind] + after[1][cap-1];
                  int notsell = 0 + after[0][cap];

                  curr[j][cap] = Math.max(sell,notsell);
                 }
            }
        }
        after = curr;
    }
        
        return after[1][2] ;
        
    }

    public static void main(String[] args) {
    
    int [] prices = {3,3,5,0,0,3,1,4} ;

    // int [] prices = {1,2,3,4,5};


    int n = prices.length ;

    System.out.println( maxProfit(prices,n));
    }
}