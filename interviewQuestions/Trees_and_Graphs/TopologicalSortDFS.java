package interviewQuestions.Trees_and_Graphs;

//🔶  Problem  Name: Topological Sort



// 📘 Problem Statement
// Given a Directed Acyclic Graph (DAG), return a topological ordering of its vertices — a linear ordering such that for every directed edge u → v, vertex u comes before v.



// 🧠 Approach (DFS-based)
// Use DFS traversal to visit all nodes.
// Use a stack to store the ordering — push nodes after all their neighbors are visited.
// At the end, pop elements from the stack for the result.



// 🔍 Visualization
// Graph:
// 5 → 2 ← 3
// ↓    ↓
// 0    4

// One possible Topological Order: 5 3 2 4 0




import java.util.*;

public class TopologicalSortDFS {

    public void topoSort(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) dfs(i, adj, visited, stack);  // ✅ pass 'visited'
        }

        System.out.print("Topological Order: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) dfs(neighbor, adj, visited, stack);  // ✅ pass 'visited'
        }

        stack.push(node);
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        TopologicalSortDFS obj = new TopologicalSortDFS();
        obj.topoSort(V, adj);
    }
}





// 🖥️ Output
// Topological Order: 5 4 2 3 1 0 (varies by DFS order)



// 📈 Complexity
// Time: O(V + E)

// Space: O(V)