import java.util.Scanner;
import java.util.*;

public class CoinChange_SpaceTabulation {
   
  static int maxValue = (int) 1e9 ;
    
  static int coinChangeProblem(int index, int target , int [] arr) {
     
     int prev [] = new int[target + 1];
      
     for(int itar =0 ; itar <= target; itar++ ){
      if( itar % arr[0] == 0) 
      prev[itar] =  itar / arr[0];
      else
        prev[itar] = maxValue ;
     }
    
    for(int ind = 1 ; ind <index ; ind++){
      
      int curr [] = new int[target + 1];
      
      for(int cap =0; cap <= target ; cap++){
       int notTaken = 0 + prev[cap];
       int taken = maxValue;
    
       if(arr[ind] <= cap)
       taken = 1 + curr[cap - arr[ind]];
       
       curr[cap] = Math.min(notTaken,taken);
      }
      prev = curr;
    }
    
     return  prev[target] ; 
    
     
     }

   public static void main(String[] args) {
    int arr[] = {1, 2, 3};
    int k = 7;
    int n = arr.length;
        
    System.out.println(coinChangeProblem(n,k,arr));	
}
}