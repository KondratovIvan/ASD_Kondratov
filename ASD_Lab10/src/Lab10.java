import java.util.*;

public class Lab10 {
    final static int INF = 99999;

    public static void main(String[] args) {

        dijkstra();
        floyd();
    }

    static void dijkstra() {//        0    1    2    3    4    5    6    7    8    9    10   11   12   13   14
        int graph[][] = new int[][]{{ 0 , 10 ,  5 , INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},//0
                                    {INF,  0 ,  6 , INF,  6 , INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},//1
                                    {INF, INF,  0 , INF,  3 ,  8 , INF, INF, INF, INF, INF, INF, INF, INF, INF},//2
                                    {INF, INF, INF,  0 , INF, INF, INF,  7 , INF, INF, INF, INF, INF, INF, INF},//3
                                    {INF, INF, INF,  5 , INF, INF, INF, INF,  4 , INF, INF, INF, INF, INF, INF},//4
                                    {INF, INF, INF, INF,  4 ,  0 ,  4 , INF, INF,  6 , INF, INF, INF, INF, INF},//5
                                    {INF, INF, INF, INF, INF, INF,  0 , INF, INF, INF,  2 , INF, INF, INF, INF},//6
                                    {INF, INF, INF, INF, INF, INF, INF,  0 ,  6 , INF, INF,  8 ,  6 , INF, INF},//7
                                    {INF, INF, INF, INF, INF,  5 , INF, INF,  0 ,  3 , INF, INF,  4 ,  5 , INF},//8
                                    {INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 , INF, INF, INF,  9 , INF},//9
                                    {INF, INF, INF, INF, INF, INF, INF, INF, INF,  7 ,  0 , INF, INF,  8 ,  10},//10
                                    {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 ,  3 , INF, INF },//11
                                    {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 , INF, INF},//12
                                    {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 , INF},//13
                                    {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  4 ,  0 } //14
        };

        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }

    public static void floyd() {//    0    1    2    3    4    5    6    7    8    9    10   11   12   13   14
        int graph[][] = new int[][]{{ 0 , 10 ,  5 , INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},//0
                					{INF,  0 ,  6 , INF,  6 , INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},//1
                					{INF, INF,  0 , INF,  3 ,  8 , INF, INF, INF, INF, INF, INF, INF, INF, INF},//2
                					{INF, INF, INF,  0 , INF, INF, INF,  7 , INF, INF, INF, INF, INF, INF, INF},//3
                					{INF, INF, INF,  5 , INF, INF, INF, INF,  4 , INF, INF, INF, INF, INF, INF},//4
                					{INF, INF, INF, INF,  4 ,  0 ,  4 , INF, INF,  6 , INF, INF, INF, INF, INF},//5
                					{INF, INF, INF, INF, INF, INF,  0 , INF, INF, INF,  2 , INF, INF, INF, INF},//6
                					{INF, INF, INF, INF, INF, INF, INF,  0 ,  6 , INF, INF,  8 ,  6 , INF, INF},//7
                					{INF, INF, INF, INF, INF,  5 , INF, INF,  0 ,  3 , INF, INF,  4 ,  5 , INF},//8
                					{INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 , INF, INF, INF,  9 , INF},//9
                					{INF, INF, INF, INF, INF, INF, INF, INF, INF,  7 ,  0 , INF, INF,  8 ,  10},//10
                					{INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 ,  3 , INF, INF },//11
                					{INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 , INF, INF},//12
                					{INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  0 , INF},//13
                					{INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,  4 ,  0 } //14
        };
        Floyd a = new Floyd();

        a.floydWarshall(graph);
    }
}

class ShortestPath {
    static final int V = 15;
    int minDistance(int dist[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int dist[])
    {
        System.out.println("Вершина \t Відстань від початку");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[V];

        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, sptSet);

            sptSet[u] = true;

            for (int v = 0; v < V; v++)

                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        printSolution(dist);
    }
}

class Floyd {
    final static int INF = 99999, V = 15;

    void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];
        int i, j, k;
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {

                for (j = 0; j < V; j++) {

                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        printSolution(dist);
    }

    void printSolution(int dist[][]) {
        System.out.println("Матриця показує найкоротші " +
                "відстані між парами вершин");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}


