import java.util.Scanner;
import java.util.*;

public class SubsetSum_SpaceTabulation {
   
 static int subSetSumK(int[] arr , int index,int target) {
        
        int [] prev = new int[target+1]; 

        for(int i=0;i<index;i++){
         prev[0] = 1;
        }

        if(arr[0] <= target){
         prev[arr[0]] =1;
        }
        
        for(int i = 1 ; i < index ; i++){
         int [] curr = new int [target+1];
         for(int k = 1 ;k <= target ;k++){
            
            int notTaken = prev[k];
            int taken = 0;
        if(arr[i] <= k)
        taken = prev[k - arr[i]];
   
        curr[k] = (notTaken == 1  || taken == 1 ) ? 1: 0 ;
         }
         prev=curr;
        }

        return prev[target] ;
     }

   public static void main(String[] args) {
   int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;

    boolean result = subSetSumK(arr,n,k) == 1;
    if(result)
    System.out.println("SubsetSum is possible : " + result);
    else
    System.out.println("SubsetSum is not possible");
   }

}