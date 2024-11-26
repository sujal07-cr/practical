import java.util.*;

public class Qeight {

    // Method to find shortest paths using Dijkstra's Algorithm
    public static int[] dijkstra(int n, int[][] graph, int start) {
        int[] dist = new int[n]; // Stores shortest distances from the start node
        boolean[] visited = new boolean[n]; // Tracks visited nodes
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // Min-heap to process nodes with the smallest distance

        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize all distances to infinity
        dist[start] = 0; // Distance to the start node is 0
        pq.add(new int[]{start, 0}); // Add the start node to the priority queue

        while (!pq.isEmpty()) {
            int[] curr = pq.poll(); // Get the node with the smallest distance
            int node = curr[0];
            int nodeDist = curr[1];

            if (visited[node]) continue; // Skip already visited nodes
            visited[node] = true;

            // Update distances to neighboring nodes
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (graph[node][neighbor] != 0 && !visited[neighbor]) { // If there's a path and not visited
                    int newDist = nodeDist + graph[node][neighbor];
                    if (newDist < dist[neighbor]) {
                        dist[neighbor] = newDist; // Update to the shorter distance
                        pq.add(new int[]{neighbor, newDist}); // Add neighbor to the queue
                    }
                }
            }
        }

        return dist; // Return the array of shortest distances
    }

    public static void main(String[] args) {
        int n = 6; // Number of locations
        int[][] graph = {
                {0, 7, 9, 0, 0, 14}, // Distance from node 0 to others
                {7, 0, 10, 15, 0, 0}, // Distance from node 1 to others
                {9, 10, 0, 11, 0, 2}, // Distance from node 2 to others
                {0, 15, 11, 0, 6, 0}, // Distance from node 3 to others
                {0, 0, 0, 6, 0, 9},   // Distance from node 4 to others
                {14, 0, 2, 0, 9, 0}   // Distance from node 5 to others
        };

        int start = 0; // Starting location
        int[] distances = dijkstra(n, graph, start);

        // Print shortest distances from the start location
        System.out.println("Shortest distances from location " + start + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To location " + i + ": " + distances[i]);
        }
    }
}

