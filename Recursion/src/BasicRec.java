// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class BasicRec {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.print(fibo(i)+" ");
        }
        System.out.println();

        System.out.println(fact(5));
        System.out.println(sum(10));
        System.out.println(sumOfDigits(342));
        reverseDigits(456);
        System.out.println(sum);
        System.out.println(countZeroes(10090004));
    }

    static int fibo(int n){
        //base condition
        if(n < 2)
            return n;

        return fibo(n-1) + fibo(n-2);
    }

    static int fact(int n){
        if(n<=1)
            return 1;
        return n* fact(n-1);
    }

    static int sum(int n){
        if(n<=1)
            return 1;
        return n+ sum(n-1);
    }

    static int sumOfDigits(int n){
        if(n==0)
            return 0;
        return n%10 + sumOfDigits(n/10);
    }

    static int sum = 0;
    static void reverseDigits(int n){
        if(n==0)
            return;
        int rem = n%10;
        sum = sum*10 + rem;
        reverseDigits(n/10);
    }

    static int countZeroes(int n){
        if(n==0)
            return 0;
        int count = 0;
        if(n%10 == 0) count = 1;

        return count + countZeroes(n / 10);
    }
}