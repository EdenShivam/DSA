import java.util.Scanner;
import java.util.*;


public class TargetSum_SpaceTabulation {
   
 static int targetSumUtil(int totalSum,int d,int[] arr , int index,int target) {
        
        if(totalSum-d<0) return 0;
        if((totalSum-d)%2==1) return 0;

        int [] prev = new int[target+1]; 
        
         prev[0] = 1;

        if(arr[0] <= target){
         prev[arr[0]] =1;
        }
        
        for(int i = 1 ; i < index ; i++){
         
         int [] curr = new int [target+1];
         curr[0] = 1; 
         for(int k = 0 ;k <= target ;k++){
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
   int arr[] = {1,1,1,1,1};
      int d = 3;
      int n = arr.length;
      
      
    int totalSum = 0;
      for(int i=0; i<arr.length;i++){
        totalSum += arr[i];
      }
        
   int s2 = (totalSum-d)/2;
             
    System.out.println(targetSumUtil(totalSum,d,arr,n,s2));
   
   }

}