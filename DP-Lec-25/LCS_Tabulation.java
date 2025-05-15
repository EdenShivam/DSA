import java.util.*;
public  class LCS_Tabulation { 
  
   static int lcsUtil(String s1, String s2 , int index1, int index2) {

     int [][] dp = new int [index1+1][index2+1] ;
     
     //Shifting of index  -1 , 0, 1, 2, ... n-1 
     // i < 0  can be written as i-1   // Base Condition using Shifting if(index1 == 0 || index2 == 0) return 0 ; 

    for(int i = 0 ; i <=index1 ; i++)
    dp[i][0] = 0 ;
    
    for(int j = 0 ; j <=index2 ; j++)
    dp[0][j] = 0 ;

    for (int ind1 = 1 ;ind1 <=index1; ind1++){
      for(int ind2 = 1; ind2 <= index2 ; ind2++){
       
       if( s1.charAt(ind1-1) ==  s2.charAt(ind2-1)) 
        dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
       else
        dp[ind1][ind2] = Math.max( dp[ind1-1][ind2] , dp[ind1][ind2-1] ) ;
        
      }
    }
      return  dp[index1][index2] ; 
    }

   public static void main(String[] args) {
     String s1 = "acd";
     String s2 = "ced";

     int n = s1.length();
     int m = s2.length();

    System.out.println(lcsUtil(s1,s2,n,m));	


}

}