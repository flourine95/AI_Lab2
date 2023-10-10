package Task1AndTask2;

import java.util.*;

public class NodeUtils {
    public static Node findNode(Node root, String label) {
        if (root == null || root.getLabel().equals(label)) {
            return root;
        }

        for (Node child : root.getChildrenNodes()) {
            Node node = findNode(child, label);
            if (node != null) {
                return node;
            }
        }

        return null;
    }
    public static Node findShortestPathWithDFS(String goal, Stack<Node> frontier, List<Node> explored) {
        while (!frontier.isEmpty()) {
            Node current = frontier.pop();
            if (current.getLabel().equals(goal)) {
                return current;
            }
            explored.add(current);
            List<Node> children = current.getChildrenNodes();
            for (Node child : children) {
                if (!explored.contains(child)) {
                    frontier.add(child);
                    child.setParent(current);
                }
            }
        }
        return null;
    }

    public static Node findShortestPathWithBFS(String goal, Queue<Node> frontier, List<Node> explored) {
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            if (current.getLabel().equals(goal)) {
                return current;
            }
            explored.add(current);
            List<Node> children = current.getChildrenNodes();
            for (Node child : children) {
                if (!frontier.contains(child) && !explored.contains(child)) {
                    frontier.add(child);
                    child.setParent(current);
                }
            }
        }
        return null;
    }

    public static List<String> printPath(Node node) {
        if (node != null) {
            List<String> result = new ArrayList<>();
            result.add(node.getLabel());
            Node tmp;
            while ((tmp = node.getParent()) != null) {
                result.add(tmp.getLabel());
                node = tmp;
            }
            Collections.reverse(result);
            return result;
        } else {
            return new ArrayList<>();
        }
    }
}
