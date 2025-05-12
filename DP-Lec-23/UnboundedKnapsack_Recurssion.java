import java.util.Scanner;
import java.util.*;

public class UnboundedKnapsack_Recurssion{
     
    static int INT_MIN = (int) -1e7;
     static int unboundedKnapsack(int[] wt ,int [] val, int W ,int index) {
    
    if(index == 0) {
      if( wt[0] <= W)
        return W/wt[0] * val[0];
      else
        return 0 ;
    }
        
    int notTaken = 0 + unboundedKnapsack(wt,val,W,index-1);

    int taken =INT_MIN;
    
    if(wt[index] <= W)
    taken = val[index]+ unboundedKnapsack(wt,val, W - wt[index],index);
   
    return Math.max(notTaken,taken) ;
     
    }

   public static void main(String[] args) {
    int wt[] = { 2, 4, 6 };
    int val[] = { 5, 11, 13 };
    int W = 10;

    int n = wt.length;

    System.out.println(unboundedKnapsack(wt,val,W,n-1));	
}
}