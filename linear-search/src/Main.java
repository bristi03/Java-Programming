// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] nums = {23,5,6,34,12,98};
        int target = 6;
        System.out.println(linearSearch(nums,target));
        }


    static int linearSearch(int[] arr, int target){
        if (arr.length ==0){
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target)
                return i;
        }
        return -1;
    }
}
