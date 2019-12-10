import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void swapElement(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition(int[] arr, int l, int r){
        int x = arr[l];
        int j = l;
        for (int i=l+1;i<r;i++){
            if (arr[i] <= x){
                j++; // expand lower region
                swapElement(arr, i, j);// swap

            }
        }
        swapElement(arr, l, j);
        return j; // return the final position of the pivot: x

    }

    public static void GreekSort(int[] arr, int l, int r){
        if (l < r){
            int m = partition(arr, l, r);
            GreekSort(arr, l, m);
            GreekSort(arr, m+1, r);
        }
    }

    private Random random = new Random();
    private int randomPartition(int[] arr, int l, int r){
        int m = random.ints(l,r).findFirst().getAsInt();

        int x = arr[m]; // random pivot
        int j = l;
        swapElement(arr, l, m);
        for (int i=l+1;i<r;i++){
            if (arr[i] <= x){
                j++; // expand lower region
                swapElement(arr, i, j);// swap

            }
        }
        swapElement(arr, l, j);
        return j; // return the final position of the pivot: x
    }
    public  void randomizedQuickSort(int[] arr, int l, int r){
        if (l < r){
            int m = randomPartition(arr, l, r);
            randomizedQuickSort(arr, l, m);
            randomizedQuickSort(arr, m+1, r);
        }
    }

    public static void main(String[] args){
        int[] a = {6,1,8,7,2};
        int j = partition(a, 0, a.length);
        System.out.println(j);
        System.out.println(Arrays.toString(a));

        int[] b = {6,1,8,7,2,10,98,-1,3,20};
        GreekSort(b, 0, b.length);
        System.out.println(Arrays.toString(b));

        int[] c = {6,1,8,7,2,10,98,-1,3,20};
        QuickSort quickSort = new QuickSort();
        quickSort.randomizedQuickSort(c, 0, c.length);
        System.out.println(Arrays.toString(c));
    }
}