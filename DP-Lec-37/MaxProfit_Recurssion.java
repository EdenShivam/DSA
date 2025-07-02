import java.util.Scanner;

public class MaxProfit_Recurssion{

    public static int maxProfit(int[] prices,int index,int n, int canBuy,int cap ) {

        // 1  meaning we can buy stock 
        // 0  meaning we cannot buy stock 

        if(index == n) return 0 ;
        if(cap == 0)  return 0 ;
        
        int profit = 0;

        if(canBuy == 1){ // we can buy the stock 
         int buy    = - prices[index] + maxProfit(prices,index+1,n,0,cap);
         int notBuy = 0 + maxProfit(prices,index+1,n,1,cap);

         profit = Math.max(buy,notBuy);

        }
        
        /*We decrease cap only when we do both buying and selling together meaning one transaction 
        has been completed */


        if(canBuy == 0){ // we can sell the stock 
         int sell    =  prices[index] + maxProfit(prices,index+1,n,1,cap-1);
         int notSell = 0 + maxProfit(prices,index+1,n,0,cap);

         profit = Math.max(sell,notSell);
        }

        return profit ;
        
    }

    public static void main(String[] args) {
    
    // int [] prices = {3,3,5,0,0,3,1,4} ;

    int [] prices = {1,2,3,4,5};
    int cap = 2 ; 

    System.out.println( maxProfit(prices,0,prices.length,1,cap));
    }
}