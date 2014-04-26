package search.graph.lineage;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Node parent;
    private List<Node> children;

    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(Node parent) {
        this();
        this.parent = parent;
    }

    public Node(Node parent, List<Node> children) {
        this.parent = parent;
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }
}
