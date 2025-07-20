import java.util.Scanner;

public class MaxProfit_Recurssion{

    public static int maxProfit(int[] prices,int index,int n, int canBuy,int fee) {

        if(index == n) return 0 ;
        
        int profit = 0;

        if(canBuy == 1){ 
         int buy    = - prices[index] + maxProfit(prices,index+1,n,0,fee);
         int notBuy = 0 + maxProfit(prices,index+1,n,1,fee);

         profit = Math.max(buy,notBuy);

        }
        
        if(canBuy == 0){ 
         int sell    =  prices[index] - fee + maxProfit(prices,index+1,n,1,fee);
         int notSell = 0 + maxProfit(prices,index+1,n,0,fee);

         profit = Math.max(sell,notSell);
        }

        return profit ;
        
    }

    public static void main(String[] args) {
    
    int [] prices = {1,3,2,8,4,9} ;
    int fee = 2 ;

    System.out.println( maxProfit(prices,0,prices.length,1,fee));
    }
}