public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int top = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item) throws StackException {
        if(isFull()){
            throw new StackException("Stack is full");
        }
        data[++top] = item;
        return true;
    }

    public  void display(){
        for (int i=0; i<=top; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public int pop() throws StackException {
        if(isEmpty()){
            throw new StackException(("Stack is Empty"));
        }
        return data[top--];
    }

    public int peek() throws StackException{
        if (isEmpty())
            throw new StackException("Stack is Empty");
        return data[top];
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == data.length-1;
    }
}
