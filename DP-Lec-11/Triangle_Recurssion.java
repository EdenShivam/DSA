import java.util.Scanner;
import java.util.*;

public class Triangle_Recurssion{

     static int minimumPathSum(int[][] triangle, int n, int i, int j ) {

        if(i == (n-1) ) return triangle[n-1][j] ;
         
        int downwards = triangle[i][j] + minimumPathSum(triangle,n,i+1,j);
        int diagonal = triangle[i][j] +  minimumPathSum(triangle,n,i+1,j+1);
           
         
        return Math.min(downwards,diagonal);
 
     }

   public static void main(String[] args) {
        int triangle[][] = {
            {1},
            {2, 3},
            {3, 6, 7},
            {8, 9, 6, 10}
        };

        int n = triangle.length;
       
        System.out.println(minimumPathSum(triangle, n,0,0)); 
}
}