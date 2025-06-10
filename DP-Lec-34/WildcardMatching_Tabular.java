import java.util.Scanner;
import java.util.*;

public class WildcardMatching_Tabular{

      public static boolean wildcardMatchingUtil(String str1, String str2 , int index1, int index2) {
      
      boolean [][] dp = new boolean[index1+1][index2+1];
      
      dp[0][0] = true ;

      for(int j =1;j<=index2;j++)
      dp[0][j] =false;

      for(int i=1;i<=index1;i++)
      dp[i][0] = checkIfContainsAllStars(str1,i);
    
       for(int i=1;i<=index1;i++){
        for(int j=1;j<=index2;j++){
            if(str1.charAt(i-1) == str2.charAt(j-1) || str1.charAt(i-1) == '?')
             dp[i][j] = dp[i-1][j-1];
            else{
                if(str1.charAt(i-1) == '*' )
                 dp[i][j] = dp[i-1][j] || dp[i][j-1] ;
                else
                 dp[i][j] = false;
            }
        }
       }
       return dp[index1][index2];
        
	}

    public static boolean checkIfContainsAllStars(String str1, int ind){

        for(int i=1;i<=ind;i++)
        {
            if(str1.charAt(i-1) != '*' ) 
            return false ;
        }
        return true ;
    }

    public static void main(String[] args) {
    String str1 = "ab*cd";
    String str2 = "abdefcd";    

    int n = str1.length();
    int m = str2.length();

    System.out.println(wildcardMatchingUtil(str1,str2,n,m));
    }
}