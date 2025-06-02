import java.util.Scanner;
import java.util.*;

public class DistinctSubsequences_SpaceTabulation{

     public static int countDistinctSubsequences(String str1, String str2 , int index1, int index2) {

        int []  prev = new int[index2+1];

        prev[0] = 1; // empty string is a subquence of itself


        for(int ind1 = 1 ; ind1 <= index1; ind1++ ){
               int []  curr = new int[index2+1];
                curr[0] = 1; 
            for(int ind2 = 1 ; ind2 <= index2 ; ind2++ ){
                if( str1.charAt(ind1-1) == str2.charAt(ind2-1))
                curr[ind2] = prev[ind2-1]+ prev[ind2];
                else
                curr[ind2] = prev[ind2];

            }
            prev = curr;
        }
        
        return prev[index2];
	}


    public static void main(String[] args) {

        String str1="rabbbit";
        String str2="rabbit";
        
        int n = str1.length();
        int m = str2.length();
        System.out.println(countDistinctSubsequences(str1,str2,n,m));
    }
}