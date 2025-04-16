package interviewQuestions.Trees_and_Graphs;


//🔶  Problem  Name: Check if a Tree is Balanced




// 📘 Problem Statement
// Determine if a binary tree is height-balanced.
// A tree is height-balanced if, for every node, the difference between the heights of its left and right subtrees is no more than 1.



// 🧠 Approach
// Use a bottom-up recursion:
//      For each node, calculate the height of the left and right subtrees.
//      If any subtree is unbalanced, propagate -1 upward.
//      If balanced, return height = 1 + max(leftHeight, rightHeight)



// 🔍 Visualization
// Balanced Tree:
//         1
//        / \
//       2   3
//      /
//     4


// Unbalanced Tree:
//         1
//        /
//       2
//      /
//     3





class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class CheckBalancedTree {

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1;

        int right = checkHeight(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        /*
             1
            / \
           2   3
          /
         4
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        CheckBalancedTree checker = new CheckBalancedTree();
        System.out.println("Is tree balanced? " + checker.isBalanced(root));
    }
}


// 🖥️ Output
// Is tree balanced? true


// 📈 Complexity
// Time: O(n)

// Space: O(h) (recursion stack)