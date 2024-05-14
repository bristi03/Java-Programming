import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        ArrayList<String> res= new ArrayList<>();
        //permutations("", "abc",res);
        //System.out.println(permutations("","abc"));
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums = {1,2,3};
        permutations(0, nums, ans,curr);
        System.out.println(ans);
        System.out.println(permutations(0, nums,curr));
    }

    static  void permutations(String p, String up, ArrayList<String> res){
        if(up.isEmpty()){
            res.add(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i);

            permutations(f+ch+s, up.substring(1), res);
        }
    }

    static  ArrayList<String> permutations(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i);

            ans.addAll(permutations(f+ch+s, up.substring(1)));
        }
        return ans;
    }

    static  void permutations(int index, int[] arr, List<List<Integer>> ans, List<Integer> curr){
        if(index == arr.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        int x = arr[index];
        for (int i = 0; i <= curr.size(); i++) {
            curr.add(i,x);
            permutations(index+1, arr, ans, curr);
            curr.remove(i);
        }

    }

    static  List<List<Integer>> permutations(int index, int[] arr, List<Integer> curr){
        List<List<Integer>> ans = new ArrayList<>();
        if(index == arr.length){
            ans.add(new ArrayList<>(curr));
            return ans;
        }
        int x = arr[index];
        for (int i = 0; i <= curr.size(); i++) {
            curr.add(i,x);
            ans.addAll(permutations(index+1, arr, curr));
            curr.remove(i);
        }
        return ans;
    }

}
