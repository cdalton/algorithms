package search.graph.lineage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class DepthSearch {
    private static final Logger LOG = LoggerFactory.getLogger(DepthSearch.class);

    public List<Node> findSiblings(Node node) {
        List<Node> lineage = listLineage(node);
        Node root = lineage.size() > 0 ? lineage.get(lineage.size() -1) : node;
        int depth = lineage.size(); // depth of current node from root given root is 0 depth
        return search(root, 0, depth);
    }

    /**
     * For a given node, returns a list representing the lineage of node.
     * Returns an empty list if the node has no parent.
     * @param node
     * @return
     */
    private List<Node> listLineage(Node node) {
        List<Node> result = new ArrayList<Node>();
        Node current = node.getParent();
        while(current != null) {
            result.add(current);
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
            LOG.debug("Found node at desired depth");
            result.add(node);
        } else {
            for(Node n : node.getChildren()) {
                result.addAll(search(n, currentDepth+1, nodeDepth));
            }
        }
        return result;
    }
}
