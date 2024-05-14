import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args) {
        ArrayList<String> res = new ArrayList<>();
        subSeq("","abc",res);
        System.out.println(res);
        System.out.println(subSeq("","abc"));
    }

    static void  subSeq(String p, String up, ArrayList<String> res){
        if(up.isEmpty()) {
            res.add(p);
            return;
        }

        char ch = up.charAt(0);

        subSeq(p+ch,up.substring(1),res);
        subSeq(p,up.substring(1),res);
    }

    static ArrayList<String> subSeq(String p, String up){
        if(up.isEmpty()) {
            ArrayList<String> li = new ArrayList<>();
            li.add(p);
            return li;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = subSeq(p+ch,up.substring(1));
        ArrayList<String> right = subSeq(p,up.substring(1));

        left.addAll(right);
        return left;
    }
}
