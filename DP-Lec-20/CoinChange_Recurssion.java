import java.util.Scanner;
import java.util.*;

public class TargetSum_Recurssion{
    
    static int maxValue = (int) 1e9 ;
    
    static int coinChangeProblem(int index, int target , int [] arr ) {
     
     if (target == 0) return 0;

     if(index == 0){
       if(target % arr[0] == 0) return target / arr[index];
       else return maxValue ;
       }
        
    int notTaken = 0 + coinChangeProblem(index - 1, target, arr );

    int taken = maxValue;
    
    if(arr[index] <= target)
    taken = 1 + coinChangeProblem(index, target - arr[index] , arr);
   
    return  Math.min(notTaken,taken) ;
     
     }

   public static void main(String[] args) {
    int arr[] = {1, 2, 3};
    int k = 7;
    int n = arr.length;
        
    System.out.println(coinChangeProblem(n-1,k,arr));	
}
}