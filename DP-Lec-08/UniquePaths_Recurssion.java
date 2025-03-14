import java.util.Scanner;
import java.util.*;

public class UniquePaths_Recurssion{

    public static int gridUniquePaths(int m , int n ) {
        
        if( m  == 0  ||  n == 0) return 1 ;
        
        if( m < 0 ||  n < 0 ) return 0;
         
        int upwards = gridUniquePaths(m-1,n);
        int left = gridUniquePaths(m,n-1);

        return upwards + left ;
 
     }

   public static void main(String[] args) {
        int[][] grid = {
            {1, 4, 7, 10},
            {2, 5, 8, 11},
            {3, 6, 9, 12}
        };
        
        int M = grid.length;      
        int N = grid[0].length; 


        System.out.println("Unique Paths : " + gridUniquePaths(M-1,N-1));
    }
}