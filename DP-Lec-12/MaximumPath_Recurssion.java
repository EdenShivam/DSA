import java.util.Scanner;
import java.util.*;

public class MaximumPath_Recurssion{

    static int getMaxPathSum(int[][] matrix, int n,int m, int row, int col) {
    
    if(col < 0 || col >=m)
     return (int) -1e9; 
    
    if(row == 0) return matrix[row][col];

    int up = matrix[row][col] + getMaxPathSum(matrix,n,m, row-1 ,col);
    int left = matrix[row][col] + getMaxPathSum(matrix,n,m, row-1 ,col-1);
    int right = matrix[row][col] + getMaxPathSum(matrix,n,m, row-1 ,col+1);

    int max =  Math.max(up,Math.max(left,right));

    return max;
 
     }

   public static void main(String[] args) {
         int[][] matrix = {
            {10, 2, 3},
            {3, 7, 2},
            {8, 1, 5}
        };
         
        int n = matrix.length;
        int m = matrix[0].length; 
        
        int maxSum = (int) -1e9;
        for(int col =0;col<m;col++){
            maxSum = Math.max(maxSum, getMaxPathSum(matrix,n,m, n-1 , col));
        }

        System.out.println("Maximum Path Sum "+maxSum);
}
}