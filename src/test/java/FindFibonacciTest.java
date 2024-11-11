import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindFibonacciTest {

    @Test
    public void test() {
        long start = System.nanoTime();
//        find(0, 1, 47);
//        System.out.println(System.nanoTime() - start);

//        start = System.nanoTime();
//        findFibonacci(47);
//        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();
        fib(6);
        System.out.println(System.nanoTime() - start);

    }

    // 0 1 1 2 3 5 8 13 21
    public int findFibonacci(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;
        int pprev = 0;
        int prev = 1;
        int cur = 0;
        for (int i = 2; i < n; i++) {
            cur = prev + pprev;
            pprev = prev;
            prev = cur;

        }
        return cur;

    }


    public int find(int pprev, int prev, int n) {
        int cur;
        cur = prev + pprev;
        pprev = prev;
        prev = cur;
        if (--n == 2) return cur;
        return find(pprev, prev, n);


    }

    // n=5 -> 3
    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    // 10
    // 9+ 8 = 17

    public static int fibDynamic(int n) {
        if (n <= 1) {
            return n;
        }

        int[] fibArray = new int[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }

        return fibArray[n];
    }
}
