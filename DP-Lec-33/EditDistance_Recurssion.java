import java.util.Scanner;

public class EditDistance_Recurssion{

    public static int editDistance(String str1, String str2 , int index1, int index2) {

        if(index2 < 0) return index1+1;

        if(index1 < 0) return index2+1;

		if( str1.charAt(index1) == str2.charAt(index2))
        return  0 + editDistance(str1,str2,index1-1,index2-1);
		else{

            int replace = 1  + editDistance(str1,str2,index1-1,index2-1);
            int delete =  1  + editDistance(str1,str2,index1-1,index2);
            int insert =  1  + editDistance(str1,str2,index1,index2-1);

            return Math.min(replace, Math.min(delete,insert) );
        } 
        
	}


    public static void main(String[] args) {

        String str1="horse";
        String str2="ros";

        

        System.out.println(editDistance(str1,str2,str1.length() -1 ,str2.length() -1 ));
    }
}