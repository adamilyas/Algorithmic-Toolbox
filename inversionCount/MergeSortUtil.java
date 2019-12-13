import java.util.Arrays;

public class MergeSortUtil {

    private int inversionCount = 0;
    public int getInversionCount(){return inversionCount;}

    private int [] merge(int[] firstHalf, int[] secondHalf){
        int[] merged = new int[firstHalf.length + secondHalf.length];
        int currentIndex = 0, firstHalfIndex = 0, secondHalfIndex = 0;
        while (firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length){
            // System.out.println(String.format("%s %s %s", currentIndex, firstHalfIndex, secondHalfIndex));

            if (firstHalf[firstHalfIndex] <= secondHalf[secondHalfIndex]){
                merged[currentIndex] = firstHalf[firstHalfIndex];
                firstHalfIndex++;
            } else {
                merged[currentIndex] = secondHalf[secondHalfIndex];

                // add this line
                this.inversionCount += firstHalf.length - firstHalfIndex;
                secondHalfIndex++;
            }
            currentIndex++;
        }
        if (firstHalfIndex == firstHalf.length){
            // put remaining of second half into the merged
            while (secondHalfIndex<secondHalf.length){
                merged[currentIndex] = secondHalf[secondHalfIndex];
                secondHalfIndex++;
                currentIndex++;
            }
        } else if (secondHalfIndex == secondHalf.length){
            // put remaining of first half into the merged
            while (firstHalfIndex<firstHalf.length){
                merged[currentIndex] = firstHalf[firstHalfIndex];
                firstHalfIndex++;
                currentIndex++;
            }
        }
        return merged;
    }

    public int[] mergeSort(int[] arr){
        if (arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;
        int[] firstHalf = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] secondHalf = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        int[] merged = merge(firstHalf, secondHalf);
        return merged;
    }

    public static void main(String[] args){
        int[] arr = { 1, 20, 6, 4, 5 };

        MergeSortUtil util = new MergeSortUtil();
        System.out.println(Arrays.toString(util.mergeSort(arr)));
        System.out.println(util.getInversionCount());

    }

}