package interviewQuestions.Trees_and_Graphs;


//🔶  Problem  Name: Detect Cycle in Graph (DFS)



// 📘 Problem Statement
// Given a directed graph, determine if it contains a cycle.



// 🧠 Approach (DFS with Recursion Stack)
// Use DFS and maintain two arrays:
//      visited[]: marks if a node is visited
//      recStack[]: tracks current DFS path
// If we revisit a node already in recStack, we found a cycle.



// 🔍 Visualization
// Graph:
// 0 → 1 → 2  
//     ↑   ↓  
//     ←---3  

//     Cycle exists: 1 → 2 → 3 → 1



import java.util.*;

public class DetectCycleInGraph {

    public boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, adj, visited, recStack))
                return true;
        }
        return false;
    }

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor] && dfs(neighbor, adj, visited, recStack))
                return true;
            else if (recStack[neighbor])
                return true;
        }

        recStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Creating a graph with cycle: 1 → 2 → 3 → 1
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);

        DetectCycleInGraph graph = new DetectCycleInGraph();
        System.out.println("Graph has cycle? " + graph.hasCycle(V, adj));
    }
}

// 🖥️ Output
// Graph has cycle? true



// 📈 Complexity
// Time: O(V + E)

// Space: O(V)