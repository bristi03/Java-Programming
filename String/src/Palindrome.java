// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Palindrome {
    public static void main(String[] args) {
        String str = "madaM";
        System.out.println(isPalindrome(str));
    }

    static boolean isPalindrome(String str){
        str = str.toLowerCase();
        if(str.length()==0)
            return true;
        for (int i = 0; i < str.length()/2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length()-1-i);
            if(start != end)
                return false;
        }
        return true;
    }
}