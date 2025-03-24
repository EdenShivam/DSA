import java.util.Scanner;
import java.util.*;

public class MinimumPathSum_Memoization{
    
    public static int gridMinPathsSum(int m , int n,int [][] dp, int [][] grid ) {

        if( m  == 0 &&  n == 0) return grid[0][0] ;
        
        if( m < 0 ||  n < 0 ) return (int) 1e9;
         
        if ( dp[m][n] != -1) return dp[m][n] ;

        int upwards = grid[m][n]+ gridMinPathsSum(m-1,n,dp,grid) ;
        int left = grid[m][n] + gridMinPathsSum(m,n-1,dp,grid);

        dp[m][n] = Math.min(upwards,left) ;

        return dp[m][n];
 
     }

   public static void main(String[] args) {
        int[][] grid = { {5 ,9 ,6}  , {11 ,5 ,2 } };
        
        int M = grid.length;      
        int N = grid[0].length; 

        int[][] dp = new int[M][N];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }


        System.out.println("MinimumPathSum : " + gridMinPathsSum(M-1,N-1,dp,grid));
    }
}