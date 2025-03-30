import java.util.Scanner;
import java.util.*;

public class MaximumPath_SpaceTabulation {
   
  static int getMaxPathSum(int [][] matrix , int n , int m) {
     
     int[] prev = new int[m];
     
     int maxSum = (int) -1e9;

     for(int col =0;col<m;col++)
      prev[col] = matrix[0][col];

     for(int row=1;row<n;row++){
      int [] curr = new int[m];
      for(int col=0;col<m;col++){

       int up = matrix[row][col] + prev[col];
       int left = (col>0) ? matrix[row][col] + prev[col-1]:maxSum ;
       int right = (col<m-1) ? matrix[row][col] + prev[col+1]: maxSum ;

       curr[col] = Math.max(up,Math.max(left,right));
      }
      prev=curr;
     }

        for(int col =0;col<m;col++){
           maxSum  = Math.max(maxSum, prev[col]);
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