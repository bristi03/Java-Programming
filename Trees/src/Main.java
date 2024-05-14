// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(sc);
        tree.dfs();
//        tree.prettyDisplay();

        //BST tree = new BST();
//        AVL tree = new AVL();
//        int[] nums ={5,2,7,1,4,6,9,8,3,10};
//        int[] nums2 = {1,2,3,4,5,6,7,8,9,10};
//        tree.populate(nums2);
//        tree.populateSorted(nums2);

//        for (int i = 1; i <= 1000; i++) {
//            tree.insert(i);
//        }
//        tree.display();
//        //System.out.println(tree.balanced());
//        System.out.print("Pre-Order traversal : ");
//        tree.preOrder();
//        System.out.println();
//        System.out.print("In-Order traversal : ");
//        tree.inOrder();
//        System.out.println();
//        System.out.print("Post-Order traversal : ");
//        tree.postOrder();
//        System.out.println();
//
//        System.out.println("Height of AVL tree: "+ tree.height());
//        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
//        SegmentTree tree = new SegmentTree(arr);
//        tree.display();
//        System.out.println("Sum: " + tree.query(4,7));


    }
}