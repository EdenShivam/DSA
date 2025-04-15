import java.util.Scanner;
import java.util.*;

public class CountSubsetSum_SpaceTabulation {
   
 static int subSetSumK(int[] arr , int index,int target) {
        
        int [] prev = new int[target+1]; 
        
         prev[0] = 1;

        if(arr[0] <= target){
         prev[arr[0]] =1;
        }
        
        for(int i = 1 ; i < index ; i++){
         
         int [] curr = new int [target+1];
         curr[0] = 1; 
         for(int k = 1 ;k <= target ;k++){

            
            int notTaken = prev[k];
            int taken = 0;
        if(arr[i] <= k)
        taken = prev[k - arr[i]];
   
        curr[k] = notTaken + taken;
         }
         prev=curr;
        }

        return prev[target] ;
     }

   public static void main(String[] args) {
   int arr[] = { 1, 2, 2, 3 };
        int k = 3;
        int n = arr.length;
        

    int result = subSetSumK(arr,n,k);
    System.out.println("CountSubsetSum : " + result);
   }

}