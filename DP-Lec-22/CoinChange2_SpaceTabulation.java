import java.util.Scanner;
import java.util.*;


public class CoinChange2_SpaceTabulation {
 
 static int noOfWaysCoinChange(int[] arr , int target,int index) {
    
  int prev[] = new int[target+1];

  for(int i =0 ;i <= target;i++){
  if(i % arr[0] == 0)
  prev[i] =1;
  }

  for(int ind = 1; ind < index; ind++){
    int curr[] = new int[target+1];
    for(int tar =0; tar <= target;tar++){

    int notTaken = prev[tar];

    int taken =0;
    if(arr[ind] <= tar)
    taken=curr[tar - arr[ind]];
    
    curr[tar] = notTaken + taken ; 
    }
    prev =curr;
  }

  return prev[target] ;
     }

   public static void main(String[] args) {
    int arr[] = { 1, 2, 3 };
   int target = 4;
   int n = arr.length;

    System.out.println(noOfWaysCoinChange(arr,target,n));	
   }

}