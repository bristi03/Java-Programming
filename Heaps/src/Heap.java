import java.util.ArrayList;
public class Heap<T extends Comparable<T>> {
    private ArrayList<T> list;
    public Heap(){
        list = new ArrayList<>();
    }

    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second,temp);
    }
    private int parent(int index){
        return (index - 1)/2;
    }
    private int left(int index){
        return (index+1)*2 - 1;
    }
    private int right(int index){
        return (index+1)*2;
    }

    public void insert(T element){
        list.add(element);
        upheap(list.size()-1);
    }

    private void upheap(int index) {
        if(index==0) return;

        int p = parent(index);
        if(list.get(index).compareTo(list.get(p)) < 0){
            swap(index, p);
            upheap(p);
        }
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Removing from an empty heap");
        }
        T temp = list.get(0);

        T last = list.remove(list.size()-1);
        if (!list.isEmpty()){
            list.set(0, last);
            downheap(0);
        }

        return temp;
    }

    private void downheap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(left).compareTo(list.get(min)) < 0){
            min = left;
        }
        if (right < list.size() && list.get(right).compareTo(list.get(min)) < 0){
            min = right;
        }

        if (min != index){
            swap(min, index);
            downheap(min);
        }
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }

    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> sorted = new ArrayList<>();

        while (!list.isEmpty()){
            sorted.add(this.remove());
        }
        return sorted;
    }
}
