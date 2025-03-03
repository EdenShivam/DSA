import java.util.Scanner;
import java.util.*;

public class FrogJump_Memoization{

    public static int countDistinctWayToFrogJump(int n, int arr[],int dp[]) {
	

        if(n == 0) return 0;
        if (n == 1) return Math.abs(arr[1] - arr[0]); // Handle n=1 case

        if(dp[n]!=-1 ) return dp[n];

        int left =   countDistinctWayToFrogJump(n-1,arr,dp) + Math.abs(arr[n]-arr[n-1]);

		int  right =  Integer.MAX_VALUE;

        if(n>1)
        right = countDistinctWayToFrogJump(n-2,arr,dp) + Math.abs(arr[n]-arr[n-2]);;

		return dp[n]=Math.min(left,right);
	}



    public static void main(String[] args) {
       
        int arr [] ={7 ,4 ,4 ,2 ,6 ,6 ,3 ,4 };
        // int dp [] = new int[arr.length-1+1];  
        int dp [] = new int[arr.length];
        //If i want to have an array of size n+1 why not i have this int dp [] = new int[arr.length];  

		Arrays.fill(dp,-1);

    System.out.println(countDistinctWayToFrogJump(arr.length-1,arr,dp));

    }
}