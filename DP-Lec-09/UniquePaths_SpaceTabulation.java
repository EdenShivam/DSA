import java.util.Scanner;
import java.util.*;

public class UniquePaths_SpaceTabulation {
   
final static int MOD = (int) (1e9 + 7);
     public static int gridUniquePaths(int n , int m,  int [][]  grid ) {
        int[] prev = new int[m]; // Stores previous row's DP values
         for (int i = 0; i < n; i++) {
            int[] curr = new int[m];
         for (int j = 0; j < m; j++) {
        
         if (grid[i][j] == -1) {
         curr[j] = 0; // Obstacle means no paths through this cell
         continue;
         }
       
        if( i == 0 && j == 0) {
            curr[j]=1;
            continue;
        }

         int upwards = ( i > 0 ) ? prev[j] : 0;
         int left =(j > 0)  ? curr[j-1] : 0 ;

        curr[j] = (upwards + left) % MOD;

        }
        prev = curr;
     }
     return prev[m-1] ; 
     }

     public static void main(String[] args) {
        int[][] grid = {
            {0 ,0 ,0}  , {0 ,-1 ,0 } ,{0 ,0 ,0}
        };

        int M = grid.length;      
        int N = grid[0].length; 

        System.out.println(gridUniquePaths(N,M,grid)); 
    }
}