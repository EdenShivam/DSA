import java.util.*;

public class MinimumPathSum_Tabulation {
     
     public static int gridUniquePaths(int m , int n,int [][] grid) {
        
       int [][] dp = new int[m][n];

       for(int i=0;i<m;i++){
       
        for(int j=0;j<n;j++){

        if(i==0 && j==0) {
        dp[i][j] = grid[0][0];
        continue;
        }
            
        int upwards = (i > 0) ? (grid[i][j] + dp[i - 1][j]) : ((int) 1e9);
        int left = (j > 0) ? (grid[i][j] + dp[i][j - 1]) : ((int) 1e9);

        dp[i][j]= Math.min(upwards ,left );
        }
       }
       return  dp[m-1][n-1] ;
     }

    public static void main(String[] args) {
        
        int[][] grid = { {5 ,9 ,6}  , {11 ,5 ,2 } };

        int M = grid.length;      
        int N = grid[0].length; 

        System.out.println("Unique Paths : " + gridUniquePaths(M,N,grid));
    }
}
