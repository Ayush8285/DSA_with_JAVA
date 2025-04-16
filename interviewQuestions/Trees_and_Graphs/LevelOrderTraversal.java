package interviewQuestions.Trees_and_Graphs;

//🔶  Problem  Name: Level Order Traversal



// 📘 Problem Statement
// Return the level order traversal of a binary tree (top to bottom, left to right).



// 🧠 Approach
// Use Breadth-First Search (BFS) with a Queue:
//      Add the root to the queue.
//      While the queue is not empty:
//              Process all nodes at the current level.
//              Add children to the queue.
//      Store values level by level.




import java.util.*;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        /*
               1
              / \
             2   3
            / \   \
           4   5   6
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        LevelOrderTraversal lot = new LevelOrderTraversal();
        List<List<Integer>> result = lot.levelOrder(root);

        System.out.println("Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}




// 🔍 Output
// Level Order Traversal:
// [1]
// [2, 3]
// [4, 5, 6]


// 📈 Complexity
// Time: O(n)

// Space: O(n) (queue + result)