import java.util.Scanner;

public class FrogJump_Recurssion{

    public static int countDistinctWayToFrogJump(int n, int arr[]) {
	

        if(n == 0) return 0;
        if (n == 1) return Math.abs(arr[1] - arr[0]); // Handle n=1 case

        int left =   countDistinctWayToFrogJump(n-1,arr) + Math.abs(arr[n]-arr[n-1]);

		int  right =  Integer.MAX_VALUE;

        if(n>1)
        right = countDistinctWayToFrogJump(n-2,arr) + Math.abs(arr[n]-arr[n-2]);;

		return Math.min(left,right);
	}


    public static void main(String[] args) {

        int arr [] ={7 ,4 ,4 ,2 ,6 ,6 ,3 ,4 };

        System.out.println(countDistinctWayToFrogJump(arr.length-1,arr));
    }
}