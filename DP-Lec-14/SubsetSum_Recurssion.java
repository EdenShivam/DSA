import java.util.Scanner;
import java.util.*;

public class SubsetSum_Recurssion{

    static boolean subSetSumK(int[] arr , int target,int index) {

        if(target == 0) return true ;
        if(index == 0)  return arr[0] == target;
        
        boolean notTaken = subSetSumK(arr,target ,index-1);

        boolean taken =false;
        if(arr[index] <= target)
        taken=subSetSumK(arr,target - arr[index],index-1);
   
 
        return notTaken || taken ;
     }

   public static void main(String[] args) {
   int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;
        
    boolean result = subSetSumK(arr, k, n - 1);
    if(result)
    System.out.println("SubsetSum is possible : " + result);
    else
    System.out.println("SubsetSum is not possible");
}
}