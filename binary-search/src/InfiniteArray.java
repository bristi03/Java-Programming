import java.util.Arrays;

public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int target = 5;
        System.out.println(Arrays.toString(arr));
        System.out.println(ans(arr,target));

    }

    static int ans(int[] arr, int target){
        //first find the range (box which contains target)
        //start with a box of size 2
        int start = 0;
        int end = 1;

        //condition of target lying in range
        while(target > arr[end]){
            int temp = end+1;
            //double the box value
            end = end + (end - start +1) * 2;
            start = temp;
        }
        return binarySearch(arr, target, start, end);

    }
    static int binarySearch(int[] arr, int target, int start, int end){
            while(start<=end){
                //find mid
                int mid = (start+end)/2;
                // int mid = low + (high-low)/2;
                if(target==arr[mid])
                    return mid;
                else if(target> arr[mid])
                    start = mid+1;
                else
                    end = mid-1;
            }
            return -1;
        }
}
