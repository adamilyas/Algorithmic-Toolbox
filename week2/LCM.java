import java.util.*;

public class LCM {

  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long gcd_r(long a, long b) {
    if (a == 0){
        return b;
    } else if (b == 0){
        return a;
    } else {
        return gcd_r(b, a%b);
    }
  }

  private static long lcm_fast(long a, long b) {
    return (a*b) / gcd_r(a, b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_fast(a, b));
    scanner.close();
  }
}
