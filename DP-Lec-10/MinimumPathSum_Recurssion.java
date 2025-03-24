import java.util.Scanner;
import java.util.*;

public class MinimumPathSum_Recurssion{

    public static int gridMinPathsSum(int m , int n ,int [][] grid) {

        if( m  == 0  &&  n == 0) return grid[0][0] ;
        
        if( m < 0 ||  n < 0 ) return (int) 1e9;
         
        int upwards = grid[m][n] + gridMinPathsSum(m-1,n,grid);
        int left = grid[m][n] +  gridMinPathsSum(m,n-1,grid);
           
         
        return Math.min(upwards,left);
 
     }

   public static void main(String[] args) {
        int[][] grid = { {5 ,9 ,6}  , {11 ,5 ,2 } };
        
        int M = grid.length;      
        int N = grid[0].length; 


        System.out.println("MinimumPathSum : " + gridMinPathsSum(M-1,N-1,grid));
    }
}