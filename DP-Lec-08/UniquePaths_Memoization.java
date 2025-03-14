import java.util.Scanner;
import java.util.*;

public class UniquePaths_Memoization{

    public static int gridUniquePaths(int m , int n,int [][] dp ) {
        
        if( m  == 0 &&  n == 0) return 1 ;
        
        if( m < 0 ||  n < 0 ) return 0;
         
        if ( dp [m][n] != -1) return dp[m][n];

        dp[m][n] = gridUniquePaths(m-1,n,dp) + gridUniquePaths(m,n-1,dp) ;

        return dp[m][n] ;
 
     }

   public static void main(String[] args) {
        int[][] grid = {
            {1, 4, 7, 10},
            {2, 5, 8, 11},
            {3, 6, 9, 12}
        };
        
        int M = grid.length;      
        int N = grid[0].length; 

        int[][] dp = new int[M + 1][N + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }



        System.out.println("Unique Paths : " + gridUniquePaths(M-1,N-1,dp));
    }
}