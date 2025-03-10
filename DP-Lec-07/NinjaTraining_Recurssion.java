import java.util.Scanner;
import java.util.*;

public class NinjaTraining_Recurssion{

    public static int getMaxMeritPoints(int day , int lastActivity,int[][] points) {
        
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

        int maxPoints= 0;
        for(int activity =0; activity < 3 ;activity++){
            if(activity !=lastActivity)
            {
                int merit= points[day][activity] + getMaxMeritPoints(day-1,activity,points);
                maxPoints = Math.max(maxPoints,merit);
            }

        }
        return maxPoints;
     }

   public static void main(String[] args) {
        int[][] points = {
            {1, 2, 5},
            {3, 1, 1},
            {3, 3, 3}
        };
        
        int n = points.length; 
        System.out.println("Maximum Merit Points: " + getMaxMeritPoints(n - 1, 3, points));
    }
}