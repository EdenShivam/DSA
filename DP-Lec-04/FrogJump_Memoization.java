import java.util.Scanner;
import java.util.*;

public class FrogJump_Memoization{

    
 public static int minJumpCost(int n, int k ,int[]height,int [] dp){
    
    int minCost=Integer.MAX_VALUE;
    if(n==0) return 0;

    if(dp[n]!=-1) return dp[n];

    for(int i=1;i<=k;i++){

    if(n-i>=0){
    int compute=minJumpCost(n-i,k,height,dp)+Math.abs(height[n] -height[n-i]);
    minCost=Math.min(compute,minCost);
    }
    }
    return dp[n]=minCost;
    }


    public static void main(String[] args) {
       
        int k=2;
        int arr [] ={10 ,40 ,30 ,10};
       
        int dp [] = new int[arr.length];

		Arrays.fill(dp,-1);

    System.out.println(minJumpCost(arr.length-1,k,arr,dp));

    }
}