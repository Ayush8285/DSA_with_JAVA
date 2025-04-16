package interviewQuestions.Trees_and_Graphs;

//🔶  Problem  Name: Dijkstra’s Algorithm

// 📘 Problem Statement
// Given a weighted graph and a source node, find the shortest distance from the source to every other node using Dijkstra's Algorithm.



// 🧠 Approach (Min-Heap / PriorityQueue)
// Use a PriorityQueue to get the minimum distance node at each step.
// Store distance[] array and update if a shorter path is found.
// Avoid revisiting already processed nodes.



// 🔍 Visualization
// Graph:
//               (10)
//          0 ---------> 1
//          |            |
//       (5)|            |(1)
//          ↓            ↓
//          2 ---------> 3
//                (2)

// Start from node 0
// Shortest distances:
//      to 0: 0
//      to 1: 8 (0 → 2 → 3 → 1)
//      to 2: 5
//      to 3: 7



import java.util.*;

class Pair {
    int node, weight;
    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class DijkstraAlgorithm {

    public void dijkstra(int V, List<List<Pair>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int currDist = curr.weight;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int wt = neighbor.weight;

                if (dist[v] > currDist + wt) {
                    dist[v] = currDist + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Directed graph with weights
        adj.get(0).add(new Pair(1, 10));
        adj.get(0).add(new Pair(2, 5));
        adj.get(2).add(new Pair(3, 2));
        adj.get(3).add(new Pair(1, 1));

        DijkstraAlgorithm obj = new DijkstraAlgorithm();
        obj.dijkstra(V, adj, 0);
    }
}


// 🖥️ Output
// Shortest distances from node 0:
// To 0: 0
// To 1: 8
// To 2: 5
// To 3: 7


// 📈 Complexity
// Time: O((V + E) log V) using Min Heap

// Space: O(V)