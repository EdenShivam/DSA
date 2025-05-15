import java.util.Scanner;
import java.util.*;


public class LCS_SpaceTabulation {
 
 static int lcsUtil(String s1, String s2 , int index1, int index2) {

     int [] prev  = new int [index2+1] ;
     int [] curr  = new int [index2+1] ;
    
    for(int j = 0 ; j <=index2 ; j++)
    prev[j] = 0 ;

    for (int ind1 = 1 ;ind1 <=index1; ind1++){
      for(int ind2 = 1; ind2 <= index2 ; ind2++){
       
       if( s1.charAt(ind1-1) ==  s2.charAt(ind2-1)) 
        curr[ind2] = 1 + prev[ind2-1];
       else
        curr[ind2] = Math.max( prev[ind2] , curr[ind2-1] ) ;
        
      }
     prev = curr;  
    }
      return  prev[index2] ; 
    }

   public static void main(String[] args) {
     String s1 = "acd";
     String s2 = "ced";

     int n = s1.length();
     int m = s2.length();

    System.out.println(lcsUtil(s1,s2,n,m));	


}
}