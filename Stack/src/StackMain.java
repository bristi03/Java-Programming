// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class StackMain {
    public static void main(String[] args) throws Exception {
        CustomStack stack = new CustomStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.display();

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}