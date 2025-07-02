import java.util.Scanner;
import java.util.*;

public class MaxProfit_SpaceTabulation{

    public static int maxProfit(int k, int[] prices) {
     int n = prices.length;
     int [][] ahead = new int[2][k+1];
     int [][] curr = new int[2][k+1];
        
        for(int ind = n-1 ; ind >= 0 ; ind --){
            for(int j = 0; j < 2; j++){
            for(int cap = 1; cap <=k; cap++){

                if(j == 1){ // we can buy the stock 
                  int buy = - prices[ind] + ahead[0][cap];
                  int notBuy = 0 + ahead[1][cap];

                  curr[j][cap] = Math.max(buy,notBuy);
                 }

                  if(j == 0){ // we can buy the stock 
                  int  sell = prices[ind] + ahead[1][cap-1];
                  int notsell = 0 + ahead[0][cap];

                  curr[j][cap] = Math.max(sell,notsell);
                 }
            }
        }
        ahead = curr;
    }
        
        return ahead[1][k] ;
}

    public static void main(String[] args) {
    
    // int [] prices = {3,3,5,0,0,3,1,4} ;

    // int [] prices = {1,2,3,4,5};
    
    int k = 2;
    int [] prices = {3,2,6,5,0,3};

    System.out.println( maxProfit(k,prices));
    }
}