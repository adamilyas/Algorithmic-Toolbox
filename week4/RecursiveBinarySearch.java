public class RecursiveBinarySearch {

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
}