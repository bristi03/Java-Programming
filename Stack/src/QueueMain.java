import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);

        queue.display();

        System.out.println(queue.remove());

        queue.display();
        queue.insert(5);
        queue.display();
        System.out.println(queue.remove());
        queue.insert(10);
        queue.display();

        Queue<Integer> q = new LinkedList<>();
        q.peek();

    }

}
