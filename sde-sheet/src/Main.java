// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
    }
        int maxLen (int[] arr, int n)
        {
            // Your code here
            int left = 0, right = 0, k = 0;
            int sum = arr[0];
            int maxlen = 0;

            while (right < n) {
                while (left <= right && sum > k) {
                    sum -= arr[left];
                    left++;
                }

                if (sum == k)
                    maxlen = Math.max(maxlen, right - left + 1);

                right++;
                if (right < n)
                    sum += arr[right];
            }
            return maxlen;
        }

}