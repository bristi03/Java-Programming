// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SLL {

    private  Node head;
    private Node tail;

    private int size;

    public SLL() {
        this.size = 0;
    }

    public void insertAtFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null)
            tail = head;

        size += 1;
    }

    public void insertAtEnd(int val){
        if(tail == null){
            insertAtFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void insert(int val, int index){
        if(index==0){
            insertAtFirst(val);
            return;
        }
        if(index == size){
            insertAtEnd(val);
            return;
        }

        Node temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size += 1;
    }

    //insert using recursion
    public void insertRec(int val, int index){
        head = insertRec(val, index, head);
    }
    private Node insertRec(int val,int index, Node node){
        if(index == 0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }
        node.next = insertRec(val, index-1, node.next);
        return node;
    }

    public int deleteAtFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteAtEnd(){
        if(size <= 1)
            return deleteAtFirst();
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index){
        if(index==0) {
            return deleteAtFirst();
        }
        if (index == size-1){
            return deleteAtEnd();
        }
        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node get(int index){
        Node node = head;
        for(int i = 1; i <= index; i++){
            node = node.next;
        }
        return node;
    }

    public Node find(int value){
        Node node = head;
        while(node != null){
            if(node.value==value)
                return node;
            node = node.next;
        }
        return null;
    }

    public void display(){
        Node temp = head;
        while(temp !=null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.println(" NULL");
    }
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}