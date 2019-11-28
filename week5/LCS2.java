import java.util.*;
// [2,4]
// [1,2,3,4]

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        System.out.println(lcs2(a, b));
    }
}

