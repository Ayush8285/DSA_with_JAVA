import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
        nodeList.add(new WeightedNode("E", 4));
        nodeList.add(new WeightedNode("F", 5));
        nodeList.add(new WeightedNode("G", 6));

        WeightedGraph graph = new WeightedGraph(nodeList);
        graph.addWeightedEdge(0,1,2 );
        graph.addWeightedEdge(0,2,5 );
        graph.addWeightedEdge(1,2,6 );
        graph.addWeightedEdge(1,3,1 );
        graph.addWeightedEdge(2,5,8 );
        graph.addWeightedEdge(3,4,4 );
        graph.addWeightedEdge(4,6,9 );
        graph.addWeightedEdge(5,6,7 );
        graph.addWeightedEdge(1,4,3 );
        graph.dijkstra(nodeList.get(0));
    }
}
