public class BMain {
    public static void main(String[] args) {
        System.out.println("Binary Heap Implementation in Java");
        BinaryHeap binaryHeap = new BinaryHeap(10);
        binaryHeap.insert(10, "Min");
        binaryHeap.insert(20, "Min");
        binaryHeap.insert(5, "Min");
        binaryHeap.insert(30, "Min");
        binaryHeap.insert(15, "Min");
        binaryHeap.levelOrder();
       binaryHeap.extractHeadOfBP("Min");
        binaryHeap.levelOrder();
        
    }
    
}
