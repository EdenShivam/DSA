import java.util.Scanner;
import java.util.*;

public class LCS_Memoization{
    
  static int lcsUtil(String s1, String s2 , int index1, int index2,int [] [] dp ) {

    if(index1 < 0  || index2 < 0) return 0 ;

    if(dp[index1][index2] != -1) return dp[index1][index2] ; 
    
    if( s1.charAt(index1) ==  s2.charAt(index2)) 
    return dp[index1][index2]  = 1 +lcsUtil(s1,s2,index1-1,index2-1,dp) ;

    else  return  dp[index1][index2] = 0 + Math.max( lcsUtil(s1,s2,index1-1,index2,dp) , lcsUtil(s1,s2,index1,index2-1,dp) ) ;
     
    }

   public static void main(String[] args) {
     String s1 = "acd";
     String s2 = "ced";

     int n = s1.length();
     int m = s2.length();

     int [][] dp = new int [n][m] ;

     for(int rows[] : dp )
     Arrays.fill(rows, -1);

    System.out.println(lcsUtil(s1,s2,n-1,m-1,dp));	


}
 
}