import java.util.Scanner;
import java.util.*;

public class DistinctSubsequences_Tabular{

     public static int countDistinctSubsequences(String str1, String str2 , int index1, int index2) {

        int [] [] dp = new int[index1+1][index2+1];

        dp[0][0] = 1; // empty string is a subquence of itself

        for(int itr1 = 1 ; itr1 <= index1 ; itr1++)
        dp[itr1][0] = 1;

        for(int itr2 = 1 ; itr2 <= index2 ; itr2++)
        dp[0][itr2] = 0;


        for(int ind1 = 1 ; ind1 <= index1; ind1++ ){
            for(int ind2 = 1 ; ind2 <= index2 ; ind2++ ){
                if( str1.charAt(ind1-1) == str2.charAt(ind2-1))
                dp[ind1][ind2] = dp[ind1-1][ind2-1]+ dp[ind1-1][ind2];
                else
                 dp[ind1][ind2] = dp[ind1-1][ind2];

            }
        }
        
        return dp[index1][index2];
	}


    public static void main(String[] args) {

        String str1="rabbbit";
        String str2="rabbit";
        
        int n = str1.length();
        int m = str2.length();
        System.out.println(countDistinctSubsequences(str1,str2,n,m));
    }
}