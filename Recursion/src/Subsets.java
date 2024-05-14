import  java.util.*;
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> res = subsetIteWithDup(nums);
        System.out.println(res);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        subsetRec(nums, 0, curr, res);
        return res;
    }

    static void subsetRec(int[] arr, int i, List<Integer> curr,List<List<Integer>> res ){
        if(i == arr.length){
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        //include arr[i]
        curr.add(arr[i]);
        subsetRec(arr, i+1, curr, res);
        //exclude arr[i] by backtracking
        curr.remove(curr.size()-1);
        subsetRec(arr,i+1, curr, res);
    }

    static List<List<Integer>> subsetIte(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num: arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }

    static List<List<Integer>> subsetIteWithDup(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start =0, end =0;
        for (int i=0; i< arr.length; i++) {
            start = 0;
            //if curr and prev element are same s = e+1
            if(i>0 && arr[i] == arr[i-1]) {
                start = end +1;
            }
            end = outer.size()-1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                ArrayList<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }

        return outer;
    }

}
