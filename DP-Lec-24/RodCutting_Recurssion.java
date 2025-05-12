import java.util.Scanner;
import java.util.*;

public class RodCutting_Recurssion{
     
    static int INT_MIN = (int) -1e7;
    
    static int rodCuttingUtil(int [] val, int target ,int index) {
    
    if(index == 0)
      return  target * val[0];

    int notTaken = 0 + rodCuttingUtil(val,target,index-1);

    int taken = INT_MIN;
    int rodLength = index+1 ; 
    
    if(rodLength <= target)
    taken = val[index]+ rodCuttingUtil(val,target - rodLength ,index);
   
    return Math.max(notTaken,taken) ;
     
    }

   public static void main(String[] args) {
     int val[] = {2,5,7,8,10};
     int N = 5;

     int n = val.length;

    System.out.println(rodCuttingUtil(val,N,n-1));	
}
}