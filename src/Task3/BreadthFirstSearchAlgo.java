package Task3;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

    @Override
    public Node execute(Node root, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(root);
        return NodeUtils.findShortestPathWithBFS(goal, frontier);
    }

    public Node execute(Node root, String start, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(NodeUtils.findNodeByName(root, start));
        return NodeUtils.findShortestPathWithBFS(goal, frontier);
    }


}
