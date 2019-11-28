import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The goal in this problem is to find the minimum number of coins needed to change the input value 
 * (an integer) into coins with denominations 1, 5, and 10.
 */
public class Change {

    private static int[] coins = {10, 5, 1};
    /**
    * @param m Larger amount to be changed to smaller denominations of 10,5,1
    * @return mininum number of coins required to change m to smaller denominations=
    */
    private static int getChange(int m) {
        int coinChanges = 0;
        List<Integer> change = new ArrayList<Integer>();
        while (m > 0){
            for (int c : coins){
                if (m-c>=0){
                    m-=c;
                    coinChanges+=1;
                    change.add(c);
                    break;
                }
            }
        }
        // for (int i : change){
        //     System.out.println(i);
        // }
        return coinChanges;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        scanner.close();
    }
}

