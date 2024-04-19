import java.util.*;

class BreadthFirstSearch_Using_Recursion {
    private int V; // Variable to store the number of vertices in the graph
    private LinkedList<Integer> adj[]; // Adjacency List to represent the graph

    // Constructor to initialize the graph with the given number of vertices
    BreadthFirstSearch_Using_Recursion(int v) {
        V = v;
        adj = new LinkedList[v]; // Create an array of linked lists to store adjacency lists
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList(); // Initialize each linked list in the array
    }

    // Function to add an edge between two vertices in the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add vertex 'w' to the adjacency list of vertex 'v'
    }

    // Recursive function to perform Breadth-First Search (BFS) traversal
    void BFSRecursive(int s, boolean visited[]) {
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node (source vertex) as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from the queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex 's'
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next(); // Get the next adjacent vertex 'n'
                if (!visited[n]) { // If the adjacent vertex 'n' has not been visited
                    visited[n] = true; // Mark it as visited
                    queue.add(n); // Enqueue the adjacent vertex 'n' for future exploration
                }
            }
        }
    }

    // Driver method to test the BFS algorithm
    public static void main(String args[]) {
        BreadthFirstSearch_Using_Recursion g = new BreadthFirstSearch_Using_Recursion(4); // Create a graph with 4 vertices

        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Breadth First Traversal (starting from vertex 2)");

        boolean visited[] = new boolean[4]; // Create a boolean array to track visited vertices
        g.BFSRecursive(2, visited); // Call the BFS recursive function with source vertex 2
    }
}