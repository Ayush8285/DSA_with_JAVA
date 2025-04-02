import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
  ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
  int[][] adjacencyMatrix;

  public Graph(ArrayList<WeightedNode> nodeList) {
    this.nodeList = nodeList;
    adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
  }

  public void addUndirectedEdge(int i, int j) {
    adjacencyMatrix[i][j] = 1;
    adjacencyMatrix[j][i] = 1;
  }

  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("   ");
    for (int i = 0; i < nodeList.size(); i++) {
      s.append(nodeList.get(i).name + " ");
    }
    s.append("\n");
    for (int i = 0; i < nodeList.size(); i++) {
      s.append(nodeList.get(i).name + ": ");
      for (int j : adjacencyMatrix[i]) {
        s.append((j) + " ");
      }
      s.append("\n");
    }
    return s.toString();
  }

  // get Neighbors
  public ArrayList<WeightedNode> getNeighbors(WeightedNode node) {
    ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
    int nodeIndex = node.index;
    for (int i=0; i<adjacencyMatrix.length; i++) {
      if(adjacencyMatrix[nodeIndex][i]==1) {
        neighbors.add(nodeList.get(i));
      }
    }
    return neighbors;

  }

  // BSF internall
  void bfsVisit(WeightedNode node) {
    LinkedList<WeightedNode> queue = new LinkedList<WeightedNode>();
    queue.add(node);
    while(!queue.isEmpty()) {
      WeightedNode currentNode = queue.remove(0);
      currentNode.isVisited = true;
      System.out.print(currentNode.name + " ");
      ArrayList<WeightedNode> neighbors = getNeighbors(currentNode);
      for (WeightedNode neighbor: neighbors) {
        if (!neighbor.isVisited) {
          queue.add(neighbor);
          neighbor.isVisited = true;
        }
      }
    }
  }

  public void bfs() {
    for (WeightedNode node : nodeList) {
      if(!node.isVisited) {
        bfsVisit(node);
      }
    }
  }

  void dfsVisit(WeightedNode node) {
    Stack<WeightedNode> stack = new Stack<>();
    stack.push(node);
    while(!stack.isEmpty()) {
      WeightedNode currentNode = stack.pop();
      currentNode.isVisited = true;
      System.out.print(currentNode.name + " ");
      ArrayList<WeightedNode> neighbors = getNeighbors(currentNode);
      for (WeightedNode neighbor : neighbors) {
        if (!neighbor.isVisited) {
          stack.push(neighbor);
          neighbor.isVisited = true;
        }
      }

    }
  }

  void dfs() {
    for (WeightedNode node : nodeList) {
      if(!node.isVisited) {
        dfsVisit(node);
      }
    }
  }



}
