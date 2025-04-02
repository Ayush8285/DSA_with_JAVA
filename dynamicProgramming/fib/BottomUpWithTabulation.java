import java.util.*;
public class BottomUpWithTabulation {
    public static void main(String[] args) {
        System.out.println(fibTab(6)); // Output: 5
    }

    public static int fibTab(int n) {
        ArrayList<Integer> tb = new ArrayList<>();
        tb.add(0); // fib(1)
        tb.add(1); // fib(2)
        for (int i = 2; i <= n-1 ; i++) {
            int n1 = tb.get(i - 1); // fib(i)
            int n2 = tb.get(i - 2); // fib(i-1)
            tb.add(n1 + n2); // fib(i+1) = fib(i) + fib(i-1)
        }
        return tb.get(n-1); // fib(n)
    }
}
