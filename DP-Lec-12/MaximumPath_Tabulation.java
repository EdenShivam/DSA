import java.util.*;

public class MaximumPath_Tabulation {
     
     static int getMaxPathSum(int [][] matrix , int n , int m) {
     
     int[][] dp = new int[n][m];
     int maxSum = (int) -1e9;

     for(int col =0;col<m;col++)
      dp[0][col] = matrix[0][col];

     for(int row=1;row<n;row++){
      for(int col=0;col<m;col++){

       int up = matrix[row][col] + dp[row-1][col];
       int left = (col>0) ? matrix[row][col] + dp[row-1][col-1]:maxSum ;
       int right = (col<m-1) ? matrix[row][col] + dp[row-1][col+1]: maxSum ;

       dp[row][col] = Math.max(up,Math.max(left,right));
      }
     }

        for(int col =0;col<m;col++){
           maxSum  = Math.max(maxSum, dp[n-1][col]);
        }
    
    return maxSum;
     }

   public static void main(String[] args) {
         int[][] matrix = {
            {10, 2, 3},
            {3, 7, 2},
            {8, 1, 5}
        };
         
        int n = matrix.length;
        int m = matrix[0].length; 

        System.out.println("Maximum Path Sum Memoization  "+ getMaxPathSum(matrix ,n ,m));

}

}
