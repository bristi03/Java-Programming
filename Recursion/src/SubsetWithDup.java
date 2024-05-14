import java.util.*;

public class SubsetWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        subsetRec(nums, 0, curr, set);
        return new ArrayList<>(set);
    }

    void subsetRec(int[] arr, int i, List<Integer> curr, HashSet<List<Integer>> set) {
        if (i == arr.length) {
            List<Integer> sortedCurr = new ArrayList<>(curr); // Create a new list
            Collections.sort(sortedCurr); // Sort the new list
            set.add(sortedCurr);// Check for uniqueness based on sorted list
            return;
        }
        // Include arr[i]
        curr.add(arr[i]);
        subsetRec(arr, i + 1, curr, set);
        // Exclude arr[i] by backtracking
        curr.remove(curr.size() - 1);
        subsetRec(arr, i + 1, curr, set);
    }

    public static void main(String[] args) {
        SubsetWithDup solution = new SubsetWithDup();
        int[] nums = {4, 1, 0};
        List<List<Integer>> subsets = solution.subsetsWithDup(nums);
        System.out.println(subsets);
    }
}
