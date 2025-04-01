import java.util.Scanner;
import java.util.*;

public class CherryPickup_Recurssion{

    static int getMaxSumChocolates(int[][] matrix, int n,int m, int row, int col1,int col2) {

    if( col1 < 0 || col1 >= m || col2<0 || col2>=m ) 
    return (int) -1e9;
    
    if (row == n - 1) {
    if(col1 == col2)
        return matrix[row][col1];
    else
        return matrix[row][col1]+matrix[row][col2];
    }

    int maxSum = (int) -1e9; 

    for(int d1=-1; d1<=1; d1++){
       for(int d2=-1; d2<=1; d2++){

       int nextMove = getMaxSumChocolates(matrix, n, m, row + 1, col1 + d1, col2 + d2);

       int res = (col1 == col2) ? matrix[row][col1] : matrix[row][col1]+matrix[row][col2] ;

       maxSum = Math.max(maxSum,nextMove+res);
       
     }
    }
    return maxSum;
 
     }

   public static void main(String[] args) {
   int matrix[][] = {{2, 3, 1, 2},
                      {3, 4, 2, 2},
                      {5, 6, 3, 5}};
    int n = matrix.length;
    int m = matrix[0].length;
        
    System.out.println("Maximum number of chocolates "+ getMaxSumChocolates(matrix,n,m,0,0,m-1));
}
}