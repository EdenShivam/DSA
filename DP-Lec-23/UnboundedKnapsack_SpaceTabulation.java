import java.util.Scanner;
import java.util.*;


public class UnboundedKnapsack_SpaceTabulation {
 
  static int INT_MIN = (int) -1e7;
    static int unboundedKnapsack(int[] wt ,int [] val, int W ,int index) {
     
    int [] prev = new int[W+1];
    
    for(int i = 0 ; i <= W ; i++ ){
      prev[i] = ((int) i / wt[0]) * val[0];
    }

    for(int ind = 1 ; ind < index ; ind++){
      int [] curr = new int[W+1];
      for(int itrw = 0 ; itrw <= W ; itrw++ ){

        int notTaken = 0 + prev[itrw];

        int taken = INT_MIN ;

        if( wt[ind] <= itrw )
        taken = val[ind] + curr[itrw - wt[ind]];

        curr[itrw] =  Math.max(notTaken,taken);
      }
      prev = curr ;    
    }
    
    return prev[W];
  }

   public static void main(String[] args) {
     int wt[] = { 2, 4, 6 };
     int val[] = { 5, 11, 13 };
     int W = 10;

     int n = wt.length;

    System.out.println(unboundedKnapsack(wt,val,W,n));	
   }

}