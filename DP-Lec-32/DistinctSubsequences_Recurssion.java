import java.util.Scanner;

public class DistinctSubsequences_Recurssion{

    public static int countDistinctSubsequences(String str1, String str2 , int index1, int index2) {

        if(index2 < 0) return 1;

        if(index1 < 0) return 0;

		if( str1.charAt(index1) == str2.charAt(index2))
        return countDistinctSubsequences(str1,str2,index1-1,index2-1) + countDistinctSubsequences(str1,str2,index1-1,index2) ;

		else return countDistinctSubsequences(str1,str2,index1-1,index2);
	}


    public static void main(String[] args) {

        String str1="babgbag";
        String str2="bag";

        

        System.out.println(countDistinctSubsequences(str1,str2,str1.length() -1 ,str2.length() -1 ));
    }
}