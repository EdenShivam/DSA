import java.util.Scanner;
import java.util.*;

public class KnapSack01_Recurssion{

    static int knapScakProblem(int weight [] ,int value [] ,int wt,int index) {
     
     if(index == 0)
     if( weight[index] <= wt)
     return value[0];
     else
     return 0;
        
    int notTaken = 0 + knapScakProblem(weight,value,wt,index-1);

    int taken = (int) -1e9;
    
    if(weight[index] <= wt)
    taken = value[index]+ knapScakProblem(weight,value,wt - weight[index] ,index-1);
   
    return  Math.max(notTaken,taken) ;
     
     }

   public static void main(String[] args) {
    int wt[] = {1, 2, 4, 5};
    int val[] = {5, 4, 8, 6};
    int W = 5;
    int n = wt.length;
        
    System.out.println(knapScakProblem(wt,val,W,n-1));	
}
}