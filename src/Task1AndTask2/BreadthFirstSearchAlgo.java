package Task1AndTask2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

    @Override
    public Node execute(Node root, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        List<Node> explored = new ArrayList<>();
        frontier.add(root);
        return NodeUtils.findShortestPathWithBFS(goal, frontier, explored);
    }

    public Node execute(Node root, String start, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        List<Node> explored = new ArrayList<>();
        frontier.add(NodeUtils.findNode(root, start));
        return NodeUtils.findShortestPathWithBFS(goal, frontier, explored);
    }


}
