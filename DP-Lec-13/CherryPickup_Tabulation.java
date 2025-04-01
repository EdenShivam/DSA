import java.util.*;

public class CherryPickup_Tabulation {
    static int getMaxSumChocolates(int[][] matrix, int n,int m) {
    
     int[][][] dp = new int[n][m][m];

      for(int j1=0;j1<m;j1++){
         for(int j2=0;j2<m;j2++){
            if(j1 == j2)
            dp[n-1][j1][j2] = matrix[n-1][j1];
            else
            dp[n-1][j1][j2] = matrix[n-1][j1]+matrix[n-1][j2];
         }
      }
   
   for(int i =n-2;i>=0;i--){
       for(int j1=0;j1<m;j1++){
         for(int j2=0;j2<m;j2++){
            int maxSum = (int) -1e9; 
            
            for(int d1=-1; d1<=1; d1++){
            for(int d2=-1; d2<=1; d2++){
            int res = (j1 == j2) ? matrix[i][j1] : matrix[i][j1]+matrix[i][j2] ;  
            int nextMove = ((j1+d1 < 0 || j1+d1 >= m) || (j2+d2 < 0 || j2+d2 >= m)) ?  (int) -1e9 : dp[i+1][j1+d1][j2+d2] ;
              
            maxSum = Math.max(maxSum,res+nextMove);
           }
     }
     dp[i][j1][j2] = maxSum;
    }
   }
   }
    return dp[0][0][m-1];
 
     }

   public static void main(String[] args) {
   int matrix[][] = {{2, 3, 1, 2},
                      {3, 4, 2, 2},
                      {5, 6, 3, 5}};
    int n = matrix.length;
    int m = matrix[0].length;

    System.out.println("Maximum number of chocolates "+ getMaxSumChocolates(matrix,n,m));
}

}
