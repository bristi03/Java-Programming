public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr={9,8,7,6,5,4,3,2,1};
        int target = 6;
        System.out.println("Index: "+ orderAgnosticBS(arr,target));
    }

    static int orderAgnosticBS(int[] arr, int target){
        int low=0;
        int high = arr.length-1;

        //find whether the array is sorted in ascending or descending order
        boolean isAsc = arr[low]< arr[high];

        while(low<=high){
            //find mid
            int mid = (low+high)/2;
            // int mid = low + (high-low)/2;
            if(target==arr[mid])
                return mid;

            if(isAsc) {
                if (target > arr[mid]) //if array is sorted in descending order do just the opposite
                    low = mid + 1; //then , high = mid-1;
                else
                    high = mid - 1; // low = mid+1
                }
            else {
                if (target > arr[mid]) //if array is sorted in descending order do just the opposite
                    high = mid-1; //then , high = mid-1;
                else
                    low = mid + 1;
                }
            }
        return -1;
    }
}
