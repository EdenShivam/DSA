import java.util.Scanner;
import java.util.*;

public class UniquePaths_Memoization{
    
    final static int MOD = (int) (1e9 + 7);
    
    public static int gridUniquePaths(int m , int n,int [][] dp, int [][] grid ) {
        
        if(m >= 0  && n >=0 && grid[m][n] == -1 ) return 0;

        if( m  == 0 &&  n == 0) return 1 ;
        
        if( m < 0 ||  n < 0 ) return 0;
         
        if ( dp [m][n] != -1) return dp[m][n] % MOD;

        dp[m][n] = gridUniquePaths(m-1,n,dp,grid) + gridUniquePaths(m,n-1,dp,grid) ;

        return dp[m][n] % MOD ;
 
     }

   public static void main(String[] args) {
        int[][] grid = {
            {0 ,0 ,0}  , {0 ,-1 ,0 } ,{0 ,0 ,0}
        };
        
        int M = grid.length;      
        int N = grid[0].length; 

        int[][] dp = new int[M + 1][N + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }



        System.out.println("Unique Paths : " + gridUniquePaths(M-1,N-1,dp,grid));
    }
}