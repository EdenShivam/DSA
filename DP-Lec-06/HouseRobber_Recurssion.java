import java.util.Scanner;
import java.util.*;

public class HouseRobber_Recurssion{

    public static int func(int [] nums, int n) {
        if (n < 0) return 0; 
        if (n == 0) return nums[0]; 

        int pick = nums[n] + func(nums, n - 2);
        int notPick = func(nums, n - 1);

        return Math.max(pick, notPick); 
    }

    public  static int houseRobber(int[] nums) {
    int n=nums.length;			
    if(n==1) return nums[0];

	// Creating temp1 with elements from index 1 to end
    int[] temp1 = new int[nums.length - 1];
    System.arraycopy(nums, 1, temp1, 0, nums.length-1);

    // Creating temp2 with elements from start till second last
    int[] temp2 = new int[nums.length - 1];
    System.arraycopy(nums, 0, temp2, 0, nums.length - 1);


    return Math.max( func(temp1,temp1.length-1), func(temp2,temp2.length-1));


	}	

    public static void main(String[] args) {

        int[] valueInHouse = {1,2,3};
        System.out.println(houseRobber(valueInHouse)); 
    }
    
}