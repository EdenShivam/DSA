import java.util.Scanner;
import java.util.*;

public class TargetSum_Recurssion{

    static int targetSumUtil(int totalSum,int d , int[] arr , int target,int index) {

     if(totalSum-d<0) return 0;
     if((totalSum-d)%2==1) return 0;

     if(index == 0){
        if(target==0 && arr[0]==0)
            return 2;
        if(target==0 || target == arr[0])
            return 1;
        return 0;
    }
        
        int notTaken = targetSumUtil(totalSum,d,arr,target ,index-1);

        int taken =0;
        if(arr[index] <= target)
        taken=targetSumUtil(totalSum,d,arr,target - arr[index],index-1);
   
 
        return notTaken + taken ;
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
       
        
    System.out.println(targetSumUtil(totalSum,d,arr,s2,n-1));	
}
}