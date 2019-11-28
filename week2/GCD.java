import java.util.*;
/**
 * GREATEST COMMON DIVISOR OF 2 INT: A AND B
 */
public class GCD {

  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  private static long testLongInt(int a){
      // can convert
      return a;
  }

  private static long gcd_r(int a, int b) {
    if (a == 0){
        return b;
    } else if (b == 0){
        return a;
    } else {
        return gcd_r(b, a%b);
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_r(a, b));
    scanner.close();
  }
}
