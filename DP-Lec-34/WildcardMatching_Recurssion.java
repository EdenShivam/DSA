import java.util.Scanner;

public class WildcardMatching_Recurssion{

    public static boolean wildcardMatchingUtil(String str1, String str2 , int index1, int index2) {

       if(index1 < 0 && index2  < 0 ) return true ;
       if(index1 < 0 && index2  >= 0 ) return false ;
       if(index2  < 0 && index1 >= 0 ) return checkIfContainsAllStars(str1,index1) ;

		if(str1.charAt(index1) == str2.charAt(index2) || str1.charAt(index1) == '?')
        return wildcardMatchingUtil(str1,str2,index1-1,index2-1);
        else{
        if(str1.charAt(index1) == '*' )
        return wildcardMatchingUtil(str1,str2,index1-1,index2) || wildcardMatchingUtil(str1,str2,index1,index2-1) ;
        else return false;
        }
        
	}

    public static boolean checkIfContainsAllStars(String str1, int index1){

        for(int i=0;i<=index1;i++)
        {
            if(str1.charAt(i) != '*' ) 
            return false ;
        }
        return true ;
    }

    public static void main(String[] args) {
    String str1 = "ab*cd";
    String str2 = "abdefcd";    

    System.out.println(wildcardMatchingUtil(str1,str2,str1.length() -1 ,str2.length() -1 ));
    }
}