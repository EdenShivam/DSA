import java.util.Scanner;
import java.util.*;


public class RodCutting_SpaceTabulation {
 
 static int INT_MIN = (int) -1e7;
  
  static int rodCuttingUtil(int [] val, int target ,int index) {
    
    int [] prev  = new int [target+1];
    
    for(int i = 0 ; i <= target ;i++)
      prev[i] = i* val[0];

    for(int ind = 1 ; ind < index ; ind++){
      int [] curr  = new int [target+1];

      for(int itr = 0 ; itr <= target ; itr++){

      int notTaken = 0 + prev[itr];

      int taken = INT_MIN;
      int rodLength = ind+1 ; 
    
      if(rodLength <= itr)
      taken = val[ind]+ curr[itr - rodLength];
      

       curr[itr] = Math.max(notTaken,taken);

      }
      prev = curr;
    }
   
    return  prev[target] ;
     
    }

   public static void main(String[] args) {
    int val[] = {2,5,7,8,10};
    int N = 5;

    int n = val.length;

    System.out.println(rodCuttingUtil(val,N,n));	
   }
}