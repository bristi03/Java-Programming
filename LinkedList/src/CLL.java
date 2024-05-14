public class CLL {
    private  Node head;
    private Node tail;

    private int size;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int val){
        Node node = new Node(val);
        if(head==null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;

    }

//    public void insertAtEnd(int val){
//        if(tail == null){
//            insertAtFirst(val);
//            return;
//        }
//        Node node = new Node(val);
//        tail.next = node;
//        tail = node;
//        size += 1;
//    }
//
//    public void insert(int val, int index){
//        if(index==0){
//            insertAtFirst(val);
//            return;
//        }
//        if(index == size){
//            insertAtEnd(val);
//            return;
//        }
//
//        Node temp = head;
//        for(int i=1; i<index; i++){
//            temp = temp.next;
//        }
//        Node node = new Node(val, temp.next);
//        temp.next = node;
//        size += 1;
//    }

//    public int deleteAtFirst(){
//        int val = head.value;
//        head = head.next;
//        if(head == null){
//            tail = null;
//        }
//        size--;
//        return val;
//    }
//
//    public int deleteAtEnd(){
//        if(size <= 1)
//            return deleteAtFirst();
//        Node secondLast = get(size - 2);
//        int val = tail.value;
//        tail = secondLast;
//        tail.next = null;
//        size--;
//        return val;
//    }

    public void delete(int value){
        Node node = head;
        if(node == null){
            return;
        }
        if (node.value == value){
            head = head.next;
            tail.next = head;
            return;
        }

        do{
            Node n = node.next;
            if(n.value == value){
                node.next = n.next;
                break;
            }
            node = node.next;
        }while(node != head);
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
        do{
            if(node.value==value)
                return node;
            node = node.next;
        }while(node != head);
        return null;
    }

    public void display(){
        Node temp = head;
        if(head != null) {
            do  {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }while(temp != head);
        }
        System.out.println(" HEAD");
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
