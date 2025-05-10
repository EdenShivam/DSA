import java.util.Scanner;
import java.util.*;

public class CoinChange2_Recurssion{

    static int noOfWaysCoinChange(int[] arr , int target,int index) {
    
    if(index == 0) return target % arr[0] == 0 ? 1 : 0 ; 
        
    int notTaken = noOfWaysCoinChange(arr,target ,index-1);

    int taken =0;
    if(arr[index] <= target)
    taken=noOfWaysCoinChange(arr,target - arr[index],index);
   
 
    return notTaken + taken ;
     }

   public static void main(String[] args) {
   int arr[] = { 1, 2, 3 };
   int target = 4;
   int n = arr.length;
        
    System.out.println(noOfWaysCoinChange(arr,target,n-1));	
}
}