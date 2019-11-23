import java.math.BigInteger;
import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    public static long getPisanoPeriod(long m) {
        long a = 0, b = 1, c;
        for (int i = 0; i < m * m; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
            if (a == 0 && b == 1)
                return i + 1;
        }
        return 0;
    }
    
    public static BigInteger getFibonacciHugeHack(long n,long m) {
        long remainder = n % getPisanoPeriod(m);
    
        BigInteger first, second, m1, remainder1;
        first = BigInteger.valueOf(0);
        second = BigInteger.valueOf(1);
        m1 = BigInteger.valueOf(m);
        remainder1 = BigInteger.valueOf(remainder);
    
        for (long i = 1; i < remainder; i++) {
            remainder1 = (first.add(second)).mod(m1);
            first = second;
            second = remainder1;
        }
        return remainder1.mod(m1);
    }   
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeHack(n, m));
        scanner.close();
    }
}

