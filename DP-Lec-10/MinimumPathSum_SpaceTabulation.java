import java.util.Scanner;
import java.util.*;

public class MinimumPathSum_SpaceTabulation {
   
     public static int gridUniquePaths(int n , int m,  int [][]  grid ) {
        
         int[] prev = new int[m]; // Stores previous row's DP values
         for (int i = 0; i < n; i++) {
            int[] curr = new int[m];
         for (int j = 0; j < m; j++) {
       
        if( i == 0 && j == 0) {
            curr[j]=grid[0][0];
            continue;
        }

         int upwards = ( i > 0 ) ? (grid[i][j] + prev[j]) : (int) 1e9;
         int left = (j > 0)  ? (grid[i][j]+ curr[j-1]) : (int) 1e9 ;

        curr[j] = Math.min(upwards,left) ;

        }
        prev = curr;
     }
     return prev[m-1] ; 
     }

     public static void main(String[] args) {
         
        int[][] grid = { {5 ,9 ,6}  , {11 ,5 ,2 } };

        int N = grid.length;      
        int M = grid[0].length; 

        System.out.println(gridUniquePaths(N,M,grid)); 
    }
}