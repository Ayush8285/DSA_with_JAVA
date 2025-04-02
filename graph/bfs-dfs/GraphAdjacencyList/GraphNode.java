import java.util.ArrayList;

public class GraphNode {
  public String name;
  public int index;
  public boolean isVisited = false;

  public ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();

  public GraphNode(String name, int index) {
    this.name = name;
    this.index = index;
  }
}
