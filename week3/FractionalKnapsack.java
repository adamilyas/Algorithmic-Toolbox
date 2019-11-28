import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/**
 * The goal of this code problem is to implement an algorithm for the fractional knapsack problem.
 * 
 * Example: A thief finds much more loot than his bag can fit. Help him to find the most valuable combination 
 * of items assuming that any fraction of a loot item can be put into his bag.
 */
public class FractionalKnapsack {
    /**
     * 
     * @param capacity maximum size of weights
     * @param values Maximize this
     * @param weights constaint
     * @return
     */
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        List<LootDetails> loots = new ArrayList<LootDetails>();
        for (int i=0;i<values.length;i++){
            loots.add(new LootDetails(values[i], weights[i]));
        }
        loots.sort(Comparator.comparing(LootDetails::getWorth).reversed());
        for (LootDetails ld : loots){
            // System.out.printf("%f, %f, %f\n", ld.getValue(), ld.getWeight(), ld.getWorth());
            if (ld.getWeight() > capacity){
                // remaining capacity
                value += ld.getWorth() * capacity;
                break;
            } else {
                value += ld.getValue();
                capacity-=ld.getWeight();
            }
        }
        return value;
    }

    private static class LootDetails {
        double value;
        double weight;
        double worth;
        LootDetails(int value, int weight){
            this.value = value;
            this.weight = weight;
            this.worth = this.value / this.weight;
        }
        double getValue(){return value;}
        double getWeight(){return weight;}
        double getWorth(){return worth;}

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
        scanner.close();
    }
} 
