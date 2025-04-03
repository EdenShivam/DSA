import java.util.Scanner;
import java.util.*;

public class CanPartition_Recurssion{

    static boolean subSetPartition(int[] arr , int target,int index) {
        if(target == 0) return true ;
        if(index == 0)  return arr[0] == target;
        
        boolean notTaken = subSetPartition(arr,target ,index-1);

        boolean taken =false;
        if(arr[index] <= target)
        taken=subSetPartition(arr,target - arr[index],index-1);
   
 
        return notTaken || taken ;
     }

   public static void main(String[] args) {
   int arr[] = { 1,5,5 };
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
        
    boolean result = subSetPartition(arr,target, n - 1);
    if(result)
    System.out.println("Subset Partition  is possible : " + result);
}
}