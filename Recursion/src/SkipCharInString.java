public class SkipCharInString {
    public static void main(String[] args) {
        System.out.println(skipChar("", "haealalaoa"));

        System.out.println(skipChar2( "haealalaoa"));

        System.out.println(skipString("daabcbaabcbc","abc"));
    }

    static String skipChar(String p, String up){//processed and unprocessed
        if(up.isEmpty())
            return p;
        char ch = up.charAt(0);

        if(ch == 'a'){
            return skipChar(p,up.substring(1));
        }
        else{
            p = p + ch;
            return skipChar(p,up.substring(1));
        }
    }

    static String skipChar2(String up){//processed and unprocessed
        if(up.isEmpty())
            return "";
        char ch = up.charAt(0);

        if(ch == 'a'){
            return skipChar2(up.substring(1));
        }
        else{
            return ch+ skipChar2(up.substring(1));
        }
    }

    static String skipString(String up, String skip){//processed and unprocessed
        if(up.isEmpty())
            return "";

        if(up.startsWith(skip)){
            return skipString(up.substring(skip.length()),skip);
        }
        else{
            return up.charAt(0)+ skipString(up.substring(1),skip);
        }
    }
}
