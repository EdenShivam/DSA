import java.util.Scanner;
import java.util.*;

public class FrogJump_Tabular{

    public static int countDistinctWayToFrogJump(int n, int arr[]) {
		
        
        int prev=0;
        int prev2=0;

        for(int i=1;i<n;i++){

            int left = prev + Math.abs(arr[i]-arr[i-1]);
            int  right =  Integer.MAX_VALUE;
            if(i>1)
            right = prev2+ Math.abs(arr[i]-arr[i-2]);
            int curr=Math.min(left,right);
            prev2=prev;
            prev=curr;

        }

        return prev;
	}


    public static void main(String[] args) {
       
    int arr [] ={7 ,4 ,4 ,2 ,6 ,6 ,3 ,4 };  

    // int arr[] = {10, 20, 30, 10};

    System.out.println(countDistinctWayToFrogJump(arr.length,arr));
    }
}