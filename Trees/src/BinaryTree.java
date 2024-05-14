import javax.naming.ldap.HasControls;
import java.util.*;

public class BinaryTree {
    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }
    private Node root;

    //insert elements
    public void populate(Scanner sc){
        System.out.println("Enter root node value");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc, root);
    }

    private void populate(Scanner sc, Node node) {
        System.out.println("Do you want to enter left of "+ node.value);
        char left = sc.next().charAt(0);

        if(left=='y'){
            System.out.println("Enter value for left of "+ node.value);
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc,node.left);
        }
        System.out.println("Do you want to enter right of "+ node.value);
        char right = sc.next().charAt(0);

        if(right=='y'){
            System.out.println("Enter value for right of "+ node.value);
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(sc,node.right);
        }
    }

    public void display(){
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) return;

        System.out.println(indent + node.value);
        display(node.left, indent+"\t");
        display(node.right, indent+"\t");
    }

    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if(node == null) return;

        prettyDisplay(node.right, level+1);

        if(level != 0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("\t\t");
            }
            System.out.println("|------->" + node.value);
        }else {
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level+1);
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<Node> queue = new LinkedList<>(); //queue for storing non-visited nodes
        queue.offer(root);

        //Breadth First Search
        while(!queue.isEmpty()){
            int levelSize = queue.size(); //number of nodes in that level
            List<Integer> currentLevel = new ArrayList<>();

            for(int i=0; i<levelSize; i++){
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.value);

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }

                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);

        }
        return result;
    }

    public void dfs(){
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
    }

    private void dfs(Node node, List<Integer> list){
        if(node == null){
            return;
        }
        list.add(node.value);
        System.out.println(node.value);
        dfs(node.left,list);
        dfs(node.right,list);
    }

    public List<String> binaryTreePaths(Node root) {
        List<String> path = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        dfs(root, path, ans);
        return ans;
    }

    void dfs(Node node,List<String> path, List<String> ans){

        path.add(String.valueOf(node.value));

        if(node.left == null && node.right == null){
            ans.add(String.join("->", path));
        }

        if(node.left != null)
            dfs(node.left, path, ans);
        if(node.right != null)
            dfs(node.right, path, ans);

        path.remove(path.size()-1);
    }
}
