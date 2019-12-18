import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * What this does: it will find the ith smallest element of input array.
 * 
 * Running time of this algorithm: O(n)
 * Recursion:
 * T(n) <= T(n/2) + O(n)
 */

public class SelectionUtil {

    private String logging = "";
    public String getLogging(){
        return logging;
    }
    public void addLogging(String logString){
        this.logging = logging.concat(logString).concat("\n ");
    }

    private Random random = new Random();

    private void swapElement(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int partition(int[] arr, int l, int r){
        int m = random.ints(l, r).findFirst().getAsInt();
        logging = logging.concat(String.format("Random index: %s \n", m));

        swapElement(arr, l, m);
        int pivot = arr[l]; // first element is now the pivot
        int partitionIndex = l+1;
        for (int i=l+1;i<r;i++){
            if (arr[i] <= pivot){
                swapElement(arr, i, partitionIndex);
                partitionIndex++;
            }
        }
        swapElement(arr, l, partitionIndex-1);
        return partitionIndex-1;
    }

    public int selection(int[] arr, int l, int r, int i){
        logging = logging.concat(String.format("l:%s r:%s i:%s \n", l, r, i));
        if (r-l<2){
            return arr[i];
        } 
        int m = partition(arr, l, r); // get partition
        logging = logging.concat(Arrays.toString(arr).concat(" \n"));
        logging = logging.concat(String.format("Partition: %s \n", m));

        if (m==i){
            return arr[i];
        } else if (i < m){  // [ ... i ... m ..... ]
            return selection(arr, l, m, i);
        } else {
            return selection(arr, m+1,r, i);
        }
    }

    public SelectionUtil(){
        this.logging = "";
    }

    public static void main(String[] args){

        // a stupid ass way
        for (int i : new int[] {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}){
            SelectionUtil util = new SelectionUtil();
            int[] arr = {10,7,11,12,9,8};
        
            int ith = util.selection(arr, 0, arr.length, i);
            if (ith != 9){
                util.addLogging(String.format("%s,  Result: %s", Arrays.toString(arr), ith));
                System.out.println(util.getLogging());
            }    
        }
    }
}