package search.graph.lineage;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepthSearchTest {
    @Test
    public void testSearchOneLevel() {
        DepthSearch search = new DepthSearch();
        Node root = new Node();
        List<Node> result = search.findSiblings(root);

        assert null != result;
        assert 1 == result.size();
        assert result.contains(root);
    }

    @Test
    public void testSearchTwoLevel() {
        // Level A
        Node a = new Node();

        // Level B
        Node ab1 = new Node(a);
        Node ab2 = new Node(a);
        a.getChildren().add(ab1);
        a.getChildren().add(ab2);

        DepthSearch search = new DepthSearch();
        List<Node> result = search.findSiblings(ab2);

        assert null != result;
        assert 2 == result.size();
        List<Node> levelB = new ArrayList<Node>(Arrays.asList(ab1, ab2));
        assert result.containsAll(levelB);

    }

    @Test
    public void testSearchThreeLevel() {
        // Level A
        Node a = new Node();

        // Level B
        Node ab1 = new Node(a);
        Node ab2 = new Node(a);
        a.getChildren().add(ab1);
        a.getChildren().add(ab2);

        // Level C
        Node ab1c1 = new Node(ab1);
        Node ab1c2 = new Node(ab1);
        Node ab2c1 = new Node(ab2);
        Node ab2c2 = new Node(ab2);
        ab1.getChildren().add(ab1c1);
        ab1.getChildren().add(ab1c2);
        ab2.getChildren().add(ab2c1);
        ab2.getChildren().add(ab2c2);

        // Given a level D node, return all nodes at level D
        DepthSearch search = new DepthSearch();
        List<Node> result = search.findSiblings(ab1c1);

        assert null != result;
        assert 4 == result.size();
        List<Node> levelC = new ArrayList<Node>(Arrays.asList(ab1c1, ab1c2, ab2c1, ab2c2));
        assert result.containsAll(levelC);

    }

    @Test
    public void testSearchFourLevel() {
        // Level A
        Node a = new Node();

        // Level B
        Node ab1 = new Node(a);
        Node ab2 = new Node(a);
        a.getChildren().add(ab1);
        a.getChildren().add(ab2);

        // Level C
        Node ab1c1 = new Node(ab1);
        Node ab1c2 = new Node(ab1);
        Node ab2c1 = new Node(ab2);
        Node ab2c2 = new Node(ab2);
        ab1.getChildren().add(ab1c1);
        ab1.getChildren().add(ab1c2);
        ab2.getChildren().add(ab2c1);
        ab2.getChildren().add(ab2c2);

        // Level D
        Node ab1c1d1 = new Node(ab1c1);
        Node ab1c1d2 = new Node(ab1c1);
        Node ab1c1d3 = new Node(ab1c1);
        Node ab1c1d4 = new Node(ab1c1);
        Node ab1c2d1 = new Node(ab1c2);
        Node ab1c2d2 = new Node(ab1c2);
        Node ab2c1d1 = new Node(ab2c1);
        ab1c1.getChildren().add(ab1c1d1);
        ab1c1.getChildren().add(ab1c1d2);
        ab1c1.getChildren().add(ab1c1d3);
        ab1c1.getChildren().add(ab1c1d4);
        ab1c2.getChildren().add(ab1c2d1);
        ab1c2.getChildren().add(ab1c2d2);
        ab2c1.getChildren().add(ab2c1d1);

        // Level E added to ensure searching ends once desired depth found
        Node ab1c1d1e1 = new Node(ab1c1d1);
        Node ab1c1d1e2 = new Node(ab1c1d1);
        Node ab1c1d1e3 = new Node(ab1c1d1);
        ab1c1d1.getChildren().add(ab1c1d1e1);
        ab1c1d1.getChildren().add(ab1c1d1e2);
        ab1c1d1.getChildren().add(ab1c1d1e3);

        // Given a level D node, return all nodes at level D
        DepthSearch search = new DepthSearch();
        List<Node> result = search.findSiblings(ab1c1d3);

        assert null != result;
        assert 7 == result.size();
        List<Node> levelD = new ArrayList<Node>(Arrays.asList(ab1c1d1, ab1c1d2, ab1c1d3, ab1c1d4, ab1c2d1, ab1c2d2, ab2c1d1));
        assert result.containsAll(levelD);

    }
}
