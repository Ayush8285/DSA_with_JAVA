package interviewQuestions.Trees_and_Graphs;

//🔶  Problem  Name: Diameter of Binary Tree



// 📘 Problem Statement
// Find the diameter of a binary tree.
// The diameter is the longest path between any two nodes, which may or may not pass through the root.



// 🧠 Approach
// Use post-order traversal to:
//      Compute the height of each subtree.
//      At each node, calculate diameter = left height + right height.
//      Keep track of the maximum diameter found.



// 🔍 Visualization
//          1
//         / \
//        2   3
//       / \
//      4   5

// Diameter: Path = 4 → 2 → 1 → 3 → Length = 3 (edges)



public class DiameterOfBinaryTree {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);

        maxDiameter = Math.max(maxDiameter, left + right);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \
          4   5
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterOfBinaryTree d = new DiameterOfBinaryTree();
        System.out.println("Diameter: " + d.diameterOfBinaryTree(root));
    }
}



// 🖥️ Output
// Diameter: 3

// 📈 Complexity
// Time: O(n)

// Space: O(h)
