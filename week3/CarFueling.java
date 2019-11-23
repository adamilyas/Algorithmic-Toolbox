import java.util.*;
import java.io.*;

public class CarFueling {
    /**
     * 
     * @param dist distance to travel
     * @param tank miles that can travel while full
     * @param stops avaliable stops
     * @return minimum number of stops required via greedy algorithm
     */
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int noOfStops = 0;
        int distLimit = tank;
        for (int i=0;i<stops.length;i++){
            // System.out.println("Current stop: " + stops[i]);
            // System.out.println("distLimit: " + distLimit);
            // check if need to top up at final stop
            if (i == stops.length-1){ 

                if (dist > distLimit){
                    distLimit = stops[i] + tank;
                    noOfStops += 1;
                    if (dist > distLimit){
                        return -1;
                    }
                } 

            } else if (stops[i+1] > distLimit){
                // System.out.println("Refill here");
                distLimit = stops[i] + tank; //stop and topup at current stop
                noOfStops += 1;
                // System.out.println("New distLimit " + distLimit);
                if (stops[i+1] > distLimit){
                    return -1;
                }
            }
        }
        return noOfStops;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
