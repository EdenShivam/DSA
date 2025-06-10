import java.util.Scanner;
import java.util.*;

public class WildcardMatching_SpaceTabulation{

     public static boolean wildcardMatchingUtil(String str1, String str2 , int index1, int index2) {
      
      boolean [] prev = new boolean[index2+1];
      
      prev[0] = true ;

      for(int j =1;j<=index2;j++)
      prev[j] =false;
    
       for(int i=1;i<=index1;i++){
        boolean [] curr = new boolean[index2+1];
        curr[0] =  checkIfContainsAllStars(str1,i);;
        for(int j=1;j<=index2;j++){
            if(str1.charAt(i-1) == str2.charAt(j-1) || str1.charAt(i-1) == '?')
             curr[j] = prev[j-1];
            else{
                if(str1.charAt(i-1) == '*' )
                 curr[j] = prev[j] || curr[j-1] ;
                else
                 curr[j] = false;
            }
        }
        prev = curr;
       }
       return prev[index2];
        
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