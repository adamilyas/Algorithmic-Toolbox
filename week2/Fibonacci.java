import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * stores values in results
 *  if value in results -> use the value in results
 *  else: put the value in results
 */

public class Fibonacci {

  private static Map<Integer, Long> results = new HashMap<>();

  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    if (results.containsKey(n)){
      return results.get(n);
    } else {
      long v = calc_fib(n - 1) + calc_fib(n - 2);
      results.put(n, v);
      return v;
    }
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
    in.close();
  }
}
