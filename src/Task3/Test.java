package Task3;

public class Test {
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
        System.out.println(NodeUtils.printPath(new BreadthFirstSearchAlgo().execute(nodeS, "F")));
        System.out.println(NodeUtils.printPath(new DepthFirstSearchAlgo().execute(nodeS, "G")));
        System.out.println(NodeUtils.printPath(new BreadthFirstSearchAlgo().execute(nodeS, "A","G")));
        System.out.println(NodeUtils.printPath(new DepthFirstSearchAlgo().execute(nodeS, "C","G")));
    }
}
