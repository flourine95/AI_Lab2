package Task3;

import java.util.*;

public class UniformCostSearchAlgo implements ISearchAlgo {

    @Override
    public Node execute(Node root, String goal) {
//        PriorityQueue<Node> frontier = new PriorityQueue<>((o1, o2) -> {
//            int compareByPathCost = Double.compare(o1.getPathCost(), o2.getPathCost());
//            if (compareByPathCost == 0) return o1.getLabel().compareTo(o2.getLabel());
//            return compareByPathCost;
//        });
        root.setPathCost(0);
        PriorityQueue<Node> frontier = new PriorityQueue<>(
                Comparator.comparingDouble(Node::getPathCost).thenComparing(Node::getLabel)
        );
        frontier.add(root);
        Set<Node> explored = new HashSet<>();
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            if (current.getLabel().equals(goal)) {
                return current;
            }
            explored.add(current);
            List<Edge> children = current.getChildren();
            for (Edge child : children) {
                Node node = child.getEnd();
                double newPathCost = child.getWeight()+current.getPathCost();
                if (!explored.contains(node) && !frontier.contains(node)) {
                    frontier.add(node);
                    node.setParent(current);
                    node.setPathCost(newPathCost);
                } else if (node.getPathCost() > newPathCost && frontier.contains(node)) {
                    node.setParent(current);
                    node.setPathCost(newPathCost);
                }
            }
        }
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
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
        ISearchAlgo algo1 = new UniformCostSearchAlgo();
        Node result = algo1.execute(nodeS, "G");
        System.out.println(NodeUtils.printPath(result));
    }
}
