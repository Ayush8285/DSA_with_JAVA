package interviewQuestions.Trees_and_Graphs;


//🔶  Problem  Name: Lowest Common Ancestor



// 📘 Problem Statement
// Given two nodes p and q, return their lowest common ancestor (LCA) in a binary tree.



// 🧠 Approach
// Use recursive DFS:
//      Base case: return root if root is null, p, or q.
//      Recurse left and right:
//              If both sides return non-null → current node is LCA.
//              If one side returns non-null → propagate it upward.



// ✅ Visualization
//               3
//             /   \
//            5     1
//           / \   / \
//          6   2 0   8
//             / \
//             7   4

// We are given two nodes, say:
// p = 5
// q = 4



// 🔎 Objective:
// Find the Lowest Common Ancestor (LCA) — the lowest node in the tree that has both 5 and 4 as descendants.



// 🧭 How the Recursion Works Step-by-Step
// We use a post-order traversal strategy (left → right → root):

// 1. Start at root (3)
// Look for p (5) and q (4) in the left and right subtrees.

// 2. Recurse into left child of 3 → Node 5
// Node 5 is equal to p, so return node 5.

// 3. Recurse into right child of 3 → Node 1
// Continue search for node 4 in right subtree.

// 4. Left of 1 → Node 0 → No match → return null
// 5. Right of 1 → Node 8 → No match → return null
// → So, entire right subtree of 3 returns null.

// Now from left side, we got Node 5 (which is p)
// From right side, we got null

// Hence, LCA is still unresolved — continue bubbling up.



// Digging deeper:
// While going down from Node 5, we look in its right subtree at Node 2
// At Node 2 → left = 7, right = 4
// Eventually, Node 4 is found → return 4

// Now:
// Left from Node 5: 6 → no match → null
// Right from Node 5: 2 → returned 4 (from its right)

// So now:
// Node 5 sees: one side is null, other is 4
// Since current node is equal to p, we now know LCA is Node 5



// ✅ Final Result:
// LCA(5, 4) = 5


// 📊 Visual Call Stack (Simplified):
// lowestCommonAncestor(3, 5, 4)
// ├── left = lowestCommonAncestor(5, 5, 4) → returns 5
// └── right = lowestCommonAncestor(1, 5, 4) → returns null
// ==> return 5


public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        /*
               3
              / \
             5   1
            / \ / \
           6  2 0  8
             / \
            7   4
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left; // 5
        TreeNode q = root.left.right.right; // 4

        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode result = lca.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + ": " + result.val);
    }
}


// 🔍 Output
// LCA of 5 and 4: 5



// 📈 Complexity
// Time: O(n)

// Space: O(h) (due to recursion stack)