package search.graph.lineage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class DepthSearch {
    private static final Logger LOG = LoggerFactory.getLogger(DepthSearch.class);

    /**
     * For a given node, returns a list of siblings or same depth nodes relative to the root node
     * @param node
     * @return
     */
    public List<Node> findSiblings(final Node node) {
        Deque<Node> lineage = listLineage(node);
        int depth = lineage.size(); // depth of current node from root given root is 0 depth
        Node root = depth > 0 ? lineage.pop() : node;
        return search(root, 0, depth);
    }

    /**
     * For a given node, returns a list representing the lineage of node.
     * Returns an empty list if the node has no parent.
     * @param node
     * @return
     */
    private Deque<Node> listLineage(final Node node) {
        Deque<Node> result = new ArrayDeque<Node>();
        Node current = node.getParent();
        while(current != null) {
            result.push(current);
            current = current.getParent();
        }
        return result;
    }

    /**
     * Recursive function to determine if the given node is the desired depth
     * If the no
     * @param node
     * @param currentDepth
     * @param nodeDepth
     * @return
     */
    private List<Node> search(Node node, final int currentDepth, final int nodeDepth) {
        List<Node> result = new ArrayList<Node>();
        if(currentDepth == nodeDepth) {
            result.add(node);
        } else {
            for(Node n : node.getChildren()) {
                result.addAll(search(n, currentDepth+1, nodeDepth));
            }
        }
        return result;
    }
}
