import java.util.*;

public class Lab9 {
    static Scanner scanner = new Scanner(System.in);
    static GraphWeighted graph = new GraphWeighted(false);

    static NodeWeighted a = new NodeWeighted("a");
    static NodeWeighted b = new NodeWeighted("b");
    static NodeWeighted c = new NodeWeighted("c");
    static NodeWeighted d = new NodeWeighted("d");
    static NodeWeighted e = new NodeWeighted("e");
    static NodeWeighted f = new NodeWeighted("f");

    final static int INF = 99999;

    public static void main(String[] args) {
        System.out.println("Введіть стартову точку: ");
        char start = scanner.next().charAt(0);

        System.out.println("Введіть пункт призначення: ");
        char destination = scanner.next().charAt(0);

        graph.printEdges();

        graph.addEdge(a,b,1);
        graph.addEdge(a,c,1);
        graph.addEdge(a,f,1);
        graph.addEdge(a,d,1);

        graph.addEdge(b,d,1);
        graph.addEdge(b,c,1);
        graph.addEdge(b,e,1);
        graph.addEdge(a,b,1);

        graph.addEdge(c,e,1);
        graph.addEdge(c,f,1);

        graph.addEdge(d,f,1);
        graph.addEdge(d,e,1);

        graph.addEdge(e,f,1);
        graph.addEdge(e,b,1);
        graph.DijkstraShortestPath(charToNode(start), charToNode(destination));

        floyd();
    }

    static NodeWeighted charToNode(char search) {
        switch (search) {
            case 'a':
                return a;
            case 'b':
                return b;
            case 'c':
                return c;
            case 'd':
                return d;
            case 'e':
                return e;
            case 'f':
                return f;
            default:
                return a;
        }
    }

    public static void floyd() {
        int graph[][] = {           {0  ,  1 ,  1 ,  1 , INF,  1 },
                                    {1  ,  0 ,  1 ,  1 ,  1 , INF},
                                    {1  ,  1 ,  0 , INF,  1 ,  1 },
                                    {1  ,  1 , INF,  0 ,  1 ,  1 },
                                    {INF,  1 ,  1 ,  1 ,  0 ,  1 },
                                    {1  , INF,  1 ,  1 ,  1 ,  0 } 
        };
        Floyd a = new Floyd();

        a.floydWarshall(graph);
    }
}

class EdgeWeighted {

    NodeWeighted source;
    NodeWeighted destination;

    EdgeWeighted(NodeWeighted s, NodeWeighted d) {
        source = s;
        destination = d;
    }
    public String toString() {
        return String.format("(%s -> %s, %f)", source.name, destination.name);
    }

}
class NodeWeighted {
    String name;
    private boolean visited;
    LinkedList<EdgeWeighted> edges;

    NodeWeighted(String name) {
        this.name = name;
        visited = false;
        edges = new LinkedList<>();
    }

    boolean isVisited() {
        return visited;
    }

    void visit() {
        visited = true;
    }

    void unvisit() {
        visited = false;
    }
}
class GraphWeighted {
    private Set<NodeWeighted> nodes;
    private boolean directed;

    GraphWeighted(boolean directed) {
        this.directed = directed;
        nodes = new HashSet<>();
    }

    public void addNode(NodeWeighted... n) {
        nodes.addAll(Arrays.asList(n));
    }
    public void addEdge(NodeWeighted source, NodeWeighted destination, double weight) {
        nodes.add(source);
        nodes.add(destination);

        addEdgeHelper(source, destination, weight);

        if (!directed && source != destination) {
            addEdgeHelper(destination, source, weight);
        }
    }

    private void addEdgeHelper(NodeWeighted a, NodeWeighted b, double weight) {
        for (EdgeWeighted edge : a.edges) {
            if (edge.source == a && edge.destination == b) {
                return;
            }
        }

        a.edges.add(new EdgeWeighted(a, b));
    }
    public void printEdges() {
        for (NodeWeighted node : nodes) {
            LinkedList<EdgeWeighted> edges = node.edges;

            if (edges.isEmpty()) {
                System.out.println("Вузол " + node.name + " не має ребер.");
                continue;
            }
            System.out.print("Вузол " + node.name + " не має ребер до: ");

            for (EdgeWeighted edge : edges) {
                System.out.print(edge.destination.name);
            }
            System.out.println();
        }
    }
    public boolean hasEdge(NodeWeighted source, NodeWeighted destination) {
        LinkedList<EdgeWeighted> edges = source.edges;
        for (EdgeWeighted edge : edges) {

            if (edge.destination == destination) {
                return true;
            }
        }
        return false;
    }
    public void resetNodesVisited() {
        for (NodeWeighted node : nodes) {
            node.unvisit();
        }
    }
    public void DijkstraShortestPath(NodeWeighted start, NodeWeighted end) {

        HashMap<NodeWeighted, NodeWeighted> changedAt = new HashMap<>();
        changedAt.put(start, null);

        HashMap<NodeWeighted, Double> shortestPathMap = new HashMap<>();


        for (NodeWeighted node : nodes) {
            if (node == start)
                shortestPathMap.put(start, 0.0);
            else shortestPathMap.put(node, Double.POSITIVE_INFINITY);
        }


        for (EdgeWeighted edge : start.edges) {
            shortestPathMap.put(edge.destination, 1.0);
            changedAt.put(edge.destination, start);
        }

        start.visit();

        while (true) {
            NodeWeighted currentNode = closestReachableUnvisited(shortestPathMap);

            if (currentNode == null) {
                System.out.println("Нема шляху між " + start.name + " та " + end.name);
                return;
            }

            if (currentNode == end) {
                System.out.println("Шлях з найменшою вагою між "
                        + start.name + " та " + end.name + " це:");

                NodeWeighted child = end;

                String path = end.name;
                while (true) {
                    NodeWeighted parent = changedAt.get(child);
                    if (parent == null) {
                        break;
                    }

                    path = parent.name + " " + path;
                    child = parent;
                }
                System.out.println(path);
                System.out.println("Шлях важить: " + shortestPathMap.get(end));
                return;
            }
            currentNode.visit();

            for (EdgeWeighted edge : currentNode.edges) {
                if (edge.destination.isVisited())
                    continue;

                if (shortestPathMap.get(currentNode)
                        + 1.0
                        < shortestPathMap.get(edge.destination)) {
                    shortestPathMap.put(edge.destination,
                            shortestPathMap.get(currentNode) + 1.0);
                    changedAt.put(edge.destination, currentNode);
                }
            }
        }
    }
    private NodeWeighted closestReachableUnvisited(HashMap<NodeWeighted, Double> shortestPathMap) {
        double shortestDistance = Double.POSITIVE_INFINITY;
        NodeWeighted closestReachableNode = null;
        for (NodeWeighted node : nodes) {
            if (node.isVisited())
                continue;

            double currentDistance = shortestPathMap.get(node);
            if (currentDistance == Double.POSITIVE_INFINITY)
                continue;

            if (currentDistance < shortestDistance) {
                shortestDistance = currentDistance;
                closestReachableNode = node;
            }
        }
        return closestReachableNode;
    }
}

class Floyd {
    final static int INF = 99999, V = 6;

    void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];
        int i, j, k;
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        for (k = 0; k < V; k++)
        {
            for (i = 0; i < V; i++)
            {

                for (j = 0; j < V; j++)
                {

                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        printSolution(dist);
    }

    void printSolution(int dist[][]) {
        System.out.println("Матриця показує найкоротші "+
                "дистанціі між парами вершин");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
