# Algorithmic-Toolbox
https://www.coursera.org/specializations/data-structures-algorithms

Some highlights:

## Fibonacci with memoization
```
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
}
```

## BinarySearch with Recursion
```
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
```
 
## Edit distance via Dynamic Programming
```
 import java.util.*;
/**
 * Compare distance between 2 strings based on the number of
 * - inserts
 * - deletions
 * - replacement
 *  of characters. E.g. really -> bread : add [b], swap [l->d], delete [l,y].
 *  ~ edit distance of 4 operation
 */
class EditDistance {

    public static int getEditDistance(String s, String t){
        int[][] dpTable = EditDistanceTable(s, t);
        return dpTable[s.length()][t.length()];
    }

    private static int[][] EditDistanceTable(String s, String t) {
        int[][] dpTable = new int[s.length()+1][t.length()+1];
        for (int i=0;i<=s.length();i++){

            for (int j=0;j<=t.length();j++){

                if (i == 0){
                    dpTable[i][j] = j; // insert all of string2
                } else if (j == 0){
                    dpTable[i][j] = i; // insert all of string1
                } else if (s.charAt(i-1) == t.charAt(j-1)){
                    dpTable[i][j] = dpTable[i-1][j-1]; // no changes from previous substring
                } else {
                    dpTable[i][j] = 1 + Collections.min(
                        Arrays.asList(
                            dpTable[i][j-1],  // Insert
                            dpTable[i-1][j],  // Remove 
                            dpTable[i-1][j-1] // Replace 
                    )); 
                }
            }
        }
        return dpTable;
    }
```
  
## Longest Common Substring
```
// Here for more explaination: https://www.youtube.com/watch?v=sSno9rV8Rhg
public class LCS2 {

    private static int lcs(int[] a, int[] b, int i, int j,int[][] memo){
        // if reach end of string.
        if (i == a.length || j == b.length){
            return 0;
        } else if (memo[i][j] >= 0){
            return memo[i][j];
        } else if (a[i] == b[j]){
            memo[i][j] = 1 + lcs(a, b, i+1, j+1, memo);
        } else {
            memo[i][j] = Math.max(
                lcs(a, b, i+1, j, memo), lcs(a, b, i, j+1, memo));
        }
        return memo[i][j];
    }

    private static int lcs2(int[] a, int[] b) {
        int[][] memo = new int[a.length][b.length];
        for (int i=0; i<a.length;i++){
            for (int j=0; j<b.length;j++){
                memo[i][j] = -1;
            }
        }
        return lcs(a, b, 0, 0, memo);
    }
}
```
