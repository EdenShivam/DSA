import java.util.Scanner;

public class FrogJump_Recurssion{

    public static int minJumpCost(int n, int k ,int[]height){
    
    if(n==0) return 0;
        
    int minCost=Integer.MAX_VALUE;
    for(int i=1;i<=k;i++){

    if(n-i>=0){
    int compute=minJumpCost(n-i,k,height)+Math.abs(height[n] -height[n-i]);
    minCost=Math.min(compute,minCost);
    }
    }
    return minCost;
    }


    public static void main(String[] args) {

        int k=2;
        int arr [] ={10 ,40 ,30 ,10};

        System.out.println(minJumpCost(arr.length-1,k,arr));
    }
}