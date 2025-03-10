import java.util.Scanner;
import java.util.*;

public class HouseRobber_Tabulation {
    public static int func(int [] nums, int n, int [] dp) {

        dp[0]=nums[0];

        for(int i=1;i<n;i++){
 
        int pick =nums[i];
        int notpick = 0+dp[i-1];

        if(i>1) pick+=dp[i-2]; 

        dp[i] = Math.max(pick,notpick); 
        }

        return dp[n-1];
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


    return Math.max( func(temp1,temp1.length,dp), func(temp2,temp2.length,dp));
	}

     public static void main(String[] args) {
        int[] valueInHouse = {1,2,3};
        int [] dp = new int[valueInHouse.length];
         Arrays.fill(dp,-1);
        System.out.println(houseRobber(valueInHouse,dp)); 
    }
}