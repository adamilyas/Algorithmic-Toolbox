import java.io.*;
import java.util.*;

public class BinarySearch {
    
    private static boolean forSubmission = true;

    static int binarySearch(int[] a, int x) {
        int left = 0, right = a.length-1;
        while (left <= right){
            // int mid = left + (right - left) / 2;
            int mid = (left + right) / 2;
            if (a[mid] == x){
                return mid; // return the index
            } else if (x < a[mid]){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        if (forSubmission){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int m = scanner.nextInt();
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
              b[i] = scanner.nextInt();
            }

            for (int i = 0; i < m; i++) {
                //replace with the call to binarySearch when implemented
                System.out.print(binarySearch(a, b[i]) + " ");
            }            
        } else {
            // test case
            int[] a = {1,5,8,12,13}; // sorted array
            int[] b = {8,1,23,1,11}; // input to find the index at arr a
            int m = b.length;
            printIntArr(a);
            printIntArr(b);
            for (int i = 0; i < m; i++) {
                System.out.println(binarySearch(a, b[i]) + " ");
            }      
        }
    }

    // some utils
    private static void printIntArr(int[] arr){
        String str = "";
        for (int el : arr){
            str = str.concat(" ").concat(String.valueOf(el));
        }
        System.out.println(str);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
