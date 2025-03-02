import java.util.Scanner;
import java.util.*;

public class ClimbingStair_Tabular{

    public static long countDistinctWayToClimbStair(int nStairs) {
		// Write your code here.

         long prev=1;
         long nextPrev=1;

         for(long i=2;i<=nStairs;i++){
             long curr=prev+nextPrev;
             prev=nextPrev;
             nextPrev=curr;
         }

             
		return nextPrev;
	}


    public static void main(String[] args) {
       
        int n=49;
        System.out.println(countDistinctWayToClimbStair(n));
    }
}