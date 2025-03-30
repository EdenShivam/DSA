import java.util.Scanner;
import java.util.*;

public class MaximumPath_Memoization{
    
     static int getMaxPathSum(int [][] matrix, int n,int m, int row, int col ,int [][] dp ) {
        
     if(col < 0 || col >= m)
     return (int) -1e9; 
    
    if(row == 0) return matrix[row][col];

    if(dp[row][col] != -1) 
    return dp[row][col]; 

    int up = matrix[row][col] + getMaxPathSum(matrix,n,m, row-1 ,col,dp);
    int left = matrix[row][col] + getMaxPathSum(matrix,n,m, row-1 ,col-1,dp);
    int right = matrix[row][col] + getMaxPathSum(matrix,n,m, row-1 ,col+1,dp);

    dp[row][col] =  Math.max(up,Math.max(left,right));

    return dp[row][col];

     }

   public static void main(String[] args) {
         int[][] matrix = {
            {10, 2, 3},
            {3, 7, 2},
            {8, 1, 5}
        };
         
        int n = matrix.length;
        int m = matrix[0].length; 


        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        int maxSum = (int) -1e9;
        for(int col =0;col<m;col++){
            maxSum = Math.max(maxSum, getMaxPathSum(matrix,n,m, n-1 , col,dp));
        }

        System.out.println("Maximum Path Sum Memoization  "+maxSum);

}
}