import java.util.Arrays;

public class RecursiveBinarySearch {

    private static int [] merge(int[] firstHalf, int[] secondHalf){
        int[] merged = new int[firstHalf.length + secondHalf.length];
        int currentIndex = 0, firstHalfIndex = 0, secondHalfIndex = 0;
        while (firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length){
            // System.out.println(String.format("%s %s %s", currentIndex, firstHalfIndex, secondHalfIndex));

            if (firstHalf[firstHalfIndex] <= secondHalf[secondHalfIndex]){
                merged[currentIndex] = firstHalf[firstHalfIndex];
                firstHalfIndex++;
            } else {
                merged[currentIndex] = secondHalf[secondHalfIndex];
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

    public static int[] mergeSort(int[] arr){
        if (arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;
        int[] firstHalf = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] secondHalf = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        int[] merged = merge(firstHalf, secondHalf);
        return merged;
    }

    /**
     * 
     * @param i number that we are search for
     * @return the index of the element we are search for. or -1 if doesnt exist
     */
    public static int BinarySearch(int i, int[] arr, int left, int right) {
        if (left >= right){
            return -1;            
        }
        int mid = (left + right)/2;
        if (arr[mid] == i){
            return mid;
        } else if (i < arr[mid]){
            return BinarySearch(i, arr, left, mid-1);
        } else if (i > arr[mid]) {
            return BinarySearch(i, arr, mid+1, right);
        } else {
            return -1;
        }
    }

    public static void main(String[] args){
        int[] merged = merge(new int[] {1}, new int[] {0});
        System.out.println(Arrays.toString(merged));
        System.out.println(Arrays.toString(mergeSort(new int[] {5,4,76,2,9,1})));
    }

}