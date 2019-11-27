import java.util.*;
/**
 * You are given a set of bars of gold and your goal is to take as much gold as possible into 
 * your bag. There is just one copy of each bar and for each bar you can either take it or not
 * (hence you cannot take a fraction of a bar).
 */
public class KnapSack {

    static int[] prepend(int[] w, int elementToPrepend){
        int[] wAfter = new int[w.length + 1];
        wAfter[0] = elementToPrepend;
        for (int i=0;i<w.length;i++){
            wAfter[i+1] = w[i];
        }
        return wAfter;
    }

    static int[][] createWeightMatrix(int W, int[] w){
        int[][] weightMatrix = new int[W+1][w.length+1];
        for (int i=0;i<=W;i++){
            for (int j=0;j<=w.length;j++){
                weightMatrix[i][j] = 0;
            }
        }
        return weightMatrix;

    }

    static int knapSack(int W, int[] w) {
        int[][] value = createWeightMatrix(W, w);
        int[] items = prepend(w, 0); // so that weights and weightMatrix is aligned
        for (int i=1;i<items.length;i++){
            for (int wStep=1;wStep<=W;wStep++){
                value[wStep][i] = value[wStep][i-1];

                // if current weight item is <= then current wStep, u may remove the current weight item
                if (items[i] <= wStep){
                    int val = value[wStep - items[i]][i-1] + items[i]; // remove that item
                    if (val > value[wStep][i]){
                        value[wStep][i] = val;
                    }
                }
            }
        }

        return value[W][w.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt(); // capacity of knapsack
        n = scanner.nextInt(); // n number of gold
        int[] w = new int[n]; // w_0 - w_n-1
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt(); 
        }
        System.out.println(knapSack(W, w));
    }
}

