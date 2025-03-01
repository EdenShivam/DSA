import java.util.Scanner;
import java.util.*;

// TimeComplexity is --  0(n)
// Space Complexity is   0(n) + 0(n) for array and Recursive Stack  


public class Memomization_example{
    
    public static int Memomization(int n,int dp[]){
      
      if(n<=1) return n;
      if(dp[n] !=-1) return dp[n];
      else
      return dp[n]=Memomization(n-1,dp)+Memomization(n-2,dp);
      }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=10;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(Memomization(n,dp));
    }
}