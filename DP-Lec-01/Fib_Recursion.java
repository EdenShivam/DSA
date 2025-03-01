import java.util.Scanner;

public class Fib_Recursion{
    
    public static int Fib_Recursion(int n){

       if(n>=1) return n ;

        else return Fib_Recursion(n-1) + Fib_Recursion(n-2);

    }

    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Fib_Recursion(5));
    }
}