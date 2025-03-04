import java.util.Scanner;
import java.util.*;

//Space Complexity =0(N)
//Time Complexity = 0(1)

public class MaximumSum_SpaceTabulation {
    public static int func(ArrayList<Integer> nums, int n, int [] dp) {

    int prev=nums.get(0);
    int prev2 =0;

    for(int i=1;i<n;i++){
 
    int pick =nums.get(i);
    int notpick = 0+prev;
    if(i>1) pick+=prev2; 

    prev2=prev;
    int curri = Math.max(pick,notpick); 
    prev=curri;
    
    }

        return prev;
    }

    public static void main(String[] args) {
       
       ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(8);
        nums.add(1);
        nums.add(9);
        
        int n = nums.size();
        int[] dp = new int[n];
    System.out.println(func(nums,n,dp));


    }
}