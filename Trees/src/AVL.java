public class AVL {
    public  class Node{
        private  int value;
        private  Node left;
        private  Node right;
        private  int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    public  Node root;

    public AVL() {

    }

    public int height(){
        return root.height;
    }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public  boolean isEmpty(){
        return root == null;
    }

    //insertion
    public void insert(int value){
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if(node == null){
            node = new Node(value);
            return node;
        }

        if (value < node.value ){
            node.left = insert(value,node.left);
            if(height(node.left)-height(node.right) > 1){
                if (value < node.left.value) //LL case
                    node = rightRotate(node);
                else{                       //LR case
                    node.left = leftRotate(node.left);
                    node = rightRotate(node);
                }
            }
        }

        if (value > node.value ){
            node.right = insert(value,node.right);
            if(height(node.right) - height(node.left) > 1){
                if(value > node.right.value)    //RR case
                    node = leftRotate(node);
                else{                           //RL case
                    node.right = rightRotate(node.right);
                    node = leftRotate(node);
                }
            }
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    private Node leftRotate(Node p) {
        Node c = p.right;
        Node t = c.left;

        c.left = p;
        p.right = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    public void populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums){
        populateSorted(nums,0,nums.length);
    }

    private void populateSorted(int[] nums, int start, int end) {
        if(start >= end) return;

        int mid = (start+end)/2;
        this.insert(nums[mid]);

        populateSorted(nums, start, mid);
        populateSorted(nums,mid+1, end);
    }

    //traversal
    public void display(){
        display(root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) return;
        System.out.println(details + node.getValue());

        display(node.left, "Left Child of " + node.getValue()+ " : ");
        display(node.right, "Right Child of " + node.getValue()+ " : ");
    }

    //Pre-Order Traversal
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null) return;
        System.out.print(node.value +" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //In-Order Traversal
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null) return;

        inOrder(node.left);
        System.out.print(node.value +" ");
        inOrder(node.right);
    }

    //Post-Order Traversal
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value +" ");
    }

    public  boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) return true;

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
}
