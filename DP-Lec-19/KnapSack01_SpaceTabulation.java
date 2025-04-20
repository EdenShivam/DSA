import java.util.Scanner;
import java.util.*;

public class KnapSack01_SpaceTabulation {
   
 static int knapScakProblem(int weight [] ,int value [] ,int wt,int index) {
      
      int prev [] = new int [wt + 1];
         
      for(int i = weight[0] ; i<=wt;i++)
       prev[i] = value[0];
      
      for(int ind = 1 ; ind < index ;ind++){ 
        int curr [] = new int [wt + 1];
        
      for(int iwt =0 ; iwt <= wt ;iwt++){

        int notTaken = 0 + prev[iwt];

        int taken = (int) -1e9;
       
       if(weight[ind] <= iwt)
       taken = value[ind]+ prev[iwt - weight[ind]];
          
      curr[iwt] = Math.max(notTaken, taken);
    }
    prev =curr;
      }
    return  prev[wt]; 
     
     }


   public static void main(String[] args) {
    int wt[] = {1, 2, 4, 5};
    int val[] = {5, 4, 8, 6};
    int W = 5;
    int n = wt.length;
        
    System.out.println(knapScakProblem(wt,val,W,n-1));	
   
   }
}