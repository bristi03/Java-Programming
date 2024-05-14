import java.util.Objects;

public class SearchStrings {
    public static void main(String[] args) {
        String[] str = {"apple","banana","guava", "berry"};
        String target = "berry";
        System.out.println(searchString(str,target,1,3));
    }
    static boolean searchString(String[] str, String target){
        for (String s : str) {
            if (s.equals(target)) {
                //target == str.charAt(i) for searching char in string
                return true;
            }
        }
        return false;
    }

    static boolean searchString(String[] str, String target, int start, int end){
        for (int i = start; i <= end; i++) {
            if (str[i].equals(target)) {
                //target == str.charAt(i) for searching char in string
                return true;
            }
        }
        return false;
    }
}
