import java.util.Scanner;
import java.util.*;

public class DistinctSubsequences_Memoization{

    public static int countDistinctSubsequences(String str1, String str2 , int index1, int index2, int [][] dp) {

        if(index2 < 0) return 1;

        if(index1 < 0) return 0;

        if(dp[index1][index2] != -1) return dp[index1][index2] ; 

		if( str1.charAt(index1) == str2.charAt(index2))
         return dp[index1][index2]  = countDistinctSubsequences(str1,str2,index1-1,index2-1,dp) + countDistinctSubsequences(str1,str2,index1-1,index2,dp) ;

		else  return dp[index1][index2] =  countDistinctSubsequences(str1,str2,index1-1,index2,dp);
	}


    public static void main(String[] args) {

        String str1="rabbbit";
        String str2="rabbit";
        
        int n = str1.length();
        int m = str2.length();

        int [] [] dp = new int[n][m];

        for(int rows [] : dp){
            Arrays.fill(rows,-1);
        }
        

        System.out.println(countDistinctSubsequences(str1,str2,n-1,m-1,dp));
    }
}