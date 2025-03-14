import java.util.Scanner;
import java.util.*;

public class UniquePaths_SpaceTabulation {
   
public static int func(int[] nums, int n) {
    int prev=nums[0];
    int prev2 =0;

    for(int i=1;i<n;i++){
 
    int pick =nums[i];
    int notpick = 0+prev;
    if(i>1) pick+=prev2; 

    prev2=prev;
    int curri = Math.max(pick,notpick); 
    prev=curri;
    
    }
    return prev;
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


    return Math.max( func(temp1,temp1.length), func(temp2,temp2.length));


	}	

     public static void main(String[] args) {
        int[] valueInHouse = {1,2,3};
        System.out.println(houseRobber(valueInHouse)); 
    }
}