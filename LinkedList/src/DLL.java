public class DLL {

    private class Node{
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.prev = previous;
        }
    }

    private Node head;

    public void insertAtFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null)
            head.prev = node;

        head = node;
    }

    public void insertAtEnd(int val){
        if(head == null){
            insertAtFirst(val);
            return;
        }
        Node node = new Node(val);
        Node last = head;
        while(last.next !=null){
            last = last.next;
        }
        last.next = node;
        node.prev = last;
        node.next=null;
    }

    public void insert(int after, int val){
        Node p = find(after);

        if(p == null){
            System.out.println("Does not exist");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        node.prev = p;
        if(node.next != null)
            node.next.prev = node;
        p.next = node;
    }

    public int deleteAtFirst(){
        int val = head.value;
        head = head.next;
        if(head.prev != null)
            head.prev = null;

        return val;
    }

    public int deleteAtEnd(){
        if(head.next==null)
            return deleteAtFirst();
        Node last = head;
        while(last.next !=null){
            last = last.next;
        }
        int val = last.value;
        last.prev.next = null;

        return val;
    }

    public int delete(int index){
        if(index==0) {
            return deleteAtFirst();
        }
        Node del = get(index);
        if(del.next == null)
            return deleteAtEnd();

        Node pre = get(index - 1);
        Node after = get(index+1);
        int val = del.value;
        pre.next = after;
        after.prev = pre;

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
        Node last = null;
        while(temp !=null){
            System.out.print(temp.value+" -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("END");
        System.out.println(" Reverse: ");

        while (last!= null){
            System.out.print(last.value+" -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

}
