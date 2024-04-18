// Define a Graph class
class Graph {
    // adjacencyMatrix will hold the graph data
    private int[][] adjacencyMatrix;
    // numberOfVertices holds the number of vertices in the graph
    private int numberOfVertices;

    // Graph constructor
    public Graph(int numberOfVertices) {
        // Initialize the number of vertices
        this.numberOfVertices = numberOfVertices;
        // Create a 2D array of size numberOfVertices x numberOfVertices
        adjacencyMatrix = new int[numberOfVertices][numberOfVertices];
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        // For a directed graph, set the value at index [source][destination] to 1
        adjacencyMatrix[source][destination] = 1;
        // If this was an undirected graph, we would also set the value at index
        // [destination][source] to 1
        // adjacencyMatrix[destination][source] = 1;
    }

    // Method to print the graph (adjacency matrix)
    public void printGraph() {
        // Loop through all vertices
        for (int i = 0; i < numberOfVertices; i++) {
            // For each vertex, loop through all other vertices
            for (int j = 0; j < numberOfVertices; j++) {
                // Print the value in the adjacency matrix at index [i][j]
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            // Print a new line at the end of each row
            System.out.println();
        }
    }
}

// Define a class to test the Graph class
public class GraphRePresentUsingAdjacencyMatrix {
    public static void main(String[] args) {
        // Create a new Graph with 5 vertices
        Graph graph = new Graph(5);
        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Print the graph
        graph.printGraph();
    }
}