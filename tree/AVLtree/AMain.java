public class AMain {
    public static void main(String[] args) {
        System.out.println("AVL Tree Implementation in Java");
        AVL avlTree = new AVL();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(5);
        avlTree.insert(3);
        avlTree.levelOrder();
        avlTree.delete(30);
        System.out.println("After deleting 30:");
        avlTree.levelOrder();
    }
}
