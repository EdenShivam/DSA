import java.util.Scanner;
import java.util.*;

public class MaximumSum_Recurssion{

    public static int func(ArrayList<Integer> nums, int n) {
        if (n < 0) return 0; 
        if (n == 0) return nums.get(0); 

        int pick = nums.get(n) + func(nums, n - 2);
        int notPick = func(nums, n - 1);

        return Math.max(pick, notPick); 
    }


    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(3);
        nums.add(2);
        nums.add(7);
        nums.add(10);
        
        int n = nums.size();
    System.out.println(func(nums,n-1));
    }
}