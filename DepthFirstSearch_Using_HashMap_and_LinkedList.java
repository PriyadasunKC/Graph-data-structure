import java.util.*;

class DepthFirstSearch_Using_HashMap_and_LinkedList {
    // A graph is represented as a map where each key is a node and the value is a
    // list of all adjacent nodes
    private HashMap<Integer, List<Integer>> graph;

    // Constructor to initialize the graph
    public DepthFirstSearch_Using_HashMap_and_LinkedList() {
        this.graph = new HashMap<>();
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        // If the source node is not already in the graph, add it
        if (!graph.containsKey(source)) {
            graph.put(source, new ArrayList<>());
        }
        // Add the destination node to the list of nodes adjacent to the source node
        graph.get(source).add(destination);
    }

    // Method to perform depth-first search starting from a given node
    public void dfs(int start) {
        // Set to keep track of visited nodes
        Set<Integer> visited = new HashSet<>();
        // Start the DFS
        dfsHelper(start, visited);
    }

    // Helper method to perform the DFS
    private void dfsHelper(int vertex, Set<Integer> visited) {
        // Mark the current node as visited
        visited.add(vertex);
        // Print the current node
        System.out.println(vertex + " ");
        // Get all nodes adjacent to the current node
        List<Integer> neighbors = graph.get(vertex);

        // If the current node has adjacent nodes
        if (neighbors != null) {
            // Visit each unvisited adjacent node
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    dfsHelper(neighbor, visited);
                }
            }
        }
    }

    // Main method to test the DFS
    public static void main(String[] args) {
        DepthFirstSearch_Using_HashMap_and_LinkedList dfs = new DepthFirstSearch_Using_HashMap_and_LinkedList();
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