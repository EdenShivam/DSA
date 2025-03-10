import java.util.Scanner;
import java.util.*;

public class NinjaTraining_Memoization{
    

    public static int getMaxMeritPoints(int day , int lastActivity,int[][] points ,int [] [] dp ) {
        
     if (day == 0) {
        int maxPoints= 0;
        for(int activity =0; activity < 3 ;activity++){
            if(activity !=lastActivity)
            {
                maxPoints =Math.max(maxPoints , points[day][activity]);
            }
        }
        return maxPoints;
     }

      if(dp[day][lastActivity] != -1 )  return dp[day][lastActivity] ;

        int maxPoints= 0;
        for(int activity =0; activity < 3 ;activity++){
        
            if(activity !=lastActivity)
            {
                int merit= points[day][activity] + getMaxMeritPoints(day-1,activity,points,dp);
                maxPoints = Math.max(maxPoints,merit);
            }

        }
        
        dp[day][lastActivity] = maxPoints ;
        
       return dp[day][lastActivity];
       
     }

   public static void main(String[] args) {
        int[][] points = {
            {1, 2, 5},
            {3, 1, 1},
            {3, 3, 3}
        };
        
        int n = points.length; 

        int [] [] dp = new int [n][4];
        for (int[] row : dp) {
        Arrays.fill(row, -1);
        }

        System.out.println("Maximum Merit Points: " + getMaxMeritPoints(n - 1, 3, points,dp));
    }
}