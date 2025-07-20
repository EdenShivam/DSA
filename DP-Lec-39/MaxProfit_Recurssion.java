import java.util.Scanner;

public class MaxProfit_Recurssion{

    public static int maxProfit(int[] prices,int index,int n, int canBuy) {

        if(index >= n) return 0 ;
        
        int profit = 0;

        if(canBuy == 1){ // we can buy the stock 
         int buy    = - prices[index] + maxProfit(prices,index+1,n,0);
         int notBuy = 0 + maxProfit(prices,index+1,n,1);

         profit = Math.max(buy,notBuy);

        }
        
        if(canBuy == 0){ // we can sell the stock 
         int sell    =  prices[index] + maxProfit(prices,index+2,n,1);
         int notSell = 0 + maxProfit(prices,index+1,n,0);

         profit = Math.max(sell,notSell);
        }

        return profit ;
        
    }

    public static void main(String[] args) {

    int [] prices = {1,2,3,0,2};

    System.out.println( maxProfit(prices,0,prices.length,1));
    }
}