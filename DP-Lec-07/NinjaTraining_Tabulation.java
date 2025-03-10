import java.util.*;

public class NinjaTraining_Tabulation {
    public static int getMaxMeritPoints(int n, int[][] points) {
        // Previous day's max points for each last activity
        int[] prev = new int[4];

        // Initialize first day's max points
        prev[0] = Math.max(points[0][1], points[0][2]);  // If last activity was Running
        prev[1] = Math.max(points[0][0], points[0][2]);  // If last activity was Fighting
        prev[2] = Math.max(points[0][0], points[0][1]);  // If last activity was Learning
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2])); // Max of all activities

        // Iterate over days from 1 to n-1
        for (int day = 1; day < n; day++) {
            int[] temp = new int[4]; // Store current day's best values
            
            for (int lastActivity = 0; lastActivity < 4; lastActivity++) {
                temp[lastActivity] = 0; // Initialize current day's values
                
                for (int activity = 0; activity < 3; activity++) {
                    if (activity != lastActivity) {
                        temp[lastActivity] = Math.max(temp[lastActivity], points[day][activity] + prev[activity]);
                    }
                }
            }

            // Update prev with temp for next day's computation
            prev = temp;
        }

        return prev[3]; // Max points on last day
    }

    public static void main(String[] args) {
        int[][] points = {
            {10, 40, 70},
            {20, 50, 80},
            {30, 60, 90}
        };

        int n = points.length;
        System.out.println("Maximum Merit Points: " + getMaxMeritPoints(n, points)); // Output: 210
    }
}
