import java.util.Scanner;
import java.util.*;

public class CountSubsetSum_Recurssion{

    static int subSetSumK(int[] arr , int target,int index) {

        if (index == 0) {
        int cnt = 0;
        if (target == 0) cnt++;            
        if (arr[0] == target) cnt++;
        return cnt;
        }
        
        int notTaken = subSetSumK(arr,target ,index-1);

        int taken =0;
        if(arr[index] <= target)
        taken=subSetSumK(arr,target - arr[index],index-1);
   
 
        return notTaken + taken ;
     }

   public static void main(String[] args) {
   int arr[] = { 1, 2, 2, 3 };
        int k = 3;
        int n = arr.length;
        
    int result = subSetSumK(arr, k, n - 1);
    System.out.println("CountSubsetSumet  : " + result);
}
}