import java.util.*;

public class UniquePaths_Tabulation {
     public static int gridUniquePaths(int m , int n,int [][] grid,int [] [] dp) {
        

       for(int i=0;i<m;i++){
       
        for(int j=0;j<n;j++){

        if(i >=0 && j>=0 && grid[i][j] == -1 ){
             dp[i][j] = 0;
             continue;
        } 

        if(i==0 && j==0) {
        dp[i][j] = 1;
        continue;
        }

        int upwards =0;
        int left = 0 ;
            
        if(i>0) upwards = dp[i-1][j];

        if(j>0) left = dp[i][j-1];

        dp[i][j]= upwards + left ;
        }
       }
       return  dp[m-1][n-1] ;
     }

    public static void main(String[] args) {
        int[][] grid = {
            {0 ,0 ,0}  , {0 ,-1 ,0 } ,{0 ,0 ,0}
        };

        int M = grid.length;      
        int N = grid[0].length; 

        int[][] dp = new int[M][N];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println("Unique Paths : " + gridUniquePaths(M,N,grid,dp));
    }
}
