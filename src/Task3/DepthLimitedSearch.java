package Task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthLimitedSearch {

    public Node execute(Node root, String goal, int limitedDepth) {
        Stack<Node> frontier = new Stack<>();
        List<Node> explored = new ArrayList<>();
        frontier.add(root);
        while (!frontier.isEmpty()) {
            Node current = frontier.pop();
            if (current.getLabel().equals(goal)) {
                return current;
            } else {
                if (current.getDepth() < limitedDepth) {
                    explored.add(current);
                    List<Node> children = current.getChildrenNodes();
                    for (Node child : children) {
                        if (!explored.contains(child) && !frontier.contains(child)) {
                            frontier.add(child);
                            child.setParent(current);
                            child.setDepth(current.getDepth()+1);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node nodeS = new Node("S");
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        nodeS.addEdge(nodeA, 5);
        nodeS.addEdge(nodeB, 2);
        nodeS.addEdge(nodeC, 4);
        nodeA.addEdge(nodeD, 9);
        nodeA.addEdge(nodeE, 4);
        nodeB.addEdge(nodeG, 6);
        nodeC.addEdge(nodeF, 2);
        nodeD.addEdge(nodeH, 7);
        nodeE.addEdge(nodeG, 6);
        nodeF.addEdge(nodeG, 1);
        DepthLimitedSearch algo1 = new DepthLimitedSearch();
        Node result = algo1.execute(nodeS, "G", 10);
        System.out.println(NodeUtils.printPath(result));
    }
}
