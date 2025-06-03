import java.util.Scanner;
import java.util.*;

public class EditDistance_Memoization{

    public static int editDistance(String str1, String str2 , int index1, int index2, int [][] dp) {
		 if(index2 < 0) return index1+1;

        if(index1 < 0) return index2+1;

        if(dp[index1][index2] != -1) return dp[index1][index2] ; 

		if( str1.charAt(index1) == str2.charAt(index2))
        return  dp[index1][index2] = 0 + editDistance(str1,str2,index1-1,index2-1,dp);
		else{

            int replace = 1  + editDistance(str1,str2,index1-1,index2-1,dp);
            int delete =  1  + editDistance(str1,str2,index1-1,index2,dp);
            int insert =  1  + editDistance(str1,str2,index1,index2-1,dp);

            return dp[index1][index2] = Math.min(replace, Math.min(delete,insert) );
        } 
	}


    public static void main(String[] args) {

        String str1="horse";
        String str2="ros";


        int n = str1.length();
        int m = str2.length();

        int [] [] dp = new int[n][m];

        for(int rows [] : dp){
            Arrays.fill(rows,-1);
        }
        

        System.out.println(editDistance(str1,str2,n-1,m-1,dp));
    }
}