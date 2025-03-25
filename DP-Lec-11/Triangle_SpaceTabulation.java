import java.util.Scanner;
import java.util.*;

public class Triangle_SpaceTabulation {
   
  static int minimumPathSum(int[][] triangle, int n) {
        
      
      int [] prev = new int[n];

      for (int j=0;j<n;j++)
      prev[j] = triangle[n-1][j];


      for(int i=n-2 ; i>=0; i--){
        int [] curr = new int [n];
         for(int j=i;j>=0; j--){
          int downwards = triangle[i][j] + prev[j];
          int diagonal = triangle[i][j] +  prev[j+1];

           curr[j] = Math.min(downwards,diagonal) ;
       }
        prev = curr;
        
      }
    
     return prev[0];
       
     }

    public static void main(String[] args) {
     int triangle[][] = {
            {1},
            {2, 3},
            {3, 6, 7},
            {8, 9, 6, 10}
        };

        int n = triangle.length;

      System.out.println(minimumPathSum(triangle, n)); 
    }
}