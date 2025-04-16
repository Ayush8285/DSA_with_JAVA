package interviewQuestions.Trees_and_Graphs;

//🔶  Problem  Name: Inorder / Preorder / Postorder Traversals

// 📘 Problem Statement
// Given the root of a binary tree, print its:
//      Inorder Traversal (Left → Node → Right)
//      Preorder Traversal (Node → Left → Right)
//      Postorder Traversal (Left → Right → Node)



// 🧠 Approach + Explanation
// These are Depth-First Traversals using recursion:
//      Inorder: Traverse the left subtree, process current node, then right subtree.
//      Preorder: Process current node, then left and right subtrees.
//      Postorder: Traverse left and right subtrees, then process the current node.
// You use recursion (DFS) and a base case for null nodes.



// 🔍 Visualization
//       1
//      / \
//      2  3
//      /\
//      4 5




import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreeTraversals {

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
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

        TreeTraversals tt = new TreeTraversals();

        System.out.print("Inorder: ");
        tt.inorder(root);
        System.out.println();

        System.out.print("Preorder: ");
        tt.preorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        tt.postorder(root);
        System.out.println();
    }
}

// ✅ Output
// Inorder: 4 2 5 1 3  
// Preorder: 1 2 4 5 3  
// Postorder: 4 5 2 3 1


// 📈 Complexity
// Time: O(n) for each

// Space: O(h) (height of tree for recursion)