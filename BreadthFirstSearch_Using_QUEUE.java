import java.util.*;

class BreadthFirstSearch_Using_QUEUE {
    // This is our graph, represented as a map where each node (an Integer) maps to
    // a list of its neighbors
    private HashMap<Integer, List<Integer>> graph;

    // Constructor for the class initializes the graph
    public BreadthFirstSearch_Using_QUEUE() {
        this.graph = new HashMap<>();
    }

    // This method adds an edge from 'source' to 'destination' in the graph
    public void addEdge(int source, int destination) {
        // If the graph doesn't already contain the source node, add it
        if (!graph.containsKey(source)) {
            graph.put(source, new ArrayList<>());
        }
        // Add the destination node to the list of neighbors for the source node
        graph.get(source).add(destination);
    }

    // This method performs Breadth-First Search (BFS) on the graph, starting from
    // the node 'start'
    public void bfs(int start) {
        // A queue is used to manage the nodes to visit next
        Queue<Integer> queue = new LinkedList<>();
        // A set is used to keep track of nodes we've already visited
        Set<Integer> visited = new HashSet<>();

        // We start the search at the 'start' node
        queue.add(start);
        visited.add(start);

        // Continue until we've visited every node
        while (!queue.isEmpty()) {
            // Visit the next node in the queue
            int vertex = queue.poll();
            System.out.println(vertex + " ");

            // Visit all neighbors of the current node
            List<Integer> neighbors = graph.get(vertex);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    // Only visit neighbors we haven't already visited
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
    }

    // The main method where we create a graph and perform BFS on it
    public static void main(String[] args) {
        BreadthFirstSearch_Using_QUEUE bfs = new BreadthFirstSearch_Using_QUEUE();
        // Adding edges to the graph
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);

        // Perform BFS starting from node 2
        bfs.bfs(2);
    }
}