import java.util.Arrays;

public class Search2dArray {
    public static void main(String[] args) {
        int [][] arr=
                {{1,2,3},
                {4,5,6},
                {7,8,9}
                };
        int target = 6;
        System.out.println(Arrays.toString(search2d(arr, target)));
    }

    private static int[] search2d(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                //we can also do
                // for(int[] ints: arr){
                // for(int element: ints){}}
                if(arr[row][col]==target)
                    return new int[] {row,col};
            }
        }
        return new int[] {-1,-1};
    }
}
