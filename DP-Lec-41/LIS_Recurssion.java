import java.util.Scanner;
import java.util.*;

public class LIS_Recurssion{
    
    static int lisUtil(int index,int prev_index,int n, int [] nums) {

    if(index == n) return 0 ;
    
    int nottaken = 0 + lisUtil(index+1,prev_index,n,nums);
    int taken = 0; 
    if(prev_index == -1 || nums[index] > nums[prev_index])
    taken = 1 + lisUtil(index+1,index,n,nums);

    return Math.max(nottaken,taken);
     
    }

   public static void main(String[] args) {
   
   int [] nums = {10,9,2,5,3,7,101,18};
   int n = nums.length ; 
    
   System.out.println(lisUtil(0,-1,n,nums));	
}
}