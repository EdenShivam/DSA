import java.util.Scanner;

public class ClimbingStair_Recurssion{

    public static long countDistinctWayToClimbStair(int nStairs) {
		// Write your code here.

        if(nStairs == 0) return 1;

        if(nStairs == 1) return 1;

		long left =   countDistinctWayToClimbStair(nStairs-1);
		long right =  countDistinctWayToClimbStair(nStairs-2);

		return left+right;
	}


    public static void main(String[] args) {

        System.out.println(countDistinctWayToClimbStair(33));
    }
}