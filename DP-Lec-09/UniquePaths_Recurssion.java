import java.util.Scanner;
import java.util.*;

public class UniquePaths_Recurssion{

    public static int gridUniquePaths(int m , int n ,int [][] grid) {
        
        if(m >= 0  && n >=0 && grid[m][n] == -1 ) return 0;

        if( m  == 0  ||  n == 0) return 1 ;
        
        if( m < 0 ||  n < 0 ) return 0;
         
        int upwards = gridUniquePaths(m-1,n,grid);
        int left = gridUniquePaths(m,n-1,grid);

        int MOD = (int) (1e9 + 7);
        return (upwards + left) % MOD ;
 
     }

   public static void main(String[] args) {
        int[][] grid = {
            {0 ,0 ,0}  , {0 ,-1 ,0 } ,{0 ,0 ,0}
        };
        
        int M = grid.length;      
        int N = grid[0].length; 


        System.out.println("Unique Paths : " + gridUniquePaths(M-1,N-1,grid));
    }
}