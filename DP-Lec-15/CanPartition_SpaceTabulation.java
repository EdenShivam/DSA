import java.util.Scanner;
import java.util.*;

public class CanPartition_SpaceTabulation {
   
 static int subSetPartition(int[] arr , int index,int target) {
        
        int [] prev = new int[target+1]; 
        
         prev[0] = 1;

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
   int arr[] = { 1,5,11,5};
   int n = arr.length;

   int target_sum = 0;
   for(int itr : arr){
    target_sum+=itr;
   }
        
  if(target_sum % 2 != 0)  {
   System.out.println("Subset Partition is not possible");
   return ;
   }

   int target = target_sum / 2 ;  

    boolean result = subSetPartition(arr,n,target) == 1;
    if(result)
    System.out.println("Subset Partition is possible : " + result);

}
}