package Task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {
    @Override
    public Node execute(Node root, String goal) {
        Stack<Node> frontier = new Stack<>();
        List<Node> explored = new ArrayList<>();
        frontier.add(root);
        return NodeUtils.findShortestPathWithDFS(goal, frontier, explored);
    }


    @Override
    public Node execute(Node root, String start, String goal) {
        Stack<Node> frontier = new Stack<>();
        List<Node> explored = new ArrayList<>();
        frontier.add(NodeUtils.findNodeByName(root,start));
        return NodeUtils.findShortestPathWithDFS(goal, frontier, explored);
    }



}
