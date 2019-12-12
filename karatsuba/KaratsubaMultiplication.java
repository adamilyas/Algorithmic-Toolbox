
public class KaratsubaMultiplication {

    private static String[] makeSameLength(String xs, String ys){
        if (xs.length() > ys.length()){
            while (xs.length() > ys.length()){
                ys = "0".concat(ys);
            }
        } else if (xs.length() < ys.length()){
            while (xs.length() < ys.length()){
                xs = "0".concat(xs);
            }
        }
        return new String[] {xs, ys};
    }

    public static long kMultiply(long x, long y){

        if (x<10 || y<10){
            return x*y;
        }

        String xs = String.valueOf(x);
        String ys = String.valueOf(y);
        String[] modifiedNumbers = makeSameLength(xs, ys);
        xs = modifiedNumbers[0];
        ys = modifiedNumbers[1];

        // split in half. If length is odd, first half > second half
        int n = xs.length();
        int splitIndex = n-n/2;
        long a = Long.valueOf(xs.substring(0, splitIndex));
        long b = Long.valueOf(xs.substring(splitIndex));
        long c = Long.valueOf(ys.substring(0, splitIndex));
        long d = Long.valueOf(ys.substring(splitIndex));
        // System.out.println(String.format("a: %s b: %s c: %s d: %s", a, b, c, d));

        long ac = kMultiply(a, c);
        long bd = kMultiply(b, d);
        long gauss = kMultiply(a+b, c+d) - ac - bd;
        
        // if n is odd, n = n-1
        return (long) Math.pow(10,n/2*2) * ac + (long) Math.pow(10,n/2) * gauss + bd;
    }

    public static void main(String[] args){
        long a = 5678, b = 1234;
        if (args.length == 2){
            a = Long.valueOf(args[0]);
            b = Long.valueOf(args[1]);

        }
        System.out.println(kMultiply(a, b));
        System.out.println(a * b);
    }
}