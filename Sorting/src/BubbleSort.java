import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5,7,8,0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean swapped;
        for(int i = 0; i < n; i++){
            swapped = false;
            for(int j = 1; j < n - i; j++){
                if (arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                    swapped = true;
                }
            }
            if(!swapped)
                break;
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
