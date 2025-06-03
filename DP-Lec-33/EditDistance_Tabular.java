import java.util.Scanner;
import java.util.*;

public class EditDistance_Tabular{

     public static int editDistance(String str1, String str2 , int index1, int index2) {

        int [] [] dp = new int[index1+1][index2+1];

        for(int itr1 = 0 ; itr1 <= index1 ; itr1++)
        dp[itr1][0] = itr1;

        for(int itr2 = 0 ; itr2 <= index2 ; itr2++)
        dp[0][itr2] = itr2;


        for(int ind1 = 1 ; ind1 <= index1; ind1++ ){
            for(int ind2 = 1 ; ind2 <= index2 ; ind2++ ){
                if( str1.charAt(ind1-1) == str2.charAt(ind2-1))
                dp[ind1][ind2] = 0 + dp[ind1-1][ind2-1];
                else{
                    int replace = 1  + dp[ind1-1][ind2-1];
                    int delete =  1  + dp[ind1-1][ind2];
                    int insert =  1  +dp[ind1][ind2-1];

                 dp[ind1][ind2] = Math.min(replace, Math.min(delete,insert) );

                }

            }
        }
        
        return dp[index1][index2];
	}


    public static void main(String[] args) {

        String str1="horse";
        String str2="ros";
        
        int n = str1.length();
        int m = str2.length();

        System.out.println(editDistance(str1,str2,n,m));
    }
}