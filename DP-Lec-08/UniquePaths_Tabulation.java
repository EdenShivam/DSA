import java.util.*;

public class UniquePaths_Tabulation {
     public static int gridUniquePaths(int m , int n) {
        
        int [] prev = new int [n] ;

       for(int i=0;i<m;i++){
       
       int [] temp = new int[n];

        for(int j=0;j<n;j++){

            if(i==0 && j==0){
            temp[j]= 1;
            continue;
            }

            int upwards =0;
            int right = 0 ;
            
            if(i>0)
            upwards = prev[j];

            if(j>0)
            right=temp[j-1];

            temp[j] = upwards + right ;
        }
        prev= temp ;

       }
       return  prev[n-1] ;
     }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 4, 7, 10},
            {2, 5, 8, 11},
            {3, 6, 9, 12}
        };
        
        int M = grid.length;      
        int N = grid[0].length; 

        System.out.println("Unique Paths : " + gridUniquePaths(M,N));
    }
}
