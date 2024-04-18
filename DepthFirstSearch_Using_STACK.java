
// Import necessary classes from the Java standard library
import java.util.*;

// Define a class for performing Depth-First Search (DFS) using a stack
class DepthFirstSearch_Using_STACK {
    // A graph is represented as a map where each node (an Integer) maps to a list
    // of its neighbors
    private HashMap<Integer, List<Integer>> graph;

    // Constructor for the class initializes the graph as an empty map
    public DepthFirstSearch_Using_STACK() {
        this.graph = new HashMap<>();
    }

    // Method to add an edge from a source node to a destination node in the graph
    public void addEdge(int source, int destination) {
        // If the source node is not already in the graph, add it with an empty list of
        // neighbors
        if (!graph.containsKey(source)) {
            graph.put(source, new ArrayList<>());
        }
        // Add the destination node to the list of neighbors of the source node
        graph.get(source).add(destination);
    }

    // Method to perform DFS starting from a given node
    public void dfs(int start) {
        // Create a stack to keep track of nodes to visit and a set to keep track of
        // visited nodes
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        // Add the start node to the stack and mark it as visited
        stack.push(start);
        visited.add(start);

        // Continue until there are no more nodes to visit
        while (!stack.isEmpty()) {
            // Remove the next node to visit from the stack
            int vertex = stack.pop();
            // Print the node
            System.out.println(vertex + " ");

            // Get the neighbors of the node
            List<Integer> neighbors = graph.get(vertex);
            // If the node has neighbors
            if (neighbors != null) {
                // For each neighbor
                for (int neighbor : neighbors) {
                    // If the neighbor has not been visited yet
                    if (!visited.contains(neighbor)) {
                        // Add the neighbor to the stack and mark it as visited
                        stack.push(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
    }

    // Main method to test the DFS implementation
    public static void main(String[] args) {
        // Create a DFS object
        DepthFirstSearch_Using_STACK dfs = new DepthFirstSearch_Using_STACK();
        // Add edges to the graph
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        // Perform DFS starting from node 2
        dfs.dfs(2);
    }
}