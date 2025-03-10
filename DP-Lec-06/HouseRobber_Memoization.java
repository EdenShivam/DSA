import java.util.Scanner;
import java.util.*;

public class HouseRobber_Memoization{
    
    public static int func(int [] nums, int n, int[] dp) {
        if (n < 0) return 0; 
        if (n == 0) return nums[0]; 

        if (dp[n] != -1) return dp[n]; 

        int pick = nums[n] + func(nums, n - 2, dp);
        int notPick = func(nums, n - 1, dp);

        return dp[n] = Math.max(pick, notPick); 
    }

    public  static int houseRobber(int[] nums,int [] dp) {
    int n=nums.length;			
    if(n==1) return nums[0];

	// Creating temp1 with elements from index 1 to end
    int[] temp1 = new int[nums.length - 1];
    System.arraycopy(nums, 1, temp1, 0, nums.length-1);

    // Creating temp2 with elements from start till second last
    int[] temp2 = new int[nums.length - 1];
    System.arraycopy(nums, 0, temp2, 0, nums.length - 1);


    return Math.max( func(temp1,temp1.length-1,dp), func(temp2,temp2.length-1,dp));


	}	

    public static void main(String[] args) {
        
        int[] valueInHouse = {1,2,3};
         int [] dp = new int[valueInHouse.length+1];
         Arrays.fill(dp,-1);

        System.out.println(houseRobber(valueInHouse,dp)); 
    }
}