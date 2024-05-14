// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
       Heap<Integer> heap = new Heap<>();
       heap.insert(4);
       heap.insert(3);
       heap.insert(6);
       heap.insert(1);
       heap.insert(9);
       heap.insert(8);

       System.out.println(heap.heapSort());
    }
}