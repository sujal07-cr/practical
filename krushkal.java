import java.util.*;

public class Qseven {

    static int[][] edges; // Array to store edges (source, destination, weight)
    static int[] parent;  // Array for Union-Find

    // Find function for Union-Find
    static int find(int node) {
        while (parent[node] != node) {
            node = parent[node]; // Follow parent chain to find the root
        }
        return node;
    }

    // Union function for Union-Find
    static void union(int src, int dest) {
        int rootSrc = find(src);
        int rootDest = find(dest);
        parent[rootSrc] = rootDest; // Connect one root to the other
    }

    // Kruskal's Algorithm
    static int kruskalsMST(int vertices, int[][] edges, int totalEdges) {
        // Initialize parent array
        parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i; // Each node is its own parent
        }

        // Sort edges by weight
        for (int i = 0; i < totalEdges - 1; i++) {
            for (int j = 0; j < totalEdges - i - 1; j++) {
                if (edges[j][2] > edges[j + 1][2]) {
                    // Swap edges[j] and edges[j + 1]
                    int[] temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }

        int mstCost = 0;
        int edgeCount = 0;

        System.out.println("Edges in the Minimum Spanning Tree:");
        for (int i = 0; i < totalEdges; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];

            // Check if adding this edge forms a cycle
            if (find(src) != find(dest)) {
                union(src, dest); // Connect the nodes
                mstCost += weight;
                edgeCount++;
                System.out.println("(" + src + ", " + dest + ") -> " + weight);

                // Stop when MST contains n-1 edges
                if (edgeCount == vertices - 1) {
                    break;
                }
            }
        }

        return mstCost;
    }

    public static void main(String[] args) {
        int vertices = 6; // Number of cities
        int totalEdges = 9; // Number of roads

        // Define edges as {source, destination, weight}
        edges = new int[][]{
                {0, 1, 4},
                {0, 2, 4},
                {1, 2, 2},
                {1, 3, 5},
                {2, 3, 8},
                {2, 4, 10},
                {3, 4, 2},
                {3, 5, 6},
                {4, 5, 3}
        };

        System.out.println("Calculating Minimum Spanning Tree...");
        int totalCost = kruskalsMST(vertices, edges, totalEdges);
        System.out.println("Total cost of MST: " + totalCost);
    }
}
