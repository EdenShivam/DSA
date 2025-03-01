import java.util.Scanner;
import java.util.*;

// TimeComplexity is --  0(n)
// Space Complexity is   0(n)


public class TabulationDP{
    
    public static void TabulationDP(){
      int n=10;
      int prev=0;
      int nextprev=1;

      for(int i=2;i<=n;i++){
         int curr=prev+nextprev;
         prev=nextprev;
         nextprev=curr;
      }
       System.out.println(nextprev);

      }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       TabulationDP();
    }
}