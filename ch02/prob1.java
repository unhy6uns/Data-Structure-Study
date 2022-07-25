/**
 * 
 */

public class prob1{
    public static int a(int n) {
        if (n == 1)
            return 0;
        else
            return 5 * a(n - 1) + 3;
    }

    public static void main(String[] args) {
        
        System.out.println(a(2));

    }
}