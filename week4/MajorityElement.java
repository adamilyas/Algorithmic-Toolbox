import java.util.*;
import java.io.*;

/**
 * Suppose to use recursion but i just use a 1 parse + hashMap LOL
 */
public class MajorityElement {

    /**
     * Init: first element to be candidate
     * Init: count = 1
     * 
     * iterate starting from second element onwards:
     *      if element == current candidate:
     *          count ++
     *      else: count --
     * 
     *      if count == 0:
     *          replace current candidate with current element
     * 
     * if count == 0: no majority element
     * else: find the count of the current candidate by iterating again.
     */
    private static int getMajorityElementUsingMooreVoting(int[] a) {
        int candidate = a[0];
        int netCount = 0;
        for (int i : a){
            if (i == candidate){
                netCount++;
            } else {
                netCount--;
            }

            if (netCount == 0){
                // set new candidate
                candidate = i;
                netCount = 1;
            }
        }

        if (netCount < 1){
            return -1;
        }
        // obtain candidate and check if count of candidate
        int count = 0;
        for (int i : a){
            if (i == candidate){
                count++;
            }
        }

        return candidate;
    }

    private static int getMajorityElementUsingHashMap(int[] a) {
        int n = a.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int el : a){
            if (map.containsKey(el)){
                map.put(el, map.get(el) + 1);
                // check if majority element
                if (map.get(el) > n/2){
                    return el;
                }
            } else {
                map.put(el ,1);
                // edge case
                if (n == 1){
                    return el;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        /**
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElementUsingHashMap(a) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
         */

        int[] a = {2, 2, 3, 5, 2, 2, 6};
        System.out.println(getMajorityElementUsingHashMap(a));
        System.out.println(getMajorityElementUsingMooreVoting(a));


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

