import java.util.Scanner;
import java.util.*;

public class MaxProfit_SpaceTabulation{

    public static int maxProfit(int[] prices,int n) {
        
        int [] prev  = new int [2];
        int [] curr  = new int [2];
        
        //If we don't have anything to sell or buy 
        prev[0] = 0 ;
        prev[1] = 0 ;

        for(int ind = n-1 ; ind >= 0 ; ind --){
            for(int j = 1 ; j >=0 ; j--){
                if(j == 1){ // we can buy the stock 
                  int buy = - prices[ind] + prev[0];
                  int notBuy = 0 + prev[1];

                  curr[j] = Math.max(buy,notBuy);
                 }

                  if(j == 0){ // we can buy the stock 
                  int  sell = prices[ind] + prev[1];
                  int notsell = 0 + prev[0];

                  curr[j] = Math.max(sell,notsell);
                 }
            }
            prev = curr;
        }
        
        return prev[1] ;
        
    }

    public static void main(String[] args) {
    
    int [] prices = {7,1,5,3,6,4} ;
    int n = prices.length ;

    System.out.println( maxProfit(prices,n));
    }
}