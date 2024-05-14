// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int target = 7;
        System.out.println("The index : "+ binarySearch(arr,target));
    }

    static int binarySearch(int[] arr, int target){
        int low=0;
        int high = arr.length-1;

        while(low<=high){
            //find mid
            int mid = (low+high)/2;
            // int mid = low + (high-low)/2;
            if(target==arr[mid])
                return mid;
            else if(target> arr[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}